package net.onlineclass;

import junit.framework.TestCase;
import net.onlineclass.controller.UserController;
import net.onlineclass.domain.User;
import net.onlineclass.utils.JsonData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)  //底层用junit  SpringJUnit4ClassRunner
@SpringBootTest(classes={OnlineClassApplication.class})//启动整个springboot工程
public class UserTest {
    @Autowired
    private UserController userController;

    @Before
    public void testBefore(){
        System.out.println("单元测试 Before方法");
    }

    @Test
    public void testLogin(){
        User user = new User();
        user.setUsername("jack");
        user.setPwd("1234");

        JsonData jsonData = userController.login(user);
        System.out.println("单元测试 Test1方法");
        System.out.println(jsonData.toString());
        TestCase.assertEquals(jsonData.getCode(),0);
    }

    @After
    public void testAfter(){
        System.out.println("单元测试 After方法");
    }
}
