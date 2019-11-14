package liemnguyen.dao;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import liemnguyen.daoimp.UserImp;
import liemnguyen.entity.User;

@Repository
@Transactional
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserDAO implements UserImp {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public int kiemTraDangNhap(String tenDangNhap, String matKhau) {
		/*
		 * -1. lỗi select user 
		 *  0. user không tồn tại 
		 *  1. pass sai 
		 *  2. OK
		 *  3. admin
		 */
		Session session = sessionFactory.getCurrentSession();
		try {
			String hql = "SELECT tenDangNhap FROM User WHERE tenDangNhap='" + tenDangNhap + "'";
			Query query = session.createQuery(hql);
			String ten = (String) query.uniqueResult();
			if (ten == null) {
				return 0;
			} else {
				hql = "SELECT tenDangNhap FROM User WHERE tenDangNhap='" + tenDangNhap + "' AND matKhau='" + matKhau
						+ "'";
				query = session.createQuery(hql);
				ten = (String) query.uniqueResult();
				if (ten==null) {
					return 1;
				} else {
					if(tenDangNhap.equals("admin")==true){
						return 3;
					}
					return 2;
				}
			}
		} catch (Exception e) {
			return -1;
		}
	}

	@Override
	public int kiemTraDangKy(String tenDangNhap, String matKhau, String nhapLaiMatKhau) {
		/*
		 * -1. lỗi select user 
		 *  0. mật khẩu không giống nhau 
		 *  1. user đã tồn tại
		 *  2. thêm user thành công 
		 *  3. thêm user thất bại
		 */
		Session session = sessionFactory.getCurrentSession();
		if (matKhau.equals(nhapLaiMatKhau) == false) {
			return 0;
		}
		try {
			String hql = "SELECT tenDangNhap FROM User WHERE tenDangNhap='" + tenDangNhap + "'";
			Query query = session.createQuery(hql);
			String ten = (String) query.uniqueResult();
			System.out.println("tenDangNhap: " + tenDangNhap);
			System.out.println("ten: " + ten);
			if (ten == null) {
				// session.close();
				session = sessionFactory.openSession();
				org.hibernate.Transaction t = (org.hibernate.Transaction) session.beginTransaction();
				User user = new User(tenDangNhap, matKhau, null, null, null, null, null);
				try {
					session.save(user);
					t.commit();
					System.out.println("Save user complete");
					return 2;
				} catch (Exception e) {
					try {
						t.rollback();
						System.out.println("Save user fail");
						return 3;
					} catch (Exception e1) {
					}
				} finally {
					session.close();
				}

			} else {
				return 1;
			}
		} catch (Exception e) {

		}
		return -1;
	}

}
