package net.onlineclass.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

//@Component
public class VideoOrderTask {

//    @Scheduled(fixedRate = 2000)  //间隔2s
//    @Scheduled(cron="*/1 * * * * *") //间隔1s
//    @Scheduled(fixedRate = 2000)

    /**
     * fixedRate 定时x秒执行一次。如果代码运行时间m超出x，以代码运行时间m为间隔
     * fixedDelay 上一次任务结束之后，再延时x秒执行此次任务。如果代码运行时间为m，则两次运行时间间隔为m+x
     */
//    @Scheduled(fixedDelay = 2000)
    public void sum(){
        System.out.println("Local Date"+ LocalDateTime.now()+"当前交易金额"+Math.random());
        try{
            Thread.sleep(4000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
