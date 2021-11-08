<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../layout/header.jsp"%>

<div class="container">
	<h1>댕댕이-자랑하기</h1>
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
							<button type="button" class="btn btn-success" onclick="location.href='/2/boast/saveForm'">글쓰기</button>
						</div>
					</div>
				</th>
			</tr>
		</thead>
	 <tbody>
             <c:forEach var="boast" items="${boastEntity.content}">
             <tr>
                <td>${boast.id }</td>
               <td><a href="/${animalId}/boast/${boast.id}">${boast.title }</a></td>
               <td>${boast.createdAt }</td>
               <td>${boast.counter}</td>
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
         <c:when test="${boastEntity.first}"></c:when>
         <c:otherwise>
            <li class="page-item"><a class="page-link" href="/${animalId}/boast?page=${boastEntity.number-1}"><</a></li>
         </c:otherwise>
      </c:choose>
      
      <!-- 페이지 그룹, 끝을 totalPages로 설정함 -->
      <c:forEach begin="${startBlockPage}" end="${boastEntity.totalPages}" var="i">
         <c:choose>
            <c:when test="${boastEntity.pageable.pageNumber + 1 ==  i}">
               <li class="page-item disabled"><a class="page-link" href="/${animalId}/boast?page=${i-1}">${i}</a></li>
            </c:when>
            <c:otherwise>
               <li class="page-item"><a class="page-link" href="/${animalId}/boast?page=${i-1}">${i}</a></li>
            </c:otherwise>
         </c:choose>
      </c:forEach>

      <!-- 다음 -->
      <c:choose>
         <c:when test="${boastEntity.last}"></c:when>
         <c:otherwise>
            <li class="page-item "><a class="page-link" href="/${animalId}/boast?page=${boastEntity.number+1}">></a></li>
         </c:otherwise>
      </c:choose>


      </ul>
</div>
</div>


<%@ include file="../../layout/footer.jsp"%>