package wang.gnim.netty.net.netty.parser;

import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_TYPE;
import static io.netty.handler.codec.http.HttpMethod.GET;
import static io.netty.handler.codec.http.HttpMethod.POST;
import static io.netty.handler.codec.http.HttpResponseStatus.BAD_REQUEST;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.multipart.Attribute;
import io.netty.handler.codec.http.multipart.DefaultHttpDataFactory;
import io.netty.handler.codec.http.multipart.HttpPostRequestDecoder;
import io.netty.handler.codec.http.multipart.InterfaceHttpData;
import io.netty.handler.codec.http.multipart.InterfaceHttpData.HttpDataType;
import io.netty.util.CharsetUtil;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.apache.log4j.Logger;

import wang.gnim.netty.net.netty.ActionCommandCache;
import wang.gnim.netty.net.netty.http.HttpParamaters;
import wang.gnim.netty.server.command.AbstractCommand;
import wang.gnim.netty.server.util.JsonTool;

public enum HttpParser {
	
	INSTANCE;

	private static final Logger logger = Logger.getLogger(HttpParser.class);

	public Object parse(ChannelHandlerContext ctx,
			FullHttpRequest request) {

		final String uri = request.getUri();
		if (!request.getDecoderResult().isSuccess()) {
			sendError(ctx, BAD_REQUEST, uri);
			return "BAD_REQUEST";
		}
		HttpParamaters param = null ;
		if (request.getMethod() == GET) {
			param = parseGetUri(request);
		} else if (request.getMethod() == POST) {
			param = parsePostUri(request);
		}

		logger.info(uri + "\n" + param.toString());

		AbstractCommand command = ActionCommandCache.INSTANCE.getCommand(param.scheme,
				param.parameters.get("command"));
		if (command == null) {
			command = ActionCommandCache.INSTANCE.getCommand("/defaults", "Default");
		} 

		Object result = command.execute(param);
		logger.info("\n" + JsonTool.toJson(result));
		
		return JsonTool.toJson(result);
	}

	private HttpParamaters parseGetUri(FullHttpRequest request) {

		HttpParamaters pams = new HttpParamaters();

		try {
			String uri = request.getUri();
			String parseUri = URLDecoder.decode(uri, "UTF-8");
			String[] arr1 = parseUri.split("\\?");
			if (arr1.length == 0) {
				// TODO

			} else if (arr1.length == 1) {
				pams.scheme = arr1[0];

			} else if (arr1.length == 2) {
				pams.scheme = arr1[0];
				String[] arr2 = arr1[1].split("&");
				for (String string : arr2) {
					String[] arr3 = string.split("=");
					pams.parameters.put(arr3[0], arr3[1]);
				}
			} else {
				// TODO
			}

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return pams;
	}

	private HttpParamaters parsePostUri(FullHttpRequest request) {

		HttpParamaters pams = new HttpParamaters();
		
		HttpPostRequestDecoder decoder = new HttpPostRequestDecoder(
				new DefaultHttpDataFactory(false), request);
		for (InterfaceHttpData postData : decoder.getBodyHttpDatas()) {
			if (postData.getHttpDataType() == HttpDataType.Attribute) {

				try {
					Attribute attribute = (Attribute) postData;
					pams.parameters.put(postData.getName(), attribute.getValue());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		

		return pams;
	}
	/**
	 * 
	 * @param ctx
	 * @param status
	 */
	public void sendError(ChannelHandlerContext ctx,
			HttpResponseStatus status, String uri) {
		FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1,
				status, Unpooled.copiedBuffer("失败: " + status.toString()
						+ " 找不到对应的请求处理\r\n检查URI ： " + JsonTool.toJson(uri),
						CharsetUtil.UTF_8));

		response.headers().set(CONTENT_TYPE, "text/plain; charset=UTF-8");
		ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
	}

	@Deprecated
	private void send(ChannelHandlerContext ctx, Object result) {
		FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, OK);
		response.headers().set(CONTENT_TYPE, "text/html; charset=UTF-8");
		StringBuilder buf = new StringBuilder((String) result);
		ByteBuf buffer = Unpooled.copiedBuffer(buf, CharsetUtil.UTF_8);
		response.content().writeBytes(buffer);
		buffer.release();
		ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
	}

}
