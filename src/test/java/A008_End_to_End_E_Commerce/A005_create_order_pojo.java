package A008_End_to_End_E_Commerce;

import java.util.List;

public class A005_create_order_pojo {
		private List<A006_create_order2> orders;
		
		
		
		public List<A006_create_order2> getOrders() {
			return orders;
		}



		public void setOrders(List<A006_create_order2> orders) {
			this.orders = orders;
		}




public static class A006_create_order2 {
					private String country;
			private String productOrderedId;
			public String getCountry() {
				return country;
			}
			public String getProductOrderedId() {
				return productOrderedId;
			}
			public void setCountry(String country) {
				this.country = country;
			}
			public void setProductOrderedId(String productOrderedId) {
				this.productOrderedId = productOrderedId;
			}
		
}
}


