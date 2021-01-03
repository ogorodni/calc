module com.calc.regexp {
    requires regex;
    requires com.calc.calculator;
    exports com.calc.regexp.service;
    exports com.calc.regexp.impl;
    // I had to export implementation. I don't understand what should I do here. Please advise.
}