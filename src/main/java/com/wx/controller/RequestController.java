package com.wx.controller;

import com.wx.Pojo.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


//原始方法
//@RestController
//public class RequestController {
//    @RequestMapping("/SimpleParam")
//    public String SimpleParam(HttpServletRequest request) {
//        String name = request.getParameter("name");
//        String ageStl = request.getParameter("age");
//
//        int age = Integer.parseInt(ageStl);
//        System.out.println(name + " " + age);
//
//        return "OK";
//    }

//springboot方式转换
//@RestController
//public class RequestController {
//    @RequestMapping("/SimpleParam")
//    public String SimpleParam(String name,Integer age) {
//        System.out.println(name + " " + age);
//
//        return "OK";
//    }
//}


//说明：@RestController=@Controller+@ResponseBody
@RestController
public class RequestController {
    @RequestMapping("/SimpleParam")
    public String SimpleParam(@RequestParam(name = "name") String username, Integer age) {
        System.out.println(username + " " + age);

        return "OK";
    }

    @RequestMapping("/SimplePojo")
    public String SimplePojo(User user) {
        System.out.println(user);

        return "OK";
    }

    @RequestMapping("/ComplexPojo")
    public String ComplexPojo(User user) {
        System.out.println(user);

        return "OK";
    }


    @RequestMapping("/dataPojo")
    public String dataPojo(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime) {
        System.out.println(updateTime);

        return "OK";
    }


    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody User user) {
        System.out.println(user.toString());
        return "OK";
    }

    @RequestMapping("/Path/{id}")
    public String PathParam(@PathVariable Integer id) {
        System.out.println("当前访问页的id为：" + id);
        return "请求已收到";
    }

    @RequestMapping("/Path/{id}/{name}")
    public String PathParam2(@PathVariable Integer id, @PathVariable String name) {
        System.out.println("当前访问页的id为：" + id);
        System.out.println("当前访问页的name为：" + name);
        return "请求已收到";
    }

}
