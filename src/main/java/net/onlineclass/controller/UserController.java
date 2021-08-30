package net.onlineclass.controller;

import net.onlineclass.domain.User;
import net.onlineclass.service.UserService;
import net.onlineclass.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    登录控制器
 */
@RestController
@RequestMapping("api/v1/pub/user")
public class UserController {
    @Autowired
    private UserService userService;

//    @PostMapping("login")
//    public JsonData login(String username,String pwd){
//        System.out.println("Username+"+username+"pwd="+pwd);
//        return JsonData.buildSuccess("");
//    }

    /**
     *
     * @param user
     * @return 返回登录结果
     */
    @PostMapping("login")
    public JsonData login(@RequestBody User user){
        System.out.println("User"+user.toString());
        String token = userService.login(user.getUsername(),user.getPwd());

        return token != null?JsonData.buildSuccess(token):JsonData.buildError("账号密码错误");
    }

    /**
     * 列出全部用户
     * @return List<User>
     */
    @GetMapping("list")
    public JsonData login(){
        List<User> list = userService.listUser();
        return JsonData.buildSuccess(list);
    }
}
