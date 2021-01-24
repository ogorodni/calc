package com.calc.antlr.service;

import com.calc.antlr.impl.EvalVisitor;
import com.calc.antlr.impl.ExprLexer;
import com.calc.antlr.impl.ExprParser;
import com.calc.calculator.Calculator;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.math.BigDecimal;

public class AntlrCalculator implements Calculator {

    @Override
    public BigDecimal evaluate(String expr) {
        CharStream input = CharStreams.fromString(expr);
        ExprLexer lexer = new ExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokens);
        ParseTree tree = parser.expr();
        EvalVisitor eval = new EvalVisitor();
        return eval.visit(tree).evaluate();
    }
}
