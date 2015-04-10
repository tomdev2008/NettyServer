package wang.gnim.netty.net.mongodb;

import java.util.Collection;
import java.util.List;

import org.bson.codecs.configuration.CodecRegistry;

import com.mongodb.CommandResult;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.MongoClientOptions;
import com.mongodb.ReadPreference;
import com.mongodb.ReplicaSetStatus;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;
import com.mongodb.client.ListDatabasesIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class MongoClientProxy {
	
	public MongoDatabase getDatabase() {
		return null;
	}

	public ListDatabasesIterable listDatabases() {
		return null;
	}

	public CodecRegistry getDefaultCodecRegistry() {
		return null;
	}

	public MongoClientOptions getMongoClientOptions() {
		return null;
	}

	public List getCredentialsList() {
		return null;
	}

	public MongoIterable listDatabaseNames() {
		return null;
	}

	public DBObject unlock() {
		return null;
	}

	public boolean isLocked() {
		return true;
	}

	public ServerAddress getAddress() {
		return null;
	}

	public void close() {
	}

	public void setWriteConcern() {
	}

	public ReadPreference getReadPreference() {
		return null;
	}

	public WriteConcern getWriteConcern() {
		return null;
	}

	public List getAllAddress() {
		return null;
	}

	public DB getDB() {
		return null;
	}

	public void dropDatabase() {
	}

	public void slaveOk() {
	}

	public void setOptions() {
	}

	public void resetOptions() {
	}

	public void addOption() {
	}

	public int getOptions() {
		return 0;
	}

	public CommandResult fsync() {
		return null;
	}

	public CommandResult fsyncAndLock() {
		return null;
	}

	public List getServerAddressList() {
		return null;
	}

	public ReplicaSetStatus getReplicaSetStatus() {
		return null;
	}

	public List getDatabaseNames() {
		return null;
	}

	public Collection getUsedDatabases() {
		return null;
	}

	public int getMaxBsonObjectSize() {
		return 0;
	}

	public String getConnectPoint() {
		return null;
	}

	public void setReadPreference() {
	}

}
