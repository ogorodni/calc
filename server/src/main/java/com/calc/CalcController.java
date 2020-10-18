package com.calc;

import com.calc.domain.ExpressionImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Controller
public class CalcController {

    @GetMapping("/calc")
    public @ResponseBody
    BigDecimal calculate(@RequestParam String expr)
    {
        ExpressionImpl expression = new ExpressionImpl(expr);
        return expression.evaluate();
    }

    @PostMapping("/calc")
    public @ResponseBody
    BigDecimal jsonCalculate(@RequestBody String expr)
    {
        ExpressionImpl expression = new ExpressionImpl(expr);
        return expression.evaluate();
    }

}
