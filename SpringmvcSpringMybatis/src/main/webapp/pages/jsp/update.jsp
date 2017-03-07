<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
		<fieldset>
			<legend>
				修改学生信息，ID:<span id="id">${vo.id}</span>
			</legend>
			<label for="studentName">studentName:</label>
				<input type="text" id="studentName" name="studentName" value="${vo.studentName}" tabindex="1" />
			<br />
			<label for="studentAge">studentAge:</label>
				<input type="text" id="studentAge" name="studentAge" value="${vo.studentAge}" tabindex="2" />
			<br />
			<label for="studentScore">studentScore:</label>
				<input type="text" id="studentScore" name="studentScore" value="${vo.studentScore}" tabindex="3" />
			<br />
			<div id="buttons">
				<label for="dummy"></label> <input id="reset" type="reset"
					tabindex="4" /> <input id="btUpdate" type="submit" tabindex="5"
					value="更新学生信息" />
			</div>
		</fieldset>
		<script src="/SpringmvcSpringMybatis/pages/script/jquery.min.js"></script>
		<script src="/SpringmvcSpringMybatis/pages/script/md5.js"></script>
		<script src="/SpringmvcSpringMybatis/pages/script/common.js"></script>
		<script src="/SpringmvcSpringMybatis/pages/script/update.js"></script>
	</div>

</body>
</html>