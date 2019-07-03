package paypaldemo.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PaypalPostController {
	

	
	 @PostMapping("/paypal/post")
	 
	    public PaypalResponse createUser(@RequestBody PaypalRequest paypalRequest) {
		 	PaypalResponse response = new PaypalResponse();
	                
		 	response.setStatus("success from post");
		 	
	        return response;
	    }
	 @PostMapping("/paypal/order")
	 public PaypalResponse createOrder() {
		 System.out.println("inside createOrder");
			String str="{\n" + 
					"  \"intent\": \"CAPTURE\",\n" + 
					"  \"purchase_units\": [\n" + 
					"  {\n" + 
					"    \"reference_id\": \"5decd4b7-3779-4b2e-9d86-6d79e49b1dc8\",\n" + 
					"    \"description\": \"Default Level 1 Order\",\n" + 
					"    \"items\": [\n" + 
					"    {\n" + 
					"      \"name\": \"Salad\",\n" + 
					"      \"sku\": \"SKU-d3538cf2-e46b-4257-bcc6-6ad4b80957ee\",\n" + 
					"      \"currency\": \"USD\",\n" + 
					"      \"quantity\": 1,\n" + 
					"      \"category\": \"PHYSICAL_GOODS\",\n" + 
					"      \"unit_amount\": {\n" + 
					"      \"currency_code\": \"USD\",\n" + 
					"      \"value\": \"1.00\"\n" + 
					"      }\n" + 
					"    }\n" + 
					"    ],\n" + 
					"    \"amount\":     {\n" + 
					"      \"value\": \"3.00\",\n" + 
					"      \"currency_code\": \"USD\",\n" + 
					"      \"breakdown\":       {\n" + 
					"        \"item_total\":        {\n" + 
					"          \"currency_code\": \"USD\",\n" + 
					"          \"value\": \"1.00\"\n" + 
					"        },\n" + 
					"        \"shipping\":         {\n" + 
					"          \"currency_code\": \"USD\",\n" + 
					"          \"value\": \"1.00\"\n" + 
					"        },\n" + 
					"        \"tax_total\":         {\n" + 
					"          \"currency_code\": \"USD\",\n" + 
					"          \"value\": \"1.00\"\n" + 
					"        }\n" + 
					"      }\n" + 
					"    },\n" + 
					"    \"payee\":\n" + 
					"    {\n" + 
					"      \"email\": \"shyam@smartwaveindia.com\",\n" + 
					"      \"payee_display_metadata\":\n" + 
					"      {\n" + 
					"        \"brand_name\": \"Shyam Test Store\",\n" + 
					"        \"phone\":\n" + 
					"        {\n" + 
					"          \"country_code\": \"1\",\n" + 
					"          \"number\": \"\"\n" + 
					"        }\n" + 
					"      }\n" + 
					"    },\n" + 
					"    \n" + 
					"    \"shipping_address\":\n" + 
					"    {\n" + 
					"      \"recipient_name\": \"Rylee Lueilwitz\",\n" + 
					"      \"line1\": \"965 Hilma Rapid\",\n" + 
					"      \"line2\": \"Apartment Number 91392\",\n" + 
					"      \"city\": \"Gilbert\",\n" + 
					"      \"country_code\": \"US\",\n" + 
					"      \"postal_code\": \"85298\",\n" + 
					"      \"state\": \"AZ\",\n" + 
					"      \"phone\": \"0018882211161\"\n" + 
					"    },\n" + 
					"    \"shipping_method\": \"United Postal Service\",\n" + 
					"    \"payment_linked_group\": 1,\n" + 
					"    \"custom\": \"MyCustomVar\",\n" + 
					"    \"invoice_number\": \"INV-d5719503-5efc-4426-a7b3-09a345d10da2\",\n" + 
					"    \"payment_descriptor\": \"Payment Nate Shop\",\n" + 
					"    \"partner_fee_details\":\n" + 
					"    {\n" + 
					"      \"amount\":\n" + 
					"      {\n" + 
					"        \"currency\": \"USD\",\n" + 
					"        \"value\": \"6.89\"\n" + 
					"      },\n" + 
					"      \"receiver\":\n" + 
					"      {\n" + 
					"        \"email\": \"javad.paypal.test-facilitator@gmail.com\",\n" + 
					"        \"merchant_id\": \"6RTE74QWR2394\",\n" + 
					"        \"payee_display_metadata\":\n" + 
					"        {\n" + 
					"          \"email\": \"\",\n" + 
					"          \"display_phone\":\n" + 
					"          {\n" + 
					"            \"country_code\": \"001\",\n" + 
					"            \"number\": \"8882211161\"\n" + 
					"          },\n" + 
					"          \"brand_name\": \"APEX\"\n" + 
					"        }\n" + 
					"      }\n" + 
					"    }\n" + 
					"  }]\n" + 
					"}";
			//String str="{\"intent\": \"CAPTURE\",\"purchase_units\": [{\"amount\": {\"currency_code\": \"USD\",\"value\": \"100.00\"},\"payee\": {\"email_address\": \"javad@india.cogbooks.com\"},\"payment_instruction\": {\"disbursement_mode\": \"INSTANT\",\"platform_fees\": [{\"amount\": {\"currency_code\": \"USD\",\"value\": \"25.00\"}}]}}]}";
		 	
			String token=getToken();
			String authHeader="Bearer "+token;
			String res="";
			PaypalResponse response = new PaypalResponse();            
		 	//response.setStatus("success from post");
			try {
			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", authHeader);
	        headers.add("Content-Type", "application/json");
		    RestTemplate restTemplate = new RestTemplate();
	        org.springframework.http.HttpEntity request = new org.springframework.http.HttpEntity(str, headers);
	        //ResponseEntity<String> response = restTemplate.exchange("https://api.sandbox.paypal.com/v2/checkout/orders", HttpMethod.POST, request, String.class); //postForEntity("https://api.sandbox.paypal.com/v2/checkout/orders", request, String.class); /
	        response = restTemplate.postForObject("https://api.sandbox.paypal.com/v2/checkout/orders", request, PaypalResponse.class);
	        //String response1 = restTemplate.postForObject("https://api.sandbox.paypal.com/v2/checkout/orders", request, String.class);
			//System.out.println(response1);
			}
			catch(Exception e) {e.printStackTrace();}
		 return response;
	 }
	 private String getToken() {
		 return "A21AAHmu-WHo2nteiAMPlv5p5dw1Tl__H04aXLd4QY5leSZ0tPocawkF8koRl3C85CV23rBSSLD3_L3S7VzfzvHicMeZSKhrQ";
	 }
	 @PostMapping("/paypal/capture-order")
	 public PaypalResponse captureOrder(@RequestParam(name="orderid", required=false, defaultValue="") String orderId) {
		 System.out.println("inside capture Order  "+orderId);
			String str="";
			String token=getToken();
			String authHeader="Bearer "+token;
			String res="";
			PaypalResponse response = new PaypalResponse();            
//		 	response.setStatus("success");
//		 	response.setId(orderId);
			try {
			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", authHeader);
	        headers.add("Content-Type", "application/json");
		    RestTemplate restTemplate = new RestTemplate();
	        org.springframework.http.HttpEntity request = new org.springframework.http.HttpEntity(headers);
	        response = restTemplate.postForObject("https://api.sandbox.paypal.com/v2/checkout/orders/"+orderId+"capture", request, PaypalResponse.class);
	        //String response1 = restTemplate.postForObject("https://api.sandbox.paypal.com/v2/checkout/orders", request, String.class);
			//System.out.println(response1);
			}
			catch(Exception e) {e.printStackTrace();}
		 return response;
	 }


}
