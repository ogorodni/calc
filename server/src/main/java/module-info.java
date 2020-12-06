open module com.calc.server {
    requires spring.context;
    requires spring.web;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires java.sql;
    requires com.calc.antlr;
    requires com.calc.calculator;
}