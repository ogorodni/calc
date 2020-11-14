package com.calc.server;

import com.calc.domain.ExpressionParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Controller
public class CalcController {

    @GetMapping("/calc")
    public @ResponseBody
    BigDecimal calculate(@RequestParam String expr)
    {
        return ExpressionParser.parse(expr).evaluate();
    }

    @PostMapping("/calc")
    public @ResponseBody
    BigDecimal jsonCalculate(@RequestBody String expr)
    {
        return ExpressionParser.parse(expr).evaluate();
    }

}
