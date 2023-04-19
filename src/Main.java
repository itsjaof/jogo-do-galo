import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static String[][] tab = new String[3][3];
    static int[] p1Play = {4, 4};
    static int[] p2Play = {4, 4};
    static boolean end = false;

    public static boolean checkPlay(String player) {
        for (int i = 0; i < 3; i++) {
            if (tab[i][0] == player && tab[i][1] == player && tab[i][2] == player) {
                end = true;
                return true;
            }
        }

        for (int j = 0; j < 3; j++) {
            if (tab[0][j] == player && tab[1][j] == player && tab[2][j] == player) {
                end = true;
                return true;
            }
        }

        if (tab[0][0] == player && tab[1][1] == player && tab[2][2] == player) {
            end = true;
        }
        if (tab[0][2] == player && tab[1][1] == player && tab[2][0] == player) {
            end = true;
            return true;
        }

        return false;
    }

    public static void updateTable(@NotNull String player, int pos1, int pos2) {
        /*
            Check if the board place is filled
        */
        if(tab[pos1][pos2] != null) {
            return;
        }

        /*
            Deciding what symbol place
        */
        if (player.equals("p1")) {
            tab[pos1][pos2] = "X";
        } else if (player.equals("p2")) {
            tab[pos1][pos2] = "O";
        } else {
            System.exit(0);
        }
    }

    public static void printTable() {
        /*
            Printing table logic
        */
        for (String[] ints : tab) {
            for (String string : ints) {
                System.out.print(string + "   ");
            }
            System.out.println();
        }
    }

    public static void play() {
        /*
            Making a play
        */
        while (!(p1Play[0] <= 2) | !(p1Play[1] <= 2)) {
            System.out.println("[Jogador 1] Escreva a posição 1 onde quer jogar: ");
            p1Play[0] = scanner.nextInt();
            System.out.println("[Jogador 1] Escreva a posição 2 onde quer jogar: ");
            p1Play[1] = scanner.nextInt();
        }

        updateTable("p1", p1Play[0], p1Play[1]);
        printTable();

        while (!(p2Play[0] <= 2) | !(p2Play[1] <= 2)) {
            System.out.println("[Jogador 2] Escreva a posição 1 onde quer jogar: ");
            p2Play[0] = scanner.nextInt();
            System.out.println("[Jogador 2] Escreva a posição 2 onde quer jogar: ");
            p2Play[1] = scanner.nextInt();
        }

        updateTable("p2", p2Play[0], p2Play[1]);
        printTable();
    }

    public static void main(String[] args) {
        while (!end) {
            printTable();
            play();
        }
    }
}