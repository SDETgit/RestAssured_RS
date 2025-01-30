package A006_Serealisation_google_map;

public class S002_pojo_class {
	private S003_pojo_location location;
	private int accuracy;
	private String name;
	private String phone_number;
	private String address;
	private String website;
	private String language;
	private S004_pojo_types types;
	public S004_pojo_types getTypes() {
		return types;
	}
	public void setTypes(S004_pojo_types types) {
		this.types = types;
	}
	public S003_pojo_location getLocation() {
		return location;
	}
	public int getAccuracy() {
		return accuracy;
	}
	public String getName() {
		return name;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public String getAddress() {
		return address;
	}
	public String getWebsite() {
		return website;
	}
	public String getLanguage() {
		return language;
	}
	public void setLocation(S003_pojo_location location) {
		this.location = location;
	}
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	
}
