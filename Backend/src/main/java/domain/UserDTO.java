package domain;

import java.sql.Timestamp;

public class UserDTO {
    private String account;
    private String password;
    private String name;
    private String address;
    private String tel;

    private int type;

    private int is_deleted;

    public UserDTO(String account, String password, String name, String address, String tel)
    {
        this.account = account;
        this.password = password;
        this.name = name;
        this.address = address;
        this.tel = tel;
    }

    public String toString(){
        String tmp = "account : " + account + "\nname : " + name;
        return tmp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel(){return tel;}

    public int getType(){return type;}

    //public int getDeleted_at(){return is_deleted;}

    //public void setDeleted_at(int is_deleted){this.is_deleted = is_deleted;}
}
