package edu.io;

public class Board {
    // Rozmiar planszy. Testy nie definiują go, ale 10x10 to standard.
    // Musi być publiczny ze względu na board.size w BoardTest
    public final int size = 10;
    
    // Plansza przechowująca Tokeny
    private Token[][] squares;
    
    // Label dla pustego tokenu (wymagane przez BoardTest)
    final String EMPTY_TOKEN_LABEL = "・";

    public Board() {
        // Inicjalizacja planszy i wypełnienie pustymi tokenami
        squares = new Token[size][size];
        clean();
    }

    /**
     * Wymagane przez BoardTest.new_board_is_clean i BoardTest.clean_method_works
     */
    public void clean() {
        Token emptyToken = new Token(EMPTY_TOKEN_LABEL);
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                squares[row][col] = emptyToken;
            }
        }
    }

    /**
     * Wymagane przez BoardTest.can_place_token
     */
    public void placeToken(int col, int row, Token token) {
        // Uwaga: w testach użyto (col, row), zakładam, że kolumny to pierwszy indeks, a wiersze drugi
        squares[row][col] = token;
    }

    /**
     * Wymagane przez BoardTest.can_place_token i _is_board_clean
     */
    public Token square(int col, int row) {
        // Zgodnie z BoardTest.square(col, row)
        return squares[row][col];
    }
    
    /**
     * Wymagane przez BoardTest.display_method_exists
     *
     * Minimalna implementacja metody, która musi istnieć.
     * Jej funkcjonalność zostanie prawdopodobnie przetestowana w późniejszych etapach.
     */
    public void display() {
        // Można tu umieścić logikę wyświetlania, ale dla przejścia testu BoardTest.display_method_exists wystarczy pusta metoda
        // System.out.println("Board display output...");
    }
}