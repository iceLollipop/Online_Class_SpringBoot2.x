package net.onlineclass.controller;

import net.onlineclass.config.WXConfig;
import net.onlineclass.domain.User;
import net.onlineclass.task.AsyncTask;
import net.onlineclass.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

@RestController
//@Controller
@RequestMapping("api/v1/test")
@PropertySource({"classpath:pay.properties"})
public class TestController {

    @Autowired  //自动注入配置文件
    private WXConfig wxConfig;

    @Autowired  //自动注入包含异步方法的类
    private AsyncTask asyncTask;

    @Value("${wxpay.appid}")
    private String payAppid;

    @Value("${wxpay.security}")
    private String paySecurity;

    /**
     * 列出全部用户
     * @return List<User>
     */
    @GetMapping("list")
    public Object testException(){
        int i = 1/0;
        return JsonData.buildSuccess("");
    }

    /**
     * 列出全部用户
     * @return List<User>
     */
    @GetMapping("get_config")
    public JsonData testConfig(){
        Map<String,String> map = new HashMap<>();
        map.put("appid",payAppid);
        map.put("security",paySecurity);
        return JsonData.buildSuccess(map);
    }

    /**
     * 获取配置文件
     * @return
     */
    @GetMapping("get_config_by_Class")
    public JsonData testConfigByClass(){
        Map<String,String> map = new HashMap<>();
        map.put("appid",wxConfig.getPayAppid());
        map.put("security",wxConfig.getPaySecurity());
        map.put("mechid",wxConfig.getPayMechid());
        return JsonData.buildSuccess(map);
    }

    /**
     *
     */
    @GetMapping("async")
    public JsonData testAsync(){
        long begin = System.currentTimeMillis();

//        asyncTask.task1();
//        asyncTask.task2();
//        asyncTask.task3();

        Future<String> task4 = asyncTask.task4();
        Future<String> task5 = asyncTask.task5();

        for(;;){
            if(task4.isDone() && task5.isDone()){
                try {
                    String task4Result = task4.get();
                    System.out.println(task4Result);

                    String task5Result = task5.get();
                    System.out.println(task5Result);

                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    break;
                }
            }
        }

        long end = System.currentTimeMillis();

        return JsonData.buildSuccess(end-begin);
    }
}
