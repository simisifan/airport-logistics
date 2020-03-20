package com.atfcm.airportlogistics.mbg.bean;

import java.util.Date;
import javax.persistence.*;

@Table(name = "fly_info")
public class flyInfo {
    @Id
    private Integer id;

    @Column(name = "oder_number")
    private String oderNumber;

    @Column(name = "location_begin")
    private String locationBegin;

    @Column(name = "time_begin")
    private Date timeBegin;

    @Column(name = "location_end")
    private String locationEnd;

    @Column(name = "time_end")
    private Date timeEnd;

    @Column(name = "location_now")
    private String locationNow;

    @Column(name = "user_id")
    private Integer userId;

    private String status;

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
     * @return location_begin
     */
    public String getLocationBegin() {
        return locationBegin;
    }

    /**
     * @param locationBegin
     */
    public void setLocationBegin(String locationBegin) {
        this.locationBegin = locationBegin;
    }

    /**
     * @return time_begin
     */
    public Date getTimeBegin() {
        return timeBegin;
    }

    /**
     * @param timeBegin
     */
    public void setTimeBegin(Date timeBegin) {
        this.timeBegin = timeBegin;
    }

    /**
     * @return location_end
     */
    public String getLocationEnd() {
        return locationEnd;
    }

    /**
     * @param locationEnd
     */
    public void setLocationEnd(String locationEnd) {
        this.locationEnd = locationEnd;
    }

    /**
     * @return time_end
     */
    public Date getTimeEnd() {
        return timeEnd;
    }

    /**
     * @param timeEnd
     */
    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    /**
     * @return location_now
     */
    public String getLocationNow() {
        return locationNow;
    }

    /**
     * @param locationNow
     */
    public void setLocationNow(String locationNow) {
        this.locationNow = locationNow;
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
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }
}