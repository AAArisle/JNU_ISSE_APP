package com.example.userstory.object;

public class ContactFunc {
    private String address;
    private String telephone;
    private String email;

    public ContactFunc(String address, String telephone, String email) {
        this.address = address;
        this.telephone = telephone;
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
