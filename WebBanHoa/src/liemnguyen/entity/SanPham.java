package liemnguyen.entity;

import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.webkit.dom.DOMWindowImpl;

@Entity
@Table(name = "SanPham")
public class SanPham {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_sp")
	private int idSanPham;

	@ManyToOne
	@JoinColumn(name = "id_loai_sp")
	private LoaiSanPham loaiSanPham;

	@Column(name = "ten_sp")
	private String tenSanPham;
	@Column(name = "gia")
	private int gia;
	@Column(name = "hinh_anh")
	private String hinhAnh;

	@Column(name = "mo_ta")
	private String moTa;

	public SanPham() {
		super();
	}

	
	

	public SanPham(LoaiSanPham loaiSanPham, String tenSanPham, int gia, String hinhAnh, String moTa) {
		super();
		this.loaiSanPham = loaiSanPham;
		this.tenSanPham = tenSanPham;
		this.gia = gia;
		this.hinhAnh = hinhAnh;
		this.moTa = moTa;
	}




	public int getIdSanPham() {
		return idSanPham;
	}




	public void setIdSanPham(int idSanPham) {
		this.idSanPham = idSanPham;
	}




	public LoaiSanPham getLoaiSanPham() {
		return loaiSanPham;
	}




	public void setLoaiSanPham(LoaiSanPham loaiSanPham) {
		this.loaiSanPham = loaiSanPham;
	}





	public String getTenSanPham() {
		return tenSanPham;
	}




	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}




	public int getGia() {
		return gia;
	}




	public void setGia(int gia) {
		this.gia = gia;
	}




	public String getHinhAnh() {
		return hinhAnh;
	}




	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}




	public String getMoTa() {
		return moTa;
	}




	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}






	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String string = "id: " + this.idSanPham + "\n" 
				+ "Loai: " + this.loaiSanPham + "\n" 
				+ "Sản phẩm: " + this.tenSanPham + "\n" 
				+ "Giá: " + this.gia + "\n" 
				+ "Hình ảnh: " + this.hinhAnh + "\n" 
				+ "Mô tả: " + this.moTa;

		return string;
	}

}
