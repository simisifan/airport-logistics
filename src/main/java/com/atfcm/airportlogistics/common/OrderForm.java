package com.atfcm.airportlogistics.common;

import javax.persistence.Column;

public class OrderForm  {
    private Integer id;

    private String oderNumber;

    private String sendername;

    private String phoneNumber;

    private String province;

    private String city;

    private String area;

    private Integer userId;

    private String type;




    private String recipename;


    private String recipePhoneNumber;


    private String provinceRecipe;


    private String cityRecipe;


    private String areaRecipe;

    @Override
    public String toString() {
        return "OrderForm{" +
                "id=" + id +
                ", oderNumber='" + oderNumber + '\'' +
                ", sendername='" + sendername + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", userId=" + userId +
                ", type='" + type + '\'' +
                ", recipename='" + recipename + '\'' +
                ", recipePhoneNumber='" + recipePhoneNumber + '\'' +
                ", provinceRecipe='" + provinceRecipe + '\'' +
                ", cityRecipe='" + cityRecipe + '\'' +
                ", areaRecipe='" + areaRecipe + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOderNumber() {
        return oderNumber;
    }

    public void setOderNumber(String oderNumber) {
        this.oderNumber = oderNumber;
    }

    public String getSendername() {
        return sendername;
    }

    public void setSendername(String sendername) {
        this.sendername = sendername;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRecipename() {
        return recipename;
    }

    public void setRecipename(String recipename) {
        this.recipename = recipename;
    }

    public String getRecipePhoneNumber() {
        return recipePhoneNumber;
    }

    public void setRecipePhoneNumber(String recipePhoneNumber) {
        this.recipePhoneNumber = recipePhoneNumber;
    }

    public String getProvinceRecipe() {
        return provinceRecipe;
    }

    public void setProvinceRecipe(String provinceRecipe) {
        this.provinceRecipe = provinceRecipe;
    }

    public String getCityRecipe() {
        return cityRecipe;
    }

    public void setCityRecipe(String cityRecipe) {
        this.cityRecipe = cityRecipe;
    }

    public String getAreaRecipe() {
        return areaRecipe;
    }

    public void setAreaRecipe(String areaRecipe) {
        this.areaRecipe = areaRecipe;
    }
}
