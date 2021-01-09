package com.kodilla;

public enum Symbol {
    EMPTY(0),
    CROSS(1),
    CIRCLE(2);

    Integer number;

    Symbol(Integer n){
        number=n;
    }
}

