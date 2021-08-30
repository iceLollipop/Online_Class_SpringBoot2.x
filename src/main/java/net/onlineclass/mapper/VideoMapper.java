package net.onlineclass.mapper;

import net.onlineclass.domain.Video;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class VideoMapper {

    private static Map<Integer, Video> videoMap = new HashMap<>();

    static {
        videoMap.put(1,new Video(1,"JAVA基础课程,JDK8-13新特性"));
        videoMap.put(2,new Video(2,"SpringBoot2.x零基础实战"));
        videoMap.put(3,new Video(3,"微服务SpringCloud全家桶"));
        videoMap.put(4,new Video(4,"SpringBoot实战微信支付课程"));
        videoMap.put(5,new Video(5,"Online Class 在线课程第一季"));
    }

    public List<Video> listVideo(){
        List<Video> list = new ArrayList<>();
        list.addAll(videoMap.values());
        return list;
    }
}
