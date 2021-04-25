package com;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML 
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

import model.Customer;

@Path("/Customer")
public class CustomerService {
	Customer registerObj = new Customer();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readCustomer() {
		return registerObj.readCustomer();
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertCustomer(@FormParam("pName") String pName,
			
	 @FormParam("pAddress") String pAddress,
	 @FormParam("pEmail") String pEmail,
	 @FormParam("pDate") String pDate,
	 @FormParam("gender") String gender,
	 @FormParam("pno") String pno)
	{
	 String output = registerObj.insertCustomer(pName, pAddress, pEmail, pDate, gender, pno);
	return output;
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updatePatient(String customerData)
	{
	//Convert the input string to a JSON object
	 JsonObject regObject = new JsonParser().parse(customerData).getAsJsonObject();
	//Read the values from the JSON object
	 String pID = regObject.get("pID").getAsString();
	 String pName = regObject.get("pName").getAsString();
	 String pAddress = regObject.get("pAddress").getAsString();
	 String pEmail = regObject.get("pEmail").getAsString();
	 String pDate = regObject.get("pDate").getAsString();
	 String gender = regObject.get("gender").getAsString();
	 String pno = regObject.get("pno").getAsString();
	 String output = registerObj.updateCustomer(pID, pName, pAddress, pEmail, pDate, gender, pno);
	return output;
	} 
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteCustomer(String customerData)
	{
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(customerData, "", Parser.xmlParser());

	//Read the value from the element <itemID>
	 String pID = doc.select("pID").text();
	 String output = registerObj.deleteCustomer(pID);
	return output;
	}
}
