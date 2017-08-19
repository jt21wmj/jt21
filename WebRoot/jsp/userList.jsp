<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html><head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>超市账单管理系统-用户管理</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css">
</head>
<body>

	<div class="menu">

		<table>
			<tbody>
				<tr>
					<td><form method="post" action="user.do">
							<input name="method" value="query" class="input-text" type="hidden"> 用户名：<input name="name" class="input-text" type="text" value="">&nbsp;&nbsp;&nbsp;&nbsp;
							<input value="查 询" type="submit">
						</form>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="main">

		<div class="optitle clearfix">
			<em>
				<input value="添加用户" class="input-button" onclick="window.location='${pageContext.request.contextPath }/jsp/userAdd.jsp'" type="button">
			</em>
			<div class="title">用户管理&gt;&gt;</div>
		</div>
		<div class="content">
			<table class="list">
				<tbody>
					<tr>
						<td width="70" height="29"><div class="STYLE1" align="center">编号</div>
						</td>
						<td width="80"><div class="STYLE1" align="center">用户名</div>
						</td>
						<td width="80"><div class="STYLE1" align="center">用户账号</div>
						</td>
						<td width="100"><div class="STYLE1" align="center">性别</div>
						</td>
						<td width="100"><div class="STYLE1" align="center">出生日期</div>
						</td>
						<td width="150"><div class="STYLE1" align="center">电话</div>
						</td>
						<td width="150"><div class="STYLE1" align="center">权限</div>
						</td>
					</tr>
					<c:forEach items="${result.data}" var="user">
					<tr>
						<td height="23"><span class="STYLE1">${user.id}</span>
						</td>
						<td><span class="STYLE1">${user.username} </span>
						</td>
						<td><span class="STYLE1"><a href="${pageContext.request.contextPath }/user/userRest/${user.id}">${user.usercode}</a>
						</span>
						</td>

						<td><span class="STYLE1">
						${user.gender==1?"女":"男"}
						 </span>
						</td>
						<td><span class="STYLE1">
						<f:formatDate value="${user.birthday}" pattern="yyyy-MM-dd"/>
						</span>
						</td>
						<td><span class="STYLE1">${user.phone}</span>
						</td>
						<td><span class="STYLE1">
						${user.userrole==1?"系统管理员":user.userrole==2?"经理":"员工" }
					     </span>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body></html>