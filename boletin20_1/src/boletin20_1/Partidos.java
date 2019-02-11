package boletin20_1;

import java.util.Arrays;
import javax.swing.JOptionPane;

public class Partidos {

    private String[] equipos = {"Celta", "Depor", "Malaga", "Atleti"};

    private String[] xornadas = {"1", "2", "3", "4"};

    private int filas = 4, columnas = 4;
    private int[][] goles = new int[filas][columnas];
    private int[] suma = new int[goles.length];

    public void crearTabla() {
        for (int f = 0; f < goles.length; f++) {
            for (int c = 0; c < goles[f].length; c++) {
                goles[f][c] = Integer.parseInt(JOptionPane.showInputDialog("Introducir número de goles"));
            }
        }
    }

    public void mostrar() {
        System.out.print("equ/xor ");
        for (int i = 0; i < goles.length; i++) {
            System.out.print(xornadas[i] + " ");
        }
        System.out.print("\n");

        for (int f = 0; f < goles.length; f++) {
            System.out.print(equipos[f] + " | ");
            for (int c = 0; c < goles[f].length; c++) {
                System.out.print(goles[f][c] + " ");
            }
            System.out.print("|\n");
        }
    }

    public void ver(int matriz[][]) {
        int filas = matriz.length; //me da el numero de filas
        int columnas = matriz[0].length; //numero de columnas, sub-0 porque todas son iguales
        System.out.print("equ/xor ");
        for (int i = 0; i < matriz[0].length; i++) {
            System.out.print(xornadas[i] + " ");
        }
        System.out.print("\n");
        ;
        for (int f = 0; f < filas; f++) {
            System.out.print(equipos[f] + " | ");
            for (int c = 0; c < columnas; c++) {

                System.out.print(matriz[f][c] + " ");
            }
            System.out.print("|\n");
        }
    }

    public void mostrarEquiposMenosGoles(int[][] goles) {
        int acu, f, c;
        for (f = 0; f < goles.length; f++) {
            acu = 0;
            for (c = 0; c < goles[f].length; c++) {
                acu = acu + goles[f][c];
            }
            suma[f] = acu;
//            System.out.println("suma: " + suma[f]);
        }
    }

    public void ordenarGolesEquipos(int[][] goles) {
        int aux, aux2;
        String auxnom;
        for (int i = 0; i < suma.length; i++) {
            for (int j = i + 1; j < suma.length; j++) {
                if (suma[i] > suma[j]) { //ordena los datos de menor a mayor
                    aux = suma[i];
                    auxnom = equipos[i];
                    suma[i] = suma[j];

                    equipos[i] = equipos[j];
                    suma[j] = aux;
                    equipos[j] = auxnom;

                    for (int k = 0; k < goles[i].length - j; k++) {
                        if (goles[i][k] > goles[j][k]) {
                            aux2 = goles[i][k];
                            goles[i][k] = goles[j][k];
                            goles[j][k] = aux2;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < goles.length; i++) {
            System.out.println(equipos[i] + " => " + suma[i]);
        }
    }

    public void equipoMasGolesJornada(int[][] goles) {
        int max, f;
        String auxnom = null, aux2 = null;
        for (int c = 0; c < goles[0].length; c++) {
            max = goles[0][c];
            aux2 = xornadas[c];
            for (f = 0; f < goles.length; f++) {
                if (goles[f][c] > max) {
                    max = goles[f][c];
                    auxnom = equipos[f];
                }
            }

            System.out.println("Jornada " + aux2 + ": " + auxnom + " => " + max);
        }

    }

    public void recordGoles(int[][] goles) {

        int max = 0;

        String auxnom = null, auxor = null;
        System.out.println("Equipo/s con mas goles en una sola jornada:");

        for (int i = 0; i < goles.length; i++) {
            for (int j = 0; j < goles[i].length; j++) {
                if (goles[i][j] > max) {
                    auxor = xornadas[j];
                    max = goles[i][j];
                    auxnom = equipos[i];
                }

            }
        }

        System.out.println("Xornada " + auxor + ": " + auxnom + " " + max);
    }

    public void buscarEquipos(int goles[][]) {
        String xornada = JOptionPane.showInputDialog("Introduce el nº de jornada:");
        String equipo = JOptionPane.showInputDialog("Introduce el nombre del equipo:");
        int x = 0, e = 0;
        for (int i = 0; i < equipos.length; i++) {
            if (equipo.equalsIgnoreCase(equipos[i])) {
                e = i;
            }
        }
        for (int i = 0; i < xornadas.length; i++) {
            if (xornada.equals(xornadas[i])) {
                x = i;
            }
        }
        System.out.println("Resultado:\nEquipo: " + equipo + "\nGoles: " + goles[e][x] + "\nXornada nº" + xornada);
    }
}
