package wang.gnim.netty.net.mongodb;

import java.util.List;

import org.bson.codecs.configuration.CodecRegistry;

import com.mongodb.BulkWriteResult;
import com.mongodb.MongoNamespace;
import com.mongodb.ReadPreference;
import com.mongodb.WriteConcern;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.DistinctIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.ListIndexesIterable;
import com.mongodb.client.MapReduceIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

public class MongoCollectionProxy {

	public MongoCollection withReadPreference () { 
		return null;
		}
		public WriteConcern getWriteConcern () { 
		return null;
		}
		public AggregateIterable aggregate () { 
		return null;
		}
		public MongoCollection withWriteConcern () { 
		return null;
		}
		public long count () { 
		return 0;
		}
		public UpdateResult replaceOne () { 
		return null;
		}
		public void drop () { 
		}
		public MongoCollection withCodecRegistry () { 
		return null;
		}
		public MapReduceIterable mapReduce () { 
		return null;
		}
		public void dropIndex () { 
		}
		public void dropIndexes () { 
		}
		public DistinctIterable distinct () { 
		return null;
		}
		public Object findOneAndReplace () { 
		return null;
		}
		public FindIterable find () { 
		return null;
		}
		public DeleteResult deleteOne () { 
		return null;
		}
		public Class getDocumentClass () { 
		return null;
		}
		public void renameCollection () { 
		}
		public CodecRegistry getCodecRegistry () { 
		return null;
		}
		public ListIndexesIterable listIndexes () { 
		return null;
		}
		public Object findOneAndDelete () { 
		return null;
		}
		public String createIndex () { 
		return null;
		}
		public MongoCollection withDocumentClass () { 
		return null;
		}
		public UpdateResult updateOne () { 
		return null;
		}
		public Object findOneAndUpdate () { 
		return null;
		}
		public void insertMany () { 
		}
		public BulkWriteResult bulkWrite () { 
		return null;
		}
		public void insertOne () { 
		}
		public List createIndexes () { 
		return null;
		}
		public MongoNamespace getNamespace () { 
		return null;
		}
		public UpdateResult updateMany () { 
		return null;
		}
		public ReadPreference getReadPreference () { 
		return null;
		}
		public DeleteResult deleteMany () { 
		return null;
		}

}
