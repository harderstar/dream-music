package com.simdy.cms.entity.base;

import java.util.Date;
import java.util.Map;

public class CommentListEnt {

    private Integer id;
    private String type;
    private Integer stickLevel;
    private String issuer;
    private String title;
    private Integer clickNum;
    private Integer commit;
    private Date uptime;
    private ProgrameListEnt programe;
    private String commentImage;

    public String getCommentImage() {
        return commentImage;
    }

    public void setCommentImage(String commentImage) {
        this.commentImage = commentImage;
    }

    @Override
    public String toString() {
        return "CommentListEnt{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", stickLevel=" + stickLevel +
                ", issuer='" + issuer + '\'' +
                ", title='" + title + '\'' +
                ", clickNum=" + clickNum +
                ", commit=" + commit +
                ", uptime=" + uptime +
                ", programe='" + programe + '\'' +
                '}';
    }

    public ProgrameListEnt getPrograme() {
        return programe;
    }

    public void setPrograme(ProgrameListEnt programe) {
        this.programe = programe;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getClickNum() {
        return clickNum;
    }

    public void setClickNum(Integer clickNum) {
        this.clickNum = clickNum;
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
}
