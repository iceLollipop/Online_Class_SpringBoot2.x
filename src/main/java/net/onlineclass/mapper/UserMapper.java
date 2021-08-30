package net.onlineclass.mapper;

import net.onlineclass.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserMapper {

    private static Map<String, User> videoMap = new HashMap<>();

    static {
        videoMap.put("jack",new User(1,"jack","123"));
        videoMap.put("online_class",new User(2,"online_class","123456"));
        videoMap.put("tom",new User(3,"tom","123456"));
    }

    public User login(String username,String pwd){
        User user = videoMap.get(username);
        if(user == null){
           return null;
        }
        if(user.getPwd().equals(pwd)){
            return user;
        }else{
            return null;
        }
    }

    public List<User> listUser(){
        List<User> list = new ArrayList<>();
        list.addAll(videoMap.values());
        return list;
    }
}
