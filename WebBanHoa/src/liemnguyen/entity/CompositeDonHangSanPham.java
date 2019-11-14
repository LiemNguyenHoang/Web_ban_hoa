package liemnguyen.entity;

import java.io.Serializable;
import java.util.Collection;

public class CompositeDonHangSanPham implements Serializable {
	// private int idDonHang;
	// private int idSanPham;
	private Collection<DonHang> donHangs;
	private Collection<SanPham> sanPhams;

	public CompositeDonHangSanPham() {
		super();
	}

	public CompositeDonHangSanPham(Collection<DonHang> donHangs, Collection<SanPham> sanPhams) {
		super();
		this.donHangs = donHangs;
		this.sanPhams = sanPhams;
	}

	public Collection<DonHang> getDonHangs() {
		return donHangs;
	}

	public void setDonHangs(Collection<DonHang> donHangs) {
		this.donHangs = donHangs;
	}

	public Collection<SanPham> getSanPhams() {
		return sanPhams;
	}

	public void setSanPhams(Collection<SanPham> sanPhams) {
		this.sanPhams = sanPhams;
	}

	
}
