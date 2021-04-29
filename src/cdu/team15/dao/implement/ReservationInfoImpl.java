package cdu.team15.dao.implement;

import cdu.team15.dao.ReservationInfoDao;
import cdu.team15.module.ReservationInfo;
import cdu.team15.util.SqlConnectionUtil;

import javax.security.sasl.SaslServer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationInfoImpl extends SqlConnectionUtil implements ReservationInfoDao {
//   操作数据库需要的字段
    PreparedStatement pstmt = null;

    @Override
//    增加预约信息
    public int insert(ReservationInfo reservationInfo) {
        int rows = 0; //受影响行数
        String sql = "insert into reservation_info(customerID,telName,telNumber,reachTime,nums,otherNeed) values(?,?,?,?,?,?)";
        try{
//          组装sql语句
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,reservationInfo.getCustomerID());
            pstmt.setString(2,reservationInfo.getTelName());
            pstmt.setString(3,reservationInfo.getTelNumber());
            pstmt.setString(4,reservationInfo.getReachTime());
            pstmt.setInt(5,reservationInfo.getNums());
            pstmt.setString(6,reservationInfo.getOtherNeed());
//          执行sql语句
            rows = pstmt.executeUpdate();
        }catch (Exception e){
            System.out.println("插入失败:"+reservationInfo+"\n"+sql+pstmt);
            e.printStackTrace();
        }

        return rows;
    }

    @Override
    public ReservationInfo selectByReservationID(int reservationID) {
//        声明ReservationInfo对象
        ReservationInfo reservationInfo = null;
        String sql = "select * from reservation_info where reservationID=?";
        try{
//          组装sql语句
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, String.valueOf(reservationID));
//            执行sql查询语句
            ResultSet res =pstmt.executeQuery();
//          将结果集res的内容取出赋值给列表对象reservationInfos
            while(res.next()){
                reservationInfo = new ReservationInfo();
                reservationInfo.setReservationID(res.getInt("reservationID"));
                reservationInfo.setCustomerID(res.getInt ("customerID"));
                reservationInfo.setTelName (res.getString("telName"));
                reservationInfo.setTelNumber(res.getString("telNumber"));
                reservationInfo.setReachTime(res.getString("reachTime"));
                reservationInfo.setNums(res.getInt("nums"));
                reservationInfo.setOtherNeed(res.getString("otherNeed"));
                reservationInfo.setStatus(res.getString("status"));
            }

        }catch (Exception e){
            System.out.println("查询失败："+sql);
            e.printStackTrace();
        }
        return reservationInfo;
    }

    @Override
//    按照状态查找预约信息
    public List<ReservationInfo> selectByStatus(String status) {

//      声明ReservationInfos列表对象接收查询结果
        List<ReservationInfo> reservationInfos = new ArrayList<>();
//        声明ReservationInfo对象
        ReservationInfo reservationInfo = null;
        String sql = "select * from reservation_info where status=?";
        try{
//          组装sql语句
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,status);
//            执行sql查询语句
            ResultSet res =pstmt.executeQuery();
//          将结果集res的内容取出赋值给列表对象reservationInfos
            while(res.next()){
                reservationInfo = new ReservationInfo();
                reservationInfo.setReservationID(res.getInt("reservationID"));
                reservationInfo.setCustomerID(res.getInt ("customerID"));
                reservationInfo.setTelName (res.getString("telName"));
                reservationInfo.setTelNumber(res.getString("telNumber"));
                reservationInfo.setReachTime(res.getString("reachTime"));
                reservationInfo.setNums(res.getInt("nums"));
                reservationInfo.setOtherNeed(res.getString("otherNeed"));
                reservationInfo.setStatus(res.getString("status"));
//                添加到预约信息列表中
                reservationInfos.add(reservationInfo);
            }

        }catch (Exception e){
            System.out.println("查询失败："+sql);
            e.printStackTrace();
        }
        return reservationInfos;
    }

    @Override
//    按照顾客ID查询预约信息
    public List<ReservationInfo> selectByCusID(int customerID) {
//        声明ReservationInfos列表对象接收查询结果
        List<ReservationInfo> reservationInfos = new ArrayList<>();
        ReservationInfo reservationInfo = null;
        String sql = "select * from  reservation_info where customerID=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,customerID);
            ResultSet res=pstmt.executeQuery();
            while (res.next()){
                reservationInfo=new ReservationInfo();
                reservationInfo.setReservationID(res.getInt("reservationID"));
                reservationInfo.setCustomerID(res.getInt ("customerID"));
                reservationInfo.setTelName (res.getString("telName"));
                reservationInfo.setTelNumber(res.getString("telNumber"));
                reservationInfo.setReachTime(res.getString("reachTime"));
                reservationInfo.setNums(res.getInt("nums"));
                reservationInfo.setOtherNeed(res.getString("otherNeed"));
                reservationInfo.setStatus(res.getString("status"));
//                添加到预约信息列表中
                reservationInfos.add(reservationInfo);
            }
        } catch (SQLException e) {
            System.out.println("查找失败！"+sql);
            e.printStackTrace();
        }
        return reservationInfos;
    }
//    按预约信息ID修改预约信息状态(通过)
    public int updateStatusByResID(int reservationID,String status){
        int rows = 0;
        String sql = "update reservation_info set status=? where reservationID=? ";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,status);
            pstmt.setInt(2,reservationID);
            rows = pstmt.executeUpdate();
        }catch (Exception e){
            System.out.println("修改失败:"+sql+"\n"+pstmt);
            e.printStackTrace();
        }

        return rows;
    }
}
