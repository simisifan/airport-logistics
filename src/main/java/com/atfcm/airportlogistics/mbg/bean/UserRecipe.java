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
    private String recipePhoneNumber;

    @Column(name = "province")
    private String provinceRecipe;

    @Column(name = "city")
    private String cityRecipe;

    @Column(name = "area")
    private String areaRecipe;




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



    @Override
    public String toString() {
        return "UserRecipe{" +
                "id=" + id +
                ", oderNumber='" + oderNumber + '\'' +
                ", recipename='" + recipename + '\'' +
                ", recipePhoneNumber=" + recipePhoneNumber +
                ", provinceRecipe='" + provinceRecipe + '\'' +
                ", cityRecipe='" + cityRecipe + '\'' +
                ", areaRecipe='" + areaRecipe + '\'' +
                '}';
    }
}