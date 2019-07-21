<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        *{
            font-size:18px;
            margin: 0;
            padding:0;
            background-color: beige;
        }
        ul{
            list-style: none;
            margin-left: 25px;
            margin-top:30px;
        }
    </style>

</head>
<body>
<ul>
    <c:forEach items="${urls}" var="item" varStatus="status">
        <c:choose>
            <c:when  test="${item.url==null}">
                <li><a href="javascript:void(0)" target="iframeContent">${item.name}</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="${item.url}" target="iframeContent">${item.name}</a></li>
            </c:otherwise>
        </c:choose>
    </c:forEach>
</ul>
<script type="text/javascript">
    if('${urls}' == '[]' || '${urls}'.length==2){
        var oUl = document.getElementsByTagName("ul")[0];
        var str = "<li><a href='/order' target='iframeContent'>订单管理</a></li>";
        oUl.innerHTML = str;
    }
</script>
</body>
</html>