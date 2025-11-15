package edu.io;

public class Token {
    // Wymagane przez TokenTest.token_has_label
    public final String label;

    // Wymagane przez TokenTest.token_has_only_one_ctor
    public Token(String label) {
        this.label = label;
    }
}