<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->

<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE HTML>
<html>

<head>
<link rel="stylesheet" href="<c:url value="/resource/Styles/styles.css"></c:url>">
<title>Pooled Admin Panel Category Flat Bootstrap Responsive Web
	Template | Home :: w3layouts</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Pooled Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript">
	
        addEventListener("load", function() {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    
</script>

<!-- Bootstrap Core CSS -->

<link
	href="<c:url value="/resource/Admin Pooled/css/bootstrap.min.css"></c:url>" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->

<link
	href="<c:url value="/resource/Admin Pooled/css/style.css"></c:url>"
	rel='stylesheet' type='text/css' />

<link rel="stylesheet"
	href="<c:url value="/resource/Admin Pooled/css/morris.css"></c:url>"
	type="text/css" />
<!-- Graph CSS -->

<link
	href="<c:url value="/resource/Admin Pooled/css/font-awesome.css"></c:url>"
	rel="stylesheet">
<!-- jQuery -->

<script
	src="<c:url value="/resource/Admin Pooled/js/jquery-2.1.4.min.js"></c:url>"></script>
<!-- //jQuery -->
<link
	href='//fonts.googleapis.com/css?family=Roboto:700,500,300,100italic,100,400'
	rel='stylesheet' type='text/css' />
<link href='//fonts.googleapis.com/css?family=Montserrat:400,700'
	rel='stylesheet' type='text/css'>
<!-- lined-icons -->
<link
	rel="<c:url value="/resource/Admin Pooled/css/icon-font.min.css"></c:url>"
	type='text/css' />
<!-- //lined-icons -->
<meta charset="utf-8">
</head>

<body>
	<div class="page-container">
		<!--/content-inner-->
		<c:choose>
			<c:when test="${user != null}">
				<div class="left-content">
			<div class="row" style="background: white !important">

				

				<div class="col-md-8 col-sm-12">
					
						
					
			
					<table id="table-sanpham" class="table">
						<thead>
							<tr>
								<th>
									<div class="checkbox">
										<label> <input id="checkall" type="checkbox" value="">
										</label>
									</div>
								</th>
								<th>Tên đăng nhập</th>
								<th>Họ tên</th>
								<th>Số điện thoại</th>
								<th>Địa chỉ</th>
								
							</tr>
						</thead>

						<tbody>
							<c:forEach var="user" items="${listUser }">
								<tr>
									<td>
										<div class="checkbox">
											<label> <input type="checkbox"
												value="${user.tenDangNhap }">
											</label>
										</div>
									</td>
									<form action="dashboarduser.htm" method="post">
										<td><button style="background:white !important;text-transform: none !important;" class="btn btn-light" name="iduserdashboard"  value="${user.tenDangNhap }">${user.tenDangNhap }</button></td>
									</form>
									<td>${user.hoTen}</td>
									<td>${user.sdt }</td>
									<td>${user.diaChi}</td>
								</tr>
							</c:forEach>
						</tbody>
						
					</table>
					<div id="xoa-sanpham" class="btn btn-danger">Xóa</div>	
						<form action="dashboarduser.htm" method="get" >
							<nav aria-label="Page navigation example">
								<ul class="pagination">
									<c:forEach var="value" begin="1" end="${tongpage}" varStatus="status">
										<c:choose>
											<c:when test="${indexs == status.index }">
												<li class="page-item" active>
													<button name="index-paging" class="btn btn-primary" value="${value }">${value }</button	>
												</li>
											</c:when>
											<c:otherwise>
												<li class="page-item">
													<button name="index-paging" class="btn btn-link" value="${value }">${value }</button	>
												</li>
											</c:otherwise>
										</c:choose>
									
									
									</c:forEach>
								</ul>
							</nav>
						</form>
				</div>
				
					
				
					<div class="col-md-4 col-sm-12">
					
					<form id="form-sanpham" action="" method="post">
						<h3>Cập nhật thông tin</h3>
					
						<label for="idsanpham">Tên đăng nhập</label> </br> 
						<input type="text" name = "idsanpham" id="idsanpham" class="form-control" value="${iduserdashboard}"> 
						
						<label for="tensanpham">Họ tên</label> </br> 
						<input type="text" name = "tensanpham" id="tensanpham" class="form-control" value="${tenuserdashboard}"> 

						<label for="giasanpham">Số điện thoại</label> </br> 
						<input type="text" name="giasanpham" id="giasanpham" class="form-control" value="${sdtuserdashboard}"> 
						
						<label for="motasanpham">Địa chỉ</label> </br>			
						<textarea name="motasanpham" id="motasanpham" class="form-control" rows="2">${diachiuserdashboard}</textarea>
						
						<h3>Đơn hàng</h3>
						<table id="table-sanpham" class="table">
							<thead>
								<tr>
									<th>Mã</th>
									<th>Tình trạng</th>									
								</tr>
							</thead>

							<tbody>
								<c:forEach var="user" items="${listUser }">
									<tr>
										<td>
											<div class="checkbox">
												<label> <input type="checkbox"
													value="${user.tenDangNhap }">
												</label>
											</div>
										</td>
										<form action="dashboarduser.htm" method="post">
											<td><button style="background:white !important;text-transform: none !important;" class="btn btn-light" name="iduserdashboard"  value="${user.tenDangNhap }">${user.tenDangNhap }</button></td>
										</form>
										<td>${user.hoTen}</td>
										<td>${user.sdt }</td>
										<td>${user.diaChi}</td>
									</tr>
								</c:forEach>
							</tbody>
						
					</table>
				</form>
					</div>
				
			</div>
		</div>
			</c:when>
			<c:when test="${user == null}">
				<div class="left-content">
					<div>
						<span>Không có User</span>
					</div>
				</div>
			</c:when>
		</c:choose>
		
		
		
		
		
		
		<!--//content-inner-->
		<!--/sidebar-menu-->
		<div class="sidebar-menu">
			<header class="logo1">
				<a href="#" class="sidebar-icon"> <span class="fa fa-bars"></span>
				</a>
			</header>
			<div style="border-top: 1px ridge rgba(255, 255, 255, 0.15)"></div>
			<div class="menu">
				 <ul id="menu">
					<li id="menu-academico"><a href="home.htm"><i
							class="fa fa-home"></i><span>Home</span>
						<div class="clearfix"></div></a></li>
                    <li id="menu-academico"><a href="dashboarddonhang.htm"><i class="fa fa-shopping-cart"></i><span>Đơn hàng</span><div class="clearfix"></div></a></li>
                    <li id="menu-academico"><a ><i class="fa fa-list-ul" aria-hidden="true"></i><span>Sản phẩm</span> <span class="fa fa-angle-right" style="float: right"></span><div class="clearfix"></div></a>
                        <ul id="menu-academico-sub">
                            <li id="menu-academico-avaliacoes" ><a href="dashboardthemsanpham.htm">Thêm</a></li>
                            <li id="menu-academico-avaliacoes"><a href="dashboardcapnhatsanpham.htm">Cập nhật</a></li>
                        </ul>
                    </li>
                    <li id="menu-academico"><a href="dashboarduser.htm"><i class="fa fa-users" aria-hidden="true"></i><span>User</span><div class="clearfix"></div></a></li>
                    <li><a href="dangxuat.htm"><i class="fa fa-sign-out"></i>  <span>Đăng xuất</span><div class="clearfix"></div></a></li>
                </ul>
			</div>
		</div>
		<div class="clearfix"></div>
	</div>
	<script>
		var toggle = true;

		$(".sidebar-icon").click(
				function() {
					if (toggle) {
						$(".page-container").addClass("sidebar-collapsed")
								.removeClass("sidebar-collapsed-back");
						$("#menu span").css({
							"position" : "absolute"
						});
					} else {
						$(".page-container").removeClass("sidebar-collapsed")
								.addClass("sidebar-collapsed-back");
						setTimeout(function() {
							$("#menu span").css({
								"position" : "relative"
							});
						}, 400);
					}

					toggle = !toggle;
				});
	</script>
	<!--js -->

	<script
		src="<c:url value="/resource/Admin Pooled/js/jquery.nicescroll.js"></c:url>"></script>

	<script
		src="<c:url value="/resource/Admin Pooled/js/scripts.js"></c:url>"></script>
	<!-- Bootstrap Core JavaScript -->

	<script
		src="<c:url value="/resource/Admin Pooled/js/bootstrap.min.js"></c:url>"></script>
	<!-- /Bootstrap Core JavaScript -->
	<!-- morris JavaScript -->

	<script
		src="<c:url value="/resource/Admin Pooled/js/raphael-min.js"></c:url>"></script>

	<script
		src="<c:url value="/resource/Admin Pooled/js/morris.js"></c:url>"></script>
	<script>
		$(document).ready(
				function() {
					//BOX BUTTON SHOW AND CLOSE
					jQuery('.small-graph-box').hover(function() {
						jQuery(this).find('.box-button').fadeIn('fast');
					}, function() {
						jQuery(this).find('.box-button').fadeOut('fast');
					});
					jQuery('.small-graph-box .box-close').click(function() {
						jQuery(this).closest('.small-graph-box').fadeOut(200);
						return false;
					});

					//CHARTS
					function gd(year, day, month) {
						return new Date(year, month - 1, day).getTime();
					}

					graphArea2 = Morris.Area({
						element : 'hero-area',
						padding : 10,
						behaveLikeLine : true,
						gridEnabled : false,
						gridLineColor : '#dddddd',
						axes : true,
						resize : true,
						smooth : true,
						pointSize : 0,
						lineWidth : 0,
						fillOpacity : 0.85,
						data : [ {
							period : '2014 Q1',
							iphone : 2668,
							ipad : null,
							itouch : 2649
						}, {
							period : '2014 Q2',
							iphone : 15780,
							ipad : 13799,
							itouch : 12051
						}, {
							period : '2014 Q3',
							iphone : 12920,
							ipad : 10975,
							itouch : 9910
						}, {
							period : '2014 Q4',
							iphone : 8770,
							ipad : 6600,
							itouch : 6695
						}, {
							period : '2015 Q1',
							iphone : 10820,
							ipad : 10924,
							itouch : 12300
						}, {
							period : '2015 Q2',
							iphone : 9680,
							ipad : 9010,
							itouch : 7891
						}, {
							period : '2015 Q3',
							iphone : 4830,
							ipad : 3805,
							itouch : 1598
						}, {
							period : '2015 Q4',
							iphone : 15083,
							ipad : 8977,
							itouch : 5185
						}, {
							period : '2016 Q1',
							iphone : 10697,
							ipad : 4470,
							itouch : 2038
						}, {
							period : '2016 Q2',
							iphone : 8442,
							ipad : 5723,
							itouch : 1801
						} ],
						lineColors : [ '#ff4a43', '#a2d200', '#22beef' ],
						xkey : 'period',
						redraw : true,
						ykeys : [ 'iphone', 'ipad', 'itouch' ],
						labels : [ 'All Visitors', 'Returning Visitors',
								'Unique Visitors' ],
						pointSize : 2,
						hideHover : 'auto',
						resize : true
					});

				});
	</script>
	<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>