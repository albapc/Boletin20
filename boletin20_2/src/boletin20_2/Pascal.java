package boletin20_2;

import javax.swing.JOptionPane;

public class Pascal {

    public static final int filas = 0;
    private static int max = 0;

    public void mostrarPiramide() {
        int filas = Integer.parseInt(JOptionPane.showInputDialog("Introducir num de filas"));
        int[][] pascal = new int[filas + 1][];
        pascal[1] = new int[1 + 2];
        pascal[1][1] = 1;
        for (int i = 2; i <= filas; i++) {
            pascal[i] = new int[i + 2];
            for (int j = 1; j < pascal[i].length - 1; j++) {
                pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
                String str = Integer.toString(pascal[i][j]);
                int longitud = str.length();
                if (longitud > max) {
                    max = longitud;
                }
            }
        }

        for (int i = 1; i <= filas; i++) {
            for (int k = filas; k > i; k--) {
                System.out.format("%-" + max + "s", " ");
            }
            for (int j = 1; j < pascal[i].length - 1; j++) {
                System.out.format("%-" + (max + max) + "s", pascal[i][j]);
            }
            System.out.println();
        }
    }
}
