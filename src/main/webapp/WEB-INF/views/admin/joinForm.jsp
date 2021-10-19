<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Register - SB Admin</title>
<link href="/admin/css/styles.css" rel="stylesheet" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"
	crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
	<div id="layoutSidenav">
		<div id="layoutSidenav_nav">
			<nav class="sb-sidenav accordion sb-sidenav-dark"
				id="sidenavAccordion">
				<div class="sb-sidenav-menu">
					<div class="nav">

						<nav class="sb-sidenav-menu-nested nav">
							<a class="nav-link" href="/test/admin/home">Home</a> <a
								class="nav-link" href="/test/admin/loginForm">관리자 로그인</a> <a
								class="nav-link" href="/test/admin/joinForm">관리자 가입</a>
						</nav>
					</div>
				</div>

			</nav>
		</div>
	</div>
	<div id="layoutAuthentication">
		<div id="layoutAuthentication_content">
			<main>
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-7">
							<div class="card shadow-lg border-0 rounded-lg mt-5">
								<div class="card-header">
									<h3 class="text-center font-weight-light my-4">회원가입</h3>
								</div>
								<div class="card-body">
									<form>
										<div class="form-floating mb-3">

											<div class="form-floating mb-3">
												<input class="form-control" id="inputFirstName" type="text"
													placeholder="Enter your first name" /> <label
													for="inputFirstName">이름</label>
											</div>
											<div class="form-floating mb-3">
												<input class="form-control" id="inputUsername" type="text"
													placeholder="Enter your first name" /> <label
													for="inputUsername">아이디</label>
											</div>
											<div class="form-floating mb-3">
												<input class="form-control" id="inputPassword"
													type="password" placeholder="Create a password" /> <label
													for="inputPassword">비밀번호</label>
											</div>
											<div class="form-floating mb-3">
												<input class="form-control" id="inputEmail" type="email"
													placeholder="name@example.com" /> <label for="inputEmail">이메일</label>
											</div>
											<div class="form-floating mb-3">
												<input class="form-control" id="inputPhone" type="text"
													placeholder="name@example.com" /> <label for="inputPhone">전화번호</label>
											</div>


										</div>
									</form>
								</div>
								<div class="mt-4 mb-0">
									<div class="d-grid">
										<a class="btn btn-primary btn-block" href="/test/admin/loginForm">회원가입</a>
									</div>
								</div>
							</div>
							<div class="card-footer text-center py-3">
								<div class="small">
									<a href="/test/admin/loginForm">이미 가입하셨습니까? 로그인을 해주세요!</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</main>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="/admin/js/scripts.js"></script>
</body>
</html>
