<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<title>Title</title>
    <style type="text/css">
        * {
            margin: 0;
            padding: 0;
        }

        .tbl {
            margin: auto;
            width: 500px;
            /*border: 1px solid black;*/
        }
        .div1{
            width: 400px;
            height: 200px;
            /*background: lightgreen;*/
            position:absolute;
            left:0;
            top: 0;
            bottom: 0;
            right: 0;
            margin: auto;
        }

        h1{
            margin-top: 20px;
            text-align:center
        }
        .btn{
            width:70px;
        }
    </style>
</head>
<body>
<h1>添加数据</h1>
<div class="div1">
<form id="frm" name="frm" action="updateDate" method="post">
<table cellspacing="0" cellpadding="0" class="tbl">
    <tr><td>客户ID</td><td><input id="clientId" name="clientId" type="text" size="60px"></td></tr>
    <tr><td>订单日期</td><td><input id="orderDate" name="orderDate" type="text" size="60px"></td></tr>
    <tr><td>重量</td><td><input id="quantity" name="quantity" type="text" size="60px"></td></tr>
    <tr><td width="260">说明</td><td><input id="commont" name="commont" type="text" size="60px"></td></tr>
    <tr><td colspan="2"><input type="button" value="保存" class="btn" onclick="addBtn()"/></td></tr>
</table>
</form>
</div>
</body>
<script type="text/javascript">
    window.onunload = function () {
        window.opener.location.reload();
        window.close();
    }
    function addBtn(){
        var clientId = document.getElementById("clientId").value;
        var orderDate = document.getElementById("orderDate").value;
        var quantity = document.getElementById("quantity").value;

        if ((clientId.length>0 && clientId!="") && (orderDate.length>0 && orderDate!="") && (quantity.length>0 && quantity!="")){
            var a = /^(\d{4})-(\d{2})-(\d{2})$/
            if (!a.test(orderDate)) {
                alert("日期格式不正确!")
                orderDate.focus();
                return false;
            }
            document.getElementById("frm").submit();
        }
    }

</script>
</html>
