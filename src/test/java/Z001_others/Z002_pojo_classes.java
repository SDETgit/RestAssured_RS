package Z001_others;

import java.util.List;

public class Z002_pojo_classes {
	private String instructor;
	private String url;
	private String services;
	private String expertise;
	private String linkedIn;
	private String courses;

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
	public String getLinkedIn() {
		return linkedIn;
	}
	public String getCourses() {
		return courses;
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
	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}
	public void setCourses(String courses) {
		this.courses = courses;
	}
}

class courses {
	public List<webAutomation> getWebAutomation() {
		return webAutomation;
	}
	public List<api> getApi() {
		return api;
	}
	public List<mobile> getMobile() {
		return mobile;
	}
	public void setWebAutomation(List<webAutomation> webAutomation) {
		this.webAutomation = webAutomation;
	}
	public void setApi(List<api> api) {
		this.api = api;
	}
	public void setMobile(List<mobile> mobile) {
		this.mobile = mobile;
	}
	private List< webAutomation> webAutomation;
	private List<api> api;
	private List<mobile> mobile;
	
	}
	
	class webAutomation {
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
	
	class api {
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
	
	class mobile {
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

	
