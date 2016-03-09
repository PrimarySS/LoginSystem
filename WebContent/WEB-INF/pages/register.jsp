<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
</head>
<body style="text-align: center;">
        <form action="${pageContext.request.contextPath}/RegisterServlet" method="post">
            <table width="60%" border="1">
                <tr>
                    <td>用户名</td>
                    <td>
                        
                        <input type="text" name="username" value="${formbean.username}">${formbean.errors.username}
                    </td>
                </tr>
                <tr>
                    <td>密码</td>
                    <td>
                        <input type="password" name="password" value="${formbean.password}">${formbean.errors.password}
                    </td>
                </tr>
                <tr>
                    <td>确认密码</td>
                    <td>
                        <input type="password" name="confirmpsw" value="${formbean.confirmpsw}">${formbean.errors.confirmpsw}
                    </td>
                </tr>
                <tr>
                    <td>邮箱</td>
                    <td>
                        <input type="text" name="email" value="${formbean.email}">${formbean.errors.email}
                    </td>
                </tr>
                <tr>
                    <td>生日</td>
                    <td>
                        <input type="text" name="birthday" value="${formbean.birthday}">${formbean.errors.birthday}
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="reset" value="清空">
                    </td>
                    <td>
                        <input type="submit" value="注册">
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>