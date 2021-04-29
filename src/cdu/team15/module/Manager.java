package cdu.team15.module;

public class Manager {
    private Integer managerID;
    private  String username;
    private String password;

    public Integer getManagerID() {
        return managerID;
    }

    public void setManagerID(Integer managerID) {
        this.managerID = managerID;
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
        return "Manager{" +
                "managerID=" + managerID +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
