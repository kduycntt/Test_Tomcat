<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>テスト・ホーム・ページ</title>
	<style type="text/css">
		table {
			width: 80%;
			margin: 10px 50px 10px 20px;
		}
		#toRegister {
		    width: 100px;
		    float: right;
    		margin-right: 19%;
    		cursor: pointer;
		}
		button.insideBtn {
			margin: 2px 0px 2px 2px;
    		width: 48%;
    		cursor: pointer;
		}
		thead {
			background: lightgrey;
		}
	</style>
</head>
<body>
	<form action="<%= request.getContextPath() %>/register">
		<a href="<%= request.getContextPath() %>/register.jsp">
			<input type="button" id="toRegister" value="新規作成" />
		</a>
		<br>
		<table border="1">
			<thead>
	    		<tr>
	        		<td>ID</td>
	        		<td>名前</td>
	        		<td>生年月日</td>
	        		<td>部門名</td>
	        		<td></td>
	    		</tr>
	    	</thead>
	    	<c:forEach var="employee" items="${employeeList}">
	    		<tr>
	    			<td><c:out value="${employee.id}" /></td>
	    			<td><c:out value="${employee.name}" /></td>
	    			<td><c:out value="${employee.birthday}"></c:out></td>
	    			<td><c:out value="${employee.department_id}"></c:out>
	    			<td><c:out value="${$employee.memo}"></c:out>
	    			<td>
                        <a href="/edit?id=<c:out value='${book.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?id=<c:out value='${book.id}' />">Delete</a>                     
                    </td>
	    		</tr>
	    	</c:forEach>
		</table>
	</form>
</body>
</html>