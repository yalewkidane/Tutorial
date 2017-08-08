package org.yale.tutorial;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.yale.tutorial.restService.crude.Crud;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

@Controller
public class HomeController {

	
	@RequestMapping(value = "service/getServiceList", method = RequestMethod.GET)
	public ResponseEntity<String> getServiceList() {
		
		System.out.println("getServiceList");

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		List<String> serviceList=new ArrayList<>();
		
		serviceList.add("service url: service/addAddressBook");
		serviceList.add("service url: service/editAddressBook");
		serviceList.add("service url: service/viewAddressBook");
		serviceList.add("service url: service/deleteAddressBook");
		
		return new ResponseEntity<String>(serviceList.toString(), responseHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value = "service/viewAddressBook", method = RequestMethod.GET)
	public ResponseEntity<String> viewAddressBook() {
		
		System.out.println("getServiceList");

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		//new Crud
		String result=Crud.view();
		
		return new ResponseEntity<String>(result, responseHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value = "service/addAddressBook", method = RequestMethod.POST)
	public ResponseEntity<String> addAddressBook() {
		
		System.out.println("getServiceList");

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		List<String> serviceList=new ArrayList<>();
		
		
		return new ResponseEntity<String>(serviceList.toString(), responseHeaders, HttpStatus.OK);
	}
	
	
	
	
	@RequestMapping(value = "service/getServiceList/rt", method = RequestMethod.GET)
	public ResponseEntity<String> getServiceList2() throws UnknownHostException {
		
		
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

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		
		String serviceList = "Texting";
		
		return new ResponseEntity<String>(serviceList, responseHeaders, HttpStatus.OK);
	}
	
}

