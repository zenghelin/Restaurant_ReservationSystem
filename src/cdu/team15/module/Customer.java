package cdu.team15.module;

public class Customer {
    private Integer customerID;
    private  String username;
    private String password;
    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
