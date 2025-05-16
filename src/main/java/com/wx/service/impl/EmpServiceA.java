package com.wx.service.impl;

import com.wx.Pojo.Emp;
import com.wx.dao.EmpDao;
import com.wx.dao.impl.EmpDaoA;
import com.wx.service.EmpService;

import java.util.List;

public class EmpServiceA implements EmpService {
    private EmpDao empDao = new EmpDaoA();

    @Override
    public List<Emp> listEmp() {
        //调用Dao中的方法
        List<Emp> parse = empDao.listEmp();

        //对数据进行处理
        parse.stream().forEach(emp -> {
            //处理性别 1: 男, 2: 女
            String gender = emp.getGender();
            if ("1".equals(gender)) {
                emp.setGender("男");
            } else if ("2".equals(gender)) {
                emp.setGender("女");
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
