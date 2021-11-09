
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

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
            <img src="images/card-image.png" alt="" />
            <div class="card-body">
              <h5 class="card-title">${mainEntity[0].title }</h5>
              <p class="card-text">${mainEntity[0].content }</p>
              <a href="/${mainEntity[0].animal.id }/boast/${mainEntity[0].id}" class="btn btn-success">게시물보기</a>
            </div>
          </div>
        </div>
        <div class="col-4">
          <div class="card">
            <img src="images/card-image.png" alt="" />
            <div class="card-body">
              <h5 class="card-title">>${mainEntity[1].title }</h5>
              <p class="card-text">${mainEntity[1].content }</p>
              <a href="/${mainEntity[1].animal.id }/boast/${mainEntity[1].id}" class="btn btn-success">게시물보기</a>
            </div>
          </div>
        </div>
        <div class="col-4">
          <div class="card">
            <img src="images/card-image.png" alt="" />
            <div class="card-body">
              <h5 class="card-title">${mainEntity[2].title }</h5>
              <p class="card-text">${mainEntity[2].content }</p>
              <a href="/${mainEntity[2].animal.id }/boast/${mainEntity[2].id}" class="btn btn-success ">게시물보기</a>
            </div>
          </div>
        </div>
          </div>
        </div>
        </div>






<%@ include file="../layout/footer.jsp" %>