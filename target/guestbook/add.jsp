<%--
  Created by IntelliJ IDEA.
  User: zhangli
  Date: 2018/7/26
  Time: 上午12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>add</title>
</head>
<body>
<form name="gbAdd" method="post" action="/add">
    <input type="text" name="title">
    <input type="text" name="subTitle">
    <input type="text" name="name">
    <textarea  name="content"></textarea>

    <input type="button" value="submit">
</form>
</body>
<script src="js/jquery-1.12.4.min.js"></script>
<script>
    $(function($){
        $(":button").click(function () {
            var title = $("input[name='title']").val();
            var subTitle = $("input[name='subTitle']").val();
            var name = $("input[name='name']").val();
            var content = $("input[name='content']").val();

            if(title=="" && subTitle=="" && name=="" && content==""){
                alert("请填写完整资料");
            }else{
                $("form[name='gbAdd']").submit();
            }
        })
    })
</script>
</html>
