<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<script src="styles/umeditor/third-party/jquery.min.js"></script>
<script src="styles/umeditor/third-party/mathquill/mathquill.min.js"></script>
<link rel="stylesheet" href="styles/umeditor/third-party/mathquill/mathquill.css"/>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
String content = request.getParameter("myEditor");



response.getWriter().print("<div class='content'>"+content+"</div>");

%>