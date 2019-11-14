package liemnguyen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import liemnguyen.dao.SanPhamDAO;
import liemnguyen.daoimp.SanPhamImp;
import liemnguyen.daoimp.UserImp;
import liemnguyen.entity.LoaiSanPham;
import liemnguyen.entity.SanPham;

@Service
public class SanPhamService implements SanPhamImp{
	@Autowired
	SanPhamDAO sanPhamDAO;


	@Override
	public List<SanPham> layDanhSachSanPhamLimit(int start) {
		// TODO Auto-generated method stub
		List<SanPham> listSanPhams = sanPhamDAO.layDanhSachSanPhamLimit(start);
		return listSanPhams;
	}

	@Override
	public SanPham laySanPham(int idSanPham) {
		// TODO Auto-generated method stub
		return sanPhamDAO.laySanPham(idSanPham);
	}

	@Override
	public List<SanPham> listSanPhamTheoLoai(int idLoai) {
		// TODO Auto-generated method stub
		return sanPhamDAO.listSanPhamTheoLoai(idLoai);
	}

	@Override
	public boolean xoaSanPhamTheoId(int id) {
		// TODO Auto-generated method stub
		return sanPhamDAO.xoaSanPhamTheoId(id);
	}

	@Override
	public boolean themSanPham(SanPham sanPham) {
		// TODO Auto-generated method stub
		return sanPhamDAO.themSanPham(sanPham);
	}
	
	
}
