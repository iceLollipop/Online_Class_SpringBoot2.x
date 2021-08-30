package net.onlineclass.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.Future;

@Component
@Async  //Async注解表示当前类所有方法都是异步方法
public class AsyncTask {

    //@Async  //Async注解特定方法且不注解类时，表示本类的当前方法是异步方法
    public void task1(){
        try{
            Thread.sleep(4000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Task1 "+ LocalDateTime.now());
    }

    public void task2(){
        try{
            Thread.sleep(4000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Task2 "+ LocalDateTime.now());
    }

    public void task3(){
        try{
            Thread.sleep(4000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Task3 "+ LocalDateTime.now());
    }

    public Future<String> task4(){
        try{
            Thread.sleep(4000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Task4 "+ LocalDateTime.now());
        return new AsyncResult<String>("Task 4");
    }

    public Future<String>  task5(){
        try{
            Thread.sleep(4000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Task5 "+ LocalDateTime.now());
        return new AsyncResult<String>("Task 5");
    }
}
