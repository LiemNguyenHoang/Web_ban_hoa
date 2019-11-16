package liemnguyen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import liemnguyen.dao.DonHangDAO;
import liemnguyen.daoimp.DonHangImp;
import liemnguyen.entity.DonHang;
import liemnguyen.entity.GioHang;
import liemnguyen.entity.GioHangSP;
import liemnguyen.entity.User;

@Service
public class DonHangService implements DonHangImp {
	@Autowired
	DonHangDAO donHangDAO;

	@Override
	public boolean themDonHang(GioHang gioHang,User user) {
		// TODO Auto-generated method stub
		return donHangDAO.themDonHang(gioHang,user);
	}

	@Override
	public List<DonHang> layDanhSachDonHangLimit(int start) {
		// TODO Auto-generated method stub
		return donHangDAO.layDanhSachDonHangLimit(start);
	}

	@Override
	public DonHang layDonHang(int idDonHang) {
		// TODO Auto-generated method stub
		return donHangDAO.layDonHang(idDonHang);
	}

	@Override
	public boolean capNhatDonHang(DonHang donHang) {
		// TODO Auto-generated method stub
		return donHangDAO.capNhatDonHang(donHang);
	}

	@Override
	public boolean xoaDonHangTheoId(int id) {
		// TODO Auto-generated method stub
		return donHangDAO.xoaDonHangTheoId(id);
	}

	@Override
	public boolean xoaChiTietDonHangTheoId(int id) {
		// TODO Auto-generated method stub
		return donHangDAO.xoaChiTietDonHangTheoId(id);
	}


}
