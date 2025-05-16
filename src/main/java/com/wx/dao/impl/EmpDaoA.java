package com.wx.dao.impl;

import com.wx.Pojo.Emp;
import com.wx.dao.EmpDao;
import com.wx.utils.XmlParserUtils;

import java.util.List;

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
