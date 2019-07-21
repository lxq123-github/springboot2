<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <title>SpringBoot练习</title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <style type="text/css">
        h1 {
            color:red;
            text-align: center;
        }
        ul{
            list-style:none;
        }
        ul span{
            color: blueviolet;
            font-weight: bold;
        }
    </style>
</head>
<body>
<h1> 错误页面 </h1>
<div>
    <ul>
        <li><span>code</span> : ${info.code}</li>
        <li>&nbsp;</li>
        <li><span>message</span> : ${info.message}</li>
        <li>&nbsp;</li>
        <li><span>url</span> : ${info.url}</li>
    </ul>
</div>
</body>
</html>