package com.simdy.cms.entity.base;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class MusicAddEnt implements Serializable {

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
    private String downloadUrl;
    private String danceTemplate;
    private Date uptime;
    private Integer commit;
    private Integer recommend;
    private String photo;
    private Integer downloadNum;
    private Integer collect;
    private String composer;


    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public Integer getCollect() {
        return collect;
    }

    public void setCollect(Integer collect) {
        this.collect = collect;
    }

    public Integer getDownloadNum() {
        return downloadNum;
    }

    public void setDownloadNum(Integer downloadNum) {
        this.downloadNum = downloadNum;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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

    public List<LabelListEnt> getLabels() {
        return labels;
    }

    public void setLabels(List<LabelListEnt> labels) {
        this.labels = labels;
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
