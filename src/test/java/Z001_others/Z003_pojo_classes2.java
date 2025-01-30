package Z001_others;

import java.util.List;

public class Z003_pojo_classes2 {
	private String instructor;
	private String url;
	private String services;
	private String expertise;
	private String linkedIn;
	private courses courses;
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
	public Z001_others.Z003_pojo_classes2.courses getCourses() {
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
	public void setCourses(Z001_others.Z003_pojo_classes2.courses courses) {
		this.courses = courses;
	}
public	class Webaotumation  {
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
public	class api  {
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
	public class mobile  {
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
	
	public class courses {
		private List<Webaotumation> Webaotumation;
		private List<api> api;
		private List<mobile> mobile;
		public List<Webaotumation> getWebaotumation() {
			return Webaotumation;
		}
		public List<api> getApi() {
			return api;
		}
		public List<mobile> getMobile() {
			return mobile;
		}
		public void setWebaotumation(List<Webaotumation> webaotumation) {
			Webaotumation = webaotumation;
		}
		public void setApi(List<api> api) {
			this.api = api;
		}
		public void setMobile(List<mobile> mobile) {
			this.mobile = mobile;
		}
		
	}
	
	}


	
