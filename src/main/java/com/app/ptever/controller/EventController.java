package com.app.ptever.controller;

import com.app.ptever.domain.pagination.Pagination;
import com.app.ptever.domain.vo.EventVO;
import com.app.ptever.domain.vo.NoticeVO;
import com.app.ptever.mapper.EventMapper;
import com.app.ptever.repository.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;


@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/event/*")
public class EventController {
    private final EventService eventService;
    private final EventMapper eventMapper;
    @GetMapping("event")
    public ModelAndView GoToEvent(Model model, Pagination pagination){
        List<EventVO> events = eventService.selectEvent();
        model.addAttribute("event",events);

//        총 목록 개수
        pagination.setTotal(eventService.selectAllCounts());
        pagination.progress();

        ModelAndView mav = new ModelAndView();
        List<EventVO> allEvents = eventService.selectAllEvents(pagination);
        mav.addObject("allEvents",allEvents);
        mav.addObject("pagination",pagination);
//        log.info(mav.toString());
        return mav;
    }
}
