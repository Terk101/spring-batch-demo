package com.batch.demo.demo.dto;

public class AddressDTO {
    private String houseNo;

    private String street;

    private String soi;

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSoi() {
        return soi;
    }

    public void setSoi(String soi) {
        this.soi = soi;
    }

    @Override
    public String toString() {
        return "AddressDTO{" +
                "houseNo='" + houseNo + '\'' +
                ", street='" + street + '\'' +
                ", soi='" + soi + '\'' +
                '}';
    }
}
