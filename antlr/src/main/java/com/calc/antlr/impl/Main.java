package com.calc.antlr.impl;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main {
    public static void main(String[] args) throws Exception {
//        TestRig tr = new TestRig( new String[]{"com.calc.antlr.Expr", "expr", "-gui"});
//        tr.process();
        CharStream input = CharStreams.fromString("(1+1)*(-2)");
        ExprLexer lexer = new ExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokens);
        ParseTree tree = parser.expr();
        EvalVisitor eval = new EvalVisitor();
        System.out.println(eval.visit(tree));

    }
}
