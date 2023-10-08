package com.app.ptever.controller;

import com.app.ptever.domain.Search;
import com.app.ptever.domain.dto.SearchDTO;
import com.app.ptever.repository.SearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;


@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/search-results/*")
@SessionAttributes("keyword")
public class SearchController {
    private final SearchService searchService;


    @GetMapping("search")
    public String searchCoursesAndProducts(@RequestParam("keyword") String keyword, Model model, HttpSession session) {
        Search search = new Search();
        search.setKeyword(keyword);

        SearchDTO searchCourses = searchService.getResult(search);
        model.addAttribute("searchCourses", searchCourses);

        int courseTotalCount = searchCourses.getCourseTotalCount();
        model.addAttribute("courseTotalCount", courseTotalCount);

        model.addAttribute("keyword", keyword);


        if(searchCourses != null && searchCourses.getCourseTotalCount() > 0) {
            return "search-results/search";
        } else {
            return "/search-results/no-search";
        }

    }

    @GetMapping("no-search")
    public String noSearchResults() {

        return "search-results/no-search";
    }



//    @GetMapping
//    public String showSearchResults() {
//        return "search";
//    }
//
//    // 통합 검색
//    @PostMapping("search")
//    public RedirectView searchCoursesAndProducts(@RequestParam("keyword") String keyword, Model model) {
//        Search search = new Search();
//        search.setKeyword(keyword);
//
//        SearchDTO searchDTO = searchService.getResult(search);
//
//        model.addAttribute("searchDTO", searchDTO);
//
//        return new RedirectView("/search-results/search");
//    }

//    @GetMapping("search")
//    public String showSearchResults(Model model) {
//        SearchDTO searchDTO = new SearchDTO();
//        model.addAttribute("searchCourses", searchDTO);
//
//        return "/search-results/search";
//    }
//
//    @PostMapping("search")
//    public String searchCoursesAndProducts(@RequestParam("keyword") String keyword, Model model) {
//        Search search = new Search();
//        search.setKeyword(keyword);
//
//        SearchDTO searchDTO = searchService.getResult(search);
//        model.addAttribute("searchCourses", searchDTO);
//
//        int courseTotalCount = searchDTO.getCourseTotalCount();
//        model.addAttribute("courseTotalCount", courseTotalCount);
//
//        return "search-results/search";
//    }



//    @GetMapping("search")
//    public String showSearchResults(@RequestParam("keyword") String keyword, Model model) {
//        if (keyword != null && !keyword.isEmpty()) {
//            Search search = new Search();
//            search.setKeyword(keyword);
//            SearchDTO searchDTO = searchService.getResult(search);
//
//            int courseTotalCount = searchDTO.getCourseTotalCount();
//
//
//            model.addAttribute("keyword", keyword);
//            model.addAttribute("searchCourses", searchDTO);
//            model.addAttribute("courseTotalCount",courseTotalCount);
//
//
//            if (searchDTO != null && searchDTO.getCourseTotalCount() > 0) {
//                return "/search-results/search";
//            } else {
//                return "/search-results/no-search";
//            }
//        } else {
//            return "redirect:/search-results/no-search";
//        }
//    }


//    @PostMapping("search")
//    public String performSearch(@RequestParam("keyword") String keyword, Model model) {
//        if (keyword != null && !keyword.isEmpty()) {
//            Search search = new Search();
//            search.setKeyword(keyword);
//            SearchDTO searchDTO = searchService.getResult(search);
//            int courseTotalCount = searchDTO.getCourseTotalCount();
//
//
//            model.addAttribute("keyword", keyword);
//            model.addAttribute("searchCourses", searchDTO);
//            model.addAttribute("courseTotalCount",courseTotalCount);
//
//            if (searchDTO != null && searchDTO.getCourseTotalCount() > 0) {
//                return "/search-results/search";
//            } else {
//                return "/search-results/no-search";
//            }
//        } else {
//            return "redirect:/search-results/no-search";
//        }
//    }

}
