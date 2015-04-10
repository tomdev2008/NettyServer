package wang.gnim.netty.net.mongodb;

import org.bson.Document;
import org.junit.Test;

import wang.gnim.netty.net.mongodb.MongoDBClient;

public class MongoDBClientTest {

	@Test
	public void insert() {
		
		Document doc = new Document();
		doc.append("demo_key", "demo_value");
		
		String table = System.currentTimeMillis() + "insert";
		
		MongoDBClient.CLIENT.insertDocument("mydb", table, doc);
	}

	@Test
	public void createCollection() {

	}

	@Test
	public void insertDocument() {

	}

	@Test
	public void getCollection() {

	}

	@Test
	public void findDocument() {

	}

}
