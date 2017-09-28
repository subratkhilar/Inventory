package com.imagestore.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.imagestore.model.Booking;

@PropertySource("classpath:application.properties")
public class BookingControllerTestImpl {

	private static final Logger LOGGER = Logger.getLogger(BookingControllerTestImpl.class);
	public static final String REST_SERVICE_URI = "http://localhost:2222";
	private static HttpHeaders getHeaders(){
    	HttpHeaders headers = new HttpHeaders();
    	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
   
    	return headers;
    	
    }
	private static void createUser() {
        System.out.println("\nTesting create User API----------");
        RestTemplate restTemplate = new RestTemplate();
        Booking booking = new Booking();
		booking.setPsngrName("Test");
		booking.setDestination("Puri");
		booking.setDeparture("pqr33");
		booking.setTravelDate(new Date());
        HttpEntity<Object> request = new HttpEntity<Object>(booking);
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/booking/create", request, Booking.class);
        //System.out.println("Location : "+uri.toASCIIString());
    }
	@SuppressWarnings({ "unchecked", "rawtypes" })
    private static void listAllUsers(){
        System.out.println("\nTesting listAllUsers API-----------");
        RestTemplate restTemplate = new RestTemplate(); 
        HttpEntity<String> request = new HttpEntity<String>(getHeaders());
        System.out.println("response >>>>>>>>> "+restTemplate.exchange(REST_SERVICE_URI+"/booking/read-all/", HttpMethod.GET, request, List.class));
        ResponseEntity<List> response  = restTemplate.exchange(REST_SERVICE_URI+"/booking/read-all/", HttpMethod.GET, request, List.class);
        System.out.println("response >>>>>>>>> "+response);
        List<LinkedHashMap<String, Object>> usersMap = (List<LinkedHashMap<String, Object>>)response.getBody();
        if(usersMap!=null){
        	 for(LinkedHashMap<String, Object> map : usersMap){
                 System.out.println("User : id="+map.get("id")+", psngrName="+map.get("psngrName")+", departure="+map.get("departure")+", destination="+map.get("destination"));
             }
        }else{
            System.out.println("No user exist----------");
        }
    }
	public static void main(String[] args) {
		LOGGER.debug("Starting REST Client!!!!");

		try {
			
			createUser();
			//listAllUsers();
			//rt.postForObject(uri, booking, Booking.class);
		} catch (Exception e) {
			/**
			 *
			 * If we get a HTTP Exception display the error message
			 */
			e.printStackTrace();
			//LOGGER.error("error:  " + e.getResponseBodyAsString());
			//ObjectMapper mapper = new ObjectMapper();

		} 

	}

}
