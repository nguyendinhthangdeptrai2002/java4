package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="nhanvien")
public class nhanVien {
@Id
@Column(name ="id")
private String id;
@Column(name ="name")
private String name;
@Column(name ="salary")
private String salary;
@Column(name ="department")
private String department;
@Column(name ="address")
private String address;
@Column(name ="position")
private boolean position =false;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSalary() {
	return salary;
}
public void setSalary(String salary) {
	this.salary = salary;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public boolean isPosition() {
	return position;
}
public void setPosition(boolean position) {
	this.position = position;
}


}
