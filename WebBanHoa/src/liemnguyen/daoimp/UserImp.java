package liemnguyen.daoimp;

import java.util.List;

import liemnguyen.entity.SanPham;
import liemnguyen.entity.User;

public interface UserImp {
	int kiemTraDangNhap(String tenDangNhap, String matKhau);
	int kiemTraDangKy(String tenDangNhap, String matKhau, String nhapLaiMatKhau);
	List<User> layDanhSachSanPhamLimit(int start);
	User layUser(String idUser);
	boolean capNhatUser(User user);
	int soLuongUser();
}
