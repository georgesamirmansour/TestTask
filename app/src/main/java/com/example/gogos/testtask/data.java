package com.example.gogos.testtask;

import com.google.gson.annotations.SerializedName;

public class data {

    @SerializedName("userId")
    private int userId;

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String tittle;

    @SerializedName("body")
    private String body;

    public data(int userId, int id, String tittle, String body) {
        this.userId = userId;
        this.id = id;
        this.tittle = tittle;
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


}
