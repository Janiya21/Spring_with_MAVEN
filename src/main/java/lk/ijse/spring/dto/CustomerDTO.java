package lk.ijse.spring.dto;

public class CustomerDTO {
    private String id;
    private String name;
    private String email;
    private String telNo;

    public CustomerDTO() {
    }

    public CustomerDTO(String id, String name, String email, String telNo) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.telNo = telNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", telNo=" + telNo +
                '}';
    }
}
