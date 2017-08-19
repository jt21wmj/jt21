<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.9.1.js"></script>
</head>
<body>
<div class="main">
	<div class="optitle clearfix">
		<div class="title">用户管理&gt;&gt;</div>

	</div>
	<f:form action="${pageContext.request.contextPath }/user/modify" modelAttribute="smbmsUser" method="post" >
		<div class="content">
			<font color="red"></font><table class="box">
			<tbody><tr>
					<td class="field">用户编号：</td>
					<td><f:hidden path="id"/>${smbmsUser.id }</td> 

				</tr>
			<tr>
					<td class="field">用户名：</td>
					<td><f:select path="username"/> <font color="red">*</font><font color="red" id="name_span"></font></td>
				</tr>
				<tr>
					<td class="field">用户性别：</td>
					<td><f:select path="gendex" items="${sexs}"/>  </td>
				</tr>
				<tr>
					<td class="field">出生日期：</td>
					<td><input type="text" name="birthDate" class="text" id="birthDate" value="<fmt:formatDate value='${smbmsUser.birthday}' pattern='yyyy-MM-dd' />"> <font color="red">*</font><font color="red" id="birthDate_span"></font></td>
				</tr>
				<tr>
					<td class="field">用户电话：</td>
					<td><f:select path="phone"/> <font color="red">*</font><font color="red" id="phone_span"></font></td>

				</tr>
				<tr>
					<td class="field">用户地址：</td>
					<td><f:select path="address"/> </td>
				</tr>
				<tr>
					<td class="field">用户权限：</td>

					<td><f:radiobuttons path="gendex" items="${roles}"/></td>
				</tr>
			</tbody></table>
		</div>
		<div class="buttons">
			<input type="submit" name="update" id="update" value="修改" class="input-button">
			<input type="button" name="button" id="button" onclick="history.back(-1)" value="返回" class="input-button"> 
		</div>
</f:form>
</div>
</body>
</html>