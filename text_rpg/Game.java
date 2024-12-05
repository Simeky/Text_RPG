package text_rpg;

import java.util.Random;
import java.util.Scanner;

public class Game {    

    /*                                          Mapa
                                                ____     ______
                                                |  |    |__  __|
                                            ____|  |___ ___||____ _______ __
                                            ____    ___ _________ _______ __
                                                |  | 

                                                |  |
                                                |  |
                                                |  |

                                                |  |_____
                                                |  |_____|
                                                |  |



     */

    public static void main(String[] args) throws InterruptedException{

        Scanner scan = new Scanner(System.in);
        
        //                                                               | Lv | HP | ATQ | DEF | EXP |                                
        byte menuChoice = 0, gameChoice, personagemStatus[] = new byte[] { 1,   10,   4,    3,    0  }, inimigoStatus[] = new byte[5], corredor = 0 ;
        String personagemNome;        

        System.out.print("Digite o nome de seu personagem:\n> ");
        personagemNome = scan.nextLine();
        delay(2000);

        while (menuChoice != 3) {

            System.out.println( "Bem vindo ao RPG de texto " + personagemNome + "!");
            System.out.println( "O jogo só termina quando seu personagem morrer.");
            System.out.println( "O que gostaria de fazer?");
            System.out.println( "1 - Começar;");
            System.out.println( "2 - Detalhes do personagem;");
            System.out.print(   "3 - Sair.\n> ");
            menuChoice = scan.nextByte();
            delay(2000);

            switch (menuChoice) {
                
                case 1:

                    do {

                        do {
                            System.out.println("Você se encontra em um lugar desconhecido feito de tijolos de pedra.\nHá um caminho a sua frente.");
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
                                    delay(2000);
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
                            System.out.print(  "3 - Seguir reto.\n> ");
                            gameChoice = scan.nextByte();

                            switch (gameChoice) {

                                case 1:
                                    System.out.println("Você decide seguir à esquerda...\nE percebe o ambiente mudar para o de uma floresta...");  
                                    corredor = 3;
                                    delay(2000);                                                
                                    break;

                                case 2:
                                    System.out.println("Você decide seguir à direita...\nE percebe o interior mudar para o de uma caverna...");
                                    corredor = 1;
                                    delay(2000);
                                    break;
                            
                                case 3:
                                    System.err.println("Você decide seguir reto...");
                                    corredor = 2;
                                    delay(2000);
                                    break;

                                default:
                                    System.err.println("Mesmo não sendo uma opção você decide não fazer nada...");
                                    delay(2000);
                                    break;
                            }

                        } while (gameChoice > 3 || gameChoice < 1);

                        if (rng() >= 16) {

                            System.out.println("Você acaba acionando uma armadilha e perde -2 de vida.");
                            personagemStatus[1] -= 2;
                            System.out.println("Vida atual: " + personagemStatus[1]);
                            delay(1000);

                        }

                        do {
                            
                            System.out.println("Conforme você avança pelo caminho, você sente que está sendo observado...");
                            if (corredor == 3) {

                                System.out.println("Você percebe um caminho estreito à sua esquerda...");
                                System.out.println("O que gostaria de fazer?");
                                System.out.println("1 - Seguir o caminho;");
                                System.out.println("2 - Ir para a passagem estreita.");

                                
                            }   else {

                                    System.out.println("O que gostaria de fazer?");
                                    System.out.println("1 - Seguir o caminho;");

                                }

                            switch (gameChoice) {
                                case 1:
                                          
                                    break;
                            
                                default:
                                    System.out.println("Mesmo não sendo uma opção você decide não fazer nada...");
                                    break;
                            }
                            

                        } while (gameChoice != 0);
                        
                    //              HP
                    } while (personagemStatus[1] > 0);
                                        
                    break;
                
                case 2:
                    System.out.println("_________________________");
                    System.out.println(  "|\tNome:\t"   + personagemNome      +   "\t|"); 
                    System.out.println(  "|\tNível:\t"  + personagemStatus[0] +   "\t|"); 
                    System.out.println(  "|\tVida:\t"   + personagemStatus[1] +   "\t|");
                    System.out.println(  "|\tAtaque:\t" + personagemStatus[2] +   "\t|");   
                    System.out.println(  "|\tDefesa:\t" + personagemStatus[3] +   "\t|");
                    System.out.println(  "|\tExp:\t"    + personagemStatus[4] +   "\t|");
                    System.out.println("|_______________________|");
                    delay(4000);
                    break;

                case 3:
                    System.out.println("Finalizando o jogo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    delay(1000);
                    break;
            }
            
        }

        scan.close();
        
    }

    //Da um valor de delay para as "telas" e "limpa" a "tela".
    public static void delay(int n) throws InterruptedException {

        Thread.sleep(n);
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");

    }

    // Random number generator para usos variados
    public static int rng() {

        Random random = new Random();
        int rng = random.nextInt(1, 21);

        return rng;
    }
    

}