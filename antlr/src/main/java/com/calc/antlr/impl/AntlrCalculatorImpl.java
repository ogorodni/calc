package com.calc.antlr.impl;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.math.BigDecimal;

public class AntlrCalculatorImpl {
    public static BigDecimal evaluate(String expr) {
        CharStream input = CharStreams.fromString(expr);
        ExprLexer lexer = new ExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokens);
        ParseTree tree = parser.expr();
        EvalVisitor eval = new EvalVisitor();
        return eval.visit(tree);
    }
}
