import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static String[][] tab = new String[3][3];
    static int[] p1Play = {4, 4};
    static int[] p2Play = {4, 4};

    public static void updateTable(@NotNull String player, int pos1, int pos2) {
        if(tab[pos1][pos2] != null) {
            return;
        }

        if (player.equals("p1")) {
            tab[pos1][pos2] = "X";
        } else if (player.equals("p2")) {
            tab[pos1][pos2] = "O";
        } else {
            System.exit(0);
        }
    }

    public static void printTable() {
        for (String[] ints : tab) {
            for (String string : ints) {
                System.out.print(string + "   ");
            }
            System.out.println();
        }
    }

    public static void play() {
        while (p1Play[0] > 2 || p1Play[1] > 2) {
            System.out.println("[Jogador 1] Escreva a posição 1 onde quer jogar: ");
            p1Play[0] = scanner.nextInt();
            System.out.println("[Jogador 1] Escreva a posição 2 onde quer jogar: ");
            p1Play[1] = scanner.nextInt();
        }

        updateTable("p1", p1Play[0], p1Play[1]);
        printTable();

        // reset p1Play for the next iteration
        p1Play = new int[]{4, 4};

        while (p2Play[0] > 2 || p2Play[1] > 2) {
            System.out.println("[Jogador 2] Escreva a posição 1 onde quer jogar: ");
            p2Play[0] = scanner.nextInt();
            System.out.println("[Jogador 2] Escreva a posição 2 onde quer jogar: ");
            p2Play[1] = scanner.nextInt();
        }

        updateTable("p2", p2Play[0], p2Play[1]);
        printTable();

        p2Play = new int[]{4, 4};
    }

    public static void main(String[] args) {
        printTable();
        for (int i = 0; i < 9; i++) {
            play();
        }
    }
}