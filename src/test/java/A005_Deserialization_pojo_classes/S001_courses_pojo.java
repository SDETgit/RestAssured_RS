package A005_Deserialization_pojo_classes;

import java.util.List;

//What Additional Libraries required?
//For JSON you need to have either Jackson, Jackson2, Gson or Johnzon in the classpath and for XML you need JAXB.
//Java object is constructed with the support of POJO classes
//POJO classes are created based on the request/Response payload.


//Design Approach:
//Java object is constructed with the support of POJO classes
//POJO classes are created based on the request/Response payload.

//User friendly Methods can be created which makes code more readable.
//Design Approach:
//Java object is constructed with the support of POJO classes

//Easy to parse and extract response (Json/XML) values if they are wrapped as Java object.
//User friendly Methods can be created which makes code more readable.
//Design Approach:

//Rest Assured also Supports deserialization by converting Response body back to Java object Advantages:
//Easy to parse and extract response (Json/XML) values if they are wrapped as Java object.
//User friendly Methods can be created which makes code more readable.

//Serialization in Rest Assured context is a process of converting a Java object into Request body (Payload)
//Rest Assured also Supports deserialization by converting Response body back to Java object Advantages:
//Easy to parse and extract response (Json/XML) values if they are wrapped as Java object.

//Serialization & Deserialization of Request/Responses with POJO classes
//Serialization in Rest Assured context is a process of converting a Java object into Request body (Payload)
//Rest Assured also Supports deserialization by converting Response body back to Java object Advantages:



public class S001_courses_pojo {

	private String instructor;
	private String url;
	private String services;
	private String expertise;
	private S002_get_courses courses;
	private String linkedIn;
	
	public String getInstructor() {
		return instructor;
	}
	public String getUrl() {
		return url;
	}
	public String getServices() {
		return services;
	}
	public String getExpertise() {
		return expertise;
	}
	public S002_get_courses getCourses() {
		return courses;
	}
	public String getLinkedIn() {
		return linkedIn;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	public void setCourses(S002_get_courses courses) {
		this.courses = courses;
	}
	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}

public static class S002_get_courses {
	private List<S003_Webautomation> webAutomation ;
	private List<S004_Api> api;
	private List<S005_mobile> mobile ;
	
	

	public List<S003_Webautomation> getWebAutomation() {
		return webAutomation;
	}
	public List<S004_Api> getApi() {
		return api;
	}
	public List<S005_mobile> getMobile() {
		return mobile;
	}
	public void setWebAutomation(List<S003_Webautomation> webAutomation) {
		this.webAutomation = webAutomation;
	}
	public void setApi(List<S004_Api> api) {
		this.api = api;
	}
	public void setMobile(List<S005_mobile> mobile) {
		this.mobile = mobile;
	}}
	
	public static class S003_Webautomation {

		private String courseTitle;
		private String price; 
		
		
		public String getCourseTitle() {
			return courseTitle;
		}
		public String getPrice() {
			return price;
		}
		public void setCourseTitle(String courseTitle) {
			this.courseTitle = courseTitle;
		}
		public void setPrice(String price) {
			this.price = price;
		}}
		
		public static  class S004_Api {

			private String courseTitle;
			private String price; 
			
			
			public String getCourseTitle() {
				return courseTitle;
			}
			public String getPrice() {
				return price;
			}
			public void setCourseTitle(String courseTitle) {
				this.courseTitle = courseTitle;
			}
			public void setPrice(String price) {
				this.price = price;
			}
		}
			
			public static  class S005_mobile {

				private String courseTitle;
				private String price; 
				
				
				public String getCourseTitle() {
					return courseTitle;
				}
				public String getPrice() {
					return price;
				}
				public void setCourseTitle(String courseTitle) {
					this.courseTitle = courseTitle;
				}
				public void setPrice(String price) {
					this.price = price;
				}}
}
