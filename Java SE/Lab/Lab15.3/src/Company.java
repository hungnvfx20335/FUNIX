import java.io.Serializable;
import java.util.Date;

public class Company implements Serializable {
    private long serialVersionUID = 1L;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String postcode;
    private String country;
    private Date createDate;

    public Company(String name, String email, String phone, String address, String postcode, String country, Date createDate) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.postcode = postcode;
        this.country = country;
        this.createDate = createDate;
    }
    @Override
    public String toString() {
        return String.format("%15s%15s%15s%15s%15s%15s%15s", name, email, phone, address, postcode, country, createDate);
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
