<%@page language="java" contentType="text/html;charset=UTF-8" %><%
String path = request.getContextPath();
String v = String.valueOf(request.getParameter("v"));
common.auth.Auth auth = new common.auth.Auth();
auth.setLoginstatus(1);
if(v.equals("0"))
{
	auth.setId(100000000L);
	auth.setAccount("admin");
	auth.setName("系统管理");
	auth.setQybm("000000");
	auth.setLogintype(0);
}
else if(v.equals("2"))
{
	auth.setId(100000L);
	auth.setAccount("useradmin");
	auth.setName("企业管理");
	auth.setQybm("100000");
	auth.setLogintype(2);
	
	auth.setUsertype(1);//企业管理员
}
else
{
	auth.setId(1L);
	auth.setAccount("user");
	auth.setName("个人用户");
	auth.setQybm("111111");
	auth.setLogintype(1);
}
auth.setSsdw("银江股份有限公司");
auth.setSsbm("技术部");
request.getSession().setAttribute(common.auth.AuthUtil.SessionName_LoginUser, auth);
response.sendRedirect("manage/frame/index.jsp");// 请修改为：manage/frame/index.jsp
%>