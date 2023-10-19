package crimeManagementSystem;

import java.sql.Blob;

public class MostWanted {
	public int id;
public String policestationname,fullname,nickname,gender,address,identifyingmark,description;
public String dateofbirth;
public Blob idproof,image;
public Blob getImage() {
	return image;
}
public void setImage(Blob image) {
	this.image = image;
}
public String getPolicestationname() {
	return policestationname;
}
public void setPolicestationname(String policestationname) {
	this.policestationname = policestationname;
}
public String getFullname() {
	return fullname;
}
public void setFullname(String fullname) {
	this.fullname = fullname;
}
public String getNickname() {
	return nickname;
}
public void setNickname(String nickname) {
	this.nickname = nickname;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getIdentifyingmark() {
	return identifyingmark;
}
public void setIdentifyingmark(String identifyingmark) {
	this.identifyingmark = identifyingmark;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}

public Blob getIdproof() {
	return idproof;
}
public void setIdproof(Blob idproof) {
	this.idproof = idproof;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getDateofbirth() {
	return dateofbirth;
}
public void setDateofbirth(String dateofbirth) {
	this.dateofbirth = dateofbirth;
}


}
