package com.yamamotokogyo.ywm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SampleController {

    @RequestMapping("/add")
    public String add(Model model, @RequestParam("a") int a, @RequestParam("b") int b) {
        model.addAttribute("result", a + b);
        return "result";
    }

}