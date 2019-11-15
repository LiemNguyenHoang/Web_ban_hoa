package liemnguyen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import liemnguyen.dao.SanPhamDAO;
import liemnguyen.dao.UserDAO;
import liemnguyen.daoimp.UserImp;
import liemnguyen.entity.SanPham;
import liemnguyen.entity.User;

@Service
public class UserService implements UserImp{
	@Autowired
	UserDAO userDAO;

	@Override
	public int kiemTraDangNhap(String tenDangNhap, String matKhau) {
		return userDAO.kiemTraDangNhap(tenDangNhap, matKhau);
	}

	@Override
	public int kiemTraDangKy(String tenDangNhap, String matKhau, String nhapLaiMatKhau) {
		// TODO Auto-generated method stub
		return userDAO.kiemTraDangKy(tenDangNhap, matKhau, nhapLaiMatKhau);
	}

	@Override
	public List<User> layDanhSachSanPhamLimit(int start) {
		// TODO Auto-generated method stub
		return userDAO.layDanhSachSanPhamLimit(start);
	}

	@Override
	public User layUser(String idUser) {
		// TODO Auto-generated method stub
		return userDAO.layUser(idUser);
	}

	
}
