<%@ page import="com.zhangli.Guestbook" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  bk: zhangli
  Date: 2018/7/25
  Time: 下午4:37
  To change tdis template use File | Settings | File Templates.
--%>
<%@page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery-1.12.4.min.js"></script>
</head>
<body>
    <table class="table">
        <tr>
            <th>ID</th>
            <th>标题</th>
            <th>摘要</th>
            <th>作者</th>
            <th>发布时间</th>
            <th>内容</th>
        </tr>

    <%
        List<Guestbook> list = (List)request.getAttribute("list");
        if(list.size()!=0){
            for(int i=0;i<list.size();i++){
                pageContext.setAttribute("bk",list.get(i));
    %>
        <tr>
            <td>${bk.id}</td>
            <td>${bk.title}</td>
            <td>${bk.subTitle}</td>
            <td>${bk.name}</td>
            <td>${bk.date}</td>
            <td>${bk.content}</td>
        </tr>
        <%----%>
        <%--<tr>--%>
            <%--<td><%=bk.getId() %></td>--%>
            <%--<td><%=bk.getTitle() %></td>--%>
            <%--<td><%=bk.getSubTitle() %></td>--%>
            <%--<td><%=bk.getName() %></td>--%>
            <%--<td><%=bk.getDate() %></td>--%>
            <%--<td><%=bk.getContent() %></td>--%>
        <%--</tr>--%>
    <% }}else{ %>
        <tr><td colspan="6">数据库中没有数据！</td></tr>
    <% } %>

    </table>
</body>
</html>
