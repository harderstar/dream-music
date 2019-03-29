package com.simdy.cms.entity.base;

import java.io.Serializable;
import java.util.Date;

public class CommentAddEnt implements Serializable {

    private Integer id;
    private Integer programe;
    private String type;
    private Integer stickLevel;
    private String issuer;
    private String title;
    private String subtitle;
    private String titleColor;
    private Integer commit;
    private Date uptime;
    private String externalLink;
    private String digest;
    private String commentImage;
    private String detail;
    private Integer music;

    public CommentAddEnt() {
    }

    public CommentAddEnt(Integer music,Integer id, Integer programe, String type, Integer stickLevel, String issuer, String title, String subtitle, String titleColor, Integer commit, Date uptime, String externalLink, String digest, String commentImage, String detail) {
        this.music = music;
        this.id = id;
        this.programe = programe;
        this.type = type;
        this.stickLevel = stickLevel;
        this.issuer = issuer;
        this.title = title;
        this.subtitle = subtitle;
        this.titleColor = titleColor;
        this.commit = commit;
        this.uptime = uptime;
        this.externalLink = externalLink;
        this.digest = digest;
        this.commentImage = commentImage;
        this.detail = detail;
    }

    public Integer getMusic() {
        return music;
    }

    public void setMusic(Integer music) {
        this.music = music;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrograme() {
        return programe;
    }

    public void setPrograme(Integer programe) {
        this.programe = programe;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getStickLevel() {
        return stickLevel;
    }

    public void setStickLevel(Integer stickLevel) {
        this.stickLevel = stickLevel;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getTitleColor() {
        return titleColor;
    }

    public void setTitleColor(String titleColor) {
        this.titleColor = titleColor;
    }

    public Integer getCommit() {
        return commit;
    }

    public void setCommit(Integer commit) {
        this.commit = commit;
    }

    public Date getUptime() {
        return uptime;
    }

    public void setUptime(Date uptime) {
        this.uptime = uptime;
    }

    public String getExternalLink() {
        return externalLink;
    }

    public void setExternalLink(String externalLink) {
        this.externalLink = externalLink;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getCommentImage() {
        return commentImage;
    }

    public void setCommentImage(String commentImage) {
        this.commentImage = commentImage;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
