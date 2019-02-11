package boletin20_1;

import javax.swing.JOptionPane;

public class Boletin20_1 {

    public static void main(String[] args) {
        int[][] matriz = {{20, 13, 11, 2}, {2, 5, 8, 9}, {6, 1, 5, 8}, {7, 8, 4, 6}};

        Partidos xornadas = new Partidos();

//        xornadas.crearTabla();
//        xornadas.mostrar();
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(""
                + "**********MENÚ**********\n"
                + "Introduce una opción:\n"
                + "1.- Ver tabla de goles de equipos\n"
                + "2.- Ver goles de equipos de menor a mayor\n"
                + "3.- Ver qué equipo marcó más goles por jornada\n"
                + "4.- Ver equipo y jornada en la que se marcaron más goles\n"
                + "5.- Buscar goles por equipo y jornada"));

        do {
            switch (opcion) {
//                opcion 1
                case 1:
                    xornadas.ver(matriz);
                    break;
                //opcion 2
                case 2:
                    xornadas.mostrarEquiposMenosGoles(matriz);
                    xornadas.ordenarGolesEquipos(matriz);
                    break;
//                opcion 3
                case 3:
                    xornadas.equipoMasGolesJornada(matriz);
                    break;
//                opcion 4
                case 4:
                    xornadas.recordGoles(matriz);
                    break;
//                opcion 5
                case 5:
                    xornadas.buscarEquipos(matriz);
                    break;
            }
        } while (opcion < 6);
    }

}
