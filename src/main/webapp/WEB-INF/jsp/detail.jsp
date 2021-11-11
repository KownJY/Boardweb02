<%@ page import="javacode.Board2VO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Board2VO vo =(Board2VO)request.getAttribute("data");
    String strIboard = request.getParameter("iboard");
%>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>detail</title>
</head>
<body>
<a href="/del?iboard=<%=vo.getIboard()%>">
    <input type="button" value="삭제">
</a>


 <div>제목: <%=vo.getTitle()%></div>
 <div><%=vo.getCtnt()%></div>
</body>
</html>
