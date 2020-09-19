package com.calc;

import com.calc.domain.Exercise;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class CalcController {

    @GetMapping("/calc")
    public String calculate(@ModelAttribute Exercise exercise, Model model)
    {
        model.addAttribute("result", exercise.calculate());
        return "calc";
    }

    @PostMapping("/calc")
    public String jsonCalculate(@RequestBody Exercise exercise, Model model)
    {
        model.addAttribute("result", exercise.calculate());
        return "calc";
    }

}
