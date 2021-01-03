package com.calc.antlr.impl;

import com.calc.regexp.impl.*;

import java.math.BigDecimal;

public class EvalVisitor extends ExprBaseVisitor<Expression> {

    /** INT */
    @Override
    public Expression visitInt(ExprParser.IntContext ctx) {return new ExpressionConst(new BigDecimal(ctx.INT().getText()));
    }

    /** expr '*' expr */
    @Override
    public Expression visitMul(ExprParser.MulContext ctx) {
        return new ExpressionBinaryOperationMultiply(visit(ctx.expr(0)), visit(ctx.expr(1)));
    }
    /** expr '/' expr */
    @Override
    public Expression visitDiv(ExprParser.DivContext ctx) {
        return new ExpressionBinaryOperationDivide(visit(ctx.expr(0)), visit(ctx.expr(1)));
    }
    /** expr '+' expr */
    @Override
    public Expression visitAdd(ExprParser.AddContext ctx) {
        return new ExpressionBinaryOperationAdd(visit(ctx.expr(0)), visit(ctx.expr(1)));
    }
    /** expr '-' expr */
    @Override
    public Expression visitSub(ExprParser.SubContext ctx) {
        return new ExpressionBinaryOperationSubstruct(visit(ctx.expr(0)), visit(ctx.expr(1)));
    }
    /** '(' expr ')' */
    @Override
    public Expression visitParens(ExprParser.ParensContext ctx) {
        return visit(ctx.expr()); // return child expr's value
    }
    /** op = -expr */
    @Override
    public Expression visitNeg(ExprParser.NegContext ctx){
        return new ExpressionBinaryOperationMultiply(visit(ctx.expr()), new ExpressionConst(new BigDecimal(-1)));
    }
}
