<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<jsp:include page="header.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thanh toán</title>
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
			<ul id="navbar-center" class="navbar-nav mr-auto ">
				<li class="nav-item"><a class="nav-link" href="home.htm">TRANG CHỦ</a></li>
				<li class="nav-item dropdown" >
					<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> SẢN PHẨM </a>
					<ul class="dropdown-menu" aria-labelledby="navbarDropdown" style="background: black !important ">	
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
							<c:when test="${user == 'admin'}">
								<li class="nav-item" ><a class="nav-link" href="dashboard.htm" style="margin-top:-2px !important">${user}</a></li>
							</c:when>
							<c:when test="${user != 'admin'}">
								<li class="nav-item" ><a class="nav-link" href="userchitiet.htm" style="margin-top:-2px !important">${user}</a></li>
							</c:when>
						</c:choose>
						<li class="nav-item"><a class="nav-link" href="dangxuat.htm">ĐĂNG XUẤT</a></li>
					</c:when>
					<c:otherwise>
						<li class="nav-item"><a class="nav-link" href="dangnhap.htm">ĐĂNG KÝ / ĐĂNG NHẬP</a></li>
					</c:otherwise>
				</c:choose>
				<li ><a href="giohang.htm"><img id="imgshopping" src="<c:url value="/resource/image/shopping-cart.png" ></c:url>" style="margin-top: 10px !important;"/></a></li>
				<li class="soluonggiohang" style="color:white !important"><span >${soluong}</span></li>
				
			</ul>

		</div>
		</nav>
	</div>

	<div class="container">
		
			<br>
			<div><h4>Không có sản phẩm trong giỏ hàng</h4></div>
			<div><a href = "home.htm">Quay lại</a></div>
			
		
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>






















