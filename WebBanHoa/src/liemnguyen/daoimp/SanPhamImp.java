package liemnguyen.daoimp;

import java.util.List;

import liemnguyen.entity.LoaiSanPham;
import liemnguyen.entity.SanPham;

public interface SanPhamImp {
	List<SanPham> layDanhSachSanPhamLimit(int start);
	SanPham laySanPham(int idSanPham);
	List<SanPham> listSanPhamTheoLoai(int idLoai);
	boolean xoaSanPhamTheoId(int id);
	boolean themSanPham(SanPham sanPham);
}
