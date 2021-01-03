module com.calc.antlr {
    requires antlr4;
    requires org.antlr.antlr4.runtime;
    requires com.calc.calculator;
    requires com.calc.regexp;
    exports com.calc.antlr.service;
}