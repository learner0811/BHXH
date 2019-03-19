<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--Navbar-->
<nav class="navbar navbar-expand-lg navbar-dark">

	<!-- Navbar brand -->
	<a class="navbar-brand" href="#"> <img
		src='<c:url value="/resources/custom/img/logo-efy.png" />'
		width="50px" height="30px">
	</a>
	<!-- Collapse button -->
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbar_content" aria-controls="navbar_content"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<!-- Collapsible content -->
	<div class="collapse navbar-collapse" id="navbar_content">

		<!-- Links -->
		<ul class="navbar-nav mr-auto">
			<li class="nav-item"><a class="nav-link" href="/BHXH/index">Trang
					Chủ </a></li>
			<li class="nav-item"><a class="nav-link" href="/BHXH/login">Đăng
					nhập</a></li>
			<li class="nav-item"><a class="nav-link" href="/BHXH/register">Đăng
					ký</a></li>
			<li class="nav-item"><a class="nav-link" href="/BHXH/user">Kê
					khai thông tin cá nhân</a></li>
			<li class="nav-item"><a class="nav-link"
				href="/BHXH/insurancereg">Đăng ký BHXH</a></li>
			<li class="nav-item"><a class="nav-link" href="/BHXH/search">Tra cứu
					thông tin bảo hiểm</a></li>
			

			<!-- Dropdown 
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" id="navbarDropdownMenuLink"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Dropdown</a>
				<div class="dropdown-menu dropdown-primary"
					aria-labelledby="navbarDropdownMenuLink">
					<a class="dropdown-item" href="#">Action</a> <a
						class="dropdown-item" href="#">Another action</a> <a
						class="dropdown-item" href="#">Something else here</a>
				</div></li>-->

		</ul>
		<c:if test="${not empty user}">
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<div class="dropdown">
						<button type="button" class="btn dropdown-toggle"
							data-toggle="dropdown"><c:out value="${user.account.username}"></c:out></button>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="/BHXH/signout">Sign out</a>
						</div>
					</div>
			</ul>
		</c:if>
	</div>
	<!-- Collapsible content -->

</nav>
<!--/.Navbar-->