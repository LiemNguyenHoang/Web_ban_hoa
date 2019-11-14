package liemnguyen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import liemnguyen.dao.LoaiSanPhamDAO;
import liemnguyen.daoimp.LoaiSanPhamImp;
import liemnguyen.entity.LoaiSanPham;

@Service
public class LoaiSanPhamService implements LoaiSanPhamImp {
	@Autowired
	LoaiSanPhamDAO loaiSanPhamDAO;

	@Override
	public List<LoaiSanPham> listLoaiSanPham() {
		// TODO Auto-generated method stub
		List<LoaiSanPham> list = loaiSanPhamDAO.listLoaiSanPham();
		return list;
	}

	@Override
	public LoaiSanPham layLoaiTheoMa(int maLoai) {
		// TODO Auto-generated method stub
		return loaiSanPhamDAO.layLoaiTheoMa(maLoai);
	}

}
