package com.oracle.Expenses.botAutomation;


import java.util.List;
import java.util.Map;

import org.apache.poi.util.SystemOutLogger;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveAuthProvider;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest extends BaseTest {
	
	@Test
	void getexpensePreferredList()
	{
		logger.info("Entered the base test");
		RestAssured.baseURI="https://fuscdrmsmc406-fa-ext.us.oracle.com/fscmRestApi/resources/latest";
		//Request Object
		PreemptiveBasicAuthScheme authScheme= new PreemptiveBasicAuthScheme();
		authScheme.setUserName("EXMVS.EMP3");
		authScheme.setPassword("Welcome1");
		RestAssured.authentication=authScheme;
		RequestSpecification httprequest=RestAssured.given();
		
		//httprequest.auth().basic("EXMVS.EMP3","Welcome1");
		
		//Response Object
		//Path parameter
		Response response=httprequest.request(Method.GET,"/expensePreferredTypes");
		
		String responseBody=response.getBody().asString();
		
		System.out.println(responseBody);
		System.out.println(response.getStatusCode());
		response.header("Content Type");//specific header
		Headers allheader = response.headers();//all headers
		
		for(Header header : allheader )
		{
			System.out.println("Header name"+ header.getName());
			System.out.println("Header value"+ header.getValue());
		}
		
		JsonPath jsonpath=response.jsonPath();
		
		System.out.println("The value"+jsonpath.get("count"));
		
		  List<Map<String, String>> companies = response.jsonPath().getList("items");
	        System.out.println(companies.get(0).get("MerchantName"));
	}
}
	
	/*@Test
	void postExpense()
	{
		RestAssured.baseURI="https://fuscdrmsmc405-fa-ext.us.oracle.com/fscmRestApi/resources/latest";
		//Request Object
		RequestSpecification httprequest=RestAssured.given();
		httprequest.auth().basic("EXMVS.EMP3","Welcome1");
		
		//Response Object
		//Path parameter
		Response response=httprequest.request(Method.GET,"/expensePreferredTypes");
		
		String responseBody=response.getBody().asString();
		
		System.out.println(responseBody);
		System.out.println(response.getStatusCode());
		
		
		
		
		
		
	}*/
	

	
	
	

