package lab9p1_andreaortez;

import java.util.ArrayList;

public class Game {

    private int[][] tab1;
    private int[][] tab2;
    private ArrayList<String> list;
    private int rondas;

    public Game() {

    }

    public int[][] getTab1() {
        return tab1;
    }

    public void setTab1(int[][] tab1) {
        this.tab1 = tab1;
    }

    public int[][] getTab2() {
        return tab2;
    }

    public void setTab2(int[][] tab2) {
        this.tab2 = tab2;
    }

    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    public int getRondas() {
        return rondas;
    }

    public void setRondas(int rondas) {
        this.rondas = rondas;
    }

    public void jugar(int rondas) {
        for (int i = 0; i < rondas; i++) {
            System.out.println("Ronda " + (i + 1) + ":\n");
            nextGen();
            System.out.println("Coordenadas de celdas vivas:\n" + list + "\n");
            print(list);
        }
    }

    public void nextGen() {
        list.clear();
        int cont1, cont2;
        //Vecinos
        for (int i = 0; i < tab1.length; i++) {//Casillas [1]
            for (int j = 0; j < tab1[0].length; j++) {
                cont1 = -1;//Inicia en -1 porque cuenta el 1 del medio
                if (tab1[i][j] == 1) {
                    for (int x = -1; x <= 1; x++) {
                        for (int y = -1; y <= 1; y++) {
                            if (tab1[x + i][y + j] == 1) {
                                cont1++;
                            }
                        }
                    }
                }
                if (tab1[i][j] == 1 && cont1 < 2) {//Validación
                    tab2[i][j] = 0;
                } else if (tab1[i][j] == 1 && cont1 > 3) {
                    tab2[i][j] = 0;
                } else if (tab1[i][j] == 1 && cont1 == 2) {
                    tab2[i][j] = 1;
                }
            }
        }
        for (int i = 1; i < tab1.length-1; i++) {//Casillas [0]
            for (int j = 1; j < tab1[0].length-1; j++) {
                cont2 = 0;
                if (tab1[i][j] == 0) {
                    for (int x = -1; x <= 1; x++) {
                        for (int y = -1; y <= 1; y++) {
                            if (tab1[x + i][y + j] == 1) {
                                cont2++;
                            }
                        }
                    }
                }
                if (tab1[i][j] == 0 && cont2 == 3) {//Validación
                    tab2[i][j] = 1;
                }
                if (tab2[i][j] == 1) {
                    list.add(Integer.toString(i) + ":" + Integer.toString(j));
                }
            }
        }
        int[][] temp;
        temp = tab1;
        tab1 = tab2;
        tab2 = temp;
    }

    public void print(ArrayList<String> list) {
        int x, y;
        int[][] temp = new int[10][10];

        for (int i = 0; i < list.size(); i++) {
            String cadena = list.get(i);
            String[] arr = cadena.split(":");
            //[1],[1]
            x = Integer.parseInt(arr[0]);
            y = Integer.parseInt(arr[1]);
            temp[x][y] = 1;
        }
        String cad = "";
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                cad += "[" + temp[i][j] + "]" + " ";
            }
            cad += "\n";
        }
        System.out.println(cad);
    }
}
