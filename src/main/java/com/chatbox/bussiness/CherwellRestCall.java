package com.chatbox.bussiness;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ws.rs.core.MultivaluedMap;

import com.fasterxml.jackson.core.io.JsonEOFException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;


public class CherwellRestCall {
	private static final String 
	APPLICATION_JSON_CHARSET_UTF_8 = "application/json";
	private static final String APPLICATION_X_WWW_FORM_URLENCODED = "application/x-www-form-urlencoded";
	//private static final String CONTENT_TYPE = "Content-Type";
	private final static String USER_AGENT = "Mozilla/5.0 (Windows NT 6.3; rv:36.0) Gecko/20100101 Firefox/36.04";
	private final static String urlAuthenticate = "http://10.41.12.38/CherwellAPI/token?api_key=cc152cdc-027b-4f4e-8f8a-18bcfefcdc61";
	private final static String urlsearchresult = "http://10.41.12.38/CherwellAPI/api/V1/getsearchresults";
	private final static String urlExecute = "http://10.41.12.38/CherwellAPI/api/V1/savebusinessobject";

	private final static String username = "CSDAdmin";
	private final static String pass = "CSDAdmin";
	private final static String grant_type = "password";
	private final static String client_id = "88b32b2d-5cec-4fcf-b66c-48bef8f394e4";

