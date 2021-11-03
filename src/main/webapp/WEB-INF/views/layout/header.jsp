
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>댕냥이천국</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript"
	src="//code.jquery.com/jquery-3.6.0.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>

</head>
<body style="min-height: 100%">

	<nav class="navbar navbar-expand-sm bg-success navbar-dark ">
		<div class="container-fluid">
			<a class="navbar-brand d-flex justify-content-center" href="/"
				style="text-align: right;"><img src="/header/logo.png"
				style="float: left; height: 35px">
				<h2>댕냥이천국</h2></a>
			<div class="collapse navbar-collapse" id="collapsibleNavbar">
				<ul class="navbar-nav">
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown">댕댕이</a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="/2/qna">QnA</a></li>
							<li><a class="dropdown-item" href="/2/boast">자랑하기</a></li>
							<li><a class="dropdown-item" href="/2/tip">꿀팁</a></li>
						</ul></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown">냐옹이</a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="/1/qna">QnA</a></li>
							<li><a class="dropdown-item" href="/1/boast">자랑하기</a></li>
							<li><a class="dropdown-item" href="/1/tip">꿀팁</a></li>
						</ul></li>
				</ul>
			</div>
			<div>



				<c:choose>
					<c:when test="${empty sessionScope.principal}">
						<ul class="navbar-nav justify-content-end">
							<li class="nav-item"><a class="nav-link" href="/user/loginForm">로그인</a></li>
							<li class="nav-item"><a class="nav-link" href="/user/joinForm">회원가입</a></li>
							<li class="nav-item"><a class="nav-link" href="/notice">공지사항</a></li>
						</ul>
					</c:when>
					<c:otherwise>
						<c:choose>
							<c:when test="${sessionScope.principal.authority eq 'admin'}">
								<ul class="navbar-nav justify-content-end">
									<li class="nav-item"><a class="nav-link" href="/logout">로그아웃</a></li>
									<li class="nav-item"><a class="nav-link" href="/user/detail/${sessionScope.principal.id }">내정보</a></li>
									<li class="nav-item"><a class="nav-link" href="/notice">공지사항</a></li>
									<li class="nav-item"><a class="nav-link" href="/admin/home">관리자페이지</a></li>
								</ul>
							</c:when>
							<c:otherwise>
								<ul class="navbar-nav justify-content-end">
									<li class="nav-item"><a class="nav-link" href="/logout">로그아웃</a></li>
									<li class="nav-item"><a class="nav-link" href="/user/detail/${sessionScope.principal.id }">내정보</a></li>
									<li class="nav-item"><a class="nav-link" href="/notice">공지사항</a></li>
								</ul>
							</c:otherwise>
						</c:choose>
					</c:otherwise>
				</c:choose>


			</div>
		</div>
	</nav>
	<br>