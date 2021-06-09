package com.example.response.controller;

import com.example.response.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    @RequestMapping("/main")
    public String main(){  //String이면 리소스를 찾는다
        return "main.html";
    }


    //ResponseEntity

// 잘안쓴다
//    @ResponseBody
//    @GetMapping("/user")
//    public User user(){
//        var user = new User(); // var는 타입추론 java11부터..
//        user.setName("steve");
//        user.setAddress("패캠");
//        return user;
//    }

}
