import java.util.Random;
import java.util.Scanner;
public class Buscaminas {
    static int[][] taulellS;
    static char[][] mines;
    static Scanner filaColumna;

    public static void main(String[] args) {
        MostrarCrearMenu();
        DemanarIComprovar(char[][]taulell);

    }

    private static void MostrarCrearMenu() {
        int OpcioTriada;
        char[][] taulell;
        System.out.println("""
                 ====MENU DE JOC====
                1- Triar Dificultat
                2-Començar Partida
                3- Exit Game""");
        Scanner lector = new Scanner(System.in);
        OpcioTriada = lector.nextInt();

        switch (OpcioTriada) {
            case 1:
                int dificultat = SelectorDificultat();
                taulell = crearTaulell(dificultat);
                mostrarTaulell(taulell);
                System.out.println(" ");
            case 2:
                System.out.println("Començant Partida..." +
                        "\n");
                //DemanarComprovarPosicio(char[][] taulell);

                break;
            case 3:
                System.out.println("Merci per jugar!");
                break;
        }
    }
    private static int SelectorDificultat() {
        Scanner lector = new Scanner(System.in);
        System.out.println("""
                Quina dificultat vols seleccionar:\s
                1- Dificultat Fàcil (8x8[10 mines])\s
                2- Dificultat Intermitja (16x16[40 mines])\s
                3-Dificultat Avançada (20x20 [64 mines])\s
                """);
        int Dificultat = lector.nextInt();
        return Dificultat;
    }
    public static char[][] crearTaulell(int Dificultat) {
        char taulell[][] = new char[0][0];
        int a, b;

        switch (Dificultat) {
            case 1: {
                int nmines = 10;
                int mida = 8;
                boolean mines;

                taulell = new char[8][8];

                for (int j = 0; j < mida; j++) {
                    for (int i = 0; i < mida; i++) {
                        taulell[j][i] = 0;
                    }
                }
                Random randomr = new Random();
                for (int i=0;i<nmines;i++) {
                    a = randomr.nextInt(0, 8);
                    b = randomr.nextInt(0, 8);

                    taulell[a][b] = 1;
                }


                break;
            }
            case 2: {
                int nmines = 40;
                int mida = 16;

                taulell = new char[16][16];

                for (int j = 0; j < mida; j++) {
                    for (int i = 0; i < mida; i++) {
                        taulell[j][i] = 0;
                    }
                }
                Random randomr = new Random();
                for (int i=0;i<nmines;i++) {
                    a = randomr.nextInt(0, 16);
                    b = randomr.nextInt(0, 16);

                    taulell[a][b] = 1;
                }


                break;
            }
            case 3: {
                int nmines = 64;
                int mida = 20;

                taulell = new char[20][20];

                for (int j = 0; j < mida; j++) {
                    for (int i = 0; i < mida; i++) {
                        taulell[j][i] = 0;
                    }
                }
                for (int i=0;i<nmines;i++){

                    Random randomr = new Random();
                    a = randomr.nextInt(0, 20);
                    b = randomr.nextInt(0, 20);

                    taulell[a][b] = 1;
                }


                break;
            }
        }

        return taulell;
    }
    public static void mostrarTaulell(char[][]taulell) {

        for (int i = 0; i < taulell.length; i++) {

            for (int j = 0; j < taulell[0].length; j++) {

                System.out.print(taulell[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public static void DemanarIComprovar(char[][] taulell) {

        boolean completat = false;

        do {

            System.out.print("Ingresa una  fila: ");

            int x = filaColumna.nextInt() - 1;

            System.out.print("Ingresa una columna: ");
            int y = filaColumna.nextInt() - 1;

            //si a les coordenades que hem demanat trobem una mina sortira un missatge de que hem perdut i ens mostrara el taullelresolt

            if (mines[x][y] == 'X') {

                System.out.println("Has trobat una mina,has perdut");
                for (int i = 0; i < mines.length; i++) {

                    for (int j = 0; j < mines[0].length; j++) {

                        if (mines[i][j] == 'X') {

                            taulell[i][j] = 'X';
                        }
                    }
                }
                mostrarTaulell(taulell);
                break;

            } else {
                taulell[x][y] = (taulellS[x][y] + "").charAt(0);
                mostrarTaulell(taulell);
            }
        } while(!completat);
    }
}
