package org.yale.tutorial.restService.crude;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class Crud {

	
	public static String save() {
		String status="";
		// connect to mongo server 
				MongoClient mongo = new MongoClient("localhost", 27017); // create a blank database 
				DB db = mongo.getDB("kode12"); //displaystatistics 
				System.out.println(db.getStats()); 
				//DBCollection coll = db.createCollection("mycol", (DBObject) db);
				DBCollection coll = db.getCollection("mycol");
				BasicDBObject doc = new BasicDBObject("title", "MongoDB")
						.append("description", "database")
						.append("likes", 100)
						.append("url", "http://www.tutorialspoint.com/mongodb/")
						.append("by", "tutorials point");
				coll.insert(doc);
				System.out.println("getServiceList");
		return status;
	}
	
	public static String delete() {
		String status="";
		
		return status;
	}
	
	public static String view() {
		String status="";
		
		// To connect to mongodb server
		MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
		// Now connect to your databases
		DB db = mongoClient.getDB( "kode12" );
		System.out.println("Connect to database successfully");
		//boolean auth = db.authenticate(myUserName, myPassword);
		//System.out.println("Authentication: "+auth);
		DBCollection coll = db.getCollection("mycol");
		System.out.println("Collection mycol selected successfully");
		DBCursor cursor = coll.find();
		int i=1;
		while (cursor.hasNext()) {
		System.out.println("Inserted Document: "+i);
		System.out.println(cursor.next());
		i++;
		}
		
		return status;
	}
	
	public static String edit() {
		String status="";
		
		return status;
	}
}
