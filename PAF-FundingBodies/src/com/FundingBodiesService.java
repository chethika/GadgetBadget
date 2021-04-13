  package com;

import model.FundingBodies;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML 
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/FundingBodies")

public class FundingBodiesService {
	FundingBodies FundingBodiesObj = new FundingBodies();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readFundingBodiess() {
		return FundingBodiesObj.readFundingBodiess();
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertFundingBodies(@FormParam("fid") String fid, @FormParam("des") String des,
			@FormParam("amount") String amount, @FormParam("date") String date) {
		String output = FundingBodiesObj.insertFundingBodies(fid, des, amount, date);
		return output;

	}

	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)

	public String updateFundingBodies(String FundingBodiesData) {
		// Convert the input string to a JSON object
		JsonObject FundingBodiesObject = new JsonParser().parse(FundingBodiesData).getAsJsonObject();

		// Read the values from the JSON object
		String fid = FundingBodiesObject.get("fid").getAsString();
		String des = FundingBodiesObject.get("des").getAsString();
		String amount = FundingBodiesObject.get("amount").getAsString();
		String date = FundingBodiesObject.get("date").getAsString();
		
		String output = FundingBodiesObj.updateFundingBodies(fid, des, amount, date);
		return output;
	}

	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteFundingBodies(String FundingBodiesData) {
		// Convert the input string to an XML document
		Document doc = Jsoup.parse(FundingBodiesData, "", Parser.xmlParser());

		// Read the value from the element <itemID>
		String fid = doc.select("fid").text();
		String output = FundingBodiesObj.deleteFundingBodies(fid);
		return output;
	}
}
