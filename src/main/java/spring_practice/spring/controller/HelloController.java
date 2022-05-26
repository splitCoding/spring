package spring_practice.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello") //웹어플리케이션에서 get방식의 hello가 들어오면 아래메서드를 호출함
    public String Hello(Model model) { //Model 은 MVC ( Model-View-Controller ) 의 모델
        //리턴값이 필요한 이유 : ViewResolver가 화면을 찾아서 처리한다
        //기본 세팅 : resources에 있는 templates 아래의 hello를 찾아 렌더링 하라
        model.addAttribute("data", "hello"); //키 ( data )에 값( hello ) 저장
        return "hello";
    }
}
