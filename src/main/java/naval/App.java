package naval;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Bienvenue dans Guerre Marine !");
        System.out.println(
                "JOUEUR 1, entrez les coordonnées de vos navires, sous la forme L C (L représente la ligne entre 0 et 4 et C la colonne entre 0 et 4).");

        String[][] cases = new String[6][6];

        creerGrille(cases);
        DemanderCoordonnees(clavier, cases);
        affficherTableau(cases);
        passer100lignes();

        System.out.println(
                "JOUEUR 2, entrez les coordonnées de vos navires, sous la forme L C (L représente la ligne entre 0 et 4 et C la colonne entre 0 et 4).");

        String[][] cases2 = new String[6][6];

        creerGrille(cases2);
        DemanderCoordonnees2(clavier, cases2);
        affficherTableau(cases2);
        passer100lignes();

        boolean yADesArobases = true;
        while (yADesArobases) {
            TirJoueur1(clavier, cases2);
            affficherTableau(cases2);
            if (encoreDesArobasesDans(cases2)) {
                yADesArobases = true;
            } else {
                yADesArobases = false;

            }

            TirJoueur2(clavier, cases);
            affficherTableau(cases);
            if (encoreDesArobasesDans(cases)) {
                yADesArobases = true;
            } else {
                yADesArobases = false;

            }
        }
        if (encoreDesArobasesDans(cases2) == false) {
            System.out.println("JOUEUR 1 A GAGNÉ !");
        }
        if (encoreDesArobasesDans(cases) == false) {
            System.out.println("JOUEUR 2 A GAGNÉ !");
        }

        clavier.close();
    }

    // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------

    private static boolean encoreDesArobasesDans(String[][] cases) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (cases[i][j].equals("@")) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void TirJoueur1(Scanner clavier, String[][] cases2) {
        System.out.println("JOUEUR 1, entrez les coordonnées de votre tir : ");
        int tirLigne = clavier.nextInt() + 1;
        int tirColonne = clavier.nextInt() + 1;
        if (cases2[tirLigne][tirColonne].equals("@")) {
            System.out.println("JOUEUR 1 A COULÉ UN NAVIRE DU JOUEUR 2 !.");
            cases2[tirLigne][tirColonne] = "X";
        } else {
            System.out.println(" JOUEUR 1 : COUP dans l'eau !.");
            cases2[tirLigne][tirColonne] = "O";
        }

        if (tirLigne > 5 || tirColonne > 5 || tirLigne < 1 || tirColonne < 1) {
            System.out.println("Coordonnées invalides. Veuillez réessayer.");
        }
    }

    private static void TirJoueur2(Scanner clavier, String[][] cases) {
        System.out.println("JOUEUR 2, entrez les coordonnées de votre tir : ");
        int tirLigne = clavier.nextInt() + 1;
        int tirColonne = clavier.nextInt() + 1;
        if (cases[tirLigne][tirColonne].equals("@")) {
            System.out.println("JOUEUR 1 A COULÉ UN NAVIRE DU JOUEUR 2 !.");
            cases[tirLigne][tirColonne] = "X";

        } else {
            System.out.println(" JOUEUR 1 : COUP dans l'eau !.");
            cases[tirLigne][tirColonne] = "O";
        }

        if (tirLigne > 5 || tirColonne > 5 || tirLigne < 1 || tirColonne < 1) {
            System.out.println("Coordonnées invalides. Veuillez réessayer.");
        }
    }

    private static void passer100lignes() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    private static void affficherTableau(String[][] cases) {
        System.out.println("Tableau :");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(cases[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void DemanderCoordonnees(Scanner clavier, String[][] cases) {
        int ligne = 0;
        int colonne = 0;
        for (int n = 1; n <= 5; n++) {
            while (true) {
                System.out.println("Entrez les coordonnées du navire " + n + " : ");
                ligne = clavier.nextInt() + 1;
                colonne = clavier.nextInt() + 1;

                if (ligne > 5 || colonne > 5 || ligne < 1 || colonne < 1) {
                    System.out.println("Coordonnées invalides. Veuillez réessayer.");
                } else if (cases[ligne][colonne].equals("@")) {
                    System.out.println("Vous avez déjà un navire à cet endroit. Veuillez réessayer.");
                } else {
                    cases[ligne][colonne] = "@";
                    break;
                }
            }
        }
    }

    private static void DemanderCoordonnees2(Scanner clavier, String[][] cases2) {
        int ligne2 = 0;
        int colonne2 = 0;
        for (int n = 1; n <= 5; n++) {
            while (true) {
                System.out.println("Entrez les coordonnées du navire " + n + " : ");
                ligne2 = clavier.nextInt() + 1;
                colonne2 = clavier.nextInt() + 1;

                if (ligne2 > 5 || colonne2 > 5 || ligne2 < 1 || colonne2 < 1) {
                    System.out.println("Coordonnées invalides. Veuillez réessayer.");
                } else if (cases2[ligne2][colonne2].equals("@")) {
                    System.out.println("Vous avez déjà un navire à cet endroit. Veuillez réessayer.");
                } else {
                    cases2[ligne2][colonne2] = "@";
                    break;
                }
            }
        }
    }

    private static void creerGrille(String[][] cases) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i == 0 && j == 0) {
                    cases[i][j] = " ";
                } else if (i == 0) {
                    cases[i][j] = Integer.toString(j - 1);
                } else if (j == 0) {
                    cases[i][j] = Integer.toString(i - 1);
                } else {
                    cases[i][j] = "-";
                }
            }
        }
    }
}
