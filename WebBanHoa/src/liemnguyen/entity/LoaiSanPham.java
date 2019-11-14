package liemnguyen.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="LoaiSanPham")
public class LoaiSanPham {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_loai_sp")
	private int idLoaiSP;
	@Column(name="ten_loai_sp")
	private String tenLoai;
	
	@OneToMany(mappedBy="loaiSanPham",fetch=FetchType.EAGER)
	private Collection<SanPham> sanPhams;

	public LoaiSanPham() {
		super();
	}

	public LoaiSanPham(int idLoaiSP, String tenLoai) {
		super();
		this.idLoaiSP = idLoaiSP;
		this.tenLoai = tenLoai;
	}

	public Collection<SanPham> getSanPhams() {
		return sanPhams;
	}

	public void setSanPhams(Collection<SanPham> sanPhams) {
		this.sanPhams = sanPhams;
	}

	public int getId() {
		return idLoaiSP;
	}

	public void setId(int idLoaiSP) {
		this.idLoaiSP = idLoaiSP;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

}
