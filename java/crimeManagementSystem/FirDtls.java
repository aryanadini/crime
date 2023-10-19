package crimeManagementSystem;

import java.sql.Date;

public class FirDtls {
	private int id;
private int firregistrationnumber;
private String dateofregistration;
private String district;

public String getDateofregistration() {
	return dateofregistration;
}
public void setDateofregistration(String dateofregistration) {
	this.dateofregistration = dateofregistration;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getFirregistrationnumber() {
	return firregistrationnumber;
}
public void setFirregistrationnumber(int firregistrationnumber) {
	this.firregistrationnumber = firregistrationnumber;
}

public String getDistrict() {
	return district;
}
public void setDistrict(String district) {
	this.district = district;
}

}