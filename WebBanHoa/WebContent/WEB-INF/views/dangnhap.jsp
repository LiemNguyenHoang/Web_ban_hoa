<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<jsp:include page="header.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đăng nhập</title>
</head>

<body>
	<div id="headerSP" class="container-fluid">
		<nav id="navbar-none"
			class=" navbar navbar-expand-lg navbar-light bg-light ">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
			<ul id="navbar-center" class="navbar-nav mr-auto ">
				<li class="nav-item"><a class="nav-link" href="home.htm">TRANG CHỦ</a></li>
				<li class="nav-item dropdown" >
					<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> SẢN PHẨM </a>
					<ul class="dropdown-menu" aria-labelledby="navbarDropdown" style="background: black !important">	
						<c:forEach var="value" items="${listloaisanpham }">
							<li style="padding:10px !important"><a href="danhmuc/${value.getId() }.htm">${value.getTenLoai() }</a></li>
							<li role="separator" class="divider"></li>
						</c:forEach>	
					</ul>
				</li>
				<li class="nav-item"><a class="nav-link" href="#">LIÊN HỆ</a></li>
			</ul>

			<ul id="navbar-right" class="navbar-nav mr-auto navbar-center">

				<li style="margin-bottom:10px" ><img id="imgshopping" src="<c:url value="/resource/image/shopping-cart.png"></c:url>" /></li>
				<li class="soluonggiohang" ><span>${soluong}</span></li>
			</ul>

		</div>
		</nav>
	</div>

	<div id = "container" style="margin:100px !important;margin-left:400px !important;margin-right:400px !important;">
		<div>
			<div style="margin:10px"><span id="dangnhap" class="actived">Đăng nhập</span> / <span id="dangky">Đăng ký </span><span>(* Dùng chữ hoa, thường, số)</span></div>
			
			<div id="login" >
					
					<form>
						  <div class="form-group ">
						    <input type="text" class="form-control" id="tendangnhap"  name="tenDangNhap" placeholder="Tên đăng nhập">
						  </div>
						  <div class="form-group">
						    <input type="password" class="form-control" id="matkhau" name="matKhau" placeholder="Mật khẩu">
						  </div>
						  
					</form>
					<input id="btnDangNhap" value="Đăng nhập" type="submit" class="btn btn-primary" style="margin-left:225px !important"> 

			</div>

			<div id="signup" style="display:none">
				
				<form>
						  <div class="form-group">
						    <input type="text" class="form-control" id="tendangky"  name="tenDangNhap" placeholder="Tên đăng nhập">
						  </div>
						  <div class="form-group">
						    <input type="password" class="form-control" id="matkhaudangky" name="matKhau" placeholder="Mật khẩu">
						  </div>
						  <div class="form-group">
						    <input type="password" class="form-control" id="nhaplaimatkhaudangky" name="nhapLaimatKhau" placeholder="Nhập lại mật khẩu">
						  </div>
						  
					</form>
				
				<input id="btnDangKy" value="Đăng ký" type="submit" class="btn btn-primary" style="margin-left:225px !important"> 
				
				
				<span id="ketqua" class="material-textinput" type="text"></span> 
			</div>
			
		</div>





	</div>

	<div id="footer" class="container-fluid">
	
	
		<div class="row">
			<div class="col-md-4">
				<span>THÔNG TIN</span> <span>Tự </span>
			</div>
			<div class="col-md-4">
				<span>LIÊN HỆ</span>
			</div>
			<div class="col-md-4">
				<p>
					<span class="title-footer">GÓP Ý</span>
				</p>
				<form action="index.htm">
					<input class="material-textinput" name="email"
						style="margin-bottom: 8px" type="text" placeholder="Email" />
					<textarea class="material-textinput" name="noidung" rows="2"
						cols="50" placeholder="Nội dung"></textarea>
					<button class="material-primary-button" style="margin-top: 10px">Gửi</button>
				</form>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>






















