/*
 * 11.01.2022 - 1:13 p.m. - by Kabraxis Luvos
 */
import java.util.Scanner;

public class Main {
    public static final String RESET = "\033[0m";
    public static final String BLACK = "\033[0;1";
    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";
    public static final String YELLOW = "\033[0;33m";
    public static final String BLUE = "\033[0;34m";
    public static final String PURPLE = "\033[0;35m";
    public static final String CYAN = "\033[0;36m";
    public static final String WHITE = "\033[0;37m";

    public static final String BLACK_BRIGHT = "\033[0;90m";
    public static final String RED_BRIGHT = "\033[0;91m";
    public static final String GREEN_BRIGHT = "\033[0;92m";
    public static final String YELLOW_BRIGHT = "\033[0;93m";
    public static final String BLUE_BRIGHT = "\033[0;94m";
    public static final String PURPLE_BRIGHT = "\033[0;95m";
    public static final String CYAN_BRIGHT = "\033[0;96m";
    public static final String WHITE_BRIGHT = "\033[0;97m";

    // Game always starts with player X
    static char currentPlayer = 'X';

    public static void main(String[] args) {


        char[][] board = {
                // 1,1   1,2  1,3 <- locations entered by user
                // 0,0   0,1  0,2 <- locations by index counting of an array
                {'_', '_', '_'},
                // 2,1   2,2  2,3
                // 1,0   1,1  1,2
                {'_', '_', '_'},
                // 3,1   3,2  3,3
                // 2,0   2,1  2,2
                {'_', '_', '_'},
        };

        gameLoop(board);
    }

    public static void gameLoop(char[][] board) {
        Scanner pauseGame = new Scanner(System.in);

        char winner = checkWinconditions(board);

        printArrayBoardArt(board);

        if (winner == 'd') {
            printWinner("Draw");
            pauseGame.nextLine();
            return;
        }
        if (winner == 'X') {
            printWinner("X wins");
            pauseGame.nextLine();
            return;
        }
        if (winner == 'O') {
            printWinner("O wins");
            pauseGame.nextLine();
            return;
        }

        int[] validatedCoordinates = getValidCoordinates(board);
        // Coordinates provided by the user start counting form 1-3,
        // while the counting in arrays start fom 0-2.
        // So, the position on the board where the user wants to place their symbol has to be
        // the user's entered coordinate - 1, like: input = 1 1 -> position = 0 0 on the board.
        // That's why I subtract 1 in the final coordinates here.
        board[validatedCoordinates[0] - 1][validatedCoordinates[1] - 1] = currentPlayer;

        changePlayer();

        gameLoop(board);
    }

