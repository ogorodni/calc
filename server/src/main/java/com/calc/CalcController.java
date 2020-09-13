package com.calc;

import com.calc.domain.Operation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
public class CalcController {

    @GetMapping("/calc")
    public BigDecimal calculate(@RequestParam(name="operation", required=true) Operation operation,
                                @RequestParam(name="param1", required = true) BigDecimal param1,
                                @RequestParam(name="param2", required = true) BigDecimal param2){
        return operation.action(param1,param2);
    }
}
