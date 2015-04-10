package wang.gnim.netty.server.core.log.client;

import java.util.Map;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public enum MongoDBClient {

	CLIENT;
	
	private final MongoClient client = new MongoClient( "localhost" , 27017 );
	
	MongoDBClient() {
		
	}
	
	/**
	 * 该方法会在DB中创建一个Collection, 如果DB不存在, 则会首先创建出该GB
	 * @param name
	 */
	public void createCollection(String dbName, String collectioNname) {
		MongoDatabase db = client.getDatabase(dbName);
		db.createCollection(collectioNname);
	}
	
	public MongoCollection<Document> getCollection(String dbName, String collectioNname) {
		MongoDatabase db = client.getDatabase(dbName);
		return db.getCollection(collectioNname);
	}
	
	public void insert (String dbName, String collectioNname, Document doc) {
		MongoDatabase db = client.getDatabase(dbName);
		MongoCollection<Document> collection = db.getCollection(collectioNname);
		collection.insertOne(doc);
	}
	
	public void insertDocument (String dbName, String collectioNname, Map<String, String> map) {
		MongoDatabase db = client.getDatabase(dbName);
		MongoCollection<Document> collection = db.getCollection(collectioNname);
		
		Document doc = new Document();
		for (String key : map.keySet()) {
			doc.append(key, map.get(key));
		}
		
		collection.insertOne(doc);
	}
	
	public FindIterable<Document> findDocument(String dbName, String collectioNname, String key, Object value) {
		MongoDatabase db = client.getDatabase(dbName);
		MongoCollection<Document> collection = db.getCollection(collectioNname);
		
		return collection.find(new BasicDBObject(key, value));
	}
}
