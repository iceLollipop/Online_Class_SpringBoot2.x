package net.onlineclass.controller;

import net.onlineclass.domain.Video;
import net.onlineclass.service.VideoService;
import net.onlineclass.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/*
* 视频控制器
* */
@RestController
@RequestMapping("/api/v1/pub/video")
public class VideoController {
    @Autowired
    private VideoService videoService;

//    @RequestMapping(value = "list",method = RequestMethod.GET)
    @GetMapping("list")
    public JsonData list(){
        List<Video> list = videoService.listVideo();
        return JsonData.buildSuccess(list);
    }
//    @RequestMapping("list")
//    public Object list(){
//        Map<String,String> map = new HashMap<>();
//        map.put("1","面试专题课程");
//        map.put("2","Spring Cloud微服务课程");
//        return map;
//    }

    @PostMapping("save_video_chapter")
    public JsonData saveVideoChapter(@RequestBody Video video){
//        List<Video> list = videoService.listVideo();
        System.out.println(video.toString());
        return JsonData.buildSuccess("");
    }
}
