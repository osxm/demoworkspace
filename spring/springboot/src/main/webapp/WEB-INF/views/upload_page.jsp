<!-- upload_page.jsp Author:Chen Xueming -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload File Page</title>
</head>
<body>
    文件上传
	<form action="do_upload" method="post" enctype="multipart/form-data">
		<input type="file" name="myfile"> <br>
		<input type="submit" value="上传">
	</form>
</body>
</html>