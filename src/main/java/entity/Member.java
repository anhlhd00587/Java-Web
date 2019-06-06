package entity;

public class Member {
    private String username;
    private String password;
    private String email;
    private String fullName;
    private String address;
    private int status;
    private String role;



    public Member() {
        this.username = "";
        this.password = "";
        this.email = "";
        this.fullName = "";
        this.address = "";

    }

    public enum Status {
        ACTIVE(1), DEACTIVE(0), DELETED(-1);

        int value;

        Status(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static Status findByValue(int value){
            for (Status status :
                    Status.values()){
                if (status.getValue() == value){
                    return status;
                }
            }
            return null;
        }
    }

    public Member(String username, String password, String email, String fullName, String address, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.address = address;
        this.role = role;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getStatus(){
        return status;
    }

    public void setStatus(Status status ){
        if (status == null){
            status = Status.DEACTIVE;
        }
        this.status = status.getValue();
    }
}
