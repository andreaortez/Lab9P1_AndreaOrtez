package lab9p1_andreaortez;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Lab9P1_AndreaOrtez {

    static Random random = new Random();
    static Scanner leer = new Scanner(System.in);
    static Game g = new Game();

    public static void main(String[] args) {
        int opcion = 0;
        int menu = menu(opcion);

        while (menu != 2) {
            switch (menu) {
                case 1: {
                    int [][] tab1 = new int [10][10];
                    int [][] tab2 = new int [10][10];
                    ArrayList<String> list = new ArrayList<>();
                    
                    System.out.print("Ingrese el numero de rondas: ");
                    int rondas = leer.nextInt();
                    g.setRondas(rondas);
                    
                    tab1=llenar(tab1, tab2, list);
                    g.setTab1(tab1);
                    g.setTab2(tab2);
                    g.jugar(rondas);
                }
            }
            menu = menu(opcion);
        }
    }

    public static int menu(int opcion) {
        System.out.println("-- MENU --");
        System.out.println("1-> Game of Life");
        System.out.println("2-> Salir");
        System.out.print("Ingrese una opcion: ");
        opcion = leer.nextInt();

        return opcion;
    }

    public static int [][] llenar (int [][] tab1, int [][] tab2, ArrayList<String> list){
        for (int i = 1; i < tab1.length-1; i++) {
            for (int j = 1; j < tab1[0].length-1; j++) {
                tab1[i][j] = 0 + random.nextInt(2);
                if (tab1[i][j]==1){
                     list.add(Integer.toString(i)+":"+Integer.toString(j));
                }
            }
        }
        g.setList(list);
        System.out.println("\nCoordenadas del tablero inicial:\n" + list + "\n");
        g.print(list);
        return tab1;
    }
            
}
