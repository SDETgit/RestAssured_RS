package A005_Deserialization_pojo_classes;

import java.util.List;

public class S002_get_courses {
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
	}
	
	
	
	
	
}
