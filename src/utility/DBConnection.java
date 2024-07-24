package utility;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class DBConnection {
	
	 public static MongoDatabase getDatabase(String dbName) {
		 MongoClient mongoClient = new MongoClient("localhost",27017);
	        return mongoClient.getDatabase(dbName);
	    }
}
