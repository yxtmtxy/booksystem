package com.yx.pojo;

import java.io.Serializable;

public class Vendor implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer vendorId;

    private String vendorName;

    private String contact;

    private String phone;

    public Vendor(Integer vendorId, String vendorName, String contact, String phone) {
        this.vendorId = vendorId;
        this.vendorName = vendorName;
        this.contact = contact;
        this.phone = phone;
    }

    public Vendor() {
        super();
    }

    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName == null ? null : vendorName.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }
}