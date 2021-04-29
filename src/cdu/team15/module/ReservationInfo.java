package cdu.team15.module;

public class ReservationInfo {
    private Integer reservationID;
    private Integer customerID;
    private String telName;
    private String telNumber;
    private String reachTime;
    private Integer nums;
    private String otherNeed;
    private String status;


    public Integer getReservationID() {
        return reservationID;
    }

    public void setReservationID(Integer reservationID) {
        this.reservationID = reservationID;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public String getTelName() {
        return telName;
    }

    public void setTelName(String telName) {
        this.telName = telName;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getReachTime() {
        return reachTime;
    }

    public void setReachTime(String reachTime) {
        this.reachTime = reachTime;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public String getOtherNeed() {
        return otherNeed;
    }

    public void setOtherNeed(String otherNeed) {
        this.otherNeed = otherNeed;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "ReservationInfo{" +
                "reservationID=" + reservationID +
                ", customerID=" + customerID +
                ", telName='" + telName + '\'' +
                ", telNumber='" + telNumber + '\'' +
                ", reachTime='" + reachTime + '\'' +
                ", nums=" + nums +
                ", otherNeed='" + otherNeed + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
