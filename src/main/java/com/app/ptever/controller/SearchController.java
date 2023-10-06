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


@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/search-results/*")
public class SearchController {
    private final SearchService searchService;

//    @GetMapping("search")
//    public void GoToSearchResult(){;}

//    @GetMapping("search")
//    public SearchDTO getResult(Search search) {
//        return searchService.getResult(search);
//    }

    @GetMapping
    public String showSearchResults() {
        return "search";
    }

    @PostMapping("search")
    public RedirectView searchCoursesAndProducts(@RequestParam("keyword") String keyword, Model model) {
        Search search = new Search();
        search.setKeyword(keyword);

        SearchDTO searchDTO = searchService.getResult(search);

        model.addAttribute("searchDTO", searchDTO);

        return new RedirectView("/search-results/search");
    }
}
