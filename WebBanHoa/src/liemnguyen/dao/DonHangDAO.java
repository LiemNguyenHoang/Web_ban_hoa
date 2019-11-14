package liemnguyen.dao;

import java.util.List;

import javax.transaction.SystemException;
import javax.transaction.Transaction;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import liemnguyen.daoimp.DonHangImp;
import liemnguyen.entity.DonHang;
import liemnguyen.entity.DonHang_SanPham;
import liemnguyen.entity.GioHang;
import liemnguyen.entity.GioHangSP;
import liemnguyen.entity.SanPham;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DonHangDAO implements DonHangImp {
	@Autowired
	SanPhamDAO sanPhamDAO;

	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public boolean themHoaDon(GioHang gioHang) {
		System.out.println("+++");
		System.out.println("them don hang ");
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		org.hibernate.Transaction t = (org.hibernate.Transaction) session.beginTransaction();

		String date = java.time.LocalDate.now().toString();
		DonHang donHang = new DonHang(true, date, gioHang.getGhiChu(), gioHang.getTenNguoiMua(), gioHang.getSdt(),
				gioHang.getDiaChi());
		
		try {
			session.save(donHang);
			t.commit();
			System.out.println("Save DonHang complete");

		} catch (Exception e) {
			try {
				t.rollback();
				System.out.println("Save DonHang fail");

			} catch (Exception e1) {

			}
		} finally {
			session.close();
		}

		// Start: thêm đơn hàng
		for (int i = 0; i < gioHang.getListGioHangSP().size(); i++) {
			DonHang_SanPham donHang_SanPham = new DonHang_SanPham();
			donHang_SanPham = new DonHang_SanPham( 
				gioHang.getListGioHangSP().get(i).getSoLuong(), 
				gioHang.getListGioHangSP().get(i).getGia(), 
				gioHang.getListGioHangSP().get(i).getIdSanPham(), 
				donHang.getIdDonHang());
			
//			donHang_SanPham.setIdSanPham(gioHang.getListGioHangSP().get(i).getIdSanPham()); 
//			donHang_SanPham.setIdDonHang(donHang.getIdDonHang()); 
//			donHang_SanPham.setSoLuong(gioHang.getListGioHangSP().get(i).getSoLuong());
//			donHang_SanPham.setGia(gioHang.getListGioHangSP().get(i).getGia());

	
			
			session = sessionFactory.openSession();
			t = (org.hibernate.Transaction) session.beginTransaction();
			try {
				session.save(donHang_SanPham);
				t.commit();
				System.out.println("Save DonHang_SanPham: " + i + " complete");

			} catch (Exception e) {
				try {
					t.rollback();
					System.out.println("Save DonHang_SanPham: " + i + " fail: "+e.getMessage());

				} catch (Exception e1) {

				}
			} finally {
				session.close();
			}

		}
		// End
		// DonHang_SanPham donHang_SanPham = new DonHang_SanPham(gioHang.g,
		// soLuong, gia, sanPham, donHang)
		// End	*/

		// long id=session.save(gioHang);
		// if(id>0){
		// return true;
		// }
		return false;
	}

}
