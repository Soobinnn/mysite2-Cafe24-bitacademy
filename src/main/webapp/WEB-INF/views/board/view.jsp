<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>   
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="${pageContext.servletContext.contextPath}/assets/css/board.css" rel="stylesheet" type="text/css">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="container">
		<c:import url='/WEB-INF/views/includes/header.jsp' />
		<div id="content">
			<div id="board" class="board-form">
			<form class="board-form" method="post" action="${pageContext.servletContext.contextPath}/board/modify">
				<input type="hidden" name="title" value="${view.title}">
				<input type="hidden" name="contents" value="${view.contents}">
				<input type="hidden" name="board_no" value="${view.board_no}">
				
				<table class="tbl-ex">
					<tr>
						<th colspan="2">글보기</th>
					</tr>
					<tr>
						<td class="label">제목</td>
						<td>${view.title}</td>
					</tr>
					<tr>
						<td class="label">내용</td>
						<td>
							<div class="view-content">
								${view.contents}
							</div>
						</td>
					</tr>
				</table>
					<a href="${pageContext.servletContext.contextPath}/board">글목록</a>
					<input type="submit" value="글수정"/>
					<c:choose>
						<c:when test='${empty sessionScope.authUser}'>
						<a href="${pageContext.servletContext.contextPath}/user/login">답글</a>
						</c:when>
						<c:otherwise>
						<a href="${pageContext.servletContext.contextPath}/board/replyBoard?g=${view.group_no}&d=${view.depth}&o=${view.order_no}">답글</a>
						</c:otherwise>
					</c:choose>
			</form>
				</div>
			</div>
		</div>
		<div class="bottom">
		<c:import url='/WEB-INF/views/includes/navigation.jsp'>
			<c:param name="menu" value="board" />
		</c:import>
		<div id="footer">
			<p>(c)opyright 2015, 2016, 2017, 2018</p>
		</div>
	</div>
</body>
</html>