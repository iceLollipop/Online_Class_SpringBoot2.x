package net.onlineclass;

import junit.framework.TestCase;
import net.onlineclass.controller.VideoController;
import net.onlineclass.domain.Video;
import net.onlineclass.service.VideoService;
import net.onlineclass.utils.JsonData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.charset.Charset;
import java.util.List;

@RunWith(SpringRunner.class)  //底层用junit  SpringJUnit4ClassRunner
@SpringBootTest(classes={OnlineClassApplication.class})//启动整个springboot工程
@AutoConfigureMockMvc
public class VideoTest {
    @Autowired
    private VideoService videoService;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void testBefore(){
        System.out.println("单元测试 Before方法");
    }

    @Test
    public void testVideoListApi() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/pub/video/list"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        int status = mvcResult.getResponse().getStatus();
        System.out.println(status);

        String result = mvcResult.getResponse().getContentAsString(Charset.forName("utf-8"));
        System.out.println(result);
    }

//    @Test
//    public void testVideoList(){
//        List<Video> videoList = videoService.listVideo();
//        TestCase.assertTrue(videoList.size()>0);
//        System.out.println("单元测试 VideoList方法");
//    }

//    @Test
//    public void testTest1(){
//        System.out.println("单元测试 Test1方法");
//    }
//
//    @Test
//    public void testTest2(){
//        System.out.println("单元测试 Test2方法");
//    }

    @After
    public void testAfter(){
        System.out.println("单元测试 After方法");
    }
}
