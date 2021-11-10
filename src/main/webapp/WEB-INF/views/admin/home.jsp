<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String strReferer = request.getHeader("referer");
	if(strReferer == null){
		%><script type="text/javascript">
		alert("정상적인 경로를 통해 다시 접근해 주십시오.");
		document.location.href="/user/loginForm";
		</script><%
		return;
	}
%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Dashboard - SB Admin</title>
        <link href="https://cdn.jsdelivr.net/npm\/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="/admin/css/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">

                            <nav class="sb-sidenav-menu-nested nav">
                                <a class="nav-link" href="/admin/main">Home</a>
                                <a class="nav-link" href="/">메인페이지로</a>
                            </nav>
                        </div>
                    </div>

                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>

                    <div class="container-fluid px-4">
                        <h1 class="mt-4">회원관리페이지</h1>
                        <br>
                        <div class="row">
                            <div class="col-xl-6">
                                <div class="card mb-4">
                                    <div class="card-header">
                                        <i class="fas fa-chart-area me-1"></i>
                                        일별 방문자
                                    </div>
                                    <div class="card-body" id="AreaChartContainer" style="position: relative; height:40%; width:100%"><canvas id="myAreaChart"></canvas></div>
                                </div>
                            </div>
                            <div class="col-xl-6">
                                <div class="card mb-4">
                                    <div class="card-header">
                                        <i class="fas fa-chart-bar me-1"></i>
                                        월별 방문자
                                    </div>
                                    <div class="card-body" id="BarChartContainer" style="position: relative; height:40%; width:100%"><canvas id="myBarChart"></canvas></div>
                                </div>
                            </div>
                        </div>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                회원 목록
                            </div>
                            <div class="card-body">
                                <table id="datatablesSimple">
                                    <thead>
                                        <tr>
                                            <th>이름</th>
                                            <th>아이디</th>
                                            <th>성별</th>
                                            <th>나이</th>
                                            <th>전화번호</th>
                                            <th>이메일</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Name</th>
                                            <th>Username</th>
                                            <th>Gender</th>
                                            <th>Age</th>
                                            <th>phone</th>
                                            <th>email</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
										<c:forEach var="user" items="${userEntity}">
										    <tr>
										       <td>${user.name }</td>
										      <td>${user.username }</td>
										      <td>${user.gender }</td>
										      <td>${user.birth}</td>
										      <td>${user.phone}</td>
										      <td>${user.email}</td>
									      </tr>
										</c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </main>

            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="/admin/js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="/admin/assets/demo/chart-area-demo.js"></script>
        <script src="/admin/assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="/admin/js/datatables-simple-demo.js"></script>
        
<script>
	getAreaChartData();
	getBarChartData();
	
	setInterval(function(){
		getAreaChartData();
	}, 3000)
	
	setInterval(function(){
		getBarChartData();
	}, 3000)
	
</script>

</body>
</html> 