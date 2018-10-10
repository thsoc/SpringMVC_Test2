<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>水果列表</title>
</head>
<body>
	<form action="queryFruitsByCondition.action" method="post">
		名称：<input type="text" name="name" />&nbsp;&nbsp; 产地：<input
			type="text" name="producting_area" /> <input type="submit"
			value="搜索" />
	</form>
	<h3>搜索结果</h3>
	<form action="fruitsArrayTest.action" method="post">
		<table width="300px;" border=1>
			<tr>
				<td></td>
				<td>名称</td>
				<td>价格</td>
				<td>产地</td>
			</tr>
			<c:forEach items="${fruitsList }" var="fruit">
				<tr>
					<td><input type="checkbox" name="fids" value="${fruit.id}" /></td>
					<td>${fruit.name }</td>
					<td>${fruit.price }</td>
					<td>${fruit.producting_area }</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="批量提交测试">
	</form>

	<form action="fruitsListTest.action" method="post">
		<table width="300px;" border=1>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>产地</td>
			</tr>
			<c:forEach items="${fruitsList }" var="fruit" varStatus="status">
				<tr>
					<td><input name="fruitList[${status.index}].name"
						value="${fruit.name }" /></td>
					<td><input name="fruitList[${status.index}].price"
						value="${fruit.price }" /></td>
					<td><input name="fruitList[${status.index}].producting_area"
						value="${fruit.producting_area }" /></td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="批量提交测试">
	</form>

	<form action="fruitsMapTest.action" method="post">
		<table width="300px;" border=1>
			<tr>
				<td><input name="fruitsMap['name']" /></td>
				<td><input name="fruitsMap['price']" /></td>
				<td><input name="fruitsMap['producting_area']" /></td>
			</tr>
		</table>
		<input type="submit" value="批量提交测试">
	</form>
</body>
</html>
