package com.wx.controller;

import com.wx.user.Address;
import com.wx.user.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ResponseController {

    @RequestMapping("/响应Hello JavaWeb")
    public Result Hello() {
        return Result.success("Hello JavaWeb");
    }

    @RequestMapping("/响应Address")
    public Result address() {
        Address address = new Address();
        address.setCountry("山东");
        address.setCity("济南");

        return Result.success(address);
    }
}
