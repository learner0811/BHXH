<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Đăng nhập</title>
<!-- MAIN CSS -->
<%@include file="common/style.jsp"%>
</head>
<body>
	<!-- Header -->
	<%@include file="common/header.jsp"%>

	<!-- Content -->
	<div class="container py-5">
		<div class="row">
			<div class="col-md-12">
				<!--  <h2 class="text-center mb-4">Bootstrap 4 Login Form</h2>-->
				<div class="row">
					<div class="col-md-6 mx-auto">
						<!-- form card login -->
						<div class="card rounded-0">
							<div class="card-header">
								<h3 class="mb-0">Đăng nhập</h3>
							</div>
							<div class="card-body">
								<c:if test="${not empty errorMsg}">
									<div class="alert alert-danger alert-dismissible">
										<button type="button" class="close" data-dismiss="alert">&times;</button>
										<c:out value="${errorMsg}"></c:out>
									</div>
								</c:if>
								<c:if test="${not empty successMsg}">
									<div class="alert alert-success alert-dismissible">
										<button type="button" class="close" data-dismiss="alert">&times;</button>
										<c:out value="${successMsg}"></c:out>
									</div>
								</c:if>
								<form class="form" id="formLogin" method="POST"
									action="/BHXH/login">
									<div class="form-group">
										<label for="uname1">Tài khoản</label> <input type="text"
											class="form-control form-control rounded-0" name="username"
											id="uname1" required="">
										<div class="invalid-feedback">Bạn phải điền tài khoản</div>
									</div>
									<div class="form-group">
										<label>Mật khẩu</label> <input type="password"
											class="form-control form-control rounded-0" id="password"
											required="" name="password">
										<div class="invalid-feedback">Bạn phải nhập mật khẩu</div>
									</div>
									<!--  <div>
										<label class="custom-control custom-checkbox"> <input
											type="checkbox" class="custom-control-input"> <span
											class="custom-control-indicator"></span> <span
											class="custom-control-description small text-dark">Remember
												me on this computer</span>
										</label>
									</div>-->
									<button type="submit"
										class="btn btn-success btn-lg float-right" id="btnLogin">Đăng
										nhập</button>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--/container-->

	<!-- footer -->
	<%@include file="common/footer.jsp"%>

	<!-- MAIN SCRIPT -->
	<%@include file="common/lib.jsp"%>
</body>
</html>