import java.time.Year;
import java.util.Scanner;

public class Level1 {

    /**
     * Déclaration d'un attribut utilisable dans toutes les fonctions (attention, à fermer à la fin de la fonction main)
     */
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Série d'exercices 1");

        System.out.println("\n--> Exercice : majorité");
        // Appel de la fonction "displayMajorityInfo" avec un jeu d'essai complet
        displayMajorityInfo(1980);
        displayMajorityInfo(1952);
        displayMajorityInfo(2000);
        displayMajorityInfo(2020);

        System.out.println("\n--> Exercice : affichage d'un calcul spécifique");
        customNumberDisplay(50, 50);
        customNumberDisplay(10, 20);
        customNumberDisplay(100, 50);

        System.out.println("\n--> Exercice : minimum/maximum");
        findMinMax(1, 2, 3);
        findMinMax(50, 400, 20);
        findMinMax(10, 20, 30);
        findMinMax(100000, 50,50);

        System.out.println("\n--> Exercice :  compte bancaire");
        checkBankAccount();
        // on force la lecture du résidu de caractères dans le scanner pour ne pas créer de big par la suite
        // plus d'informations ici : https://therenegadecoder.com/code/be-careful-with-scanner-methods-in-java/
        scanner.nextLine();

        System.out.println("\n--> Exercice : participation employeur");
        displayParticipationRate();

        System.out.println("Fin de la fonction main");

