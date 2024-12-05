package text_rpg;

import java.util.Random;
import java.util.Scanner;

public class Game {    

    public static void main(String[] args) throws InterruptedException{

        Scanner scan = new Scanner(System.in);
        
        //                                                                    | HP | ATQ | DEF | EXP |  
        byte menuChoice = 0, gameChoice, personagemStatus[] = new byte[] {  10,   4,    3,    0  }, inimigoStatus[] = new byte[4];
        int rng;
        String nomePersonagem;        

        System.out.print("Digite o nome de seu personagem:\n> ");
        nomePersonagem = scan.nextLine();
        delay(2000);

        while (menuChoice != 3) {

            System.out.println( "Bem vindo ao RPG de texto " + nomePersonagem + "!");
            System.out.println( "O jogo só termina quando seu personagem morrer.");
            System.out.println( "O que gostaria de fazer?");
            System.out.println( "1 - Começar;");
            System.out.println( "2 - Detalhes do personagem;");
            System.out.print(   "3 - Sair.\n> ");
            menuChoice = scan.nextByte();
            delay(2000);

            switch (menuChoice) {
                
                case 1:
                                //HP
                    while (personagemStatus[0] > 0) {

                        do {
                            System.out.println("Você se encontra em um lugar desconhecido.\nHá um caminho a sua frente.");
                            System.out.println("O que gostaria de fazer?");
                            System.out.println( "1 - Seguir caminho;");
                            System.out.println( "2 - Olhar ao redor;");
                            System.out.print(   "3 - Nada.\n> ");
                            gameChoice = scan.nextByte();

                            switch (gameChoice) {

                                case 1:
                                    System.out.println("Você decide seguir o caminho...");  
                                    delay(1000);                                                
                                    break;

                                case 2:
                                    System.out.println("Você olha ao redor...\nNão parece ter nada que chame atenção...");
                                    delay(1000);
                                    break;
                            
                                default:
                                    System.err.println("Você decide não fazer nada...");
                                    delay(1000);
                                    break;
                            }
                        } while (gameChoice != 1);

                        do {

                            System.out.println("Você se depara com três caminhos...");
                            System.out.println("O que gostaria de fazer?");
                            System.out.println("1 - Ir para a esquerda;");
                            System.out.println("2 - Ir para a direita;");
                            System.out.print("3 - Seguir reto.\n> ");
                            gameChoice = scan.nextByte();

                            switch (gameChoice) {

                                case 1:
                                    System.out.println("Você decide seguir à esquerda...");  
                                    delay(1000);                                                
                                    break;

                                case 2:
                                    System.out.println("Você decide seguir à direita...");
                                    delay(1000);
                                    break;
                            
                                case 3:
                                    System.err.println("Você decide seguir reto...");
                                    delay(1000);
                                    break;

                                default:
                                    System.err.println("Mesmo não sendo uma opção você decide não fazer nada...");
                                    delay(1000);
                                    break;
                            }

                        } while (gameChoice > 3 || gameChoice < 1);

                        if (rng() >= 1) {



                        }
                        
                    }
                                        
                    break;
                
                case 2:
                    System.out.println("_________________________");   
                    System.out.println(  "|\tVida:\t"   + personagemStatus[0] +   "\t|");
                    System.out.println(  "|\tAtaque:\t" + personagemStatus[1] +   "\t|");   
                    System.out.println(  "|\tDefesa:\t" + personagemStatus[2] +   "\t|");
                    System.out.println(  "|\tExp:\t"    + personagemStatus[3] +   "\t|");
                    System.out.println("|_______________________|");
                    delay(3000);
                    break;

                case 3:
                    System.out.println("Finalizando o jogo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
            
        }

        scan.close();
        
    }

    //Da um valor de delay para as "telas"
    public static void delay(int n) throws InterruptedException {

        Thread.sleep(n);
        System.out.println("\n\n\n\n\n");

    }

    public static int rng() {

        Random random = new Random();
        int rng = random.nextInt(1, 21);

        return rng;
    }

}