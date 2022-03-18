/*
 * 11.01.2022 - 1:13 p.m. - by Kabraxis Luvos
 */

import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public class Main {
    // Game always starts with player X
    static char currentPlayer = 'X';

    static String[] castleArtDynamicCloud = {
            // Castle Art: Cloud
            // Contains: Upper castle part, cloud & horse's upper head, knight's upper body & sword
            /*00*/ "         ___",
            /*01*/ "      __(_  )___",
            /*02*/ "    _(          )",
            /*03*/ "   (     )-----´        |----______________,",
            /*04*/ "    `---'               |    Kabraxis '22 /",
            /*05*/ "                        |---____________/",
            /*06*/ "                        |",
            /*07*/ "                        X                     \\,/",
            /*08*/ "                       /~\\",
            /*09*/ "                      /~~~\\                        /`\\",
            /*10*/ "                     /~~~~~\\",
            /*11*/ "      |---____,     /~~~~~~~\\             |---____,",
            /*12*/ "      |--____/     /~~~~~~~~~\\            |--____/",
            /*13*/ "      |           /~~~~~~~~~~~\\           |",
            /*14*/ "      X           |     .   .:|           X",
            /*15*/ "     /~\\          |   _   _   |          /~\\",
            /*16*/ "    /~~~\\         |  |+| |+|  |         /~~~\\",
            /*17*/ "   /~~~~~\\        |  |_| |_|  |        /~~~~~\\",
            /*18*/ "   | :   |      __|           |__      | :   |                           |",
            /*19*/ "   |.:   |____| ; .           . ; |____|.:   |                           |",
            /*20*/ "   |  _    .        __________       .    _  |                           |",
            /*21*/ "   | |+| |.  ==   /            \\  ==  .| |+| |                        / -+-",
            /*22*/ "   | |_|   .     /              \\    .   |_| |                       {).//",
            /*23*/ "   |     |: ,   |    * 1 2 3 *   |  , :|     |                   c==// )",
            /*24*/ "   | .   |  |   |    ---------   |  |  |   . |           -^~~-_./   | |"
    };

    static String[] castleArtDynamicFireworksA = {
            // Castle Art: Fireworks A
            // Contains: Upper castle part & horse's upper head, knight's upper body & sword

            /*00*/ "                           .",
            /*01*/ "                         _\\(/_  .:.",
            /*02*/ "       .''.      .       ./)\\,  ':'",
            /*03*/ "      :_\\/_:   _\\(/_    |----______________,    .''.",
            /*04*/ "  .''.: /\\ :   ./)\\     |    Kabraxis '22 /    :_\\/_:     .",
            /*05*/ " :_\\/_:'.:::.      `    |---____________/      : /\\ :  .'.:.'.",
            /*06*/ " : /\\ : :::::       `   |       `            :  '..'.  -=:o:=-",
            /*07*/ "  '..'  ':::'        `  X        `        '.\\'/.' _\\(/_'.':'.'",
            /*08*/ "      ' ,              /~\\                -= o =-  /)\\  , '",
            /*09*/ "       '        .:.   /~~~\\       *''*    .'/.\\'.   '  ,",
            /*10*/ "       '        ':'  /~~~~~\\  .:.*_\\/_*     :      ' ,",
            /*11*/ "      |---____,  '  /~~~~~~~\\ ':'* /\\ *   |---____, ',",
            /*12*/ "      |--____/   ' /~~~~~~~~~\\    *''*    |--____/  ,",
            /*13*/ "      |          '/~~~~~~~~~~~\\    ,      |",
            /*14*/ "      X           |     .   .:|   ,       X",
            /*15*/ "     /~\\          |   _   _   |  ,       /~\\     .* *.",
            /*16*/ "    /~~~\\         |  |+| |+|  |         /~~~\\    *. .*",
            /*17*/ "   /~~~~~\\        |  |_| |_|  |        /~~~~~\\     *",
            /*18*/ "   | :   |      __|           |__      | :   |    ,           \\",
            /*19*/ "   |.:   |____| ; .           . ; |____|.:   |   ,             \\",
            /*20*/ "   |  _    .        __________       .    _  |  ,               \\",
            /*21*/ "   | |+| |.  ==   /            \\  ==  .| |+| |                   +    /",
            /*22*/ "   | |_|   .     /              \\    .   |_| |                    \\\\.{)",
            /*23*/ "   |     |: ,   |    * 1 2 3 *   |  , :|     |                   c==// )",
            /*24*/ "   | .   |  |   |    ---------   |  |  |   . |           -^~~-_./   | |"
    };

    static String[] castleArtDynamicFireworksB = {
            // Castle Art: Fireworks B
            // Contains: Upper castle part & horse's upper head, knight's upper body & sword

            /*00*/ "                         .",
            /*01*/ "      . .               -:-",
            /*02*/ "    .'.:,'.              '\\",
            /*03*/ "    .'.;.`.     .  .  . |----______________,   :",
            /*04*/ "     `.:.'     ._. ! ._.|    Kabraxis '22 / '.\\'/.'",
            /*05*/ "                ._\\!/_. |---____________/   -= o =-",
            /*06*/ "   .'.;.`.       . ! .  |                   .'/.\\'.",
            /*07*/ "    `,:.'          .    X                      :",
            /*08*/ "     ,'            .   /~\\      .  .  .",
            /*09*/ "    ,              .  /~~~\\    . \\ | / .",
            /*10*/ "   ,                 /~~~~~\\   .__\\:/__.",
            /*11*/ "      |---____,     /~~~~~~~\\    .';`.    |---____,",
            /*12*/ "      |--____/     /~~~~~~~~~\\    ,       |--____/",
            /*13*/ "      |           /~~~~~~~~~~~\\  ,        |",
            /*14*/ "      X     .     |     .   .:|   ,.,     X",
            /*15*/ "     /~\\   -:-    |   _   _   |  ._!_.   /~\\",
            /*16*/ "    /~~~\\   ' .   |  |+| |+|  |    ;    /~~~\\",
            /*17*/ "   /~~~~~\\     \\  |  |_| |_|  |        /~~~~~\\     . ' .",
            /*18*/ "   | :   |      __|           |__      | :   |      .:.       \\",
            /*19*/ "   |.:   |____| ; .           . ; |____|.:   |      '          \\",
            /*20*/ "   |  _    .        __________       .    _  |     /            \\",
            /*21*/ "   | |+| |.  ==   /            \\  ==  .| |+| |                   +    /",
            /*22*/ "   | |_|   .     /              \\    .   |_| |                    \\\\.{)",
            /*23*/ "   |     |: ,   |    * 1 2 3 *   |  , :|     |                   c==// )",
            /*24*/ "   | .   |  |   |    ---------   |  |  |   . |           -^~~-_./   | |"
    };

    static String[] castleArtFixedLeftSide = {
            // Castle Art: Left side
            // Contains: Left castle wall & board rows

            /*25 1/2*/ "   |     |  |   |  >1| ",
            /*26 1/2*/ "   |-    |  |   |  >2| ",
            /*27 1/2*/ "   _ _   |  |   |  >3| "
    };

    static String[] castleArtFixedRightSide = {
            // Castle Art: Right side
            // Contains: Right castle wall, horse's body, knight's legs & bottom part

            /*25 2/2*/ "|   |  |  |     |          /' _,  /._/|__K",
            /*26 2/2*/ "|   |  |  |    -|          `~~ -,   // '~~~\\;;,",
            /*27 2/2*/ "|   |  |  |  _  |             ,_( _||_..\\ L| ';;"
    };

    static String[] castleArtFixedLowerSide = {
            // Castle Art: Lower side
            // Contains: Castle gate, way to castle, horse's legs

            /*28*/ "    '--~~__ |   |    ---------   |  | _|_    |            / ~|/ ~' `\\<\\>   ;;",
            /*29*/ "           ~---___________________---~   ~`---,          /   |      /  |   ;",
            /*30*/ "                                               ~~----____\"~--|~~----/__|____---____-~---~~--",
            /*31*/ "                  ~----__                                    \"     \"   \"",
            /*32*/ "                        `~~----____-~---~~----____-~"
    };

    public static void main(String[] args) throws InterruptedException {
        char[][] board = {
                // 1,1   1,2  1,3 <- locations entered by user
                // 0,0   0,1  0,2 <- locations by index counting of an array
                {'_', '_', '_'},
                // 2,1   2,2  2,3
                // 1,0   1,1  1,2
                {'_', '_', '_'},
                // 3,1   3,2  3,3
                // 2,0   2,1  2,2
                {'_', '_', '_'}
        };

        howToPlay();

        gameLoop(board);
    }

    public static void howToPlay() {


    }

    public static void gameLoop(char[][] board) throws InterruptedException {
        Scanner pauseGame = new Scanner(System.in);

        char winner = checkWinconditions(board);

        printArrayBoardArtGameRuns(board);

        if (winner == 'd') {
            printWinner("Draw", board);
            pauseGame.nextLine();
            return;
        }
        if (winner == 'X') {
            printWinner("X wins", board);
            pauseGame.nextLine();
            return;
        }
        if (winner == 'O') {
            printWinner("O wins", board);
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

    public static void printArrayBoardArtGameRuns(char[][] board) {
        for (String castleArt : castleArtDynamicCloud) {
            System.out.println(castleArt);
        }

        for (int i = 0; i < board.length; i++) {
            System.out.print(castleArtFixedLeftSide[i]); //
            for (int j = 0; j < board[1].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.print(castleArtFixedRightSide[i]);
            System.out.println();
        }

        for (String castleArt : castleArtFixedLowerSide) {
            System.out.println(castleArt);
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

    public static void printWinner(String fromGameLoopWinningLetter, char[][] board) throws InterruptedException {
        for (String castleArt : castleArtDynamicFireworksA) {
            System.out.println(castleArt);
        }

        for (int i = 0; i < board.length; i++) {
            System.out.print(castleArtFixedLeftSide[i]); //
            for (int j = 0; j < board[1].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.print(castleArtFixedRightSide[i]);
            System.out.println();
        }

        for (String castleArt : castleArtFixedLowerSide) {
            System.out.println(castleArt);
        }

        // Prints out who is the winner
        System.out.println(fromGameLoopWinningLetter);

        pauseAndClearScreen(2, 100);

        for (String castleArt : castleArtDynamicFireworksB) {
            System.out.println(castleArt);
        }

        for (int i = 0; i < board.length; i++) {
            System.out.print(castleArtFixedLeftSide[i]); //
            for (int j = 0; j < board[1].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.print(castleArtFixedRightSide[i]);
            System.out.println();
        }

        for (String castleArt : castleArtFixedLowerSide) {
            System.out.println(castleArt);
        }

        // Prints out who is the winner
        System.out.println(fromGameLoopWinningLetter);
    }

    // This area is for style purposes. It's used to pause the game for n seconds and/or clear the screen
    public static void pauseAndClearScreen(int pauseSeconds, int clearLines) throws InterruptedException {

        TimeUnit.SECONDS.sleep(pauseSeconds);

        for (int i = 0; i <= clearLines; i++) {
            System.out.println();
        }

    }
}
