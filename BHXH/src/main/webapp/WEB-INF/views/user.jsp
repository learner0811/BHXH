<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Kê khai thông tin cá nhân</title>
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
		<h2 class="h2">Kê khai thông tin cá nhân</h2>
		<c:if test="${not empty successMsg}">
			<div class="alert alert-success alert-dismissible">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				<c:out value="${successMsg}"></c:out>
			</div>
		</c:if>
		<form:form action="/BHXH/user" method="post" modelAttribute="user">
			<fieldset class="scheduler-border">
				<legend class="scheduler-border">Thông tin cá nhân</legend>
				<form:input type="hidden" path="id" />
				<form:input type="hidden" path="account.id" />
				<form:input type="hidden" path="account.username" />
				<form:input type="hidden" path="account.password" />
				<div class="row">
					<label class="col-md-3">Họ và tên</label>
					<div class="col-md-3">
						<input class="form-control form-control-sm" type="text"
							name="name" required="required"
							oninvalid="this.setCustomValidity('Không được để trống')"
							oninput="this.setCustomValidity('')">
					</div>
					<label class="col-md-3">Giới tính</label>
					<div class="col-md-3">
						<select class="form-control" name="sex">
							<option>Nam</option>
							<option>Nữ</option>
						</select>
					</div>
				</div>

				<div class="row">
					<label class="col-md-3">Ngày sinh</label>
					<div class="col-md-3">
						<input id="datepicker" class="form-control form-control-sm"
							type="text" name="dob" required="required" autocomplete="off">
					</div>
					<label class="col-md-3">Chứng minh thư</label>
					<div class="col-md-3">
						<input class="form-control form-control-sm number" type="text"
							name="identityCard" required="required"
							pattern="[0-9]{1}[1-9]{1}[0-9]{7}"
							oninvalid="this.setCustomValidity('Số chứng minh không đúng theo quy định')"
							oninput="this.setCustomValidity('')">
					</div>
				</div>

				<div class="row">
					<label class="col-md-3">Địa chỉ</label>
					<div class="col-md-3">
						<input class="form-control form-control-sm" type="text"
							name="address" required="required">
					</div>
					<label class="col-md-3">Tỉnh/Thành phố (*)</label>
					<div class="col-md-3">
						<select class="form-control" name="city.id">
							<c:forEach items="${cities}" var="cities">
								<option value="${cities.id}">${cities.name}</option>
							</c:forEach>
						</select>
					</div>
				</div>

				<div class="row">
					<label class="col-md-3">Số điện thoại</label>
					<div class="col-md-3">
						<input class="form-control form-control-sm number" type="text"
							name="phone" required="required" pattern="0[1-9]{1}[0-9]{8,9}"
							oninvalid="this.setCustomValidity('Số điện thoại không hợp lệ')"
							oninput="this.setCustomValidity('')">
					</div>
					<label class="col-md-3">Email</label>
					<div class="col-md-3">
						<input class="form-control form-control-sm" type="text"
							name="account.email">
					</div>
				</div>


			</fieldset>
			<div class="row">
				<input type="submit" value="Nhập" class="btn btn-success btn-submit">
			</div>
		</form:form>
	</div>
	<!-- footer -->
	<%@include file="common/footer.jsp"%>

	<!-- MAIN SCRIPT -->
	<%@include file="common/lib.jsp"%>

	<script>
		var numberInput = document.getElementsByClassName("number");
		for (var i = 0; i < numberInput.length; i++) {
			setInputFilter(numberInput[i], function(value) {
				return /^\d*\.?\d*$/.test(value);
			});
		}
	</script>

	<script>
		$.fn.datepicker.dates['vi'] = {
			days : [ "Chủ nhật", "Thứ hai", "Thứ ba", "Thứ tư", "Thứ năm",
					"Thứ sáu", "Thứ bảy" ],
			daysShort : [ "CN", "Thứ 2", "Thứ 3", "Thứ 4", "Thứ 5", "Thứ 6",
					"Thứ 7" ],
			daysMin : [ "CN", "T2", "T3", "T4", "T5", "T6", "T7" ],
			months : [ "Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5",
					"Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10",
					"Tháng 11", "Tháng 12" ],
			monthsShort : [ "Th1", "Th2", "Th3", "Th4", "Th5", "Th6", "Th7",
					"Th8", "Th9", "Th10", "Th11", "Th12" ],
			today : "Hôm nay",
			clear : "Xóa",
			format : "dd/mm/yyyy"
		};

		$('#datepicker').datepicker({
			uiLibrary : 'bootstrap4',
			language : 'vi'
		});
	</script>

</body>
</html>