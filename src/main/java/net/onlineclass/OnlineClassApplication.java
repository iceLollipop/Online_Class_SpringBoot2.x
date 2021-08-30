package net.onlineclass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication      //主类启动
@ServletComponentScan       //注册Servlet
@EnableScheduling           //任务调度
@EnableAsync                //支持异步
public class OnlineClassApplication {
    public static void main(String[] args){
        SpringApplication.run(OnlineClassApplication.class,args);
    }
}
