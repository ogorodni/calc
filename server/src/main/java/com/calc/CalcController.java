package com.calc;

import com.calc.domain.Exercise;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
public class CalcController {

    @GetMapping("/calc")
    public BigDecimal calculate(@RequestParam(name="exercise") Exercise exercise){
        return exercise.calculate();
    }
}
