package crawring;

import java.sql.Timestamp;

public class KeywordDAO {
	private String title;
	private String img_url;
	private String architects;
	private String location;
	private String category;
	private String partnerInCharge;
	private String projectArchitect;
	private String projectTeam;
	private String projectYear;
	private String photographs;
	private String clients;
	private String lightingConsultant;
	
	/*
	 * 1. 아키타이져 https://architizer.com/
	 * 
	 * 2. 아키데일리 https://www.archdaily.com/
	 * 
	 * 3. 디자인붐_건축파트 https://www.designboom.com/architecture/
	 * 
	 * 4. 디진_건축파트 https://www.dezeen.com/architecture/
	 */
	
	public String getImg_url() {
		return img_url;
	}
	@Override
	public String toString() {
		return "KeywordDAO [title=" + title + ", img_url=" + img_url + ", architects=" + architects + ", location="
				+ location + ", category=" + category + ", partnerInCharge=" + partnerInCharge + ", projectArchitect="
				+ projectArchitect + ", projectTeam=" + projectTeam + ", projectYear=" + projectYear + ", photographs="
				+ photographs + ", clients=" + clients + ", lightingConsultant=" + lightingConsultant
				+ ", construction=" + construction + ", city=" + city + ", nation=" + nation + ", area=" + area
				+ ", completionYear=" + completionYear + ", regDate=" + regDate + "]";
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPartnerInCharge() {
		return partnerInCharge;
	}
	public void setPartnerInCharge(String partnerInCharge) {
		this.partnerInCharge = partnerInCharge;
	}
	public String getProjectArchitect() {
		return projectArchitect;
	}
	public void setProjectArchitect(String projectArchitect) {
		this.projectArchitect = projectArchitect;
	}
	public String getProjectTeam() {
		return projectTeam;
	}
	public void setProjectTeam(String projectTeam) {
		this.projectTeam = projectTeam;
	}
	public String getProjectYear() {
		return projectYear;
	}
	public void setProjectYear(String projectYear) {
		this.projectYear = projectYear;
	}
	public String getPhotographs() {
		return photographs;
	}
	public void setPhotographs(String photographs) {
		this.photographs = photographs;
	}
	public String getClients() {
		return clients;
	}
	public void setClients(String clients) {
		this.clients = clients;
	}
	public String getLightingConsultant() {
		return lightingConsultant;
	}
	public void setLightingConsultant(String lightingConsultant) {
		this.lightingConsultant = lightingConsultant;
	}
	public String getConstruction() {
		return construction;
	}
	public void setConstruction(String construction) {
		this.construction = construction;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	private String construction;
	private String city;
	private String nation;

	
	private String area;
	private String completionYear;
	
	private Timestamp regDate;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCompletionYear() {
		return completionYear;
	}
	public void setCompletionYear(String completionYear) {
		this.completionYear = completionYear;
	}
	}
