<%@ page import="javacode.Board2VO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Board2VO> list = (List<Board2VO>)request.getAttribute("data");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>리스트</title>

</head>
<body>

<div>
    <a href="/write">
        <input type="button" value="글쓰기">
    </a>


</div>
<table>

    <% for(Board2VO vo : list) { %>
    <tr>
        <td><%=vo.getIboard()%></td>
        <td>
            <a href="/detail?iboard=<%=vo.getIboard()%>">
                <%=vo.getTitle()%>
            </a>

        </td>
        <td><%=vo.getCtnt()%></td>
        <td><%=vo.getWriter()%></td>
        <td><%=vo.getRdt()%></td>
    </tr>
 <%}%>

</table>



</body>
</html>