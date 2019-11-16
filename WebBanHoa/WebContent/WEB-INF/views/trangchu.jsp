<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<jsp:include page="header.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trang chủ</title>
</head>

<body>
	<div id="header" class="container-fluid">
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
					<ul class="dropdown-menu" aria-labelledby="navbarDropdown" style="background: none !important ;border: none !important">	
						<c:forEach var="value" items="${listloaisanpham }">
							<li style="padding:10px !important"><a href="danhmuc/${value.getId() }.htm">${value.getTenLoai() }</a></li>
							<li role="separator" class="divider"></li>
						</c:forEach>	
					</ul>
				</li>
				<li class="nav-item"><a class="nav-link" href="#">LIÊN HỆ</a></li>
			</ul>

			<ul id="navbar-right" class="navbar-nav mr-auto navbar-center">
				<c:choose>
					<c:when test="${user != null}">
						<c:choose>
							<c:when test="${user == admin}">
								<li class="nav-item" ><a class="nav-link" href="dashboard.htm" style="margin-top:-2px !important">${user}</a></li>
							</c:when>
							<c:otherwise>
								<li class="nav-item" ><a class="nav-link" href="userchitiet.htm" style="margin-top:-2px !important">${user}</a></li>
							</c:otherwise>
						</c:choose>
						<li class="nav-item"><a class="nav-link" href="dangxuat.htm">ĐĂNG XUẤT</a></li>
						
					</c:when>
					<c:otherwise>
						<li class="nav-item"><a class="nav-link" href="dangnhap.htm">ĐĂNG KÝ / ĐĂNG NHẬP</a></li>
					</c:otherwise>
				</c:choose>
				<li ><a href="giohang.htm"><img id="imgshopping" src="<c:url value="/resource/image/shopping-cart.png" ></c:url>" style="margin-top: 10px !important;"/></a></li>
				<li class="soluonggiohang" style="color:white !important"><span >${soluonggh}</span></li>
			</ul>

		</div>
		</nav>
	</div>

	<div id="title-sanpham" class="container">
		<div class="row">

			<c:forEach var="sanpham" items="${listSanPham }">

				<div class="col-md-3 col-sm-6">

					<%-- <a href="chitiet/${sanpham.getIdSanPham()}.htm "> --%>
					<div class="card">
						<img src="<c:url value="/resource/image/sanpham/${sanpham.hinhAnh }"></c:url>" class="card-img-top" alt="Card image">
						<div class="card-body">
							<h5 class="card-title">${sanpham.tenSanPham }</h5>
							<p class="card-text">${sanpham.gia }</p>
							<span style="display:none !important" class="idsanpham">${sanpham.getIdSanPham()}</span>
							<span style="display:none !important" class="tensanpham">${sanpham.getTenSanPham()}</span>
							<span style="display:none !important" class="giasanpham">${sanpham.getGia()}</span>
							<span style="display:none !important" class="hinhanhsanpham">${sanpham.getHinhAnh()}</span>
							<button class=" btn btn-primary btn-giohang">Mua</button>
							<button class=" btn btn-link"> <a href="chitiet/${sanpham.getIdSanPham()}.htm">Chi tiết</a> </button>
						</div>
					</div>
					<!-- </a> -->

				</div>

			</c:forEach>

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






















