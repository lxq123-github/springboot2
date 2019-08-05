<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="frm" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
            width: 700px;
            border: 1px solid black;
        }

        .div1 {
            width: 800px;
            height: 300px;
            background: lightgreen;
            position: absolute;
            left: 0;
            top: 0;
            bottom: 0;
            right: 0;
            margin: auto;
        }

        .div1 .div2 {
            margin-top: 30px;
            margin-left: 60px;
            height: 30px;
            width: 100%;
        }

        .div1 .div3 {
            margin-left: 60px;
            height: 30px;
            width: 100%;
            position: absolute;
            bottom: 0px;
        }

        h1 {
            margin-top: 30px;
            text-align: center;
        }

        h2 {
            margin-top: 20px;
            color: red;
            text-align: center;
        }

        .btn {
            width: 65px;
        }
    </style>
</head>
<body>
<h1>订单信息</h1>
<c:if test="${orders.list==null || fn:length(orders.list) == 0}">
    <h2>没有数据</h2>
</c:if>
<div class="div1">
    <div class="div2">
        <input type="button" class="btn" value="添加" onclick="addBtn()"/>&nbsp;&nbsp;<input
            class="btn" type="button" value="全部删除" onclick="deleteAll()"/>
    </div>
    <table cellspacing="0" cellpadding="0" class="tbl" border="1px solid black">
        <thead align="middle">
        <td><input type="checkbox" value="" id="selectAll" onclick="selectAll()"
                   style="width:20px;height:18px;"/></td>
        <td>编号</td>
        <td>客户ID</td>
        <td>订单日期</td>
        <td>重量</td>
        <td width="260">说明</td>
        <td>操作</td>
        </thead>
        <tbody>
        <form id="chkFrm" method="post" action="order/batchDelete"
              onsubmit="return checkBoxForm();">
            <c:forEach items="${orders.list}" var="item" varStatus="status">
                <tr align="middle">
                    <td><input type="checkbox" value="${item.orderId}" name="ids"
                               style="width:20px;height:18px;"/></td>
                    <td>${item.orderId}</td>
                    <td>${item.clientId}</td>
                    <td><frm:formatDate value="${item.orderDate}" pattern="yyyy-MM-dd"/></td>
                    <td>${item.quantity}</td>
                    <td>${item.commont}</td>
                    <td><input class="btn" id="delete" type="button" value="删除"
                               onclick="deleteBtn('${item.orderId}')"/> <input class="btn"
                                                                               id="update"
                                                                               type="button"
                                                                               value="更新"
                                                                               onclick="updateBtn('${item.orderId}')"/>
                    </td>
                </tr>
            </c:forEach>
        </form>
        </tbody>
    </table>
    <div class="div3">
        <form name="f2" method="POST" action="order/go" onSubmit="return checknum()">
            <table border="0" align="center" width="500px">
                <tr>
                    <td>第${orders.pageNum}页 共${orders.pages}页 <a href="1">首页</a></td>
                    <td><a href="${orders.pageNum<=1?orders.pageNum:orders.pageNum-1}">上一页</a></td>
                    <td>
                        <a href="${orders.pageNum>=orders.pages?orders.pages:orders.pageNum+1}">下一页</a>
                    </td>
                    <td><a href="${orders.pages}">最后一页</a></td>
                    <td>转到第:<input id="pages" type="text" name="pages" size="5">页<input
                            type="submit" value="GO" name="cndok"></td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
<script>
  function checknum() {
    var pages = document.getElementById("pages").value;
    if (pages > '${orders.pages}' || pages < 1) {
      return false;
    }
  }

  function deleteBtn(id) {
    window.location.href = "order/delete/" + id;
  }

  function updateBtn(id) {
    window.open("order/update?orderId=" + id, "newwindow",
        "height=500, width=800, top=200, left=400, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no")
  }

  function addBtn() {
    window.open("order/add", "newwindow",
        "height=500, width=800, top=200, left=400, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no")
  }

  function selectAll() {
    var selectAll = document.getElementById("selectAll");
    var ids = document.getElementsByName("ids");
    for (var i = 0; i < ids.length; i++) {
      ids[i].checked = selectAll.checked;
    }
  }

  function deleteAll() {
    var flag = false;
    var delIds = document.getElementsByName("ids");
    for (var i = 0; i < delIds.length; i++) {
      if (delIds[i].checked) {
        flag = true;
      }
    }
    if (!flag) {
      return false;
    }
    document.getElementById("chkFrm").submit();
  }
</script>
</html>
