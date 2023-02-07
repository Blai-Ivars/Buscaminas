import java.util.Scanner;

public class Main {

    //Inicialitzem les variable

    static char[][] taulell;
    static char[][] mines;
    static char[][] taulellS;

    public static void main(String[] args) {

        int dificultat;

        Scanner sc = new Scanner(System.in);

        System.out.println("Tria la dificultat:\n1. Fàcil\n2. Intermitg\n3. Expert");

        dificultat = sc.nextInt();

        switch (dificultat){

            case 1:
                iniciarTaulell(8, 8, 10);
                break;
            case 2:
                iniciarTaulell(16, 16, 40);
                break;
            case 3:
                iniciarTaulell(20, 20, 64);
                break;
        }
        Començar(1);
    }

    public static void mostrarTaulell() {

        for (int i = 0; i < taulell.length; i++) {

            for (int j = 0; j < taulell[0].length; j++) {

                System.out.print(taulell[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void iniciarTaulell(int files, int columnes, int totalMinas) {

        //inicialitzem les 3 variables

        taulell = new char[files][columnes];
        mines = new char[files][columnes];
        taulellS = new char[files][columnes];


        //emplenem el taulell que sera mostrat a l'usuari amb asteriscs

        for (int i = 0; i < taulell.length; i++) {

            for (int j = 0; j < taulell[0].length; j++) {

                taulell[i][j] = '*';
            }
        }

        /* Emplenem el taulell amb mines aleatoriament
        si el ntotal de mines < que el contador.
         */
        int contadorMines = 0;

        while (contadorMines < totalMinas) {

            int x = (int) (Math.random() * files);

            int y = (int) (Math.random() * columnes);

            if (mines[x][y] == '\u0000') {  //null en unicode

                mines[x][y] = 'X';

                contadorMines++;
            }
        }
    }



    public static void Començar(int quantitatMines) {

        /* Demanem a l'usuari que ingresi una fila i una columnas
          farem el bucle fins que el taulell no estigui completat
         */

        boolean completat = false;

        do {

            Scanner sc = new Scanner(System.in);
            System.out.print("Ingresa una  fila: ");
            int x = sc.nextInt() - 1;

            Scanner lector = new Scanner(System.in);
            System.out.print("Ingresa una columna: ");
            int y = lector.nextInt() - 1;

            //si a les coordenades que hem demanat trobem una mina sortira un missatge de que hem perdut i ens mostrara el taullel resolt

            if (mines[x][y] == 'X') {

                System.out.println("Has trobat una mina,has perdut");
                for (int i = 0; i < mines.length; i++) {

                    for (int j = 0; j < mines[0].length; j++) {

                        if (mines[i][j] == 'X') {

                            taulell[i][j] = 'X';
                        }
                    }
                }
                mostrarTaulell();
                break;

            } else {

                taulell[x][y] = (taulellS[x][y] + "").charAt(0);
                mostrarTaulell();
            }

            boolean victoria = verficarVictoria(quantitatMines);

            if (victoria) {

                System.out.println("Ganaste!");

                for (int i = 0; i < mines.length; i++) {

                    for (int j = 0; j < mines[0].length; j++) {

                        if (mines[i][j] == 'X') {

                            taulell[i][j] = '*';
                        }
                    }
                }
                mostrarTaulell();
                break;
            }
        } while (!completat);
    }

    public static boolean verficarVictoria(int quantitatMines) {

        int posiblesMinas = 0;

        for (int i = 0; i < taulell.length; i++) {
            for (int j = 0; j < taulell[0].length; j++) {
                if (taulell[i][j] == '*') {
                    posiblesMinas++;
                }
            }
        }
        if (posiblesMinas == quantitatMines) {
            return true;
        }
        return false;
    }
}