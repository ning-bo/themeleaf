package com.example.themeleaf.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author NingBo
 * @create 2018-05-29 16:37
 * @desc
 **/
@Entity
@Table(name = "language")
public class LanguageEntity implements Serializable {

    private static final long serialVersionUID = 3780164496525529057L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "language")
    private String language;

    @Column(name = "picture")
    private String picture;

    @Column (name = "create_time")
    private String createTime;

    @Column(name = "status")
    private Long status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }
}
