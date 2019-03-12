<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="my" uri="/mytl/i18n"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title></title>
</head>
<body>
<h3>自定义国际化</h3>
<my:msg key="hello"><my:arg v="@china"/></my:msg><br>
<my:msg key="hello" language="zh"><my:arg v="@china"/></my:msg><br>
<my:msg key="hello"><my:arg v="@china"/></my:msg><br>
<my:msg key="hello" language="en"><my:arg v="@china"/></my:msg><br>
<my:msg key="hello" language="en"><my:arg v="@china" language="zh" country="CN"/></my:msg><br>
<my:msg key="hello" language="en" country="US"><my:arg v="china"/></my:msg><br>
<my:msg key="hello"><my:arg v="中国"/>世界</my:msg><br>
<hr>
<h3>JSTL国际化（&lt;fmt:message&gt;）</h3>
<fmt:message key="hello"><fmt:param value="中国"/></fmt:message><br>
<fmt:message key="china"/><br>
<hr>
<h3>Spring国际化（&lt;s:message&gt;）</h3>
<s:message code="hello" arguments="中国"/><br>
<s:message code="china"/><br>
</body>
</html>