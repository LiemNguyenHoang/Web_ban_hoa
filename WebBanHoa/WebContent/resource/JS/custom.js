$(document).ready(
		function() {

			$("#btnDangNhap").click(
					function() {
						var tendangnhap = $("#tendangnhap").val().trim();
						var matkhau = $("#matkhau").val().trim();
						$.ajax({
							url : "/WebBanHoa/api/KiemTraDangNhap.htm",
							type : "GET",
							data : {
								tendangnhap : tendangnhap,
								matkhau : matkhau
							},

							success : function(value) {
								if (value == -3) {
									alert("Mật khẩu không hợp lệ")
								} else if (value == -2) {
									alert("Tên đăng nhập không hợp lệ")
								} else if (value == -1) {
									alert("bug select user")
								} else if (value == 0) {
									alert("Tên đăng nhập không tồn tại")
								} else if (value == 1) {
									alert("Sai mật khẩu")
								} else if (value == 2) {
									duongDanHienTai = window.location.href;
									duongDan = duongDanHienTai.replace(
											"/dangnhap.htm", "/home.htm");
									window.location = duongDan;
								}else if (value == 3) {
									duongDanHienTai = window.location.href;
									duongDan = duongDanHienTai.replace(
											"/dangnhap.htm", "/dashboard.htm");
									window.location = duongDan;
								}
							}
						})
					});
			$("#btnDangKy").click(
					function() {
						var tendangnhap = $("#tendangky").val().trim();
						var matkhau = $("#matkhaudangky").val().trim();
						var nhaplaimatkhau = $("#nhaplaimatkhaudangky").val().trim();

						$.ajax({
							url : "/WebBanHoa/api/KiemTraDangKy.htm",
							type : "GET",
							data : {
								tendangnhap : tendangnhap,
								matkhau : matkhau,
								nhaplaimatkhau : nhaplaimatkhau
							},

							success : function(value) {
								if (value == -3) {
									alert("Mật khẩu không hợp lệ")
								} else if (value == -2) {
									alert("Tên đăng nhập không hợp lệ")
								} else  if (value == -1) {
									alert("bug select user")
								} else if (value == 0) {
									alert("Mật khẩu không trùng khớp")
								} else if (value == 1) {
									alert("Tên đăng nhập đã tồn tại")
								} else if (value == 2) {
									duongDanHienTai = window.location.href;
									duongDan = duongDanHienTai.replace(
											"/dangnhap.htm", "/home.htm");
									window.location = duongDan;
								} else if (value == 3) {
									alert("insert user fail")
								}

							}
						})
					});

			$("#dangnhap").click(function() {
				$(this).addClass("actived");
				$("#dangky").removeClass("actived");
				$("#login").show();
				$("#signup").css("display", "none");
			});
			$("#dangky").click(function() {
				$("#dangnhap").removeClass("actived");
				$(this).addClass("actived");
				$("#login").css("display", "none");
				$("#signup").show();
			});

			$(".btn-giohang").click(
					function() {

						var id = $(this).closest("div").find(".idsanpham")
								.text();
						var ten = $(this).closest("div").find(".tensanpham")
								.text();
						var gia = $(this).closest("div").find(".giasanpham")
								.text();
						var hinhanh = $(this).closest("div").find(
								".hinhanhsanpham").text();
						$.ajax({
							url : "/WebBanHoa/api/ThemGioHang.htm",
							type : "GET",
							data : {
								id : id,
								soluongsp : 1,
								gia : gia,
								ten : ten,
								hinhanh : hinhanh
							},

							success : function(value) {
								$(".soluonggiohang").html(
										"<span>" + value + "</span>");
							}
						});
					});

			TinhTongGioHang(false)

			function TinhTongGioHang(isEventChange) {
				var tongtiensp = 0;
				$(".giatien").each(
						function() {
							var giatien = $(this).closest("tr")
									.find(".giatien").attr("data-value");
							var soluong = $(this).closest("tr").find(
									".soluong-giohang").val();

							var tongtien = giatien * soluong;

							if (isEventChange == false) {
								$(this).html(tongtien);

							}

							tongtiensp = tongtiensp + parseInt(tongtien);
							// $(".giatien").html(tongtien + "");
							$("#tongtien").html(tongtiensp + "");

						})
			}
			$(".soluong-giohang").change(
					function() {
						var soluong = $(this).val();
						var giatien = $(this).closest("tr").find(".giatien")
								.attr("data-value");

						var tongtien = soluong * parseInt(giatien);
						$(this).closest("tr").find(".giatien").html(tongtien);

						TinhTongGioHang(true);

						var id = $(this).closest("tr").find(".id").attr(
								"data-id");

						$.ajax({
							url : "/WebBanHoa/api/CapNhatGioHang.htm",
							type : "GET",
							data : {
								id : id,
								soluongsp : soluong
							},

							success : function(value) {

							}
						});
					});

			$(".xoa-giohang").click(
					function() {
						var self = $(this);
						var id = $(this).closest("tr").find(".id").attr(
								"data-id");
						$.ajax({
							url : "/WebBanHoa/api/XoaGioHang.htm",
							type : "GET",
							data : {
								id : id
							},

							success : function(value) {
								self.closest("tr").remove();
								TinhTongGioHang(true);
								$(".soluonggiohang").html(
										"<span>" + value + "</span>");
							}
						});
					});

//			$("body").on("click", ".paging-item", function() {
//				$(".paging-item").removeClass("active");
//				$(this).addClass("active");
//				var index = $(this).text();
//				var startSP = (index - 1) * 5;
//				$.ajax({
//					url : "/WebBanHoa/api/LaySanPhamLimit.htm",
//					type : "GET",
//					data : {
//						spbatdau : startSP
//					},
//
//					success : function(value) {
//						var tbodysanpham = $("#table-sanpham").find("tbody");
//						tbodysanpham.empty();
//						tbodysanpham.append(value);
//					}
//				});
//			});

			$("#checkall").change(function() {
				if (this.checked) {
					$("#table-sanpham input").each(function() {
						$(this).attr("checked", true);
					})
					$("#table-donhang input").each(function() {
						$(this).attr("checked", true);
					})
				} else {
					$("#table-sanpham input").each(function() {
						$(this).attr("checked", false);
					})
					$("#table-donhang input").each(function() {
						$(this).attr("checked", false);
					})
				}
			})
			$("#xoa-sanpham").click(function() {
				$("#table-sanpham >tbody input:checked").each(function() {
					var masanpham = $(this).val();
					var This = $(this);

					$.ajax({
						url : "/WebBanHoa/api/XoaSanPham.htm",
						type : "GET",
						data : {
							masanpham : masanpham
						},

						success : function(value) {
							This.closest("tr").remove();
						}
					});
				})
			});
			$("#xoa-donhang").click(function() {
				$("#table-donhang >tbody input:checked").each(function() {
					var madonhang = $(this).val();
					var This = $(this);
					$.ajax({
						url : "/WebBanHoa/api/XoaDonHang.htm",
						type : "GET",
						data : {
							madonhang : madonhang
						},

						success : function(value) {
							This.closest("tr").remove();
						}
					});
				})
			});

			var files = [];
			$("#hinhanhsanpham").change(function(event) {
				files = event.target.files();
				forms = new FormData();
				forms.append("file", files[0]);

				$.ajax({
					url : "/WebBanHoa/api/UploadFile.htm",
					type : "POST",
					data : forms,
					contentType : false,
					processData : false,
					enctype : "multipart/form-data",
					success : function(value) {

					}
				});
			});

			$("#them-sanpham").click(function(event) {
				event.preventDefault();
				var formdata = $("#form-sanpham").serializeArray();
				json = {};
				$.each(formdata, function(i, field) {
					json[field.name] = field.value;
				});

				/* console.log(JSON.stringify(json)); */
				$.ajax({
					url : "/WebBanHoa/api/ThemSanPham.htm",
					type : "GET",
					data : {
						dataJson : JSON.stringify(json)
					},
					success : function(value) {

					}
				});

			});
			
//			$("body").on("click",".capnhatsanpham",function(event){
//				masanpham = $(this).attr("data-id");
//				
//				$.ajax({
//					 cache: false,
//					url : "/WebBanHoa/api/LaySanPhamTheoMa.htm",
//					type : "POST",
//					data : {
//						idSanPham:masanpham 
//					},
//					success : function(value) {
//						
//						var arr1 = value.split(',');
//						var arr2 = arr1[0].split(':');
//						$("#tensanpham").val(arr2[1]);
//						
//						arr2 = arr1[1].split(':');
//						var num =5;
//						$("#danhmucsanpham").val(arr2[1]);
//						console.log("|"+arr2[1]);
//						
//						arr2 = arr1[2].split(':');
//						$("#giasanpham").val(arr2[1]);
//						
//						arr2 = arr1[3].split(':');
//						$("#motasanpham").val(arr2[1]);
//					}
//				});
//			});

		})
