import java.util.Random;
import java.util.Scanner;
public class Game {
    static Scanner sc = new Scanner(System.in);
    public static boolean restart = true;

    public static void main(String[] args) {
        welcome();
        bet();
        play();
    }

    public static void welcome() {
        System.out.print("Votre nom: ");
        String nom = sc.nextLine();
        System.out.println("Bonjour " + nom + ", Bienvenu sur le jeu Bandit manchot. \n Règles du jeu : \n Vous devez miser une somme a chaque fois que vous tentez votre chance. \n Si aucun symbole est identiques vous perdez votre mise. \n Si 2 symboles identiques votre gain de mise est / 2. \n Si 3 symbole identiques votre gain de mise + mise * 2 ");
    }

    public static int bet() {         
        System.out.print("Souhaitez vous essayer: (1 oui / 2 non) :");
        int game = sc.nextInt();
        if(game == 2) {
            System.out.print("Aurevoir");
            System.exit(0);
        }
        else {
            System.out.print("Je suis heureux de vous voir tenter votre chance !");
            System.out.print("Voici votre mise : " + 0);
        } 
        return game;         
  }  
  
    public static void play() {
        int solde = 1000;
        do {
        System.out.print("Combiens voulez vous miser ? (votre solde actuelle est de : " + solde + ") ! \n");
        int mise = sc.nextInt();
        System.out.print("Vous avez décider de miser " + mise + "\n");
        System.out.print("  - Pour commencer taper 1 \n");
        System.out.print("  - Pour annuler taper 2 \n");
        int start = sc.nextInt();

        if(start == 1) {

            String trefle = "\u2663";
            String coeur = "\u2665";
            String pique = "\u2660";
            String carreau = "\u2666";
            String[] symbole = {trefle, coeur, pique, carreau};
            
            String ANSI_BLACK = "\u001B[30m";
            String ANSI_RED = "\u001B[31m";
            String ANSI_GREEN ="\u001B[32m";
            String ANSI_BLUE ="\u001B[34m";

            System.out.print(ANSI_BLACK + trefle);
            System.out.print(ANSI_RED + coeur);
            System.out.print(ANSI_GREEN + pique);
            System.out.print(ANSI_BLUE + carreau);


            Random rand1 = new Random();
            int random = rand1.nextInt(symbole.length);
            System.out.print(symbole[random]);

            Random rand2 = new Random();
            int random2 = rand2.nextInt(symbole.length);
            System.out.print(symbole[random2]);

            Random rand3 = new Random();
            int random3 = rand3.nextInt(symbole.length);
            System.out.print(symbole[random3]);

                if(random == random2 && random == random3 && random2 == random3) 
                {   
                    int total1 = mise * 2;
                    solde = solde + total1;
                    System.out.print("Bravo! Vous avez gagnée ! \n Voici votre solde : " + solde );
                }
                else if(random != random2 && random != random3 && random2 != random3)
                {
                    solde = 0;
                    System.out.print("Dommage ;( \n Vous avez tout perdu : " + solde);
                }
                else
                {   
                    int total3 = mise / 2;
                    solde = solde - total3;
                    System.out.print("Vous avez perdu la moitié de votre mise :" + total3 + "\n votre solde :" + solde );
                }
            }else{
                System.out.print(":(");

            }
            sc.nextLine();
            if(solde == 0) {
                System.out.print("Vous avez plus rien dans votre solde.\n Terminée");
                System.exit(0);
            }else{
                System.out.print("Voulez vous rejouer ? (true / false) : ");
                boolean choose = sc.nextBoolean();
                restart = choose;
            }

        } while (restart);
    }
}

