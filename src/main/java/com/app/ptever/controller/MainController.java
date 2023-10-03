package com.app.ptever.controller;

import com.app.ptever.domain.dto.CourseSelectDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor

public class MainController {

    @GetMapping("/")
    public String GoToMain(){
        return "mainpage/mainpage";
    }
}
