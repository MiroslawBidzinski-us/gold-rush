package edu.io.token;

public abstract class Token {
    // Wymagane przez TokenTest.token_has_only_one_ctor (chociaż test dopuszcza publiczny ctor)
    private final String label;
    public Token(String label) {
        this.label = label;// Pusty konstruktor wymagany, aby mieć tylko jeden
    }
    
    public abstract String label();
}