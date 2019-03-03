package com.simdy.cms.entity.base;

import java.util.Date;

public class MusicListEnt {

    private Integer id;
    private String name;
    private Integer popularity;
    private String singer;
    private Date uptime;
    private Integer commit;
    private Integer recommend;

    public MusicListEnt() {
    }

    public MusicListEnt(Integer id, String name, Integer popularity, String singer, Date uptime, Integer commit, Integer recommend) {
        this.id = id;
        this.name = name;
        this.popularity = popularity;
        this.singer = singer;
        this.uptime = uptime;
        this.commit = commit;
        this.recommend = recommend;
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

    public Integer getPopularity() {
        return popularity;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public Date getUptime() {
        return uptime;
    }

    public void setUptime(Date uptime) {
        this.uptime = uptime;
    }

    public Integer getCommit() {
        return commit;
    }

    public void setCommit(Integer commit) {
        this.commit = commit;
    }

    public Integer getRecommend() {
        return recommend;
    }

    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
    }
}
