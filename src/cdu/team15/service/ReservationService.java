package cdu.team15.service;

import cdu.team15.module.ReservationInfo;

import java.util.List;

public interface ReservationService {
//     顾客提交新的预约信息接口
    int addReservationInfo(ReservationInfo reservationInfo);
//    经理更新数据时先查询数据库是否有这个信息
    ReservationInfo isHaveReservationInfo(int reservationID);
//    经理按状态字段查看所有预约信息接口
    List<ReservationInfo> findReservationInfosByStatus(String status);
//    返回每个用户新提交的预约信息接口
    List<ReservationInfo> newAddReservationOne(int customerID);
//    经理审核顾客提交的预约信息,修改预约信息状态接口
    int updateReservationStatus(int reservationID, String status);

}
