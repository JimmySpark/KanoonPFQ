package ir.spark_team.kanoonpfq.Model;

public class School_Shop {

    String title, address, phone, location;

    public School_Shop(String title, String address, String phone, String location) {
        this.title = title;
        this.address = address;
        this.phone = phone;
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }
}
