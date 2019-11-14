package liemnguyen.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.Proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.*;

import liemnguyen.controller.TrangChuController;
import liemnguyen.daoimp.SanPhamImp;
import liemnguyen.daoimp.UserImp;
import liemnguyen.entity.LoaiSanPham;
import liemnguyen.entity.SanPham;

@Repository
@Transactional
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SanPhamDAO implements SanPhamImp {
	@Autowired
	SessionFactory sessionFactory;


	@Override
	public List<SanPham> layDanhSachSanPhamLimit(int start) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession(); 
		String hql = "from SanPham";
		Query query =  session.createQuery(hql);
		if(start>=0){
			query.setFirstResult(start);
			query.setMaxResults(TrangChuController.LIMIT_SP);
		}
		List<SanPham> listSanPhams = query.list();
		return listSanPhams;
	}

	@Override
	public SanPham laySanPham(int idSanPham) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql = "from SanPham where idSanPham="+idSanPham;
		Query query = session.createQuery(hql);
		SanPham sanPham = (SanPham) query.uniqueResult();
		return sanPham;
	}

	@Override
	public List<SanPham> listSanPhamTheoLoai(int idLoai) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.getCurrentSession(); 
		String hql = "from SanPham where loaiSanPham="+idLoai;
		Query query =  session.createQuery(hql);
		List<SanPham> listSanPhamTheoLoai = query.list();
		
		
//		return listSanPhams;
		
		return listSanPhamTheoLoai;
	}

	@Override
	public boolean xoaSanPhamTheoId(int id) {
		Session session = sessionFactory.getCurrentSession();
		SanPham sanPham = new SanPham();
		sanPham.setIdSanPham(id);
		session.delete(sanPham);
		return false;
	}

	@Override
	public boolean themSanPham(SanPham sanPham) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction t =  session.beginTransaction();
		try{
			session.save(sanPham);
			t.commit();
			return true;
		}catch(Exception e){
			t.rollback();
			return false;
		}
	}


}










