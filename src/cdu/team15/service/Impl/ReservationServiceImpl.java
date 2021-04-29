package cdu.team15.service.Impl;

import cdu.team15.dao.ReservationInfoDao;
import cdu.team15.dao.implement.ReservationInfoImpl;
import cdu.team15.module.ReservationInfo;
import cdu.team15.service.ReservationService;

import java.util.List;

public class ReservationServiceImpl implements ReservationService {

    ReservationInfoDao reservationInfoDao = new ReservationInfoImpl();


//    顾客提交新的预约信息实现方法
    @Override
    public int addReservationInfo(ReservationInfo reservationInfo){
        int rows = reservationInfoDao.insert(reservationInfo);
        return rows;
    }

    @Override
    public ReservationInfo isHaveReservationInfo(int reservationID) {
       ReservationInfo reservationInfo =  reservationInfoDao.selectByReservationID(reservationID);
        return  reservationInfo;
    }


    //     经理按状态字段查看所有预约信息实现方法
    @Override
    public List<ReservationInfo> findReservationInfosByStatus(String status) {
        List<ReservationInfo> reservationInfos = reservationInfoDao.selectByStatus(status);
        return reservationInfos;
    }



//    返回每个用户新提交的预约信息实现方法
    @Override
    public List<ReservationInfo> newAddReservationOne(int customerID) {
        List<ReservationInfo> reservationInfos = reservationInfoDao.selectByCusID(customerID);
        return reservationInfos;
    }



//      经理审核顾客提交的预约信息,修改预约信息状态实现方法
    @Override
    public int updateReservationStatus(int reservationID, String status) {
        int rows= reservationInfoDao.updateStatusByResID(reservationID,status);
        return rows;
    }

}
