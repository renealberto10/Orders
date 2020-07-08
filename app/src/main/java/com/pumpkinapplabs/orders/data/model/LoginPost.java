package com.pumpkinapplabs.orders.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginPost {
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("token_type")
    @Expose
    private String tokenType;
    @SerializedName("userid")
    @Expose
    private Integer userid;
    @SerializedName("rol")
    @Expose
    private Integer rol;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getRol() {
        return rol;
    }

    public void setRol(Integer rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "LoginPost{" +
                "message='" + message + '\'' +
                ", token='" + token + '\'' +
                ", tokenType='" + tokenType + '\'' +
                ", userid=" + userid +
                ", rol=" + rol +
                '}';
    }
}

