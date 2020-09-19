package com.calc.domain;
import lombok.*;
import java.math.BigDecimal;
import java.util.Formatter;
import java.util.Locale;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Exercise{
    private Operation operation;
    private BigDecimal param1;
    private BigDecimal param2;

    public String toHTMPParams() {
        return new Formatter(Locale.US).format("operation=%s&param1=%.2f&param2=%.2f", operation, param1, param2).toString();
    }

    public BigDecimal calculate() {
        return operation.action(param1, param2);
    }

}
