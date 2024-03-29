package liemnguyen.dao;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import liemnguyen.daoimp.UserImp;
import liemnguyen.entity.SanPham;
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
		 * -3. matKhau không hợp lệ
		 * -2. tenDangNhap không hợp lệ
		 * -1. lỗi select user 
		 *  0. user không tồn tại 
		 *  1. pass sai 
		 *  2. OK
		 *  3. admin
		 */
		
		String parttern = "^[a-zA-Z0-9]{1,30}$";
		Pattern regex = Pattern.compile(parttern);
		Matcher matcher = regex.matcher(tenDangNhap);
		if(matcher.find()){
			// tenDangNhap hợp lệ
			matcher = regex.matcher(matKhau);
			if(matcher.find()){
				// matKhau hợp lệ
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
			}else{
				return -3;
			}
			
		}else{
			return -2;
		}
		
		
	}

	@Override
	public int kiemTraDangKy(String tenDangNhap, String matKhau, String nhapLaiMatKhau) {
		/*
		 * -3. matKhau không hợp lệ
		 * -2. tenDangNhap không hợp lệ
		 * -1. lỗi select user 
		 *  0. mật khẩu không giống nhau 
		 *  1. user đã tồn tại
		 *  2. thêm user thành công 
		 *  3. thêm user thất bại
		 */
		
		String parttern = "^[a-zA-Z0-9]{1,30}$";
		Pattern regex = Pattern.compile(parttern);
		Matcher matcher = regex.matcher(tenDangNhap);
		if(matcher.find()){
			// tenDangNhap hợp lệ
			matcher = regex.matcher(matKhau);
			if(matcher.find()){
				// matKhau hợp lệ
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
				
			}else{
				return -3;
			}
			
		}else{
			return -2;
		}
		
		
		return -1;
	}

	@Override
	public List<User> layDanhSachSanPhamLimit(int start) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession(); 
		String hql = "from User";
		Query query =  session.createQuery(hql);
		if(start>=0){
			query.setFirstResult(start);
			query.setMaxResults(TrangChuController.LIMIT_SP);
		}
		List<User> listUser = query.list();
		return listUser;
	}

	@Override
	public User layUser(String idUser) {
		// TODO Auto-generated method stub
		User user = new User();
		try{
			Session session = sessionFactory.getCurrentSession();
			String hql = "from User where tenDangNhap='"+idUser+"'";
			Query query = session.createQuery(hql);
			user = (User) query.uniqueResult();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return user;
	}

	@Override
	public boolean capNhatUser(User user) {
		Session session = sessionFactory.openSession();
		Transaction t =  session.beginTransaction();
		try{
			session.update(user);
			t.commit();
			return true;
		}catch(Exception e){
			t.rollback();
			return false;
		}
	}

	@Override
	public int soLuongUser() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession(); 
		String hql = "from User";
		Query query =  session.createQuery(hql);
		List<User> listUser = query.list();
		return listUser.size();
	}


}
