package com.wx.service.impl;

import com.wx.Pojo.Emp;
import com.wx.dao.EmpDao;
import com.wx.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //控制反转的操作
public class EmpServiceB implements EmpService {

    @Autowired //依赖注入的操作
    private EmpDao empDao;

    @Override
    public List<Emp> listEmp() {
        //调用Dao中的方法
        List<Emp> parse = empDao.listEmp();

        //对数据进行处理
        parse.stream().forEach(emp -> {
            //处理性别 1: 男, 2: 女
            String gender = emp.getGender();
            if ("1".equals(gender)) {
                emp.setGender("男士");
            } else if ("2".equals(gender)) {
                emp.setGender("女士");
            }

            //处理职业
            String job = emp.getJob();
            if ("1".equals(job)) {
                emp.setJob("讲师");
            } else if ("2".equals(job)) {
                emp.setJob("班主任");
            } else if ("3".equals(job)) {
                emp.setJob("就业指导");
            }
        });
        return parse;

    }
}
