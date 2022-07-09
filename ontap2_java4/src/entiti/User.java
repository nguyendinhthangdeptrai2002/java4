package entiti;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
@Id
@Column (name="id")
private String id;
@Column (name="name")
private String name;
@Column (name="email")
private String email;
@Column (name="birt")
private String birt;
@Column (name="chucvu")
private boolean chucvu=false;
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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getBirt() {
	return birt;
}
public void setBirt(String birt) {
	this.birt = birt;
}
public boolean isChucvu() {
	return chucvu;
}
public void setChucvu(boolean chucvu) {
	this.chucvu = chucvu;
}
	
}
