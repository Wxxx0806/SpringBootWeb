package com.wx.dao.impl;

import com.wx.Pojo.Emp;
import com.wx.dao.EmpDao;
import com.wx.utils.XmlParserUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Component//控制反转操作，将当前类交给IOC容器进行管理，成为IOC容器的bean方法
@Repository
public class EmpDaoA implements EmpDao {
    @Override
    public List<Emp> listEmp() {
        //加载并解析emp.xml文件
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        System.out.println(file);
        List<Emp> parse = XmlParserUtils.parse(file, Emp.class);

        return parse;
    }
}
