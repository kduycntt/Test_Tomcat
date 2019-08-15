<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録</title>
<style>
	body {
		font-size: 20px;
	}
	table {
		margin: 50px 0px 0px 20px;
		width: 90%;
		border: 0;
		border-spacing: 20px;
	}
	#back {
		margin: 10px 0px 0px 10px;
		width: 8%;
		cursor: pointer;
	}
	#register {
		margin: 10px 10px 0px 10px;
		float: right;
		width: 8%;
		cursor: pointer;
	}
	#memo {
		position: absolute;
	}
</style>
</head>
<body>
	<form action="register" method="post">
		<a href="<%= request.getContextPath() %>/Home.jsp">
				<input type="button" id="back" value="戻る" />
		</a>
		<input id="register" type="submit" value="登録"/>
		<table>
			<tr>
	        	<td>名前</td>
	        	<td> <input type="text" name="userName"></td>
	    	</tr>
	    	<tr>
	        	<td>生年月日</td>
	        	<td> <input type="date" name="birthDate"></td>
	    	</tr>
	    	<tr>
	        	<td>専門</td>
	        	<td>
					<select id="department">
						<option selected hidden="true"></option>
						<option value="企画部">企画部</option>
						<option value="経営管理部">経営管理部</option>
					</select>
				</td>
	    	</tr>
	    	<tr>
	        	<td id="memo">メモ</td>
	        	<td> <textarea name="memo" rows="6" cols="100"></textarea></td>
	    	</tr>
		</table>
	</form>
</body>
</html>