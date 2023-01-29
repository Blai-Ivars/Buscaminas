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
                DemanarComprovarPosicio(int[][] MinaLocation);

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
        double w,z;

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
                do  {
                    w=Math.random()*8;
                    z=Math.random()*8;
                    w=(int)w;
                    z=(int)z;
                    if  (z!=0 && w!=0 && z!=8-1 && w!=8-1){
                        taulell[(int)w][(int) z ]=1;
                        nmines++;
                    }
                }while (nmines<=10);
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
                do  {
                    w=Math.random()*16;
                    z=Math.random()*16;
                    w=(int)w;
                    z=(int)z;
                    if  (z!=0 && w!=0 && z!=16-1 && w!=16-1){
                        taulell[(int)w][(int) z ]=1;
                        nmines++;
                    }
                }while (nmines<=40);

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
                do  {
                    w=Math.random()*20;
                    z=Math.random()*20;
                    w=(int)w;
                    z=(int)z;
                    if  (z!=0 && w!=0 && z!=20-1 && w!=20-1){
                        taulell[(int)w][(int) z ]=1;
                        nmines++;
                    }
                }while (nmines<=64);

                break;
            }
        }

        return taulell;
    }

    public static void mostrarTaulell(char[][] taulell)
    {

        for (int i = 0; i < taulell.length; i++) {
            for (int j = 0; j < taulell[0].length; j++) {
                System.out.print(taulell[i][j] + "0 ");
            }
            System.out.print("\n");
        }
    }

    public static boolean DemanarComprovarPosicio(int[][] PosicioMina,char[][] taulell){
        Scanner lector=new Scanner(System.in);
        int [][] Posicio=new int[1][1];
        boolean Minatrobada=false;
        PosicioMina= PosicioMina([][]);//Posa Aqui la posicio de la mina en plan  "posicioMina(posicio); per aixi transferir la posicio i mes aball comprovar-la"

        do {
            System.out.println("Introdueix la coordenada x desitjada");
            int x = lector.nextInt();
            System.out.println("Introdueix la coordenada y desitjada");
            int y = lector.nextInt();

            if (Posicio[x][y] == PosicioMina[1][1]){
                Minatrobada = true;
            }else
            {
                PosicioMina[x][y] = taulell[x][y];

                taulell[x][y] = 'X';
                for (int i = 0; i < taulell.length; i++) {
                    for (int j = 0; j < taulell[0].length; j++) {
                        System.out.print(taulell[x][y] + "0 ");
                    }
                    System.out.print("\n");
                }
            }
        }while(Minatrobada=false);
        return Minatrobada;
    }
    // fer algun de if minatrobada == true sout "Has perdut" o una merda aixi
}






