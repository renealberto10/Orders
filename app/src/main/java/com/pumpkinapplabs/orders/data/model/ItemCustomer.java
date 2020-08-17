package com.pumpkinapplabs.orders.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class ItemCustomer {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("idtype")
    @Expose
    private Integer idtype;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("business_name")
    @Expose
    private String businessName;
    @SerializedName("contact_name")
    @Expose
    private String contactName;
    @SerializedName("telephone")
    @Expose
    private String telephone;
    @SerializedName("cellphone")
    @Expose
    private String cellphone;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("ncr")
    @Expose
    private String ncr;
    @SerializedName("nit")
    @Expose
    private String nit;
    @SerializedName("dui")
    @Expose
    private String dui;
    @SerializedName("attached")
    @Expose
    private String attached;
    @SerializedName("created_at")
    @Expose
    private String createdAt;

    public ItemCustomer(Integer id, Integer idtype, String type, String businessName, String contactName, String telephone, String cellphone, String address, String ncr, String nit, String dui, String attached, String createdAt) {
        this.id = id;
        this.idtype = idtype;
        this.type = type;
        this.businessName = businessName;
        this.contactName = contactName;
        this.telephone = telephone;
        this.cellphone = cellphone;
        this.address = address;
        this.ncr = ncr;
        this.nit = nit;
        this.dui = dui;
        this.attached = attached;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdtype() {
        return idtype;
    }

    public void setIdtype(Integer idtype) {
        this.idtype = idtype;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNcr() {
        return ncr;
    }

    public void setNcr(String ncr) {
        this.ncr = ncr;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getAttached() {
        return attached;
    }

    public void setAttached(String attached) {
        this.attached = attached;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
