package edu.io.token;

import java.lang.reflect.Modifier;

public abstract class Token {
    // Wymagane przez TokenTest.token_has_only_one_ctor (chociaż test dopuszcza publiczny ctor)
    public Token() {
        // Pusty konstruktor wymagany, aby mieć tylko jeden
    }
    
    // Wymagane przez TokenTest.class_Token_is_abstract
    // Oraz przez TokenTest.token_has_label
    public abstract String label();
}