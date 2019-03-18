package com.simdy.cms.entity.base;

import java.util.Date;
import java.util.List;

public class MusicAddEnt {

    private Integer id;
    private String name;
    private List<SingerEnt> singers;
    private String album;
    private List<LabelListEnt> labels;
    private String auditionUrl;
    private String lyric;
    private String image;
    private Integer popularity;
    private Double size;
    private Integer like;
    private Integer download;
    private String danceTemplate;
    private Date uptime;
    private Integer commit;
    private Integer recommend;

    public MusicAddEnt() {
    }

    public MusicAddEnt(Integer id, String name, List<SingerEnt> singers, String album, List<LabelListEnt> labels, String auditionUrl, String lyric, String image, Integer popularity, Double size, Integer like, Integer download, String danceTemplate, Date uptime, Integer commit, Integer recommend) {
        this.id = id;
        this.name = name;
        this.singers = singers;
        this.album = album;
        this.labels = labels;
        this.auditionUrl = auditionUrl;
        this.lyric = lyric;
        this.image = image;
        this.popularity = popularity;
        this.size = size;
        this.like = like;
        this.download = download;
        this.danceTemplate = danceTemplate;
        this.uptime = uptime;
        this.commit = commit;
        this.recommend = recommend;
    }

    public List<LabelListEnt> getLabels() {
        return labels;
    }

    public void setLabels(List<LabelListEnt> labels) {
        this.labels = labels;
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

    public List<SingerEnt> getSingers() {
        return singers;
    }

    public void setSingers(List<SingerEnt> singers) {
        this.singers = singers;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getAuditionUrl() {
        return auditionUrl;
    }

    public void setAuditionUrl(String auditionUrl) {
        this.auditionUrl = auditionUrl;
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getPopularity() {
        return popularity;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public Integer getDownload() {
        return download;
    }

    public void setDownload(Integer download) {
        this.download = download;
    }

    public String getDanceTemplate() {
        return danceTemplate;
    }

    public void setDanceTemplate(String danceTemplate) {
        this.danceTemplate = danceTemplate;
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
