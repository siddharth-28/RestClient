package com.example.restTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.restTemplate.domain.StudentDAO;

/**
 * Hello world!
 *
 */
public class App 
{

	
    public static void main( String[] args )
    {
    	RestTemplate restTemplate = new RestTemplate();
    	ResponseEntity<String> response = restTemplate.getForEntity(
    	        "http://localhost:8081/example",
    	        String.class);
    	
    	  System.out.println( "Hello World!" );
    	  String jsonStringUser = "{"
    		        + "\"id\":\"\"" + ","
    		        + "\"name\":\"abhinay\"" + ","
    		        + "\"rollNum\":\"152923\""
    		        + "}";
    	  HttpHeaders headers = new HttpHeaders();
    	  headers.setContentType( MediaType.APPLICATION_JSON );
    	HttpEntity entity =  new HttpEntity( jsonStringUser, headers );
    	StudentDAO stud = restTemplate.postForObject( "http://localhost:8081/examples", entity, StudentDAO.class );
    	System.out.println(entity);
    
    	System.out.println(response);
      
    }
    
}
