package crimeManagementSystem;

import java.sql.Blob;
import java.sql.Date;

public class SuspectedCriminals {
public int id;
public Blob image,idproof;
public String fullname,gender,address,policestationname,officerincharge,remark;
public int height,weight;
public String dateofbirth,arrestdate;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Blob getImage() {
	return image;
}
public void setImage(Blob image) {
	this.image = image;
}
public Blob getIdproof() {
	return idproof;
}
public void setIdproof(Blob idproof) {
	this.idproof = idproof;
}
public String getFullname() {
	return fullname;
}
public void setFullname(String fullname) {
	this.fullname = fullname;
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
public String getPolicestationname() {
	return policestationname;
}
public void setPolicestationname(String policestationname) {
	this.policestationname = policestationname;
}
public String getOfficerincharge() {
	return officerincharge;
}
public void setOfficerincharge(String officerincharge) {
	this.officerincharge = officerincharge;
}
public String getRemark() {
	return remark;
}
public void setRemark(String remark) {
	this.remark = remark;
}
public int getHeight() {
	return height;
}
public void setHeight(int height) {
	this.height = height;
}
public int getWeight() {
	return weight;
}
public void setWeight(int weight) {
	this.weight = weight;
}
public String getDateofbirth() {
	return dateofbirth;
}
public void setDateofbirth(String dateofbirth) {
	this.dateofbirth = dateofbirth;
}
public String getArrestdate() {
	return arrestdate;
}
public void setArrestdate(String arrestdate) {
	this.arrestdate = arrestdate;
}



}
