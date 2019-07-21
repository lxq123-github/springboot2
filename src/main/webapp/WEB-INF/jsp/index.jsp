<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Home</title>
    <style>
        #iframeTop{
            width: 99%;
            height: 70px;
        }
        #iframeLeft{
            width: 15%;
            height: 600px;
            float: left;
        }
        #iframeContent{
            width: 84%;
            height: 600px;
        }
    </style>
<body>
<div>
    <iframe id="iframeTop" name="iframeTop" frameborder="3" border="1" src="index/top"></iframe>
    <iframe id="iframeLeft" name="iframeLeft" frameborder="3" border="1"  src="index/left"></iframe>
    <iframe id="iframeContent" name="iframeContent" frameborder="3" border="1"  src=""></iframe>
</div>
</body>