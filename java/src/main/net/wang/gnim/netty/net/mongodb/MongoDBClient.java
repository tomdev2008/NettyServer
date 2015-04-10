package wang.gnim.netty.net.mongodb;

import java.util.Map;
import java.util.regex.Pattern;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * Java MongoDB driver 是线程安全的. 我们创建一个全局的MongoClient实例, 然后每次向MongoDB服务器
 * 发送请求时,都使用这个实例. MongoClient内部维持一个连接池(默认最大大小是100). 每个向DB的请求, Java 线程
 * 都会从池子里获得一个连接, 然后在该连接上执行操作, 操作执行完毕, 释放这个连接.
 * 
 * 
 * @author wangming
 *
 */
public enum MongoDBClient {

	CLIENT;

	private final MongoClient client = new MongoClient("localhost", 27017);

	MongoDBClient() {
		setWriteConcern();
	}

	/**
	 * 保障write operation的可靠性, 和db.getLastError()方法关系很大.
	 * 
	 * 一般来说,所有的mongo driver,在执行一个写操作(insert、update、delete)之后,
	 * 都会立刻调用db.getLastError()方法. 这样才有机会知道刚才的写操作是否成功 ,
	 * 如果捕获到错误就可以进行相应的处理.处理逻辑也是完全由client决定的,
	 * 比如写入日志、抛出错误、等待一段时间再次尝试写入等.
	 * 
	 * ACKNOWLEDGED				:
	 * UNACKNOWLEDGED			:
	 * FSYNCED					:
	 * JOURNALED				:
	 * REPLICA_ACKNOWLEDGED		:
	 * NORMAL					:
	 * SAFE						:
	 * MAJORITY					:
	 * FSYNC_SAFE				:
	 * JOURNAL_SAFE				:
	 * REPLICAS_SAFE			:
	 */
	private void setWriteConcern() {
		client.setWriteConcern(WriteConcern.ACKNOWLEDGED);
	}

	/**
	 * 该方法会在DB中创建一个Collection, 如果DB不存在, 则会首先创建出该GB
	 * 
	 * 对象db 就是对指定数据库的连接.
	 * 
	 * @param name
	 */
	public void createCollection(String dbName, String collectioNname) {
		MongoDatabase db = client.getDatabase(dbName);
		db.createCollection(collectioNname);
	}

	/**
	 * 
	 * @param dbName
	 * @param collectioNname
	 * @return
	 */
	public MongoCollection<Document> getCollection(String dbName,
			String collectioNname) {
		MongoDatabase db = client.getDatabase(dbName);
		return db.getCollection(collectioNname);
	}

	/**
	 * 
	 * @param dbName
	 * @param collectioNname
	 * @param doc
	 */
	public void insertDocument(String dbName, String collectioNname, Document doc) {
		MongoDatabase db = client.getDatabase(dbName);
		MongoCollection<Document> collection = db.getCollection(collectioNname);
		collection.insertOne(doc);
	}

	/**
	 * 
	 * @param dbName
	 * @param collectioNname
	 * @param map
	 */
	public void insertDocument(String dbName, String collectioNname,
			Map<String, String> map) {
		MongoDatabase db = client.getDatabase(dbName);
		MongoCollection<Document> collection = db.getCollection(collectioNname);

		Document doc = new Document();
		for (String key : map.keySet()) {
			doc.append(key, map.get(key));
		}

		collection.insertOne(doc);
	}
	
	/**
	 * 
	 * @param dbName
	 * @param collectioNname
	 * @param key
	 * @param value
	 * @return
	 */
	public FindIterable<Document> findFirstDocument(String dbName,
			String collectioNname, String key, Object value) {
		MongoDatabase db = client.getDatabase(dbName);
		MongoCollection<Document> collection = db.getCollection(collectioNname);

		return collection.find(new BasicDBObject(key, value));
	}
	
	/**
	 * 
	 * @param dbName
	 * @param collectioNname
	 * @param key
	 * @param value
	 */
	public void findOneDocument(String dbName,
			String collectioNname, String key, Object value) {
		MongoDatabase db = client.getDatabase(dbName);
		MongoCollection<Document> collection = db.getCollection(collectioNname);
	}
	
	/**
	 * 通过正则表达式查找
	 * 
	 * @param dbName
	 * @param collectioNname
	 * @param key
	 * @param pattern
	 * @return 
	 */
	public FindIterable<Document> findDocumentByPattern(String dbName,
			String collectioNname, String key, String pattern) {
		MongoDatabase db = client.getDatabase(dbName);
		MongoCollection<Document> collection = db.getCollection(collectioNname);
		
		Pattern value = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
		BasicDBObject args = new BasicDBObject(key, value);

		return collection.find(args);
	}
	
}
