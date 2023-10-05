package com.app.ptever.controller;

import com.app.ptever.domain.vo.EventVO;
import com.app.ptever.mapper.EventMapper;
import com.app.ptever.repository.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public void GoToEvent(Model model){
        List<EventVO> events = eventService.selectEvent();
        model.addAttribute("event",events);
    }
}
