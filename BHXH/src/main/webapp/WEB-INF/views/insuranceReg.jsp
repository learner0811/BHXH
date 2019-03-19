<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Đăng ký bảo hiểm xã hội</title>
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
		<h2 class="h2">ĐĂNG KÝ KÊ KHAI BHXH ĐIỆN TỬ MIỄN PHÍ</h2>

		<c:if test="${not empty errorMsg}">
			<div class="alert alert-danger alert-dismissible">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				<c:out value="${errorMsg}"></c:out>
			</div>
		</c:if>
		<form:form modelAttribute="reg" method="post"
			action="/BHXH/insurancereg" acceptCharset="utf-8">
			<fieldset class="scheduler-border">
				<legend class="scheduler-border">Thông tin đơn vị</legend>
				<div class="row">
					<label class="col-md-3">Mã số thuế/Mã ngân sách</label>
					<div class="col-md-3">
						<input id = "mst" class="form-control form-control-sm number" type="text"
							name="taxCode" pattern="[0-9]{10}"
							oninvalid="this.setCustomValidity('Mã số thuế không hợp lệ')"
							oninput="this.setCustomValidity('')">
					</div>
					<div class="checkbox col-md-4" style="white-space: nowrap;">
						<label><input type="checkbox" style="margin-right: 20px"
							name="hasTaxCode" id="ckb">Không có MST/MNS</label>
					</div>
				</div>

				<div class="row">
					<label class="col-md-3">Thu nhập cá nhân (*)</label>
					<div class="col-md-3">
						<input class="form-control form-control-sm number" type="text"
							name="income" maxlength="10">
					</div>

					<label class="col-md-3">Loại bảo hiểm xã hội</label>
					<div class="form-group col-md-3">
						<select class="form-control" name="insuranceType">
							<option value="require">Bắc buộc</option>
							<option value="willing">Tự nguyện</option>
						</select>
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
		$('#ckb').click(function(){
			var checked = this.checked;
			if (checked){
				$('#mst').attr('disabled', true);
				console.log('disable');
			}
			else{
				$('#mst').attr('disabled', false);
				console.log('unblock');
			}	
		});		
	</script>
</body>
</html>