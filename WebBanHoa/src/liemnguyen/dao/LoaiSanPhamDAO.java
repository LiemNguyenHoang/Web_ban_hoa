package liemnguyen.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import liemnguyen.daoimp.LoaiSanPhamImp;
import liemnguyen.entity.LoaiSanPham;
import liemnguyen.entity.SanPham;

@Repository
@Transactional
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class LoaiSanPhamDAO implements LoaiSanPhamImp {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<LoaiSanPham> listLoaiSanPham() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession(); 
		String hql = "from LoaiSanPham";
		Query query =  session.createQuery(hql);
		List<LoaiSanPham> listLoaiSanPhams = query.list();
		return listLoaiSanPhams;
	}

	@Override
	public LoaiSanPham layLoaiTheoMa(int maLoai) {
		// TODO Auto-generated method stub
		List<LoaiSanPham> listLoaiSanPham = listLoaiSanPham();
		for(LoaiSanPham loaiSanPham:listLoaiSanPham){
			if(loaiSanPham.getId()==maLoai){
				return loaiSanPham;
			}
		}
		return null;
	}

}
