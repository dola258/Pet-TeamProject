<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../layout/header.jsp"%>

<div class="container">
	<h1>냐옹이-QnA</h1>
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
							<button type="button" class="btn btn-success" onclick="location.href='/1/qna/saveForm'">글쓰기</button>
						</div>
					</div>
				</th>
			</tr>
		</thead>
	 <tbody>
             <c:forEach var="qna" items="${qnaEntity.content}">
             <tr>
                <td>${qna.id }</td>
               <td><a href="/${animalId}/qna/${qna.id}">${qna.title }</a></td>
               <td>${qna.createdAt }</td>
               <td>${qna.counter}</td>
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
         <c:when test="${qnaEntity.first}"></c:when>
         <c:otherwise>
            <li class="page-item"><a class="page-link" href="/${animalId}/qna?page=${qnaEntity.number-1}"><</a></li>
         </c:otherwise>
      </c:choose>
      
      <!-- 페이지 그룹, 끝을 totalPages로 설정함 -->
      <c:forEach begin="${startBlockPage}" end="${qnaEntity.totalPages}" var="i">
         <c:choose>
            <c:when test="${qnaEntity.pageable.pageNumber + 1 ==  i}">
               <li class="page-item disabled"><a class="page-link" href="/${animalId}/qna?page=${i-1}">${i}</a></li>
            </c:when>
            <c:otherwise>
               <li class="page-item"><a class="page-link" href="/${animalId}/qna?page=${i-1}">${i}</a></li>
            </c:otherwise>
         </c:choose>
      </c:forEach>

      <!-- 다음 -->
      <c:choose>
         <c:when test="${qnaEntity.last}"></c:when>
         <c:otherwise>
            <li class="page-item "><a class="page-link" href="/${animalId}/qna?page=${qnaEntity.number+1}">></a></li>
         </c:otherwise>
      </c:choose>


      </ul>
</div>
</div>


<%@ include file="../../layout/footer.jsp"%>