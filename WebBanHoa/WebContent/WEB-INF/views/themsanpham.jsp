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
<jsp:include page="footer.jsp"></jsp:include>
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
	href="<c:url value="/resource/Admin Pooled/css/bootstrap.min.css"></c:url>"
	rel='stylesheet' type='text/css' />
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
</head>

<body>
	<div class="page-container">
		<!--/content-inner-->
		<div class="left-content">
			<div class="row" style="background: white !important">

				<h3>Sản phẩm</h3>
				<form id="form-sanpham" action="">
					<div class="col-md-6 col-sm-12">
						<label for="tensanpham">Tên sản phẩm</label> </br> 
						<input type="text" name = "tensanpham" id="tensanpham" class="form-control"> 
						
						<label for="danhmucsanpham">Loại</label> </br> 
						<select class="form-control" name="danhmucsanpham" id="danhmucsanpham">
							<c:forEach var="valuedanhmucsp" items="${danhmucsp }">
								<option value="${valuedanhmucsp.getId()}">${valuedanhmucsp.getTenLoai()}</option>
							</c:forEach>
						</select> 
						
						<label for="giasanpham">Giá</label> </br> 
						<input type="text" name="giasanpham" id="giasanpham" class="form-control"> 
						
						<label for="motasanpham">Mô tả</label> </br>			
						<textarea name="motasanpham" id="motasanpham" class="form-control" rows="3"></textarea>
						
						<label for="hinhanhsanpham">Hình ảnh</label> </br> 
						<input type="file" name="hinhanhsanpham" id="hinhanhsanpham" class="form-control" value="not">
			

					</div>
				</form>

				<div class="col-md-6 col-sm-12">
					<div style="float: right">
						<div id="them-sanpham" class="btn btn-info">Thêm sản phẩm</div>
						<div id="xoa-sanpham" class="btn btn-info">Xóa</div>
					</div>
					<table id="table-sanpham" class="table">
						<thead>
							<tr>
								<th>
									<div class="checkbox">
										<label> <input id="checkall" type="checkbox" value="">
										</label>
									</div>
								</th>
								<th>Tên sản phầm</th>
								<th>Loại</th>
								<th>Giá</th>
							</tr>
						</thead>

						<tbody>
							<c:forEach var="sanpham" items="${listSanPham }">
								<tr>
									<td>
										<div class="checkbox">
											<label> <input type="checkbox"
												value="${sanpham.idSanPham }">
											</label>
										</div>
									</td>
									<td>${sanpham.tenSanPham }</td>
									<td>${sanpham.loaiSanPham.tenLoai }</td>
									<td>${sanpham.gia }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<nav aria-label="Page navigation example">
						<ul class="pagination">

							<c:forEach var="value" begin="1" end="${tongpage}">
								<c:choose>
									<c:when test="${value == 1 }">
										<li class="paging-item  page-item active"><a
											class="page-link" href="#">${value }</a></li>
									</c:when>
									<c:otherwise>
										<li class="paging-item page-item"><a class="page-link"
											href="#">${value }</a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</ul>
					</nav>
				</div>
			</div>
		</div>
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
					<li><a href="index.html"><i class="fa fa-tachometer"></i>
							<span>Dashboard</span>
							<div class="clearfix"></div></a></li>

					<li id="menu-academico"><a href="inbox.html"><i
							class="fa fa-envelope nav_icon"></i><span>Inbox</span>
							<div class="clearfix"></div></a></li>
					<li><a href="gallery.html"><i class="fa fa-picture-o"
							aria-hidden="true"></i><span>Gallery</span>
							<div class="clearfix"></div></a></li>
					<li id="menu-academico"><a href="charts.html"><i
							class="fa fa-bar-chart"></i><span>Charts</span>
							<div class="clearfix"></div></a></li>
					<li id="menu-academico"><a href="#"><i
							class="fa fa-list-ul" aria-hidden="true"></i><span> Short
								Codes</span> <span class="fa fa-angle-right" style="float: right"></span>
							<div class="clearfix"></div></a>
						<ul id="menu-academico-sub">
							<li id="menu-academico-avaliacoes"><a href="icons.html">Icons</a></li>
							<li id="menu-academico-avaliacoes"><a href="typography.html">Typography</a></li>
							<li id="menu-academico-avaliacoes"><a href="faq.html">Faq</a></li>
						</ul></li>
					<li id="menu-academico"><a href="errorpage.html"><i
							class="fa fa-exclamation-triangle" aria-hidden="true"></i><span>Error
								Page</span>
							<div class="clearfix"></div></a></li>
					<li id="menu-academico"><a href="#"><i class="fa fa-cogs"
							aria-hidden="true"></i><span> UI Components</span> <span
							class="fa fa-angle-right" style="float: right"></span>
							<div class="clearfix"></div></a>
						<ul id="menu-academico-sub">
							<li id="menu-academico-avaliacoes"><a href="button.html">Buttons</a></li>
							<li id="menu-academico-avaliacoes"><a href="grid.html">Grids</a></li>
						</ul></li>
					<li><a href="tabels.html"><i class="fa fa-table"></i> <span>Tables</span>
							<div class="clearfix"></div></a></li>
					<li><a href="maps.html"><i class="fa fa-map-marker"
							aria-hidden="true"></i> <span>Maps</span>
							<div class="clearfix"></div></a></li>
					<li id="menu-academico"><a href="#"><i
							class="fa fa-file-text-o"></i> <span>Pages</span> <span
							class="fa fa-angle-right" style="float: right"></span>
							<div class="clearfix"></div></a>
						<ul id="menu-academico-sub">
							<li id="menu-academico-boletim"><a href="calendar.html">Calendar</a></li>
							<li id="menu-academico-avaliacoes"><a href="signin.html">Sign
									In</a></li>
							<li id="menu-academico-avaliacoes"><a href="signup.html">Sign
									Up</a></li>

						</ul></li>
					<li><a href="#"><i class="fa fa-check-square-o nav_icon"></i><span>Forms</span>
							<span class="fa fa-angle-right" style="float: right"></span>
							<div class="clearfix"></div></a>
						<ul>
							<li><a href="input.html"> Input</a></li>
							<li><a href="validation.html">Validation</a></li>
						</ul></li>
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