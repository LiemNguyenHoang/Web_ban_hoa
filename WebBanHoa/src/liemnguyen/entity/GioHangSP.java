package liemnguyen.entity;

public class GioHangSP {
	private int idSanPham,
	soLuong,
	gia;
	private String tenSanPham;
	private String hinhAnh;

	public GioHangSP() {
		super();
	}

	public GioHangSP(int idSanPham, int soLuong, int gia, String tenSanPham, String hinhAnh) {
		super();
		this.idSanPham = idSanPham;
		this.soLuong = soLuong;
		this.gia = gia;
		this.tenSanPham = tenSanPham;
		this.hinhAnh = hinhAnh;
	}

	public int getIdSanPham() {
		return idSanPham;
	}

	public void setIdSanPham(int idSanPham) {
		this.idSanPham = idSanPham;
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

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	

}
