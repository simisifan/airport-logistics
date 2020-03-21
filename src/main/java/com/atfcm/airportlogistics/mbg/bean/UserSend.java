package com.atfcm.airportlogistics.mbg.bean;

import javax.persistence.*;

@Table(name = "table_user_send")
public class UserSend {
    @Id
    private Integer id;

    @Column(name = "oder_number")
    private String oderNumber;

    private String sendername;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String province;

    private String city;

    private String area;

    @Column(name = "user_id")
    private Integer userId;

    private String type;

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
     * @return sendername
     */
    public String getSendername() {
        return sendername;
    }

    /**
     * @param sendername
     */
    public void setSendername(String sendername) {
        this.sendername = sendername;
    }

    /**
     * @return phone_number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
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
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "UserSend{" +
                "id=" + id +
                ", oderNumber=" + oderNumber +
                ", sendername='" + sendername + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", userId=" + userId +
                ", type='" + type + '\'' +
                '}';
    }
}