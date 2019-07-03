package paypaldemo.controller;

public class PaypalResponse {

	public PaypalResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String status;
	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public PaypalResponse(String status) {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
