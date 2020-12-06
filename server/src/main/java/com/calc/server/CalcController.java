package com.calc.server;

import com.calc.antlr.service.AntlrCalculator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Controller
public class CalcController {

    AntlrCalculator antlrCalculator = new AntlrCalculator();

    @GetMapping("/calc")
    public @ResponseBody
    BigDecimal calculate(@RequestParam String expr) {
        return antlrCalculator.evaluate(expr);
    }

    @PostMapping("/calc")
    public @ResponseBody
    BigDecimal jsonCalculate(@RequestBody String expr) {
        return antlrCalculator.evaluate(expr);
    }

}
