<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/SpringmvcSpringMybatis/add.do" method="post">
			<fieldset>
				<legend>Add student information</legend>
				<label for="studentName">Student Name:</label>
				<input type="text" id="studentName" name="studentName" value="" tabindex="1"/>
				<br/>
				<label for="studentAge">Student Age:</label>
				<input type="text" id="studentAge" name="studentAge" value="" tabindex="2"/>
				<br/>
				<label for="studentScore">Student Score:</label>
				<input type="text" id="studentScore" name="studentScore" value="" tabindex="3"/>
				<br/>
				<div id="buttons">
				<input id="reset" type="reset" tabindex="4"/>
				<input id="submit" type="submit" tabindex="5" value="添加学生信息"/>
				</div>
			</fieldset>
		</form>

</body>
</html>