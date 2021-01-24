module com.calc.antlr {
    requires antlr4;
    requires org.antlr.antlr4.runtime;
    requires com.calc.calculator;
    requires com.calc.domain;
    exports com.calc.antlr.service;
}