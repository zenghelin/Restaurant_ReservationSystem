<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ZHL
  Date: 2021/1/10
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>预约信息展示界面</title>
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
<body>
    <h1 style="font-size: 100px;text-align: center">用户预约信息审核情况</h1>
    <h2 style="float: right"><a href="loginOutServlet"><button type="button" class="btn btn-danger">注销</button></a></h2>
    <button onclick="reflush()" class="btn btn-success">点击刷新页面</button>
    <table border="1" class="table table-hover">
        <caption style="font-size: 50px;font-weight: bolder">待审核</caption>
        <tr class="danger">
            <td>编号</td>
            <td>顾客编号</td>
            <td>联系人称呼</td>
            <td>联系人电话</td>
            <td>到店时间</td>
            <td>人数</td>
            <td>特殊需求</td>
            <td>预约状态</td>
            <td>选项</td>
        </tr>
        <c:forEach items="${reservationInfoWaits}" var="reservationInfoWait" varStatus="s">
            <tr class="success">
                <td>${reservationInfoWait.reservationID}</td>
                <td>${reservationInfoWait.customerID}</td>
                <td>${reservationInfoWait.telName}</td>
                <td>${reservationInfoWait.telNumber}</td>
                <td>${reservationInfoWait.reachTime}</td>
                <td>${reservationInfoWait.nums}</td>
                <td>${reservationInfoWait.otherNeed}</td>
                <td>${reservationInfoWait.status}</td>
                <td><a href="checkReservationInfo?reservationID=${reservationInfoWait.reservationID}">去审核</a></td>
            </tr>
        </c:forEach>
    </table>
    <table border="1" class="table table-bordered">
        <caption style="font-size: 50px;font-weight: bolder">预约成功</caption>
        <tr class="active">
            <td>编号</td>
            <td>顾客编号</td>
            <td>联系人称呼</td>
            <td>联系人电话</td>
            <td>到店时间</td>
            <td>人数</td>
            <td>特殊需求</td>
            <td>预约状态</td>
        </tr>
        <c:forEach items="${reservationInfoOks}" var="reservationInfoOk" varStatus="s">
            <tr class="info">
                <td>${reservationInfoOk.reservationID}</td>
                <td>${reservationInfoOk.customerID}</td>
                <td>${reservationInfoOk.telName}</td>
                <td>${reservationInfoOk.telNumber}</td>
                <td>${reservationInfoOk.reachTime}</td>
                <td>${reservationInfoOk.nums}</td>
                <td>${reservationInfoOk.otherNeed}</td>
                <td>${reservationInfoOk.status}</td>
            </tr>
        </c:forEach>
    </table>
    <table border="1" class="table table-bordered">
        <caption style="font-size: 50px;font-weight: bolder">预约失败</caption>
        <tr class="active">
            <td>编号</td>
            <td>顾客编号</td>
            <td>联系人称呼</td>
            <td>联系人电话</td>
            <td>到店时间</td>
            <td>人数</td>
            <td>特殊需求</td>
            <td>预约状态</td>
        </tr>
        <c:forEach items="${reservationInfoNos}" var="reservationInfoNo" varStatus="s">
            <tr class="info">
                <td>${reservationInfoNo.reservationID}</td>
                <td>${reservationInfoNo.customerID}</td>
                <td>${reservationInfoNo.telName}</td>
                <td>${reservationInfoNo.telNumber}</td>
                <td>${reservationInfoNo.reachTime}</td>
                <td>${reservationInfoNo.nums}</td>
                <td>${reservationInfoNo.otherNeed}</td>
                <td>${reservationInfoNo.status}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
