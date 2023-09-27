package com.app.ptever.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/shoppingbasket/*")
public class ShoppingBasketController {
//    장바구니
    @GetMapping("shoppingbasket-off")
    public void GoToShoppingBasket(){;}
}