    public static void printArrayBoardArt(char[][] board) {

        String[] upperCastleArt = {
//                /*00*/ "         ___",
//                /*01*/ "      __(_  )___",
//                /*02*/ "    _(          )",
//                /*03*/ "   (     )-----´        |----______________,",
//                /*04*/ "    `---'               |    Kabraxis '22 /",
//                /*05*/ "                        |---____________/",
//                /*06*/ "                        |",
//                /*07*/ "                        X                     \\,/",
//                /*08*/ "                       /~\\",
//                /*09*/ "                      /~~~\\                         /`\\",
//                /*10*/ "                     /~~~~~\\",
//                /*11*/ "      |---____,     /~~~~~~~\\             |---____,",
//                /*12*/ "      |--____/     /~~~~~~~~~\\            |--____/",
//                /*13*/ "      |           /~~~~~~~~~~~\\           |",
//                /*14*/ "      X           |     .   .:|           X",
//                /*15*/ "     /~\\          |   _   _   |          /~\\",
//                /*16*/ "    /~~~\\         |  |+| |+|  |         /~~~\\",
//                /*17*/ "   /~~~~~\\        |  |_| |_|  |        /~~~~~\\",
//                /*18*/ "   | :   |      __|           |__      | :   |",
//                /*19*/ "   |.:   |____| ; .           . ; |____|.:   |",
//                /*20*/ "   |  _    .        __________       .    _  |",
//                /*21*/ "   | |+| |.  ==   /            \\  ==  .| |+| |",
//                /*22*/ "   | |_|   .     /              \\    .   |_| |",
//                /*23*/ "   |     |:  ,  |    * 1 2 3 *   | ,  :|     |",
//                /*24*/ "   | .   |  |   |    ---------   |  |  |   . |"
                /*00*/ BLUE + "         ___" + RESET,
                /*01*/ BLUE + "      __(_  )___" + RESET,
                /*02*/ BLUE + "    _(          )" + RESET,
                /*03*/ BLUE + "   (     )-----´" + YELLOW_BRIGHT + "        |----______________," + RESET,
                /*04*/ BLUE + "    `---'" + YELLOW_BRIGHT + "               |    " + PURPLE_BRIGHT + "Kabraxis '22" + YELLOW_BRIGHT + " /" + RESET,
                /*05*/ YELLOW_BRIGHT +             "                        |---____________/" + RESET,
                /*06*/ YELLOW_BRIGHT +             "                        |" + RESET,
                /*07*/ RED +                       "                        X" + WHITE_BRIGHT + "                     \\,/" + RESET,
                /*08*/ RED +                       "                       /~\\" + RESET,
                /*09*/ RED +                       "                      /~~~\\" + WHITE_BRIGHT + "                        /`\\" + RESET,
                /*10*/ RED +                       "                     /~~~~~\\" + RESET,
                /*11*/ YELLOW_BRIGHT +  "      |---____,     " + RED + "/~~~~~~~\\             " + YELLOW_BRIGHT + "|---____," + RESET,
                /*12*/ YELLOW_BRIGHT +  "      |--____/     " + RED + "/~~~~~~~~~\\            " + YELLOW_BRIGHT + "|--____/" + RESET,
                /*13*/ "      |           /~~~~~~~~~~~\\           |",
                /*14*/ "      X           |     .   .:|           X",
                /*15*/ "     /~\\          |   _   _   |          /~\\",
                /*16*/ "    /~~~\\         |  |+| |+|  |         /~~~\\",
                /*17*/ "   /~~~~~\\        |  |_| |_|  |        /~~~~~\\",
                /*18*/ "   | :   |      __|           |__      | :   |",
                /*19*/ "   |.:   |____| ; .           . ; |____|.:   |",
                /*20*/ "   |  _    .        __________       .    _  |",
                /*21*/ "   | |+| |.  ==   /            \\  ==  .| |+| |",
                /*22*/ "   | |_|   .     /              \\    .   |_| |",
                /*23*/ "   |     |:  ,  |    * 1 2 3 *   | ,  :|     |",
                /*24*/ "   | .   |  |   |    ---------   |  |  |   . |"
        };

        String[] leftOfBoardCastleArt = {
                /*25 1/2*/ "   |     |  |   |  >1| ",
                /*26 1/2*/ "   |-    |  |   |  >2| ",
                /*27 1/2*/ "   _ _   |  |   |  >3| "
        };

        String[] rightOfBoardCastleArt = {
                /*25 2/2*/ "|   |  |  |     |",
                /*26 2/2*/ "|   |  |  |    -|",
                /*27 2/2*/ "|   |  |  |  _  |"
        };

        String[] lowerCastleArt = {
                /*28*/ "    '--~~__ |   |    ---------   |  | _|_    |",
                /*29*/ "           ~---___________________---~   ~`---,",
                /*30*/ "                                               ~~----____-~"
        };

        for (String s : upperCastleArt) {
            System.out.println(s);
        }

        for (int i = 0; i < board.length; i++) {
            System.out.print(leftOfBoardCastleArt[i]);
            for (int j = 0; j < board[1].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.print(rightOfBoardCastleArt[i]);
            System.out.println();
        }

        for (String s: lowerCastleArt) {
            System.out.println(s);
        }
    }

    // User's input of coordinates is a string that will be checked if it contains
    // numbers and then the numbers will be translated to integers.
    // Keeps asking for the correct input.
    public static int[] getValidCoordinates(char[][] board) {
        Scanner scanner = new Scanner(System.in);
        // Only positive numbers are allowed.
        String pattern = "([-+])?\\d+";
        printTurnMessage();
        String userInputToCheckBeforeSplit = scanner.nextLine();

        // If the user's input contains only white space or no input at all, this will filter it out
        if (userInputToCheckBeforeSplit.length() < 3 || userInputToCheckBeforeSplit.charAt(0) == 0 ||
                userInputToCheckBeforeSplit.charAt(0) == ' ' || userInputToCheckBeforeSplit.charAt(2) == 0 ||
                userInputToCheckBeforeSplit.charAt(2) == ' ') {
            System.out.println("You must enter two numbers, separated by a space!");
            return getValidCoordinates(board);
        }

        String[] coordinates = userInputToCheckBeforeSplit.split(" ");
        // Loops as long as the input doesn't match the pattern of only positive integers.
        if (!coordinates[0].matches(pattern) || !coordinates[1].matches(pattern)) {
            System.out.println("You should enter numbers!");
            return getValidCoordinates(board);
        }

        // Translates string numbers to integers.
        int[] numCoordinates = {Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1])};

