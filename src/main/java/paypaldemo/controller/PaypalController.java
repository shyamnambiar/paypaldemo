package paypaldemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Controller
public class PaypalController {
	
	@GetMapping("/paypal")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		System.out.println("inside controller");
		final String uri = "http://localhost:8080/paypal/post";
		RestTemplate restTemplate = new RestTemplate();
		PaypalResponse response = new PaypalResponse();
		response = restTemplate.postForObject( uri, response, PaypalResponse.class);
        model.addAttribute("name", response.getStatus());
        return "paypaldemo";
    }
	
	


}
