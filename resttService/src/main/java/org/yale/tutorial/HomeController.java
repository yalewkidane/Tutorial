package org.yale.tutorial;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
		
		serviceList.add("service url: service/addAddressBook;");
		serviceList.add("service url: service/editAddressBook;");
		serviceList.add("service url: service/viewALLAddressBook;");
		serviceList.add("service url: service/viewAddressBook/{firstName};");
		serviceList.add("service url: service/deleteAddressBook;");
		
		return new ResponseEntity<String>(serviceList.toString(), responseHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value = "service/viewAllAddressBook", method = RequestMethod.GET)
	public ResponseEntity<String> viewAllAddressBook() {
		
		System.out.println("getServiceList");

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		//new Crud
		String result=Crud.view();
		
		return new ResponseEntity<String>(result, responseHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value = "service/viewAddressBook/{firstName}", method = RequestMethod.GET)
	public ResponseEntity<String> viewAddressBook(@PathVariable String firstName) {
		
		System.out.println("getServiceList");

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		//new Crud
		String result=Crud.view(firstName);
		
		return new ResponseEntity<String>(result, responseHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value = "service/addAddressBook", method = RequestMethod.POST)
	public ResponseEntity<String> addAddressBook(@RequestBody String body) {
		
		System.out.println("getServiceList");

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		String result=Crud.save(body);
		
		
		return new ResponseEntity<String>(result, responseHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value = "service/deleteAddressBook", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteAddressBook() {
		
		System.out.println("getServiceList");

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		String result=Crud.delete();
		
		
		return new ResponseEntity<String>(result, responseHeaders, HttpStatus.OK);
	}
	
}

