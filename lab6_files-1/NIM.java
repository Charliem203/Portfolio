/*
 * CSCI 1913
 * Lab 06
 * Author: TODO: FILL ME IN
 * */
/* Charlie Madison */
.package student



public class NIM {

    /**
     * cerate a game state array
     * @param size -- the number of rows
     * @param stickMax -- the largest value
     * @return an array representing a token array. The array in the first position will be one, each following will be
     *     one larger up to the max.
     */
    public static int[] createGameState(int size, int stickMax){
        int [] num_Tokens = new int [size];
        for(int i = 0; i < size; i++)
        {
            int x = i + 1;
            if(x > stickMax)
            {
                x = stickMax;
            }
            num_Tokens[i] = x;
        }
        return num_Tokens; // you will want to delete this line.
    }

    /**
     * This provided function operators similarly to the python isDigit method. You give it a string and it will tell
     * you if the string contains only digits. Give it a read -- the actual design isn't hard, basically a linear search.
     * @param str any string
     * @return true if all letters in the string are digits.
     */
    private static boolean isDigit(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if a given move (as represented by two input strings) is valid. This should check if the inputs are numbers
     * if those numbers are in the valid range.
     * @param gameState an array representing the number of tokens in each row.
     * @param row a string representing which row the user wants to take from. 1-indexed.
     * @param takes a string representing how many tokens the user wants to take.
     * @return true if and only if the move would be valid
     */
    public static boolean isValidMove(int[] gameState, String row, String takes) {

        int intRows;
        int intTakes;
        if (!isDigit(row) || !isDigit(takes))
        {
            return false;
        }
        else
        {
            intRows = Integer.parseInt(row) - 1;
            intTakes = Integer.parseInt(takes);
        }
        int len = gameState.length;
        if(intRows > len || intRows == 0)
        {
            return false;
        }
        if(intTakes < 1 || intTakes > 3)
        {
            return false;
        }
        if(intTakes > gameState[intRows])
        {
            return false;
        }
        return true;

    }

    /**
     * User System.out.println to represent a token grid to the program user.
     * @param gameState an array representing the number of tokens in each row.
     */
    public static void drawGameState(int[] gameState){
        // TODO: FILL ME IN
    }


    /**
     * Create an updated version of the game state. You can assume the row and takes are valid for the gameState array provided.
     * @param gameState an array representing the number of tokens in each row.
     * @param row the row the user wants to take from (0-indexed)
     * @param takes the number of tokens the user wants to take
     * @return a new array representing the state number of tokens in each row after the given numbers were removed.
     */
    public static int[] update(int[] gameState, int row, int takes){


        //TODO: FILL ME IN
        return null; // you will want to delete this line.
    }

    /**
     *
     * @param gameState an array representing the number of tokens in each row.
     * @return true if and only if every element of gameState is false.
     */
    public static boolean isOver(int[] gameState) {

        //TODO: FILL ME IN
        return false; // you will want to delete this line.
    }
}