package ru.job4j;

public class Hospital extends Doctor{
    public String hospitalName;
    public String address;
    public String phone;

    public Hospital() {

    }

    public Hospital(String hospitalName, String address, String phone) {
        this.name = hospitalName;
        this.address = address;
        this.phone = phone;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
}
