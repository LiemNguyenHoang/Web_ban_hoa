package liemnguyen.daoimp;

import java.util.List;

import liemnguyen.entity.LoaiSanPham;

public interface LoaiSanPhamImp {
	List<LoaiSanPham> listLoaiSanPham();
	LoaiSanPham layLoaiTheoMa(int maLoai);
}
