package liemnguyen.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ChiTietDonHang")
public class ChiTietDonHang {
	@Id
	@Column(name = "id_chi_tiet_don_hang")
	@GeneratedValue
	private int idChiTietDonHang;
	
	
	@ManyToOne
	@JoinColumn(name = "id_don_hang")
	private DonHang donHang;
	
	@Column(name = "so_luong_sp")
	private int soLuong;
	@Column(name = "gia")
	private int gia;
	
	@Column(name = "id_san_pham")
	private int idSanPham;
	
	// End
	public ChiTietDonHang() {
		super();
	}

	public ChiTietDonHang(DonHang donHang, int soLuong, int gia, int idSanPham) {
		super();
		this.donHang = donHang;
		this.soLuong = soLuong;
		this.gia = gia;
		this.idSanPham = idSanPham;
	}

	public int getIdChiTietDonHang() {
		return idChiTietDonHang;
	}

	public void setIdChiTietDonHang(int idChiTietDonHang) {
		this.idChiTietDonHang = idChiTietDonHang;
	}

	public DonHang getDonHang() {
		return donHang;
	}

	public void setDonHang(DonHang donHang) {
		this.donHang = donHang;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

	public int getIdSanPham() {
		return idSanPham;
	}

	public void setIdSanPham(int idSanPham) {
		this.idSanPham = idSanPham;
	}

	

	



	
}
