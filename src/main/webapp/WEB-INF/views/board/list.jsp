<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.servletContext.contextPath }/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<script>
console.log('${authUser}');
console.log('${sessionScope.authUser}');
console.log('${sessionScope.authUser.no}');
console.log('${vo.reg_date}');
</script>
<body>
	<div id="container">
		<c:import url='/WEB-INF/views/includes/header.jsp' />
		<div id="content">
			<div id="board">
				<form id="search_form" action="" method="post">
					<input type="text" id="kwd" name="kwd" value="">
					<input type="submit" value="찾기">
				</form>
				<table class="tbl-ex">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>작성일</th>
						<th>&nbsp;</th>
					</tr>	
					<c:forEach items="${list}" var="vo" varStatus="status">		
					<c:choose>
					<c:when test='${vo.reg_date=="Fri Jan 01 11:11:11 KST 9999"}'>
					<tr>
						<td>${vo.board_no}</td>
							<td style="text-align:left; padding-left:${20*vo.depth}px">
							<c:if test='${vo.depth>0}'>
							<img src='${pageContext.servletContext.contextPath }/assets/images/reply.png'>
							</c:if>
							<span>삭제된 게시글 입니다.</span>
							</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					</c:when>
					<c:otherwise>
					<tr>
						<td>${vo.board_no}</td>
							<td style="text-align:left; padding-left:${20*vo.depth}px">
							<c:if test='${vo.depth>0}'>
							<img src='${pageContext.servletContext.contextPath }/assets/images/reply.png'>
							</c:if>
							<a href="${pageContext.servletContext.contextPath}/board/view?no=${vo.board_no}">${vo.title }</a></td>
						<td>${vo.name }</td>
						<td>${vo.hit }</td>
						<td><fmt:formatDate value="${vo.reg_date}" pattern="yyyy-MM-dd"/></td>
						<c:choose>
						<c:when test='${sessionScope.authUser.no==vo.no}'>
							<td><a href="${pageContext.servletContext.contextPath}/board/delete?n=${vo.board_no}" class="del">삭제</a></td>
						</c:when>
						<c:when test='${sessionScope.authUser.no!=vo.no}'>
							<td></td>
						</c:when>
						</c:choose>
					</tr>
					</c:otherwise>
					</c:choose>
					</c:forEach>	
				</table>
				
				<!-- pager 추가 -->
				<div class="pager">
					<ul>
						<li><a href="">◀</a></li>
						<li><a href="">1</a></li>
						<li class="selected">2</li>
						<li><a href="/board/list?p=3">3</a></li>
						<li>4</li>
						<li>5</li>
						<li><a href="">▶</a></li>
					</ul>
				</div>
									
				<!-- pager 추가 -->				
				<c:if test="${!empty sessionScope.authUser.no}">
				<div class="bottom">
					<a href="${pageContext.servletContext.contextPath}/board/write" id="new-book">글쓰기</a>
				</div>
				</c:if>				
			</div>
		</div>
		<c:import url='/WEB-INF/views/includes/navigation.jsp'>
			<c:param name="menu" value="board" />
		</c:import>
		<c:import url='/WEB-INF/views/includes/footer.jsp' />
	</div>
</body>
</html>