package cdu.team15.dao;

import cdu.team15.module.ReservationInfo;

import java.util.List;

public interface ReservationInfoDao {
//    增加预约信息
    int insert(ReservationInfo reservationInfo);

//    修改预约信息
//    int update(ReservationInfo reservationInfo);
//    删除预约信息
//    int delete(ReservationInfo reservationID);

//    按照reservationID查询预约信息
    ReservationInfo selectByReservationID(int reservationID);
//    按状态字段查询预约信息
    List<ReservationInfo> selectByStatus(String status);
//    按预约人的编号查询预约信息
    List<ReservationInfo> selectByCusID(int customerID);
//    按预约信息ID修改预约信息状态
    int updateStatusByResID(int reservationID, String status);
}
