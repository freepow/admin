<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags"	prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>계정 조회</title>
<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
<script type='text/javascript' src='/dwr/interface/AccountService.js'></script>


<script type="text/javascript">
	function saveComment() {
		AccountService.cancelJoinToSpaceDWR(myCallBack);
	}
	
	function myCallBack(outData) {
		if(outData != null) {
			var jResult = eval("("+outData+")");
			if(jResult.rtnResult > 0) {
					alert(jResult.rtnMsg);
			} else {
				alert('결과값 없음');
			}
		}
	}
</script>
</head>
<body>
	<form name="myForm">
	<input type="button" value="dwr실행" onclick="javascript:saveComment();">
 </form>
</body>
</html>