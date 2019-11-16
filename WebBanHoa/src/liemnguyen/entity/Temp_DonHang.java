package liemnguyen.entity;

public class Temp_DonHang {
	private Integer MaSanPham;
	private String TenSanPham;
	private Integer SoLuong;
	private Integer Gia;
	
	public Temp_DonHang() {
		super();
	}

	public Temp_DonHang(Integer maSanPham, String tenSanPham, Integer soLuong, Integer gia) {
		super();
		MaSanPham = maSanPham;
		TenSanPham = tenSanPham;
		SoLuong = soLuong;
		Gia = gia;
	}

	public Integer getMaSanPham() {
		return MaSanPham;
	}

	public void setMaSanPham(Integer maSanPham) {
		MaSanPham = maSanPham;
	}

	public String getTenSanPham() {
		return TenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		TenSanPham = tenSanPham;
	}

	public Integer getSoLuong() {
		return SoLuong;
	}

	public void setSoLuong(Integer soLuong) {
		SoLuong = soLuong;
	}

	public Integer getGia() {
		return Gia;
	}

	public void setGia(Integer gia) {
		Gia = gia;
	}

	
	
}
