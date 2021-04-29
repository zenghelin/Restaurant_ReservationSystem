<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ZHL
  Date: 2021/1/10
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<html>
<head>
    <title>添加预约信息界面</title>
    <!-- Bootstrap -->
    <link href="lib/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="lib/bootstrap-3.3.7-dist/js/jquery-3.5.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="lib/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script>
        function reflush() {
            history.go(0);
        }
    </script>
</head>
<%--关闭窗口时刷新--%>
<body onUnload="opener.location.reload()">
<h1>填写预约信息</h1>
<h2 style="float: right"><a href="loginOutServlet"><button type="button" class="btn btn-danger">注销</button></a></h2>
    <form action="doAddReservationInfo" method="post" class="form-inline">
        <div class="form-group">
            <label for="telName">联系人称呼：</label>
            <input type="text" class="form-control" name="telName" id="telName" value="您怎么称呼">
        </div><br><br>
        <div class="form-group">
            <label for="telNumber">联系人电话号码：</label>
            <input type="text" class="form-control" name="telNumber" id="telNumber" value="13281055395">
        </div><br><br>
        <div class="form-group">
            <label for="reachTime">到店时间：</label>
            <input type="text" class="form-control" name="reachTime" id="reachTime" value="2021-01-07 11:59">
        </div><br><br>
        <div class="form-group">
            <label for="nums">人数：</label>
            <input type="text" class="form-control" name="nums" id="nums" value="3">
        </div><br><br>
        <div class="form-group">
            <label for="otherNeed">其他特殊需求：</label>
            <input type="text" class="form-control" name="otherNeed" id="otherNeed" value="需要店家提供的其他服务">
        </div><br><br>
<%--        加一个顾客ID隐藏表单有利于提交预约信息填写CustomerID--%>
        <input type="hidden" name="userID" value=${userID}>
        <input type="submit" class="btn btn-info">
        <input type="reset" class="btn btn-danger">
    </form>
    <h2 style="text-align: center">你的预约信息</h2>
    <button onclick="reflush()" class="btn btn-success">点击刷新页面</button>
    <c:if test="${reservationInfos!=null}">
        <table class="table table-hover">
            <tr class="info">
                <th>联系人姓名</th>
                <th>联系人电话</th>
                <th>到店时间</th>
                <th>人数</th>
                <th>其他需求</th>
                <th>审核情况</th>
            </tr>
            <c:forEach items="${reservationInfos}" var="reservationInfo" varStatus="s">
                <tr class="warning">
                    <td>${reservationInfo.telName}</td>
                    <td>${reservationInfo.telNumber}</td>
                    <td>${reservationInfo.reachTime}</td>
                    <td>${reservationInfo.nums}</td>
                    <td>${reservationInfo.otherNeed}</td>
                    <td>${reservationInfo.status}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</body>
</html>
