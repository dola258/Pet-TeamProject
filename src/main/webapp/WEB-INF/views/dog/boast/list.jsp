<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../layout/header.jsp"%>

<div class="container">
	<h1>공지사항</h1>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>글 번호</th>
				<th>제목</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>3</td>
				<td><a href="#" class="text-dark text-decoration-none">광고글
						쓰지 마세요!</a></td>
				<td>2021-10-01</td>
				<td>3</td>
			</tr>
			<tr>
				<td>2</td>
				<td><a href="#" class="text-dark text-decoration-none">넵</a></td>
				<td>2021-10-02</td>
				<td>2</td>
			</tr>
			<tr>
				<td>1</td>
				<td><a href="#" class="text-dark text-decoration-none">알겠습니다</a></td>
				<td>2021-10-03</td>
				<td>1</td>
			</tr>
		</tbody>
	</table>
	<br>
	<br>
	<div class="d-flex justify-content-between">
		<ul class="pagination order-2">
			<li class="page-item"><a class="page-link" href="#"><</a></li>
			<li class="page-item"><a class="page-link" href="#">1</a></li>
			<li class="page-item active"><a class="page-link" href="#">2</a></li>
			<li class="page-item"><a class="page-link" href="#">3</a></li>
			<li class="page-item"><a class="page-link" href="#">></a></li>
		</ul>
		<div class="item order-1"></div>
		<button type="button" class="btn btn-success btn-xs order-3 h-25 " onclick="location.href='#'">글쓰기</button>
	</div>
</div>

<%@ include file="../../layout/footer.jsp"%>