        // In case the user enters coordinates bigger than 3 or smaller than 0 an error will be shown and
        // the method will be reset and restarted.
        if (numCoordinates[0] > 3 || numCoordinates[0] < 1 || numCoordinates[1] > 3 || numCoordinates[1] < 1) {
            System.out.println("Coordinates should be from 1 to 3!");
            return getValidCoordinates(board);
        }

        // When user input is in range and a number, this checks whether it's valid or not.
        if (!isValidTurn(board, numCoordinates)) {
            return getValidCoordinates(board);
        }

        return numCoordinates;
    }

    // Coordinates provided by the user start counting from 1-3,
    // while the counting in arrays start from 0-2.
    // So the position on the board where the user wants to place their symbol has to be
    // the user's entered coordinate - 1, like: input = 1 1 -> position = 0 0 on the board.
    // That's why I subtract 1 in the if-condition here.
    public static boolean isValidTurn(char[][] board, int[] getValidCoordinates) {
        if (board[getValidCoordinates[0] - 1][getValidCoordinates[1] - 1] == '_') {
            return true;
        } else {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }
    }

    public static void printTurnMessage() {
        System.out.println("Enter the coordinates:");
    }

    public static void changePlayer() {
        switch (currentPlayer) {
            case 'X':
                currentPlayer = 'O';
                break;
            default:
                currentPlayer = 'X';
                break;
        }
    }

    public static char checkWinconditions(char[][] board) {
        /* Iterate through board to determine:
         * -> O wins: three O's in a row
         * -> X wins: three X's in a row
         * -> Draw: neither side wins, no more empty cells
         * */

        // --- Win conditions ---

        // >>> X win conditions <<<

        // True if the indexes that are building the diagonal line from top left to bottom right
        // or from top right to bottom left are "X"

        boolean xWinLeftDiagonal = board[0][0] == ('X') &&
                board[1][1] == ('X') &&
                board[2][2] == ('X');

        boolean xWinRightDiagonal = board[0][2] == ('X') &&
                board[1][1] == ('X') &&
                board[2][0] == ('X');

        // True if the indexes that are building horizontal lines left to right are "X'
        boolean xWinHorizontal1 = board[0][0] == ('X') &&
                board[0][1] == ('X') &&
                board[0][2] == ('X');

        boolean xWinHorizontal2 = board[1][0] == ('X') &&
                board[1][1] == ('X') &&
                board[1][2] == ('X');

        boolean xWinHorizontal3 = board[2][0] == ('X') &&
                board[2][1] == ('X') &&
                board[2][2] == ('X');

        // True if the indexes that are building vertical lines top to bottom are "X"
        boolean xWinVertical1 = board[0][0] == ('X') &&
                board[1][0] == ('X') &&
                board[2][0] == ('X');

        boolean xWinVertical2 = board[0][1] == ('X') &&
                board[1][1] == ('X') &&
                board[2][1] == ('X');

        boolean xWinVertical3 = board[0][2] == ('X') &&
                board[1][2] == ('X') &&
                board[2][2] == ('X');

        // >>> O win conditions <<<

        // True if the indexes that are building the diagonal line from top left to bottom right
        // or from top right to bottom left are "O"
        boolean oWinLeftDiagonal = board[0][0] == ('O') &&
                board[1][1] == ('O') &&
                board[2][2] == ('O');

        boolean oWinRightDiagonal = board[0][2] == ('O') &&
                board[1][1] == ('O') &&
                board[2][0] == ('O');

        // True if the indexes that are building horizontal lines left to right are "O"
        boolean oWinHorizontal1 = board[0][0] == ('O') &&
                board[0][1] == ('O') &&
                board[0][2] == ('O');

        boolean oWinHorizontal2 = board[1][0] == ('O') &&
                board[1][1] == ('O') &&
                board[1][2] == ('O');

        boolean oWinHorizontal3 = board[2][0] == ('O') &&
                board[2][1] == ('O') &&
                board[2][2] == ('O');

        // True if the indexes that are building vertical lines top to bottom are "O"
        boolean oWinVertical1 = board[0][0] == ('O') &&
                board[1][0] == ('O') &&
                board[2][0] == ('O');

        boolean oWinVertical2 = board[0][1] == ('O') &&
                board[1][1] == ('O') &&
                board[2][1] == ('O');

        boolean oWinVertical3 = board[0][2] == ('O') &&
                board[1][2] == ('O') &&
                board[2][2] == ('O');

        // Returns the letter of the winner, depending on the previous
        // boolean conditions.
        if (xWinLeftDiagonal || xWinRightDiagonal ||
                xWinHorizontal1 || xWinHorizontal2 ||
                xWinHorizontal3 || xWinVertical1 ||
                xWinVertical2 || xWinVertical3) {
            return 'X';
        }

        if (oWinLeftDiagonal || oWinRightDiagonal ||
                oWinHorizontal1 || oWinHorizontal2 ||
                oWinHorizontal3 || oWinVertical1 ||
                oWinVertical2 || oWinVertical3) {
            return 'O';
        }

        // --- Draw condition ---
        int X = 0;
        int O = 0;

        for (char[] c : board) {
            for (char ch : c) {
                if (ch == 'X') {
                    X++;
                } else if (ch == 'O') {
                    O++;
                }
            }
        }

        if (X + O == 9) {
            return 'd';
        }

        // --- Game goes on condition ---
        return ' ';
    }

    public static void printWinner(String gameLoopWinner) {
        System.out.println(gameLoopWinner);
    }
}
/*
00         ___
01      __(_  )___
02    _(          )
03   (     )-----`        |----______________,
04    `---'               |    Kabraxis '22 /
05                        |---____________/
06                        |
07                        X                     \,/
08                       /~\
09                      /~~~\                         /`\
10                     /~~~~~\
11      |---____,     /~~~~~~~\             |---____,
12      |--____/     /~~~~~~~~~\            |--____/
13      |           /~~~~~~~~~~~\           |
14      X           |     .   .:|           X
15     /~\          |   _   _   |          /~\
16    /~~~\         |  |+| |+|  |         /~~~\
17   /~~~~~\        |  |_| |_|  |        /~~~~~\
18   | :   |      __|           |__      | :   |
19   |.:   |____| ; .           . ; |____|.:   |
20   |  _    .        __________       .    _  |
21   | |+| |.  ==   /            \  ==  .| |+| |
22   | |_|   .     /              \    .   |_| |
23   |     |:  ,  |    * 1 2 3 *   | ,  :|     |
24   | .   |  |   |    ---------   |  |  |   . |
25   |     |  |   |  >1| _ _ _ |   |  |  |     |
26   |-    |  |   |  >2| _ _ _ |   |  |  |    -|
27   _ _   |  |   |  >3| _ _ _ |   |  |  |  _  |
28    '--~~__ |   |    ---------   |  | _|_    |
29           ~---___________________---~   ~`---,
30                                               ~~----____-~
*/