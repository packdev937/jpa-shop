package jpabook.jpashop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j // 얘는 뭘까?
public class HomeController {

    @RequestMapping("/") // GetMapping 과의 차이점
    public String home() {
        log.info("home controller");
        return "home";
    }
}
