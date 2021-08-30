package net.onlineclass.service.impl;

import net.onlineclass.domain.Video;
import net.onlineclass.mapper.VideoMapper;
import net.onlineclass.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VideoServiceImpl implements VideoService{

    @Autowired
    private VideoMapper VideoMapper;

    @Override
    public List<Video> listVideo() {
        return VideoMapper.listVideo();
    }
}
