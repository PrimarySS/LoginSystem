<%@ page language="java" pageEncoding="UTF-8"%>
<%--为了避免在jsp页面中出现java代码，这里引入jstl标签库，利用jstl标签库提供的标签来做一些逻辑判断处理 --%>

<!DOCTYPE HTML>
<html>
<head>
<script src="http://ajax.aspnetcdn.com/ajax/jquery/jquery-2.1.4.min.js"></script>
<title>首页</title>
<script type="text/javascript">
    	function doLogout(){
    		//访问LogoutServlet注销当前登录的用户
    		window.location.href="${pageContext.request.contextPath}/LogoutServlet";
    	}
    </script>
</head>

<body>
	<input type="hidden" id="user" value="${user.username}">
	<input type="hidden" id="path"
		value="${pageContext.request.contextPath}">
	<h1>SYF的网站</h1>
	<hr />
	<div id="content"></div>


	<hr />
</body>
<script>
	var name = $("#user").val();
	var path = $("#path").val();

	
	if(name==null || name == "")
		{
			$("#content").append("<a href='"+path+"/register' target='_blank'>注册</a>");
			$("#content").append("<a href='"+path+"/login'>登陆</a>");		}
	else 
		{
		    
		    $("#content").append("欢迎您："+name+"<input type='button' value='退出登陆' onclick='doLogout()'>");
		}  
	
	</script>
</html>