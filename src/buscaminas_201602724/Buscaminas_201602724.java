
package buscaminas_201602724;


import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


public class Buscaminas_201602724{
    public static char[][] matriz = new char[20][20];
    public static char[][] matriz2 = new char[20][20];
    public static int filas = 0;
    public static int columnas = 0;
    public static int minas = 0;
    public static int m1 = 0;
    public static int m2 = 0;
    public static int ganar = 0;
    public static boolean fipartida = false;
    public static boolean debug = false;
    public static int count = 0;
    public static boolean fi = false;
    int z;
    int in;


        public static void main(String[] args) throws IOException  {
       
        while (!fi) {
            count = 0;
            fipartida = false;
            mostrarMenu();
            iniciaTablero();
            imTablero(filas, columnas, matriz2);
            System.out.println("");
            
            
            introMovim();
            intrMinas();
            checkMinas();
            recursivDestapa(m1, m2);
            while (!fipartida) {
                if (debug) {
                    imTablero(filas, columnas, matriz);
                    System.out.println("");
                }
                imTablero(filas, columnas, matriz2);
                System.out.println("");
               
               
                System.out.println("");
                introMovim();
                recursivDestapa(m1, m2);
            }
        }
        

    }
   
            
        
    public static void mostrarMenu() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Luis Canel");
        System.out.println("201602724");
        System.out.println("IPC1 'A' Practica 1 ");
        System.out.println("BUSCAMINAS!");    
        System.out.println("Presione enter para continuar");
        char inicio = (char)System.in.read();
        System.out.println("BUSCAMINAS");
        System.out.println("=========================");
        System.out.println("Menu:");
        System.out.println("1. Principiante");
        System.out.println("2. Intermedio");
        System.out.println("3. Experto");
        System.out.println("4. Salir");
        System.out.println("");
        System.out.print("Ingrese opcion: ");
        int opcion = sc.nextInt();
        System.out.println("");
        switch (opcion) {
            case 1:
                filas = 5;
                columnas = 5;
                minas = 4;
                ganar = (4 * 4) - 4;

                break;
            case 2:
                filas = 7;
                columnas = 7;
                minas = 8;
                ganar = (6 * 6) - 8;
                break;
            case 3:
                filas = 9;
                columnas = 9;
                minas = 12;
                ganar = (8 * 8) - 12;
                break;
            case 4:
                fi = true;
                System.exit(0);
                break;
            default:
                System.out.println("Introduce una opción valida!!");
                break;
        }
    }


    public static void imTablero(int length, int length0, char[][] matriz) {
        System.out.println("Tablero de juego");
        for (int i = 1; i < length; i++) {
            if (i == 1) {
                System.out.println("---------------------------------");
            }
            System.out.printf("%4s", i + " ");
            for (int j = 1; j < length0; j++) {
                System.out.printf("%s", "|" + matriz[i][j] + "|");
            }
            if (i == length ) {
                System.out.println("");
                for (int j = 0; j < columnas; j++) {
                    if (j == 0) {
                        System.out.print("    ");
                    }
                    System.out.printf("%3s", j + " ");
                }
            }
            System.out.println("");
        }
    }


    public static int randNumero(int sup) {
        Random rnd = new Random();
        int num = (int) (Math.random() * sup);
        return num;
    }

    public static void iniciaTablero() {
        for (int l = 0; l < filas; l++) {
            for (int m = 0; m < columnas; m++) {
                matriz2[l][m] = 'x';
            }
        }
        for (int l = 0; l < filas; l++) {
            for (int m = 0; m < columnas; m++) {
                matriz[l][m] = 'x';
            }
        }
    }


    public static void intrMinas() {
        boolean full = false;
        int i = 0;
        out:
        while (i <= minas) {
            for (int j = 1; j < filas; j++) {
                for (int k = 1; k < columnas; k++) {
                    int mina = randNumero(columnas);
                    if ((k == mina) && (matriz[j][k] == 'x') && (j != m1 && k != m2)) {
                        matriz[j][k] = '*';
                        ++i;
                        if (i == minas) {
                            break out;
                        }
                    }
                }
            }
        }
    }


    public static void checkMinas() {
        int c = 0;
        for (int n = 2; n <= matriz.length - 2; ++n) {
            for (int o = 2; o <= matriz[0].length - 2; ++o) {
                c = 0;
                if ((matriz[n + 1][o + 1] == '*') && (matriz[n][o] == 'x')) {
                    ++c;
                }
                if ((matriz[n - 1][o - 1] == '*') && (matriz[n][o] == 'x')) {
                    ++c;
                }
                if ((matriz[n - 1][o + 1] == '*') && (matriz[n][o] == 'x')) {
                    ++c;
                }
                if ((matriz[n + 1][o - 1] == '*') && (matriz[n][o] == 'x')) {
                    ++c;
                }
                if ((matriz[n - 1][o] == '*') && (matriz[n][o] == 'x')) {
                    ++c;
                }
                if ((matriz[n + 1][o] == '*') && (matriz[n][o] == 'x')) {
                    ++c;
                }
                if ((matriz[n][o + 1] == '*') && (matriz[n][o] == 'x')) {
                    ++c;
                }
                if ((matriz[n][o - 1] == '*') && (matriz[n][o] == 'x')) {
                    ++c;
                }
                if (matriz[n][o] == 'x') {
                    if (c > 0) {
                        matriz[n][o] = Integer.toString(count).charAt(0);
                    } else if (count == 0) {
                        matriz[n][o] = Integer.toString(count).charAt(0);
                    }
                }
            }
        }
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matriz[i][j] == 'x') {
                    matriz[i][j] = Integer.toString(0).charAt(0);
                }
            }
        }
    }


    public static void introMovim() {
        Scanner sc = new Scanner(System.in);
        boolean valid = false;
        int h = 0;
        while (!valid) {
            System.out.println("V: Voltear");
            System.out.println("R: Reiniciar");
            System.out.println("S: Salir");
            System.out.println("Introduce tu movimiento!");
            System.out.print("Introduce la fila ");
            m1 = sc.nextInt();
            System.out.print("Introduce la columna ");
            m2 = sc.nextInt();
            System.out.println("");

            System.out.println("Ingresar opcion");
            switch(h){
                
                case 1:
                    
                    break;
                case 2:     
                    break;
                case 3:
                    System.exit(0);
                    break;
                   
            }    
            if ((m1 < filas && m2 < columnas) && (m1 > 0 && m2 > 0)) {
                valid = true;
            } else {
                valid = false;
            }

                
            }

    }

    public static void recursivDestapa(int casilla, int casilla2) {
        int casi = m1;
        int casi2 = m2;
        if (casilla > filas - 1 || casilla < 0 || casilla2 > columnas - 1 || casilla2 < 0) {
            return;
        }
        if (matriz[casi][casi2] == '*') {
            fipartida = true;
            System.out.println("Perdiste!!");
            System.out.println("");
            
        } else if (matriz[casilla][casilla2] == '0') {
            if (matriz2[casilla][casilla2] != matriz[casilla][casilla2]) {
                matriz2[casilla][casilla2] = matriz[casilla][casilla2];
                ++count;
                recursivDestapa(casilla + 1, casilla2);
                recursivDestapa(casilla, casilla2 + 1);
                recursivDestapa(casilla + 1, casilla2 + 1);
            }
            if (casilla > filas - 1 || casilla < 0 || casilla2 > columnas - 1 || casilla2 < 0) {
                recursivDestapa(casilla, casilla2 - 1);
                recursivDestapa(casilla - 1, casilla2);
                recursivDestapa(casilla - 1, casilla2 - 1);
                recursivDestapa(casilla - 1, casilla2 + 1);
                recursivDestapa(casilla + 1, casilla2 - 1);
            }
        } else if ((matriz[casilla][casilla2] > '0')) {
            if (matriz2[casilla][casilla2] != matriz[casilla][casilla2]) {
                matriz2[casilla][casilla2] = matriz[casilla][casilla2];
                ++count;
            }
        }
        if (count == ganar) {
            System.out.println("Ganaste!!");
            fipartida = true;
        }
    }


    
}
