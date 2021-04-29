package cdu.team15.service;

import cdu.team15.dao.ReservationInfoDao;
import cdu.team15.dao.implement.ReservationInfoImpl;
import cdu.team15.module.ReservationInfo;

import java.util.ArrayList;
import java.util.List;

public class testReservationInfoDaoService {
    public static void main(String[] args) {
//      1.测试reservationInfoDao的insert方法(通过)
        ReservationInfo reservationInfo = new ReservationInfo();
        reservationInfo.setCustomerID(1);
        reservationInfo.setTelName("二明");
        reservationInfo.setTelNumber("18282684835");
        reservationInfo.setReachTime("2020-02-5 18：48：00");
        reservationInfo.setNums(2);
        reservationInfo.setOtherNeed("靠窗通风");
        new testReservationInfoDaoService().Reservation_insert_Check(reservationInfo);


//      2.测试selectByStatus方法(通过)（由于函数都是public外部函数，所以要用本实体类调用方法（new testReservationInfoDaoService()）才行。）
//        new testReservationInfoDaoService().Reservation_selectByStatus_Check("待审核");

//      3.测试selectByCusID方法(测试通过)
//        System.out.println(new testReservationInfoDaoService().reservationInfoDao.selectByCusID(1));

//      4.测试updateStatusByResID方法()
//        System.out.println("影响行数："+ new testReservationInfoDaoService().reservationInfoDao.updateStatusByResID(1,"预约成功"));
    }

    ReservationInfoDao reservationInfoDao = new ReservationInfoImpl();

//    1.测试reservationInfoDao的insert方法
    public int Reservation_insert_Check(ReservationInfo reservationInfo){
        return reservationInfoDao.insert(reservationInfo);
    }

//      2.测试selectByStatus方法
    public void Reservation_selectByStatus_Check(String status){
        List<ReservationInfo> reservationInfos = new ArrayList<>();
        reservationInfos = reservationInfoDao.selectByStatus(status);
        System.out.println(reservationInfos);

    }



//      3.测试selectByCusID方法



//      4.测试updateStatusByResID方法
}
