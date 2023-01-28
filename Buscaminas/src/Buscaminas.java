import java.util.Random;
import java.util.Scanner;

public class Buscaminas {
    public static void main(String[] args) {
        MostrarCrearMenu();
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
                break;
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");
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

                taulell = new char[8][8];

                for (int j = 0; j < mida; j++) {
                    for (int i = 0; i < mida; i++) {
                        taulell[j][i] = 0;
                    }
                }
                Random randomr = new Random();
                a = randomr.nextInt(0, 9);
                b = randomr.nextInt(0, 9);
                //MIRAR QUE ÉS AIXÓ I QUE FA PK NI PUTIS
                taulell[a][b] = 1;

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
                a = randomr.nextInt(0, 17);
                b = randomr.nextInt(0, 17);
                //MIRAR QUE ÉS AIXÓ I QUE FA PK NI PUTIS
                taulell[a][b] = 1;

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

                Random randomr = new Random();
                a = randomr.nextInt(0, 21);
                b = randomr.nextInt(0, 21);
                //MIRAR QUE ÉS AIXÓ I QUE FA PK NI PUTIS

                taulell[a][b] = 1;

                break;
            }
        }

        return taulell;
    }

    public static void mostrarTaulell(char[][] taulell)
    {
        taulell[4][6] = 'X';
        for (int i = 0; i < taulell.length; i++) {
            for (int j = 0; j < taulell[0].length; j++) {
                System.out.print(taulell[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static int DemanarPosicio(){

        Scanner lector=new Scanner(System.in);
        int [][] Posicio;

        
        return Posicio;
    }
    public static void ComprovarPosicio(int [] Posicio){




    }
}








