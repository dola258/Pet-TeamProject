
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<style>

	@import url("/user_Css/main.css");
	
</style>



<div class="container">
    <div class="text-center">
    <br>
    <br> 
	<h4>Best  post</h4>
	<br>
  </div>
  <div class="text-center">
 <div class="row">
        <div class="col-4">
          <div class="card">
            <div class="card-body cards">
              <h5 class="card-title cards-title">${mainEntity[0].title }</h5>
              <img class="card-img-top" src="${image[0]}" onerror="this.src='/admin/assets/img/no-image-icon-23485.png'" alt="사진이 없습니다."  width="322" height="238">
              <p></p>
              <a href="/${mainEntity[0].animal.id }/boast/${mainEntity[0].id}" class="btn btn-success">게시물보기</a>
            </div>
          </div>
        </div>
        <div class="col-4">
          <div class="card">
            <div class="card-body cards">
              <h5 class="card-title cards-title">${mainEntity[1].title }</h5>
              <img class="card-img-top" src="${image[1]}" onerror="this.src='/admin/assets/img/no-image-icon-23485.png'" alt="사진이 없습니다."  width="322" height="238">
              <p></p>
              <a href="/${mainEntity[1].animal.id }/boast/${mainEntity[1].id}" class="btn btn-success">게시물보기</a>
            </div>
          </div>
        </div>
        <div class="col-4">
          <div class="card">
            <div class="card-body cards">
              <h5 class="card-title cards-title">${mainEntity[2].title }</h5>
              <img class="card-img-top" src="${image[2]}" onerror="this.src='/admin/assets/img/no-image-icon-23485.png'" alt="사진이 없습니다."  width="322" height="238">
              <p></p>
              <a href="/${mainEntity[2].animal.id }/boast/${mainEntity[2].id}" class="btn btn-success ">게시물보기</a>
            </div>
          </div>
        </div>
          </div>
        </div>
        </div>



<%@ include file="../layout/footer.jsp" %>