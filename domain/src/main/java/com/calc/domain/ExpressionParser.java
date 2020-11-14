package com.calc.domain;

import com.calc.domain.impl.ExpressionBinaryOperation;
import com.calc.domain.impl.ExpressionNode;
import com.calc.domain.impl.Operation;
import com.florianingerl.util.regex.Matcher;
import com.florianingerl.util.regex.Pattern;

import java.math.BigDecimal;


public class ExpressionParser {
    final private static String BALANCED_BRACKETS_STRING_IN_BRACES = "(?<brace>\\((?:[^()]+|(?'brace'))*+\\))";
    final private static String BALANCED_BRACKETS_STRING = "(?<operand>[^()]|" + BALANCED_BRACKETS_STRING_IN_BRACES + ")+";
    final private static String LEFT_OPERAND = "(?<left>" + BALANCED_BRACKETS_STRING + ")";
    final private static String RIGHT_OPERAND = "(?<right>(?'operand')*)";
    final private static String OPERAND = "^-?\\d+$";

    public static Expression parse(String expr) {
        String str = expr.replaceAll(" ", "");
        Pattern sumPattern = Pattern.compile("^" + LEFT_OPERAND + "(?<operation>\\+|-)" + RIGHT_OPERAND + "$");
        Matcher sumMatcher = sumPattern.matcher(str);
        Pattern mulPattern = Pattern.compile("^" + LEFT_OPERAND + "(?<operation>\\*|/)" + RIGHT_OPERAND + "$");
        Matcher mulMatcher = mulPattern.matcher(str);
        Pattern bracketPattern = Pattern.compile("^" + BALANCED_BRACKETS_STRING_IN_BRACES + "$");
        Matcher bracketMatcher = bracketPattern.matcher(str);
        Pattern operandPattern = Pattern.compile(OPERAND);
        Matcher operandMatcher = operandPattern.matcher(str);
        if (sumMatcher.find()) {
            System.out.println("left: " + sumMatcher.group("left") + ", operation: " + sumMatcher.group("operation").charAt(0) + ", right: " + sumMatcher.group("right"));
            Expression left = parse(sumMatcher.group("left"));
            Expression right = parse(sumMatcher.group("right"));
            Operation operation = Operation.getOperation(sumMatcher.group("operation").charAt(0));
            return new ExpressionBinaryOperation(left, right, operation);
        } else if (mulMatcher.find()) {
            System.out.println("left: " + mulMatcher.group("left") + ", operation: " + mulMatcher.group("operation").charAt(0) + ", right: " + mulMatcher.group("right"));
            Expression left = parse(mulMatcher.group("left"));
            Expression right = parse(mulMatcher.group("right"));
            Operation operation = Operation.getOperation(mulMatcher.group("operation").charAt(0));
            return new ExpressionBinaryOperation(left, right, operation);
        } else if (bracketMatcher.find()) {
            System.out.println("brackets: (" + str.substring(1, str.length() - 1) + ")");
            return parse(str.substring(1, str.length() - 1));
        } else if (operandMatcher.find()){
            System.out.println("value: " + str);
            return new ExpressionNode(new BigDecimal(str));
        } else {
            throw new IllegalArgumentException("you try to parse incorrect expression: " + str);
        }
    }
}
