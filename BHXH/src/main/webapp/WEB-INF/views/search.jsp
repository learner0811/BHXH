<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import= "java.util.Date"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Tra cứu</title>
<!-- MAIN CSS -->
<%@include file="common/style.jsp"%>
<style type="text/css">
.row {
	margin: 20px 0;
}

.btn-submit {
	margin: 0 auto;
}
</style>
</head>
<body>
	<!-- Header -->
	<%@include file="common/header.jsp"%>

	<div class="container">
		<h2 class="h2">Tra cứu thông tin bảo hiểm xã hội</h2>
		<form:form action="" method="post" modelAttribute="search">
			<fieldset class="scheduler-border">
				<legend class="scheduler-border">TRA CỨU MÃ SỐ BẢO HIỂM XÃ
					HỘI</legend>
				<div class="row">
					<label class="col-md-3">Tỉnh/TP</label>
					<div class="form-group col-md-3">
						<select class="form-control" name="city">
							<c:forEach items="${cities}" var="cities">
								<option value="${cities.id}">${cities.name}</option>
							</c:forEach>
						</select>
					</div>
					<label class="col-md-3">Họ và Tên</label>
					<div class="col-md-3">
						<input class="form-control form-control-sm" type="text"
							name="name">
					</div>
				</div>

				<div class="row">
					<label class="col-md-3">CMND (*)</label>
					<div class="col-md-3">
						<input class="form-control form-control-sm" type="text"
							name="identityCard" required="required">
					</div>

					<label class="col-md-3">Loại bảo hiểm xã hội</label>
					<div class="form-group col-md-3">
						<select class="form-control" name="insuranceType">
							<option value="require">Bắc buộc</option>
							<option value="willing">Tự nguyện</option>
						</select>
					</div>
				</div>
				<div class="row">
					<label class="col-md-3">Mã bảo hiểm xã hội</label>
					<div class="col-md-3">
						<input class="form-control form-control-sm" type="text"
							name="insuranceCode">
					</div>
				</div>
			</fieldset>
			<div class="row">
				<input type="submit" value="Tra cứu"
					class="btn btn-success btn-submit">
			</div>
		</form:form>
		<div class="row">
			<c:if test="${not empty userInfo}">
				<h3>Thông tin cá nhân</h3>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>Họ và tên</th>
							<th>Ngày sinh</th>
							<th>Giới tính</th>
							<th>Địa chỉ</th>
							<th>Số CMND</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${userInfo.name }</td>
							<td><fmt:setLocale value="vi-VN"></fmt:setLocale> <fmt:formatDate
									value="${userInfo.dob}" pattern="dd-MM-y" /></td>
							<td>${userInfo.sex}</td>
							<td>${userInfo.address} ${userInfo.city.name }</td>
							<td>${userInfo.identityCard }</td>
						</tr>
					</tbody>
				</table>
				
				<br>
				<h3>Thông tin bảo hiểm</h3>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>Mã bảo hiểm</th>
							<th>Mã số thuế</th>
							<th>Loại bảo hiểm</th>
							<th>Trạng thái</th>
							<th>Ngày bắt đầu</th>
							<th>Thu nhập (VNĐ)</th>
							<th>Tỷ lệ</th>
							<th>Phí đóng</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${userInfo.insurance.insurancecode }</td>							
							<td>${userInfo.insurance.taxcode}</td>
							<td>
								<c:choose>
									<c:when test="${userInfo.insurance.type == 'require'}">
										Bắt buộc
									</c:when>
									<c:when test="${userInfo.insurance.type == 'willing'}">
										Tự nguyện
									</c:when>
								</c:choose>
							</td>
							<td>
								<c:choose>
									<c:when test="${userInfo.insurance.status == '1'}">
										Hoạt động
									</c:when>
									<c:when test="${userInfo.insurance.status == '0'}">
										Không hoạt động
									</c:when>
								</c:choose>
							</td>
							<td>
								<fmt:setLocale value="vi-VN"></fmt:setLocale> <fmt:formatDate
									value="${userInfo.insurance.startDate}" pattern="dd-MM-y" />
							</td>
							<td>${userInfo.insurance.income}</td>
							<td>
								<c:choose>
									<c:when test="${userInfo.insurance.type == 'require'}">
										${requireType.rate} %
									</c:when>
									<c:when test="${userInfo.insurance.type == 'willing'}">
										${willingType.rate} %
									</c:when>
								</c:choose>
							</td>
							<td>
								<c:choose>
									<c:when test="${userInfo.insurance.type == 'require'}">
										${requireType.rate * userInfo.insurance.income / 100}
									</c:when>
									<c:when test="${userInfo.insurance.type == 'willing'}">
										${willingType.rate * userInfo.insurance.income / 100}
									</c:when>
								</c:choose>
							</td>
						</tr>
					</tbody>
				</table>
			</c:if>
		</div>
	</div>	
	
	<!-- footer -->
	<%@include file="common/footer.jsp"%>

	<!-- MAIN SCRIPT -->
	<%@include file="common/lib.jsp"%>
</body>
</html>