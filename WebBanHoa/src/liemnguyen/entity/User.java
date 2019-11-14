package liemnguyen.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UserP")
public class User {
	@Id
	@Column(name="ten_dang_nhap")
	private String tenDangNhap;

	@Column(name="mat_khau")
	private String matKhau;
	@Column(name="ho_ten")
	private String hoTen;
	@Column(name="dia_chi")
	private String diaChi;
	@Column(name="email")
	private String email;
	@Column(name="sdt")
	private String sdt;
	@Column(name="hinh_anh")
	private String hinhAnh;
	public User() {
		super();
	}
	public User(String tenDangNhap, String matKhau, String hoTen, String diaChi, String email, String sdt,
			String hinhAnh) {
		super();
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.email = email;
		this.sdt = sdt;
		this.hinhAnh = hinhAnh;
	}
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	
}
