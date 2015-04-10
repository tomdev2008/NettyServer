package wang.gnim.netty.net.mongodb;

import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;

import com.mongodb.ReadPreference;
import com.mongodb.WriteConcern;
import com.mongodb.client.ListCollectionsIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class MongoDatabaseProxy {
	public String getName() {
		return null;
	}

	public CodecRegistry getCodecRegistry() {
		return null;
	}

	public ReadPreference getReadPreference() {
		return null;
	}

	public WriteConcern getWriteConcern() {
		return null;
	}

	public MongoDatabase withCodecRegistry() {
		return null;
	}

	public MongoDatabase withReadPreference() {
		return null;
	}

	public MongoDatabase withWriteConcern() {
		return null;
	}

	public MongoIterable listCollectionNames() {
		return null;
	}

	public ListCollectionsIterable listCollections() {
		return null;
	}

	public void createCollection() {
	}


	public MongoCollection getCollection() {
		return null;
	}

	public Document runCommand() {
		return null;
	}


	public void drop() {
	}

}
