<%--<jsp:useBean id="reservationInfo" scope="request" type="cdu.team15.module.ReservationInfo"/>--%>
<%--
  Created by IntelliJ IDEA.
  User: ZHL
  Date: 2021/1/12
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>审核页面</title>
</head>
<body>
    <h1>审核预约信息</h1>
    <p>预约信息编号:${reservationInfo.reservationID}</p>
    <p>顾客编号:${reservationInfo.customerID}</p>
    <p>联系人称呼:${reservationInfo.telName}</p>
    <p>联系人电话:${reservationInfo.telNumber}</p>
    <p>到店时间:${reservationInfo.reachTime}</p>
    <p>人数:${reservationInfo.nums}</p>
    <p>特殊需求:${reservationInfo.otherNeed}</p>

    <form action="doCheckReservationInfo" method="post">
<%--        隐藏表单提交reservationID--%>
        <input type="hidden" name="reservationID" value="${reservationInfo.reservationID}">
        是否批准: <input type="radio" name="status" value="预约成功">给予通过
        <input type="radio" name="status" value="预约失败">不予通过<br>
        <p style="color: red">请选择是否批准</p>
        <input type="submit">
    </form>

</body>
</html>
