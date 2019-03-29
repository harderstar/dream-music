package com.simdy.cms.entity;

import java.io.Serializable;
import java.util.Date;

public class Album implements Serializable {

    private Integer id;
    private String name;
    private Integer singerId;
    private String issueCompany;
    private Date issueDate;
    private String photo;
    private String details;

    public Album(){

    }

    public Album(Integer id, String name, Integer singerId, String issueCompany, Date issueDate, String photo, String details) {
        this.id = id;
        this.name = name;
        this.singerId = singerId;
        this.issueCompany = issueCompany;
        this.issueDate = issueDate;
        this.photo = photo;
        this.details = details;
    }
    public Integer getId() {
        return id;
    }



    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSingerId() {
        return singerId;
    }

    public void setSingerId(Integer singerId) {
        this.singerId = singerId;
    }

    public String getIssueCompany() {
        return issueCompany;
    }

    public void setIssueCompany(String issueCompany) {
        this.issueCompany = issueCompany;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
