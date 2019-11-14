package liemnguyen.entity;

import java.sql.Date;
import java.util.Collection;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="DonHang")
public class DonHang {
	@Id
	@Column(name = "id_don_hang")
	@GeneratedValue
	private int idDonHang;

	@Column(name = "tinh_trang")
	private boolean tinhTrang;
	@Column(name = "ngay_mua")
	private String ngayMua;
	@Column(name = "ghi_chu")
	private String ghiChu;
	@Column(name = "ten_nguoi_mua")
	private String tenNguoiMua;
	@Column(name = "sdt")
	private String sdt;
	@Column(name = "dia_chi")
	private String diaChi;

	
	
	public DonHang() {
		super();
	}

	public DonHang(boolean tinhTrang, String ngayMua, String ghiChu, String tenNguoiMua, String sdt, String diaChi) {
		super();
		this.tinhTrang = tinhTrang;
		this.ngayMua = ngayMua;
		this.ghiChu = ghiChu;
		this.tenNguoiMua = tenNguoiMua;
		this.sdt = sdt;
		this.diaChi = diaChi;
	}
	

	public int getIdDonHang() {
		return idDonHang;
	}

	public void setIdDonHang(int idDonHang) {
		this.idDonHang = idDonHang;
	}

	public boolean isTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public String getNgayMua() {
		return ngayMua;
	}

	public void setNgayMua(String ngayMua) {
		this.ngayMua = ngayMua;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public String getTenNguoiMua() {
		return tenNguoiMua;
	}

	public void setTenNguoiMua(String tenNguoiMua) {
		this.tenNguoiMua = tenNguoiMua;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}



	
	

}
