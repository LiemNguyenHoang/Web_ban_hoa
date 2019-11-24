package liemnguyen.dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.SystemException;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import liemnguyen.controller.TrangChuController;
import liemnguyen.daoimp.DonHangImp;
import liemnguyen.entity.DonHang;
import liemnguyen.entity.ChiTietDonHang;
import liemnguyen.entity.GioHang;
import liemnguyen.entity.GioHangSP;
import liemnguyen.entity.SanPham;
import liemnguyen.entity.User;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DonHangDAO implements DonHangImp {
	@Autowired
	SanPhamDAO sanPhamDAO;

	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public boolean themDonHang(GioHang gioHang, User user) {

		// TODO Auto-generated method stub
		// start

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		if(user.getTenDangNhap()==null){
			user=new User("noname", "12345", null, null, null, null, null);
			System.out.println("user tendangnhap: null");
		}
		System.out.println("user getTenDangNhap: "+user.getTenDangNhap());
		DonHang donHang = new DonHang(user,false, dtf.format(now).toString(), gioHang.getGhiChu(), gioHang.getTenNguoiMua(),
				gioHang.getSdt(), gioHang.getDiaChi());

		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.save(donHang);
			t.commit();
			System.out.println("thêm donhang ok");
			session.close();
			
			// Start: thêm chitietdonhang
			
			for(int i = 0;i<gioHang.getListGioHangSP().size();i++){
				GioHangSP gioHangSP =    gioHang.getListGioHangSP().get(i);
				SanPham sanPham = sanPhamDAO.laySanPham(gioHangSP.getIdSanPham()) ;
				ChiTietDonHang chiTietDonHang = new ChiTietDonHang(donHang, gioHangSP.getSoLuong(), gioHangSP.getSoLuong()*gioHangSP.getGia(), sanPham.getIdSanPham());
				
				session = sessionFactory.openSession();
				t =  session.beginTransaction();
				try{
					session.save(chiTietDonHang);
					t.commit();
					System.out.println("chitietdonhang "+i+": "+" OK");
					
				}catch(Exception e){
					t.rollback();
					System.out.println("chitietdonhang "+i+": "+" Not OK");
					return false;
				}

				
			}
			
			// End
			session.close();
			return true;
		} catch (Exception e) {

			t.rollback();
			session.close();
			return false;
		}
		// end
		
		
		// Session session = sessionFactory.openSession();
		// org.hibernate.Transaction t = (org.hibernate.Transaction)
		// session.beginTransaction();
		//
		// String date = java.time.LocalDate.now().toString();
		// DonHang donHang = new DonHang(true, date, gioHang.getGhiChu(),
		// gioHang.getTenNguoiMua(), gioHang.getSdt(),
		// gioHang.getDiaChi());
		//
		// try {
		// session.save(donHang);
		// t.commit();
		// System.out.println("Save DonHang complete");
		//
		// } catch (Exception e) {
		// try {
		// t.rollback();
		// System.out.println("Save DonHang fail");
		//
		// } catch (Exception e1) {
		//
		// }
		// } finally {
		// session.close();
		// }
		//
		// // Start: thêm đơn hàng
		// for (int i = 0; i < gioHang.getListGioHangSP().size(); i++) {
		// DonHang_SanPham donHang_SanPham = new DonHang_SanPham();
		// donHang_SanPham = new DonHang_SanPham(
		// gioHang.getListGioHangSP().get(i).getSoLuong(),
		// gioHang.getListGioHangSP().get(i).getGia(),
		// gioHang.getListGioHangSP().get(i).getIdSanPham(),
		// donHang.getIdDonHang());
		//
		//// donHang_SanPham.setIdSanPham(gioHang.getListGioHangSP().get(i).getIdSanPham());
		//// donHang_SanPham.setIdDonHang(donHang.getIdDonHang());
		//// donHang_SanPham.setSoLuong(gioHang.getListGioHangSP().get(i).getSoLuong());
		//// donHang_SanPham.setGia(gioHang.getListGioHangSP().get(i).getGia());
		//
		//
		//
		// session = sessionFactory.openSession();
		// t = (org.hibernate.Transaction) session.beginTransaction();
		// try {
		// session.save(donHang_SanPham);
		// t.commit();
		// System.out.println("Save DonHang_SanPham: " + i + " complete");
		//
		// } catch (Exception e) {
		// try {
		// t.rollback();
		// System.out.println("Save DonHang_SanPham: " + i + " fail:
		// "+e.getMessage());
		//
		// } catch (Exception e1) {
		//
		// }
		// } finally {
		// session.close();
		// }
		//
		// }
		// // End
		// // DonHang_SanPham donHang_SanPham = new DonHang_SanPham(gioHang.g,
		// // soLuong, gia, sanPham, donHang)
		// // End */
		//
		// // long id=session.save(gioHang);
		// // if(id>0){
		// // return true;
		// // }
		// return false;
	}

	@Override
	@Transactional
	public List<DonHang> layDanhSachDonHangLimit(int start) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession(); 
		String hql = "from DonHang  order by idDonHang desc";
		Query query =  session.createQuery(hql);
		if(start>=0){
			query.setFirstResult(start);
			query.setMaxResults(TrangChuController.LIMIT_SP);
		}
		List<DonHang> listDonHangs = query.list();
		return listDonHangs;
	}

	@Override
	@Transactional
	public DonHang layDonHang(int idDonHang) {
		// TODO Auto-generated method stub
		System.out.println("===");
		Session session = sessionFactory.getCurrentSession();
		String hql = "from DonHang where idDonHang="+idDonHang;
		Query query = session.createQuery(hql);
		DonHang donHang = (DonHang) query.uniqueResult();
		return donHang;
	}

	@Override
	@Transactional
	public boolean capNhatDonHang(DonHang donHang) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction t =  session.beginTransaction();
		try{
			session.update(donHang);
			t.commit();
			return true;
		}catch(Exception e){
			t.rollback();
			return false;
		}
	}

	@Override
	@Transactional
	public boolean xoaDonHangTheoId(int id) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.getCurrentSession();
		DonHang donHang = new DonHang();
		donHang = layDonHang(id);
		session.delete(donHang);
		return false;
	}

	@Override
	@Transactional
	public boolean xoaChiTietDonHangTheoId(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		ChiTietDonHang  chiTietDonHang = new ChiTietDonHang();
		chiTietDonHang.setIdChiTietDonHang(id);
		session.delete(chiTietDonHang);
		return false;
	}

	@Override
	@Transactional
	public int soLuongDonHang() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession(); 
		String hql = "from DonHang";
		Query query =  session.createQuery(hql);
		List<DonHang> listDonHangs = query.list();
		return listDonHangs.size();
	}
	

}
