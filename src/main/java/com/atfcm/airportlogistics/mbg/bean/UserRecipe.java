package com.atfcm.airportlogistics.mbg.bean;

import javax.persistence.*;

@Table(name = "table_user_recipe")
public class UserRecipe {
    @Id
    private Integer id;

    @Column(name = "oder_number")
    private String oderNumber;

    private String recipename;

    @Column(name = "phone_number")
    private Integer phoneNumber;

    private String province;

    private String city;

    private String area;

    @Column(name = "send_id")
    private Integer sendId;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return oder_number
     */
    public String getOderNumber() {
        return oderNumber;
    }

    /**
     * @param oderNumber
     */
    public void setOderNumber(String oderNumber) {
        this.oderNumber = oderNumber;
    }

    /**
     * @return recipename
     */
    public String getRecipename() {
        return recipename;
    }

    /**
     * @param recipename
     */
    public void setRecipename(String recipename) {
        this.recipename = recipename;
    }

    /**
     * @return phone_number
     */
    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber
     */
    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return area
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * @return send_id
     */
    public Integer getSendId() {
        return sendId;
    }

    /**
     * @param sendId
     */
    public void setSendId(Integer sendId) {
        this.sendId = sendId;
    }
}