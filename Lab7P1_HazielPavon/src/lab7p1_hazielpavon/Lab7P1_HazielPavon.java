package lab7p1_hazielpavon;

import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.Random;

public class Lab7P1_HazielPavon {

    static Scanner leer = new Scanner(System.in);
    static Random ran = new Random();

    public static void main(String[] args) {

        boolean seguir = true;
        while (seguir) {

            System.out.println("1. Juego");
            System.out.println("2. Piedra Papel o tijera");
            System.out.println("3. Salir");
            int opcion = leer.nextInt();

            switch (opcion) {

                case 1:

                    int score = 0;
                    int score2 = 0;

                    System.out.println("Ingrese La cantidad de  filas");
                    int n = leer.nextInt();
                    System.out.println("Ingrese la cantidad de columnas");
                    int m = leer.nextInt();
                    int[][] mat = lectura(n, m);
                    print(mat);

                    int bala11 = 1;
                    int bala22 = 1;

                    while (bala11 > 0 && bala22 > 0) {
                        System.out.println("Ingrese cantidad de balas jugador 1");
                        bala11 = leer.nextInt();

                        if (bala11 > m * n / 2) {
                            System.out.println("Ingrese un valor valido de balas");
                            break;
                        } else {
                            System.out.println("Ingrese cantidad de balas Jugador 2");
                        }
                        bala22 = leer.nextInt();

                        if (bala22 > m * n / 2) {
                            System.out.println("Ingrese un valor valido de balas");

                        }
// aqui empiezan los disparos
                        System.out.println("Elige donde disparar jugador 1");
                        int disparo = leer.nextInt();

                        vali2(mat, disparo);
                        score += disparo;
                        print(mat); 
                        

                        if (disparo > 88) {
                            System.out.println("Ingrese un valor valido de balas");
                            break;

                        } else {

                            System.out.println("Elige que numero disparar Jugador 2");
                        }

                        int disparo2 = leer.nextInt();

                        vali1(mat, disparo2);
                        score2 += disparo2;
                        print(mat);
                        if (disparo2 > 88) {
                            System.out.println("Ingrese un valor valido de balas");
                            break;
                        }

                        bala22--;
                        bala11--;
                    }

                    if (score > score2) {
                        System.out.println("El ganador es el jugador 1");
                    } else {
                        System.out.println("El ganador es el jugador 2");
                    }

                    if (score == score2) {
                        System.out.println("Empate");
                    }

                    break;

                case 2:

                    break;

                case 3:

                    seguir = false;

                default:
                    if (opcion > 3) {
                        System.out.println("Ingrese un valor valuido");

                    }

            }

        }

    }

    public static int[][] lectura(int n, int m) {
        int[][] temporal = new int[n][m];

        int num = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                num = 1 + ran.nextInt(n * m);

                while (revisar(temporal, num, n, m)) {
                    num = 1 + ran.nextInt(n * m);
                }
                temporal[i][j] = num;
            }

        }

        return temporal;
    }

    public static boolean revisar(int[][] temporal, int num, int n, int m) {

        boolean repetido = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (num == temporal[i][j]) {

                    repetido = true;
                }

            }
        }

        return repetido;
    }

    public static void print(int[][] matriz) {

        System.out.println("-----Tablero para Jugar-----");

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("[ " + matriz[i][j] + " ]");
            }
            System.out.println("");

        }
    }

    public static int[][] vali2(int[][] matriz, int disparo) {
        boolean dio;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {

                if (disparo == matriz[i][j]) {

                    dio = true;
                    matriz[i][j] = 99;
                    System.out.println("Acerto");
                    break;
                }

            }
        }

        return matriz;

    }

    public static int[][] vali1(int[][] matriz, int disparo2) {

        boolean dio;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {

                if (disparo2 == matriz[i][j]) {
                    dio = true;
                    matriz[i][j] = 88;
                    System.out.println("Acerto");
                    break;

                }

            }
        }
        return matriz;
    }

}
