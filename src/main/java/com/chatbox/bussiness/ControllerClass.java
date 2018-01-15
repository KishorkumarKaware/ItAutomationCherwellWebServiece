package com.chatbox.bussiness;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//import org.codehaus.jackson.map.ObjectMapper;

import com.chatbox.model.API_Request_Model;
import com.chatbox.model.Parameters;
import com.chatbox.model.ResponseMdl;
import com.chatbox.model.Result;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("itautocherwell")
public class ControllerClass {
	static String result = "";

	@GET
	public Response getMsg() {
		return Response.status(200).entity("Hello").build();

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getConf(String outputJSON) throws Exception {

		System.out.println("Request recieved");
		API_AI_Request response = new API_AI_Request();

		//System.out.println("responceBO : " + response.toString());
		API_Request_Model apiAiResponse = response.jsonToJava(outputJSON);

		//System.out.println("apiAiResponse : " + apiAiResponse);

		Result rs = apiAiResponse.getResult();
		
		
		//System.out.println("rs :" + rs.toString());
          Parameters param = rs.getParameters();
          String description = param.getDescription();
          int d_length = description.length();
          String shortDescription = "";
          if(d_length <30){
        	  shortDescription = description;
          }else{
        	  shortDescription = description.substring(0, 135) + "...";
          }
          String name = "";
  		try{
  		name = apiAiResponse.getOriginalRequest().getData().getUser().getName();
  		}catch(Exception e){
  			//e.printStackTrace();
  		}
		CherwellRestCall aeRestCall = new CherwellRestCall();
		String token = aeRestCall.autohantication();
		String clientId = aeRestCall.sendSkypedetail(name, token);
		
		String ticketId =aeRestCall.execute(token,description,shortDescription,clientId);
		ResponseMdl res=new ResponseMdl();
		//String ticketId = "";
		
		// Case: Software Install
			 System.out.println("User Name : " + name);
			 String msg = "";
	  //  if(name.equals("")){
	    	msg =" Your requested ticket is successfully generated. Your ticket number is :"+ticketId;
	    /*}else
	    {
		 msg ="Mr/miss."+name+"\n Congrats.! Your requested ticket is successfully generated. Your ticket number is :"+ticketId;
	    }*/
		System.out.println("........................");
		//ResponseMdl res = new ResponseMdl();
		res.setSource("policyWS");
		res.setSpeech(msg);
		res.setDisplayText(msg);
        System.out.println("........................");

		ObjectMapper om = new ObjectMapper();
		String str2 = om.writeValueAsString(res);

		return Response.status(200).entity(str2).header("Content-Type", "application/json").build();
	}
}