        // fermeture du scanner pour libération de la ressource
        scanner.close();
    }

    /**
     * Fonction qui affiche un message en fonction d'une année de naissance passée en paramètre)
     *  
     * @param birthYear Une année de naissance
     */
    public static void displayMajorityInfo(int birthYear) {
        
        // Récupération de l'année actuelle
        int currentYear = Year.now().getValue();

        if (currentYear - birthYear < 18) {
            System.out.println("Utilisateur mineur");
        } else {
            System.out.println("Utilisateur majeur");
        }
    }

    /**
     * Fonction qui prend en paramètre deux nombre entiers et qui affiche :
     * - la somme des deux nombres si celle-ci (la somme) est supérieure ou égale à 100
     * - la multiplication des deux nombres si leur somme est inférieure à 100
     */
    public static void customNumberDisplay(int number1, int number2) {
        int sum = number1 + number2;

        System.out.println("Résultat : ");
        if (sum >= 100) {
            System.out.println(sum);
        } else {
            System.out.println(number1 * number2);
        }
    } 

    /**
     * Fonction qui trouve et affiche le minimum et le maximum entre 3 nombres.
     * 
     * @param number1 Premier nombre (entier)
     * @param number2 Second nombre (entier)
     * @param number3 Trosième nombre (entier)
     */
    public static void findMinMax(int number1, int number2, int number3) {
        // déclaration des variables qui vont contenir les résultats (min et max)
        // on intialise ces variables de avec number1
        int min = number1;
        int max = number1;

        // Comme min a été initialisée avec number1, on compare avec number2
        if (number2 < min) {
            // dans le cas où number2 est plus petit, on met à jour min
            min = number2;
        }

        // même chose avec le maximum, si number2 est plus grand on met à jour max
        if (number2 > max) {
            max = number2;
        }

        // number2 a été traité, on passe à number3
        if (number3 < min) {
            // ici number3 est plus petit que min, on met à jour min
            min = number3;
        }

        // même chose pour le maximum
        if (number3 > max) {
            max = number3;
        }

        // affichage des résultats en console
        System.out.println("Minimum : " + min);
        System.out.println("Maximum : " + max);
    }

    /**
     * Cette fonction vérifie si un caractère alphanumérique est une voyelle ou une consonne.
     * Attention, la fonction ne vérifie pas si le caractère est un caractère spécial ou accentué. 
     * 
     * Perspective d'évolution : renvoyer 's' s'il s'agit d'un caractère spécial ou accentué
     * 
     * @param letter La lettre à traiter
     * @return 'v' si la lettre est une voyelle, 'c' dans le cas contraire (attention, ne traite pas les caratères spéciaux et accentués)
     */
    public static char vowelOrConsonant(char letter) {

        // condition testant toutes les voyelles
        // Attention à la priorité des opérateurs : l'opération "==" est prioritaire par rapport à l'opérateur "||"
        if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u' || letter == 'y') {
            // cas d'une voyelle, on retourne 'v'
            return 'v';
        } else {
            // autre cas, on retourne c
            return 'c';
        }
    }

    /**
     * Fonction qui va demander à l'utilisateur d'entrée le montant restant sur son compte et le prix du produit qu'il souhaite acheter.
     * La fonction indique (en console) si l'opération est possible et affichage l'argent restant sur le compte si possible.
     * 
     * Aucun paramètre d'entrée ni de sortie.
     */
    public static void checkBankAccount() {
        // affichage d'un premier message
        System.out.println("Combien vous reste t-il sur votre compte ?");
        // récupération de la saisie utilisateur
        float accountAmount = scanner.nextFloat();

        // affichage deuxième message
        System.out.println("Quel est le prix de l'article que vous souhaitez acheter ?");
        // récupération de la saisie utilisateur
        float productPrice = scanner.nextFloat();

        float difference = accountAmount - productPrice;
        if (difference < 0) {
            System.out.println("Vous n'avez pas assez d'argent et aucun découvret n'est autorisé.");
        } else { // cas où l'utilisateur a plus ou autant d'argent que le prix du produit
            System.out.println("Il vous restera après achat : " + difference + " euros");
        }
    }

    public static void displayParticipationRate() {
        // variable qui nous permettra de relancer la boucle do..while qui commence à la ligne 154
        char repeatUserChoice = 'N';
        do { // boucle permettant de répéter l'opération pour plusieurs employé.e.s

            // initialisation du taux de participation intial (la valeur sera ajustée par la suite)
            int participationRate = 20;
            
            System.out.println("--- Saisie d'informations sur l'employé ---");
            
            // déclaration de la variable "userchoice" en dehors du do..while pour pouvoir s'en service ligne 162
            char maritalStatus;
            // la boucle "do..while" permet de répéter la demande à l'utilisateur si ni la lettre 'C', ni la lettre 'A' n'est saisie
            do {
                System.out.println("État matrimonial (C pour célibataire, A pour autre situation) :");
                // lecture de la saisie utilisateur
                String input = scanner.nextLine();

                // récupération de la première lettre de la saisie utilisateur
                // attention, il y a un bug si l'utilisateur ne rentre aucun caractère
                maritalStatus = input.charAt(0);

            } while(maritalStatus != 'C' && maritalStatus != 'A');

            // ajustement du taux de participation si l'utilisateur n'est pas célibataire
            if (maritalStatus == 'A') {
                participationRate = 25;
            }

            // récupération du nombre d'enfants à charge
            System.out.println("Nombre d'enfants à charge :");
            int childrenNumber = scanner.nextInt();

            // ajustement du taux de participation en fonction des enfants 
            participationRate = participationRate + childrenNumber * 15; 

            System.out.println("Salaire mensuel :");
            // récupération du salaire mensuel de l'utilisateur
            float salary = scanner.nextFloat();

            // l'appel à "next" qui permet de lire le caractère de retour à la ligne caché qui n'est pas lu par "nextFloat"
            scanner.nextLine(); // obligatoire pour ne pas que ça plante, pour plus d'informations sur la situation : https://therenegadecoder.com/code/be-careful-with-scanner-methods-in-java/

            // si le salaire est inférieur à 1800, on ajoute 10% au taux de participation
            if (salary < 1800) {
                participationRate = participationRate + 10;
            }
            
            // plafonnement du taux de participation
            if (participationRate > 50) {
                participationRate = 50;
            }

            System.out.println("Le taux de participation est de " + participationRate + " %");

            do {
                System.out.println("Souhaitez effectuer le calcul pour un autre employé ? (O/N)");
                // lecture de la saisie utilisateur
                String input = scanner.nextLine();

                // récupération de la première lettre de la saisie utilisateur
                // attention, il y a un bug si l'utilisateur ne rentre aucun caractère
                repeatUserChoice = input.charAt(0);

            } while(repeatUserChoice != 'O' && repeatUserChoice != 'o' && repeatUserChoice != 'N' && repeatUserChoice != 'n');

        } while (repeatUserChoice == 'O');
    }
}