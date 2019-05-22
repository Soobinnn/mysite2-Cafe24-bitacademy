<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.servletContext.contextPath}/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url='/WEB-INF/views/includes/header.jsp'/>
		<div id="content">
			<div id="board">
				<form class="board-form" method="post" action="${pageContext.servletContext.contextPath}/board/write">
					<c:choose>
						<c:when test='${!empty replyBoard}'>
							<input type = "hidden" name = "order_no" value="${replyBoard.order_no}">
							<input type = "hidden" name = "depth" value="${replyBoard.depth}">
						<c:otherwise>
							<input type = "hidden" name = "order_no" value="1">
							<input type = "hidden" name = "depth" value="0">
						</c:otherwise>
						</c:when>
					</c:choose>
					<input type = "hidden" name = "hit" value="0">
					<input type = "hidden" name = "no" value="${sessionScope.authUser.no}">		
					<table class="tbl-ex">
						<tr>
							<th colspan="2">글쓰기</th>
						</tr>
						<tr>
							<td class="label">제목</td>
							<td><input type="text" name="title" value=""></td>
						</tr>
						<tr>
							<td class="label">내용</td>
							<td>
								<textarea id="content" name="contents"></textarea>
							</td>
						</tr>
					</table>
					<div class="bottom">
						<a href="${pageContext.servletContext.contextPath}/board">취소</a>
						<input type="submit" value="등록">
					</div>
				</form>				
			</div>
		</div>
		<c:import url='/WEB-INF/views/includes/navigation.jsp'>
			<c:param name="menu" value="board" />
		</c:import>
		<div id="footer">
			<p>(c)opyright 2015, 2016, 2017, 2018</p>
		</div>
	</div>
</body>
</html>