package crimeManagementSystem;

import java.sql.Blob;
import java.sql.Date;

public class PostMortum {
public int id;
public String fullname,gender,address,doctorsname,hospitaladdress,descriptionofcase;
public String dateofbirth,dateofpostmortum;
public Blob image,idproof,postmortum;
public int firid;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
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
public String getDoctorsname() {
	return doctorsname;
}
public void setDoctorsname(String doctorsname) {
	this.doctorsname = doctorsname;
}
public String getHospitaladdress() {
	return hospitaladdress;
}
public void setHospitaladdress(String hospitaladdress) {
	this.hospitaladdress = hospitaladdress;
}
public String getDescriptionofcase() {
	return descriptionofcase;
}
public void setDescriptionofcase(String descriptionofcase) {
	this.descriptionofcase = descriptionofcase;
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
public Blob getPostmortum() {
	return postmortum;
}
public void setPostmortum(Blob postmortum) {
	this.postmortum = postmortum;
}

public String getDateofbirth() {
	return dateofbirth;
}
public void setDateofbirth(String dateofbirth) {
	this.dateofbirth = dateofbirth;
}
public String getDateofpostmortum() {
	return dateofpostmortum;
}
public void setDateofpostmortum(String dateofpostmortum) {
	this.dateofpostmortum = dateofpostmortum;
}
public int getFirid() {
	return firid;
}
public void setFirid(int firid) {
	this.firid = firid;
}

}
