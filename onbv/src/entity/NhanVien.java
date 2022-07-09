package entity;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="nhanvien")

public class NhanVien {
	@Id
	@Column (name = "id")
    private String id;
	@Column(name="name")
	private String name;
	@Column(name="sodt")
	private String sodt;
	@Column(name="email")
	private String email;
	@Column (name="ngaysinh")
	private Date ngaysinh;
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
	public String getSodt() {
		return sodt;
	}
	public void setSodt(String sodt) {
		this.sodt = sodt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public boolean isChucvu() {
		return chucvu;
	}
	public void setChucvu(boolean chucvu) {
		this.chucvu = chucvu;
	}
	
	
}
