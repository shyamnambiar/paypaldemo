package paypaldemo.controller;

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


}
