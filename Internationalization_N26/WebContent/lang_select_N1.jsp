<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix = "x" uri = "http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Internationalization - i18n</title>
</head>
<body>

<form id="language">
	Language: <select id="langMenu" onchange="javascript:handleSelect(this)">
		<option value="blank">-Select a language-</option>
		<option value="?locale=hi_IN">Hindi(India)</option>
		<option value="?locale=el_GR">Greek(Greece)</option>
		<option value="?locale=ar_SA">Arabic(Saudi Arab)</option>
		<option value="?locale=es_ES">Spanish(Spain)</option>
	</select>
</form>

<hr>

<fmt:setLocale value="${param.locale}"/>
<fmt:bundle basename="/i18n/website">

<p><fmt:message key="label.hello"/> Aman
<p><fmt:message key="label.welcome"/>
<p><fmt:message key="label.pleased.presence"/>
<p><fmt:message key="label.thanks"/>

</fmt:bundle>

<script type="text/javascript">
	function handleSelect(elm) { 
		window.location = elm.value; 
	} 
</script>

</body>
</html>