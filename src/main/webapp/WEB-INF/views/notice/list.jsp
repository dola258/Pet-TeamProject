<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">
	<h1>공지사항</h1>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>글 번호</th>
				<th>제목</th>
				<th>작성일</th>
				<th>
					<div  class="d-flex justify-content-between">
						<div class="align-self-end">조회수</div>
						<div>
							<button type="button" class="btn btn-success" onclick="location.href='/notice/saveForm'">글쓰기</button>
						</div>
					</div>
				</th>
			</tr>
		</thead>
	 <tbody>
             <c:forEach var="notice" items="${noticeEntity.content}">
             <tr>
                <td>${notice.id }</td>
               <td><a href="/notice/${notice.id}">${notice.title }</a></td>
               <td>${notice.createdAt }</td>
               <td>${notice.counter}</td>
               </tr>
         </c:forEach>

      </tbody>

   </table>
   <br>
   <br>
        <div class="d-flex justify-content-center">
<ul class="pagination order-2">
      
      <!-- 이전 -->
      <c:choose>
         <c:when test="${noticeEntity.first}"></c:when>
         <c:otherwise>
            <li class="page-item"><a class="page-link" href="/notice?page=${notice.number-1}"><</a></li>
         </c:otherwise>
      </c:choose>
      
      <!-- 페이지 그룹, 끝을 totalPages로 설정함 -->
      <c:forEach begin="${startBlockPage}" end="${noticeEntity.totalPages}" var="i">
         <c:choose>
            <c:when test="${noticeEntity.pageable.pageNumber + 1 ==  i}">
               <li class="page-item disabled"><a class="page-link" href="/notice?page=${i-1}">${i}</a></li>
            </c:when>
            <c:otherwise>
               <li class="page-item"><a class="page-link" href="/notice?page=${i-1}">${i}</a></li>
            </c:otherwise>
         </c:choose>
      </c:forEach>

      <!-- 다음 -->
      <c:choose>
         <c:when test="${noticeEntity.last}"></c:when>
         <c:otherwise>
            <li class="page-item "><a class="page-link" href="/notice?page=${noticeEntity.number+1}">></a></li>
         </c:otherwise>
      </c:choose>


      </ul>
</div>
</div>

<%@ include file="../layout/footer.jsp"%>