<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Đăng ký</title>
<!-- MAIN CSS -->
<%@include file="common/style.jsp"%>
<style type="text/css">
.signup-form {
	width: 400px;
	margin: 0 auto;
	padding: 30px 0;
}

.signup-form form {
	color: #999;
	border-radius: 3px;
	margin-bottom: 15px;
	background: #f2f3f7;
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	padding: 30px;
}

.signup-form h2 {
	text-align: center;
}
</style>
</head>
<body>
	<!-- Header -->
	<%@include file="common/header.jsp"%>

	<div class="signup-form">
		<form action="/BHXH/register" method="post">
			<h2>Đăng ký</h2>

			<c:if test="${not empty errorMsg}">
				<div class="alert alert-danger alert-dismissible">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					<c:out value="${errorMsg}"></c:out>
				</div>
			</c:if>			
			<div class="form-group">
				<input type="text" class="form-control" name="username"
					placeholder="Tên tài khoản" required="required">
			</div>
			<div class="form-group">
				<input type="email" class="form-control" name="email"
					placeholder="Email" required="required">
			</div>
			<div class="form-group">
				<input type="password" class="form-control" name="password"
					placeholder="Mật khẩu" required="required">
			</div>
			<div class="form-group">
				<input type="password" class="form-control" name="confirm_password"
					placeholder="Nhập lại mật khẩu" required="required">
			</div>
			<div class="form-group">
				<label class="checkbox-inline"><input type="checkbox"
					required="required" name="license"> Tôi đồng ý với các <a
					href="#">điều khoản </a> &amp; <a href="#">bảo mật sử dung</a></label>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-success btn-lg btn-block">Đăng
					ký</button>
			</div>
		</form>
	</div>
	<!-- footer -->
	<%@include file="common/footer.jsp"%>

	<!-- MAIN SCRIPT -->
	<%@include file="common/lib.jsp"%>
</body>
</html>