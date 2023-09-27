package com.app.ptever.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/shopping/*")
public class ShoppingController {

//    쇼핑몰
    @GetMapping("shopping")
    public void GoToShopping(){;}

//    쇼핑몰 리뷰
    @GetMapping("shopping-review")
    public void GoToShoppingReview(){;}

}
