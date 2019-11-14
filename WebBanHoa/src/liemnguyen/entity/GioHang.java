package liemnguyen.entity;

import java.util.List;

public class GioHang {
	private List<GioHangSP> listGioHangSP;
	private String ghiChu, tenNguoiMua, sdt, diaChi;

	public GioHang() {
		super();
	}

	public GioHang(List<GioHangSP> listGioHangSP, String ghiChu, String tenNguoiMua, String sdt, String diaChi) {
		super();
		this.listGioHangSP = listGioHangSP;
		this.ghiChu = ghiChu;
		this.tenNguoiMua = tenNguoiMua;
		this.sdt = sdt;
		this.diaChi = diaChi;
	}

	public List<GioHangSP> getListGioHangSP() {
		return listGioHangSP;
	}

	public void setListGioHangSP(List<GioHangSP> listGioHangSP) {
		this.listGioHangSP = listGioHangSP;
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
