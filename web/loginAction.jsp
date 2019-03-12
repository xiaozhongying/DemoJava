<%@page language="java" contentType="text/html;charset=UTF-8" import="dswork.web.*,common.auth.AuthUtil"%><%
String path = request.getContextPath();
MyRequest req = new MyRequest(request);
String account = req.getString("account");
String password = req.getString("password");
String authcode = req.getString("authcode");
int logintype = req.getInt("logintype");
AuthUtil login = new AuthUtil(pageContext);
String s = "about:blank", m = "";
if(logintype == common.auth.Auth.ADMIN || logintype == common.auth.Auth.ENTERPRISE || logintype == common.auth.Auth.USER)
{
	if(login.login(account, password, logintype, authcode))
	{
		response.sendRedirect("manage/frame/index.jsp");
	}
	if(logintype == common.auth.Auth.ENTERPRISE)
	{
		s = "loginEp.html";
	}
	else if(logintype == common.auth.Auth.USER)
	{
		s = "loginPerson.html";
	}
	else
	{
		s = "login.html";
	}
	m = login.getMsg();
}
else
{
	m = "非法访问";
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title></title>
<script type="text/javascript">alert("<%=m %>");location.href="<%=s%>";</script>
</head>
<body></body>
</html>