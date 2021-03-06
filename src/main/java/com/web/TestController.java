package com.web;

import com.exception.AppException;
import com.model.UserInfo;
import com.view.SingUpDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/test")
@Api(value = "test")
public class TestController {
    @GetMapping("/get")
    public String information() {
        return " this information system";
    }


    @GetMapping("/getuser")
    public UserInfo getuser() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(123L);
        return userInfo;

    }

    @PostMapping("/postuser")
    public UserInfo postuser(@Valid @RequestBody SingUpDto singUp) {
        if (singUp.getUserName().equals("usertest")) {
            UserInfo userInfo = new UserInfo();
            userInfo.setUserName("test2");
            return userInfo;
        } else {
            throw new AppException("user.not.found");
        }
    }

}
