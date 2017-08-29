package com.lanlinker.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by MetalSteel on 2017/8/29.
 */
@Controller
public class DispatchController {
    @GetMapping("/student")
    public String dispatch(){
        return "/student";
    }
}
