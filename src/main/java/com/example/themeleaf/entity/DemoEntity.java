package com.example.themeleaf.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author NingBo
 * @create 2018-05-23 11:37
 * @desc demo实体类
 **/
@Entity
@Table(name = "test")
public class DemoEntity implements Serializable{

    @Id          //import   javax.persistence.*;  而不是org.springframework.data.annotation.Id;
    @GeneratedValue
    @Column (name = "id")
    private Long id;

    @Column (name = "title")
    private String title;

    @Column (name = "content")
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
