module com.calc.domain {
    requires regex;
    requires calculator.api;
    exports com.calc.regexp.service;
}