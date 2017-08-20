
package buscaminas_201602724;

import java.util.Scanner;


public class menu2 {
    
    int filas =0;
    int columnas =0;
    int minas=0;
    int m1=0;
    int m2=0;
    int ganar=0;
    int matriz[][]= new int[4][4];
    int matriz2[][]= new int[6][6];
    int matriz3[][]= new int[8][8];
    int a;
    public menu2(){
        
        do{
            
        
        Scanner sc = new Scanner(System.in);
        System.out.println("BUSCAMINAS!");
        System.out.println("1. Principiante");
        System.out.println("2. Intermedio");
        System.out.println("3. Experto");
        System.out.println("4. Salir");
        System.out.println("Ingrese opcion:");
        
        int a = sc.nextInt();
        }while(a>4);
        switch(a){
            case  1:
                filas = 4;
                columnas = 4;
                minas = 4;
                ganar= (3*3)-4;
                break;
            case 2:
                filas = 6;
                columnas = 6;
                minas = 6;
                ganar = (5*5)-6;
            case 3:
                filas = 8;
                columnas = 8;
                
                break;
                
        }
}
 
        
    }