	static String inputLine="";
	public String autohantication() throws IOException, JsonEOFException{
		String token;
		Client client = Client.create();
		WebResource webResource = client.resource(urlAuthenticate);
		MultivaluedMap<String, String> x = new MultivaluedMapImpl();
		ArrayList<String> x1 = new ArrayList<>();
		ArrayList<String> x2 = new ArrayList<>();
		ArrayList<String> x3 = new ArrayList<>();
		ArrayList<String> x4 = new ArrayList<>();
		x1.add(grant_type);
		x2.add(client_id);
		x3.add(username);
		x4.add(pass);
		x.put("grant_type", x1);
		x.put("client_id", x2);
		x.put("username", x3);
		x.put("password", x4);

		ClientResponse res = webResource.type(
				APPLICATION_X_WWW_FORM_URLENCODED).post(ClientResponse.class, x);

		String output = res.getEntity(String.class);
		System.out.println("Authenticate Call Status: " + res.getStatus());
		Matcher m1 = 
				Pattern.compile("\"access_token\":\"([^\"]*)\"").matcher(output);

		if(!m1.find()) {
			System.out.println("Authentication call DOESNOT return token.");
		}
		token = m1.group(1);
		System.out.println("Authentication token: " + token);

		return token;
		/*String outputJSON = "";
		String t2="";
		String str ="";
		//String postDataBody = "";
		//Get Values from property file

		// POST example URL
		URL obj = new URL(urlAuthenticate);

		// Send post request
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// Basic reuqest header to simulate a browser request
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Content-Type", " application/x-www-form-urlencoded");
		String postDataBody = "grant_type=password&client_id=cc152cdc-027b-4f4e-8f8a-18bcfefcdc61&username=CSDAdmin&password=CSDAdmin";
		// Payload
		con.setDoOutput(true); 
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());

		// POST data added to the request as a part of body
		wr.writeBytes(postDataBody);
		wr.flush();
		wr.close();

		// Reading the HTML output of the POST HTTP request
		//int responseCode = con.getResponseCode();
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		while ((inputLine = in.readLine()) != null)
		{
			str=inputLine;
		}

		String sessionToken = new JSONObject(str).getString("access_token");
		System.out.println("Access Token : "+sessionToken);
		in.close();

        Client client = Client.create();
    	WebResource webResource = client.resource(urlExecute);
		ClientResponse res = webResource.type(
				APPLICATION_X_WWW_FORM_URLENCODED).post(ClientResponse.class, x);


		return sessionToken;*/
	}
	
			
	public String execute(String token,String description, String shortDescription,String clientId) throws Exception 
	{
		RasaIntegration ri=new RasaIntegration();
	   //Object ServiceValue="";
	   String ServiceValue="",CategoryValue="",SubcategoryValue="";
		HashMap<String,String> hm=ri.check_response(description);  
		ServiceValue= hm.get("Service");
		CategoryValue=hm.get("Category");
		SubcategoryValue=hm.get("Subcategory");
			System.out.println("Service : "+ServiceValue);
			System.out.println("Category : "+CategoryValue);
			System.out.println("Subcategory : "+SubcategoryValue);
		
		String outputJSON = "";
		String inputjson="{"
				+"  \"busObId\": \"6dd53665c0c24cab86870a21cf6434ae\","
				+"  \"fields\": ["
				+"{"
				+ "  \"dirty\": true,"
				+ "  \"displayName\": \"Description\","
				+"  \"fieldId\": \"252b836fc72c4149915053ca1131d138\","
				+ "  \"name\": \"Description\","
				+"  \"value\": \""+description+"\""
				+"},"
				+ "{"
				+"  \"dirty\": true,"
				+"  \"displayName\": \"Priority\","
				+ "  \"fieldId\": \"83c36313e97b4e6b9028aff3b401b71c\","
				+"  \"name\": \"Priority\","
				+"  \"value\": \"3\""
				+"},"
				+"{"
				+ "  \"dirty\": true,"
				+ "  \"displayName\": \"Customer ID\","
				+ "  \"fieldId\": \"933bd530833c64efbf66f84114acabb3e90c6d7b8f\","
				+ "  \"name\": \"CustomerRecID\","
				+"  \"value\": "+clientId+"    },"
				+"{"
				+"  \"dirty\": true,"
				+"  \"displayName\": \"Short Description\","
				+ "  \"fieldId\": \"93e8ea93ff67fd95118255419690a50ef2d56f910c\","
				+ "  \"name\": \"laptop is not working\","
				+"  \"value\": \""+shortDescription+"\""
				+"},"
				+ "{"
				+"  \"dirty\": true,"
				+ "  \"displayName\": \"Call Source\","
				+ "  \"fieldId\": \"93670bdf8abe2cd1f92b1f490a90c7b7d684222e13\","
				+"  \"name\": \"CallSource\","
				+ "  \"value\": \"Chat Session\""
				+"},"
				+ "{"
				+  "  \"dirty\": true,"
				+  "  \"displayName\": \"Service\","
				+ "  \"fieldId\": \"936725cd10c735d1dd8c5b4cd4969cb0bd833655f4\","
				+ "  \"name\": \"Service\","
				+ "  \"value\": \""+ServiceValue+"\""
				+"},"
				+ "{"
				+ "  \"dirty\": true,"
				+  "  \"displayName\": \"Category\","
				+ "  \"fieldId\": \"9e0b434034e94781ab29598150f388aa\","
				+  "  \"name\": \"Category\","
				+ "  \"value\": \""+CategoryValue+"\""
				+"},"
				+"{"
				+ "  \"dirty\": true,"
				+ "  \"displayName\": \"Subcategory\","
				+ "  \"fieldId\": \"1163fda7e6a44f40bb94d2b47cc58f46\","
				+ "  \"name\": \"Subcategory\","
				+ "  \"value\":  \""+SubcategoryValue+"\""
				
				+"}"
				+"]"
				+"}";
		/*"{  \"busObId\": \"6dd53665c0c24cab86870a21cf6434ae\","
				+ "  \"fields\": ["
				+ "    {      \"dirty\": true,"
				+ "      \"displayName\": \"Description\","
				+ "      \"fieldId\": \"252b836fc72c4149915053ca1131d138\","
				+ "      \"name\": \"Description\","
				+ "      \"value\": \""+description+"\""
				+ "    },"
				+ "    {      \"dirty\": true,"
				+ "      \"displayName\": \"Priority\","
				+ "      \"fieldId\": \"83c36313e97b4e6b9028aff3b401b71c\","
				+ "      \"name\": \"Priority\","
				+ "      \"value\": \"3\""
				+ "    },    {"
				+ "      \"dirty\": true,"
				+ "      \"displayName\": \"Customer ID\","
				+ "      \"fieldId\": \"933bd530833c64efbf66f84114acabb3e90c6d7b8f\","
				+ "      \"name\": \"CustomerRecID\","
				+ "      \"value\": "+clientId+"    },"
				+ "    {      \"dirty\": true,"
				+ "      \"displayName\": \"Short Description\","
				+ "      \"fieldId\": \"93e8ea93ff67fd95118255419690a50ef2d56f910c\","
				+ "      \"name\": \"ShortDescription\","
				+ "      \"value\": \""+shortDescription+"\""
				+ "    },    {"
				+ "      \"dirty\": true,"
				+ "      \"displayName\": \"Call Source\","
				+ "      \"fieldId\": \"93670bdf8abe2cd1f92b1f490a90c7b7d684222e13\","
				+ "      \"name\": \"CallSource\","
				+ "      \"value\": \"Chat Session\""
				+ "    }, "
				+"{"
				+ "      \"dirty\": true,"
				+ "      \"displayName\": \"Service\","
				+ "      \"fieldId\": \"936725cd10c735d1dd8c5b4cd4969cb0bd833655f4\","
				+ "      \"name\":\"Service\","
				+ "      \"value\":\""+ServiceValue+"\""
				+  "},"
				+  "{"
				+  "      \"dirty\": true,"
				+  "      \"displayName\": \"Category\","
				+  "      \"fieldId\": \"9e0b434034e94781ab29598150f388aa\","
				+  "      \"name\": \"Category\","
				+"      \"value\": \""+CategoryValue+"\""
				+  "},"
				+"{"
				+ "      \"dirty\": true,"
				+  "      \"displayName\": \"Subcategory\","
				+ "      \"fieldId\": \"1163fda7e6a44f40bb94d2b47cc58f46\","
				+"      \"name\": \"Subcategory\","
				+ "      \"value\": \""+SubcategoryValue+"\""
				+"}"
				+"]}";
				*/
		token = "Bearer "+token;
		System.out.println("Json input : "+inputjson);
		String ticketId = "";
		try{
			URL url = new URL(String.valueOf(urlExecute));
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "Application/json");
			//conn.setRequestProperty("x-session-token", token);
			conn.setRequestProperty("Authorization", token);
			byte[] outputInBytes = inputjson.getBytes("UTF-8");
			//System.out.println(inputjson);
			OutputStream os = conn.getOutputStream();
			os.write(outputInBytes);    
			os.close();

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String t2="";
			while ((t2 = br.readLine()) != null) {
				outputJSON = String.valueOf(outputJSON) + t2;
			}
			conn.disconnect();
			Matcher m1 = 
					Pattern.compile("\"busObPublicId\":\"([^\"]*)\"").matcher(outputJSON);

			if(!m1.find()) {
				System.out.println("Authentication call DOESNOT return token.");
			}
			ticketId = m1.group(1);
			System.out.println("Authentication ticketID: " + ticketId);
		}catch(Exception e){
			e.printStackTrace();
		}
		return ticketId;
	}

	public String sendSkypedetail(String name, String token){
		String outputJSON = "";
		String inputjson="{"
				+ "	\"filters\": ["
				+ "	{ \"fieldId\": \"9432f2e8b2027c742db6e546fcadb9d94a5142c807\","
				+ "	\"operator\": \"eq\","
				+ "	\"value\": \""+name+"\""
				+ "	}		],"
				+ "\"association\": \"Customer - Internal\","
				+ "\"busObId\": \"93405caa107c376a2bd15c4c8885a900be316f3a72\","
				+ "\"fields\": ["
				+ "\"9337c2311be1de079984b34edb8aa7129a564327a2\"],"
				+ "\"includeAllFields\": false,"
				+ "\"scope\": \"Global\","
				+ "\"scopeOwner\": \"None\","
				+ "\"searchId\": \"string\","
				+ "\"searchName\": \"Chat Bot Employees\"}";
		token = "Bearer  "+token;
		//String ticketId = "";
		String userId = "";
		try{
			URL url = new URL(String.valueOf(urlsearchresult));
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			//conn.setRequestProperty("x-session-token", token);
			conn.setRequestProperty("Authorization", token);
			byte[] outputInBytes = inputjson.getBytes("UTF-8");
			OutputStream os = conn.getOutputStream();
			os.write(outputInBytes);    
			os.close();

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String t2="";
			while ((t2 = br.readLine()) != null) {
				outputJSON = String.valueOf(outputJSON) + t2;
			}

			conn.disconnect();
			System.out.println("Output Json : "+outputJSON);
			/*String result =  (new JSONPObject(outputJSON).get("businessObjects").toString()).replace("[", "").replace("]", "");
			//System.out.println("Result :"+result.toString());
			userId = new JSONPObject( new JSONPObject(result).get("fields").toString()).get("value").toString();
			System.out.println("User Id: " + userId);*/
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
		    ObjectMapper mapper1 = new ObjectMapper();
		    JsonNode actualObj = mapper1.readTree(outputJSON);
		    String jsonNode1 = (actualObj.get("businessObjects").toString()).replace("[", "").replace("]", "");
		     actualObj = mapper1.readTree(jsonNode1);
		     jsonNode1 = actualObj.get("fields").toString();
		     actualObj = mapper1.readTree(jsonNode1);
		     userId = actualObj.get("value").toString();
		    System.out.println("JSon Node : "+jsonNode1.toString());
		    
		    System.out.println("User Id: " + userId);
		}catch (Exception e) 
		{
		   e.printStackTrace();
		   // TODO: handle exception
		}
		return userId;
	}
	/*public static void main(String[] args) throws JsonEOFException, IOException {
		CherwellRestCall cwl = new CherwellRestCall();
		String token = cwl.autohantication();
		String clientId = cwl.sendSkypedetail("Pradnya Pujari", token); 
		System.out.println(cwl.execute(token,"test","test", clientId));
	}*/
}
