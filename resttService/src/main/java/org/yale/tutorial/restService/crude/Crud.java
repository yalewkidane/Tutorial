package org.yale.tutorial.restService.crude;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

public class Crud {

	
	public static String save(String person) {
		String status="";
		MongoClient mongo = new MongoClient("localhost", 27017); // create a blank database 
		DB db = mongo.getDB("kode12"); 
		DBCollection coll = db.getCollection("person");
		DBObject dbObject = (DBObject)JSON.parse(person);

		status=coll.insert(dbObject).toString();
		return status;
	}
	
	public static String delete() {
		String status="";
		MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
		DB db = mongoClient.getDB( "kode12" );
		DBCollection coll = db.getCollection("person");
		BasicDBObject document = new BasicDBObject();
		status=coll.remove(document).toString();
		return status;
	}
	
	public static String view() {
		String result="";
		MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
		DB db = mongoClient.getDB( "kode12" );
		DBCollection coll = db.getCollection("person");
		DBCursor cursor = coll.find();
		while (cursor.hasNext()) {
			result+=cursor.next();
		}
		
		return result;
	}
	
	public static String view(String firstName) {
		String result="";
		MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
		DB db = mongoClient.getDB( "kode12" );
		DBCollection coll = db.getCollection("person");
		
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("name.firstName", firstName);
		DBCursor cursor = coll.find(whereQuery);
		while (cursor.hasNext()) {
			result+=cursor.next();
		}
		
		return result;
	}
	
	public static String edit() {
		String status="";
		
		return status;
	}
}
