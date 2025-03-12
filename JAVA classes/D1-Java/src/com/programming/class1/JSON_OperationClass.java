package com.programming.class1;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JSON_OperationClass {
	
	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		ObjectNode jsonNode = objectMapper.createObjectNode();
		jsonNode.put("Name","ABC");
		jsonNode.put("Age","25");
		jsonNode.put("City","Bengaluru");
		jsonNode.put("State","Karnataka");
		jsonNode.put("Country","India");
		
		objectMapper.writeValue(new File("mydata.json"), jsonNode );
		
		JsonNode jsonNode2 = objectMapper.readTree(new File("mydata.json"));
		
		String name = jsonNode2.get("Name").asText();
		int age = jsonNode2.get("Age").asInt();
		String city = jsonNode2.get("City").asText();
		String state = jsonNode2.get("State").asText();
		String country = jsonNode2.get("Country").asText();
		
		System.out.println("Name is "+name +" and age is "+age);
		System.out.println("City is "+city +" and state is "+ state + " and country is "+ country );
	}
	
}
