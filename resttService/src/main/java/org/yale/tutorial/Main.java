package org.yale.tutorial;

import java.util.Date;

import org.yale.tutorial.restService.model.Address;
import org.yale.tutorial.restService.model.Name;
import org.yale.tutorial.restService.model.Person;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

	public static void main(String[] args) {
		Person person = new Person();
		
		Name name=new Name();
		name.setFirstName("abebe");
		name.setLastName("chala");
		person.setName(name);
		
		Address address=new Address();
		address.setPost("341414");
		address.setEmail("abebe@facebook.com");
		person.setAddress(address);
		
		person.setPhoneNo("+82100100");
		person.setBirthDate(new Date());
		
		person.setNote("some one from java workshope");
		
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			String jsonInString = mapper.writeValueAsString(person);
			
			System.out.println(jsonInString);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
