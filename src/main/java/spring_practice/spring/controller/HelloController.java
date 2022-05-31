package spring_practice.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello") //웹어플리케이션에서 get방식의 hello가 들어오면 아래메서드를 호출함
    public String hello(Model model) { //Model 은 MVC ( Model-View-Controller ) 의 모델
        //리턴값이 필요한 이유 : ViewResolver가 화면을 찾아서 처리한다
        //기본 세팅 : resources에 있는 templates 아래의 hello를 찾아 렌더링 하라
        model.addAttribute("data", "hello"); //키 ( data )에 값( hello ) 저장
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-mvc";
    }

    @GetMapping("hello-string")
    @ResponseBody //내용을 그대로 출력 ( 리턴 값이 string )
    public String helloString(@RequestParam("name") String name) {
        return "Hello String " + name;
    }

    @GetMapping("hello-api") //get방식의 hello-responseBody-object
    @ResponseBody //리턴 값이 Object일 경우 json 형식으로 출력
    public Hello helloApi(@RequestParam("name") String name) {
        Hello h = new Hello();
        h.setName(name);
        return h;
    }

    static class Hello {
        private String name = "";

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            //json에 "name" : return값 으로 표시
            return name;
        }

        public String getEtc() {
            //json에 "etc" : "etc" 으로 반환
            return "etc";
        }
    }
}
