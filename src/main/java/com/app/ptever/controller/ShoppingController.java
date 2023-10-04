package com.app.ptever.controller;

import com.app.ptever.domain.dto.ShoppingMallDTO;
import com.app.ptever.repository.ShoppingMallService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/shopping/*")
public class ShoppingController {
    private final ShoppingMallService shoppingMallService;

//    쇼핑몰
    @GetMapping("shopping")
    public ModelAndView GoToShopping(){
        ModelAndView mav = new ModelAndView();
        List<ShoppingMallDTO> allProducts = shoppingMallService.findProductAll();
        mav.addObject("allProducts", allProducts);
        return mav;
    }

//    쇼핑몰 리뷰
    @GetMapping("shopping-review")
    public void GoToShoppingReview(){;}

}
