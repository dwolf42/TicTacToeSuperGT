/*
 * 11.01.2022 - 1:13 p.m. - by Kabraxis Luvos
 */
import java.util.Scanner;
import java.util.Arrays;


public class Main {
    // Defines which row aka. castle art to print.
    static int castleArtRow = 0; // Default 0, 1 & 2 only for winner's cheer.

    static String[] castleArtDynamicCloud = {

            // Castle Art: Basic - Row 0

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
            // Castle Art: Fireworks 1 - Row 1
            // Contains: Upper Castle part & Horse's upper head, Knight's upper body & sword

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
            // Castle Art: Fireworks 2 - Row 2
            // Contains: Upper Castle part & Horse's upper head, Knight's upper body & sword

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

            // Castle Art: Left side - Row 0
            // Contains: Left Castle wall & Board rows

                    /*25 1/2*/ "   |     |  |   |  >1| ",
                    /*26 1/2*/ "   |-    |  |   |  >2| ",
                    /*27 1/2*/ "   _ _   |  |   |  >3| "
            };

    static String[] castleArtFixedRightSide = {
            // Castle Art: Right side - Row 1
            // Contains: Right Castle wall, Horse's body, Knight's legs & Bottom part

                    /*25 2/2*/ "|   |  |  |     |          /' _,  /._/|__K",
                    /*26 2/2*/ "|   |  |  |    -|          `~~ -,   // '~~~\\;;,",
                    /*27 2/2*/ "|   |  |  |  _  |             ,_( _||_..\\ L| ';;"
            };

    static String[] castleArtFixedLowerSide = {
            // Castle Art: Lower side - Row 2
            // Contains: Castle Gate, Way to Castle, Horse's legs

                    /*28*/ "    '--~~__ |   |    ---------   |  | _|_    |            / ~|/ ~' `\\<\\>   ;;",
                    /*29*/ "           ~---___________________---~   ~`---,          /   |      /  |   ;",
                    /*30*/ "                                               ~~----____\"~--|~~----/__|____---____-~---~~--",
                    /*31*/ "                  ~----__                                    \"     \"   \"",
                    /*32*/ "                        `~~----____-~---~~----____-~"
    };

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
                {'_', '_', '_'}
        };

        printArrayBoardGameEnds(board);
    }

    public static void printArrayBoardGameEnds(char[][] board) {

        // Prints castleArtDynamicCloud
        for (String castleArt : castleArtDynamicCloud ) {
            System.out.println(castleArt);
            }

        // Prints the game board
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
}
