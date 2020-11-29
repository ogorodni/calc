package com.calc.antlr.impl;

import java.math.BigDecimal;

public class EvalVisitor extends ExprBaseVisitor<BigDecimal> {

    /** INT */
    @Override
    public BigDecimal visitInt(ExprParser.IntContext ctx) {
        return new BigDecimal(ctx.INT().getText());
    }

    /** expr op=('*'|'/') expr */
    @Override
    public BigDecimal visitMulDiv(ExprParser.MulDivContext ctx) {
        BigDecimal left = visit(ctx.expr(0)); // get value of left subexpression
        BigDecimal right = visit(ctx.expr(1)); // get value of right subexpression
        if ( ctx.op.getType() == ExprParser.MUL ) return left.multiply(right);
        return left.divide(right); // must be DIV
    }
    /** expr op=('+'|'-') expr */
    @Override
    public BigDecimal visitAddSub(ExprParser.AddSubContext ctx) {
        BigDecimal left = visit(ctx.expr(0)); // get value of left subexpression
        BigDecimal right = visit(ctx.expr(1)); // get value of right subexpression
        if ( ctx.op.getType() == ExprParser.ADD ) return left.add(right);
        return left.subtract(right); // must be SUB
    }
    /** '(' expr ')' */
    @Override
    public BigDecimal visitParens(ExprParser.ParensContext ctx) {
        return visit(ctx.expr()); // return child expr's value
    }
}
