package A005_Deserialization_pojo_classes;


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



public class S001_courses {

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
	
}
