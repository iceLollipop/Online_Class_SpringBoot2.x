package net.onlineclass.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Video implements Serializable {

    private int id;

    private String title;

    private String summary;

    private int price;

    @JsonProperty("cover_img")
    private String coverImg;

    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",locale = "zh",timezone = "GMT+8")   //JSON序列化配置 格式化日期
    private Date createTime;

    @JsonProperty("chapter_list")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Chapter> chapterList;       //JSON序列化配置 过滤空字段

    public Video(){

    }

    public Video(int id,String title){
        this.id = id;
        this.title = title;
        this.createTime =  new Date();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public int getPrice() {
        return price;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public List<Chapter> getChapterList() {
        return chapterList;
    }

    public void setChapterList(List<Chapter> chapterList) {
        this.chapterList = chapterList;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", price=" + price +
                ", coverImg='" + coverImg + '\'' +
                ", createTime=" + createTime +
                ", chapterList=" + chapterList +
                '}';
    }
}
