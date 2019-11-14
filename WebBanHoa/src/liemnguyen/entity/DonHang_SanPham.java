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
import javax.persistence.Table;

@Entity
@Table(name = "DonHang_SanPham")
public class DonHang_SanPham {
	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;
	
	@Column(name = "so_luong_sp")
	private int soLuong;
	@Column(name = "gia")
	private int gia;
	@Column(name = "id_san_pham")
	private int idSanPham;
	@Column(name = "id_don_hang")
	private int idDonHang;
	
	// End
	public DonHang_SanPham() {
		super();
	}



	public DonHang_SanPham(int soLuong, int gia, int idSanPham, int idDonHang) {
		super();
		this.soLuong = soLuong;
		this.gia = gia;
		this.idSanPham = idSanPham;
		this.idDonHang = idDonHang;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getIdDonHang() {
		return idDonHang;
	}

	public void setIdDonHang(int idDonHang) {
		this.idDonHang = idDonHang;
	}

	

	
	
}
