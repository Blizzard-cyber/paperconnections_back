package com.kuang.controller;

import com.kuang.service.PaperService;
import com.kuang.service.PaperServiceImpl;
import com.kuang.service.UserService;
import com.kuang.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaperController {
    @Autowired
    @Qualifier("paperServiceImpl")
    private PaperService paperService;



}
