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
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
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
		<div class="row">
			<div class="col-md-6 col-sm-12">
				<h3>Danh sách sản phẩm trong giỏ hàng</h3>
				<table class="table">
					<thead>
						<tr>
							<!-- <td><h5>Hình ảnh sản phẩm</h5></td> -->
							<td><h5>Tên sản phẩm</h5></td>
							<td><h5>Số lượng</h5></td>
							<td><h5>Giá</h5></td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="value" items="${listgiohang }">
							<tr>
								<%-- <td><img src="<c:url value="/resource/image/sanpham/${value.getHinhAnh()}"></c:url>" /></td> --%>
								<td>${value.getTenSanPham() }</td>
								<td><input class="soluong-giohang" type="number" min="1"
									value="${value.getSoLuong()}" /></td>
								<td class="giatien" data-value="${value.getGia()}">${value.getGia() }</td>
								<td class="id" data-id="${ value.getIdSanPham()}"
									style="display: none !important"></td>
								<td class=" xoa-giohang btn btn-danger">Xóa</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<h4 style="color: red !important">
					Tổng tiền: <span id="tongtien">0</span>
				</h4>
			</div>

			<div class="col-md-6 col-sm-12">
				<h3>Thông tin người nhận</h3>
				<div class="form-group">
					<form:form action="" method="post" modelAttribute="giohangMA">
						<input class="form-control" id="tennguoimua" name="tenNguoiMua" path="tenNguoiMua" placeholder="Tên người mua" value="${tennguoimuadonhang }"/> 
						<form:errors path="tenNguoiMua" style="color:red !important"></form:errors>
						
						<input class="form-control" id="sodienthoai" name="sdt"  path="sdt"  placeholder="Số điện thoại" value="${sdtdonhang }"/> 
						<form:errors path="sdt" style="color:red !important"></form:errors>
						
						<input class="form-control" id="diachi" name="diaChi" path="diaChi" placeholder="Địa chỉ" value="${diachidonhang }"/> 
						<form:errors path="diaChi" style="color:red !important"></form:errors>
						
						<textarea class="form-control" rows="3" id="ghichu" name="ghiChu"  path="ghiChu" placeholder="Ghi chú">${ghichudonhang }</textarea><br> 
						<form:errors path="ghiChu" style="color:red !important"></form:errors>
						
						<input id="btnDatHang" type="submit" class="btn btn-primary" value="Đặt hàng" />

					</form:form>
				</div>
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






















