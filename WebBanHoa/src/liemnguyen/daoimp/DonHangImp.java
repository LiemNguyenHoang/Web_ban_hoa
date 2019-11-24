package liemnguyen.daoimp;

import java.util.List;

import liemnguyen.entity.DonHang;
import liemnguyen.entity.GioHang;
import liemnguyen.entity.GioHangSP;
import liemnguyen.entity.SanPham;
import liemnguyen.entity.User;

public interface DonHangImp {
	boolean themDonHang(GioHang gioHang,User user);
	List<DonHang> layDanhSachDonHangLimit(int start);
	DonHang layDonHang(int idDonHang);
	boolean capNhatDonHang(DonHang donHang);
	boolean xoaDonHangTheoId(int id);
	boolean xoaChiTietDonHangTheoId(int id);
	int soLuongDonHang();
}
