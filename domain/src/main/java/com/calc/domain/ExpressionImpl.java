package com.calc.domain;

import java.math.BigDecimal;

import com.florianingerl.util.regex.*;

public class ExpressionImpl implements Expression {
    final private String BALANCED_BRACKETS_STRING_IN_BRACES = "(?<brace>\\((?:[^()]+|(?'brace'))*+\\))";
    final private String BALANCED_BRACKETS_STRING = "(?<operand>[^()]|" + BALANCED_BRACKETS_STRING_IN_BRACES + ")+";
    final private String LEFT_OPERAND = "(?<left>" + BALANCED_BRACKETS_STRING + ")";
    final private String RIGHT_OPERAND = "(?<right>(?'operand')*)";
    ExpressionImpl left;
    ExpressionImpl right;
    Operation operation;
    BigDecimal value;

    public ExpressionImpl(String str) {
        String trimmedStr = str.replaceAll(" ", "");
        parseExpression(trimmedStr);
    }

    private void parseExpression(String str) {
        Pattern sumPattern = Pattern.compile("^" + LEFT_OPERAND + "(?<operation>\\+|-)" + RIGHT_OPERAND + "$");
        Matcher sumMatcher = sumPattern.matcher(str);
        Pattern mulPattern = Pattern.compile("^" + LEFT_OPERAND + "(?<operation>\\*|/)" + RIGHT_OPERAND + "$");
        Matcher mulMatcher = mulPattern.matcher(str);
        Pattern bracketPattern = Pattern.compile("^" + BALANCED_BRACKETS_STRING_IN_BRACES + "$");
        Matcher bracketMatcher = bracketPattern.matcher(str);
        if (sumMatcher.find()) {
            System.out.println("left: " + sumMatcher.group("left") + ", operation: " + sumMatcher.group("operation").charAt(0) + ", right: " + sumMatcher.group("right"));
            left = new ExpressionImpl(sumMatcher.group("left"));
            right = new ExpressionImpl(sumMatcher.group("right"));
            operation = Operation.getOperation(sumMatcher.group("operation").charAt(0));
        } else if (mulMatcher.find()) {
            System.out.println("left: " + mulMatcher.group("left") + ", operation: " + mulMatcher.group("operation").charAt(0) + ", right: " + mulMatcher.group("right"));
            left = new ExpressionImpl(mulMatcher.group("left"));
            right = new ExpressionImpl(mulMatcher.group("right"));
            operation = Operation.getOperation(mulMatcher.group("operation").charAt(0));
        } else if (bracketMatcher.find()) {
            System.out.println("brackets: (" + str.substring(1, str.length()-1) + ")");
            parseExpression(str.substring(1, str.length()-1));
        } else {
            System.out.println("value: " + str);
            value = new BigDecimal(str);
        }
    }

    @Override
    public BigDecimal evaluate() {
        if (value == null) {
            return operation.action(left.evaluate(), right.evaluate());
        } else {
            return value;
        }
    }
}
