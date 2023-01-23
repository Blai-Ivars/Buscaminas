import java.util.Scanner;
public class Buscaminas {

    public static void main(String[] args) {
        MostrarCrearMenu();

    }


    private static void MostrarCrearMenu()
    {
        int OpcioTriada = 0;
        int[][] taulell;
        System.out.println(" ====MENU DE JOC====\n" +
                           "1- Triar Dificultat\n" +
                           "2-Començar Partida\n" +
                           "3- Exit Game");

        Scanner lector=new Scanner(System.in);
        OpcioTriada=lector.nextInt();

       switch (OpcioTriada){

           case 1:

                int dificultat=SelectorDificultat();
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
        System.out.println("Quina dificultat vols seleccionar: \n" +
                "1- Dificultat Fàcil (8x8[10 miens]) \n"+
                "2- Dificultat Intermitja (16x16[40 mines]) \n" +
                "3-Dificultat Avançada (20x20 [64 mines]) \n");

        int Dificultat = lector.nextInt();
        return Dificultat;
    }

    public static void crearTaulell(int Dificultat){
        switch (Dificultat)
        {
            case 1:
            {
                System.out.println("Hola");
            }

        }
        return taulell;
    }
    
}


