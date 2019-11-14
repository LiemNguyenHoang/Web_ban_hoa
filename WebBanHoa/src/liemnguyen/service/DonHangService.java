package liemnguyen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import liemnguyen.dao.DonHangDAO;
import liemnguyen.daoimp.DonHangImp;
import liemnguyen.entity.GioHang;
import liemnguyen.entity.GioHangSP;

@Service
public class DonHangService implements DonHangImp {
	@Autowired
	DonHangDAO donHangDAO;

	@Override
	public boolean themHoaDon(GioHang gioHang) {
		// TODO Auto-generated method stub
		return donHangDAO.themHoaDon(gioHang);
	}


}
