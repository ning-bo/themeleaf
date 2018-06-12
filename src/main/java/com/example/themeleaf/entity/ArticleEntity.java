package com.example.themeleaf.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author NingBo
 * @create 2018-05-29 10:08
 * @desc article的实体类
 **/
@Entity
@Table(name = "article")
public class ArticleEntity implements Serializable {

    private static final long serialVersionUID = 1045959075380243040L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column (name = "title")
    private String title;

    @Column (name = "title_pic")
    private String titlePic;

    @Column (name = "title_content")
    private String titleContent;

    @Column (name = "content")
    private Date content;

    @Column (name = "create_time")
    private Date createTime;

    @Column (name = "lastmodify_time")
    private String lastmodifyTime;

    @Column(name = "status")
    private Integer status;

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

    public String getTitlePic() {
        return titlePic;
    }

    public void setTitlePic(String titlePic) {
        this.titlePic = titlePic;
    }

    public String getTitleContent() {
        return titleContent;
    }

    public void setTitleContent(String titleContent) {
        this.titleContent = titleContent;
    }

    public Date getContent() {
        return content;
    }

    public void setContent(Date content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLastmodifyTime() {
        return lastmodifyTime;
    }

    public void setLastmodifyTime(String lastmodifyTime) {
        this.lastmodifyTime = lastmodifyTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
