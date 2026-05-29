import java.util.Scanner;

public class Calculatrice {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double nombre1, nombre2;
        int choix;

        System.out.println("=== CALCULATRICE JAVA ===");

        System.out.print("Entrez le premier nombre : ");
        nombre1 = scanner.nextDouble();

        System.out.print("Entrez le deuxième nombre : ");
        nombre2 = scanner.nextDouble();

        System.out.println("\nChoisissez une opération :");
        System.out.println("1 - Addition");
        System.out.println("2 - Soustraction");
        System.out.println("3 - Multiplication");
        System.out.println("4 - Division");

        System.out.print("Votre choix : ");
        choix = scanner.nextInt();

        switch (choix) {

            case 1:
                System.out.println("Résultat = " + (nombre1 + nombre2));
                break;

            case 2:
                System.out.println("Résultat = " + (nombre1 - nombre2));
                break;

            case 3:
                System.out.println("Résultat = " + (nombre1 * nombre2));
                break;

            case 4:
                if (nombre2 != 0) {
                    System.out.println("Résultat = " + (nombre1 / nombre2));
                } else {
                    System.out.println("Erreur : division par zéro impossible !");
                }
                break;

            default:
                System.out.println("Choix invalide !");
        }

        scanner.close();
    }
}