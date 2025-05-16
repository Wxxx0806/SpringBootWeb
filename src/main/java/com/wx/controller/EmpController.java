package com.wx.controller;

import com.wx.Pojo.Emp;
import com.wx.Pojo.Result;
import com.wx.dao.EmpDao;
import com.wx.service.EmpService;
import com.wx.service.impl.EmpServiceA;
import com.wx.utils.XmlParserUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {

    private EmpService empService=new EmpServiceA();

    @RequestMapping("/listEmp")
    public Result list() {


//        //加载并解析emp.xml文件
//        String file= this.getClass().getClassLoader().getResource("emp.xml").getFile();
//        System.out.println(file);
//        List<Emp> parse = XmlParserUtils.parse(file, Emp.class);
//
//        //对数据进行处理
//        parse.stream().forEach(emp -> {
//            //处理性别 1: 男, 2: 女
//            String gender=emp.getGender();
//            if("1".equals(gender)){
//                emp.setGender("男");
//            }else if("2".equals(gender)){
//                emp.setGender("女");
//            }
//
//            //处理职业
//            String job=emp.getJob();
//            if("1".equals(job)){
//                emp.setJob("讲师");
//            }else if("2".equals(job)){
//                emp.setJob("班主任");
//            }else if("3".equals(job)){
//                emp.setJob("就业指导");
//            }
//        });

        //调用数据
        List<Emp> empList = empService.listEmp();

        //响应请求
        return Result.success(empList);
    }
}
