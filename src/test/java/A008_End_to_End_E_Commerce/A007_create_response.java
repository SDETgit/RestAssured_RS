package A008_End_to_End_E_Commerce;

import java.util.List;

public class A007_create_response {

	private List<String> orders;
	private List<String> productOrderId;
	private String message;
	public List<String> getOrders() {
		return orders;
	}
	public List<String> getProductOrderId() {
		return productOrderId;
	}
	public String getMessage() {
		return message;
	}
	public void setOrders(List<String> orders) {
		this.orders = orders;
	}
	public void setProductOrderId(List<String> productOrderId) {
		this.productOrderId = productOrderId;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
