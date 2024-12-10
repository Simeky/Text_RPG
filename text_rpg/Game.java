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

     //                                                               | Lv | HP | ATQ | DEF | EXP |  
     byte menuChoice = 0, gameChoice, personagemStatus[] = new byte[] { 1,   10,   4,    3,    0  }, inimigoStatus[], corredor = 0 ;
     String personagemNome, inimigoNome;

     Scanner scan = new Scanner(System.in);

    public void main(String[] args) throws InterruptedException{ 

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

                        trap();

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

    public void battle() {

        if (corredor == 1) {
            
            inimigoNome = "Lobo cinzento";
            inimigoStatus = new byte[] {2, 6, 4, 1, 7};
            
        }   else if (corredor == 2) {

                inimigoNome = "Golem de pedra";
                inimigoStatus = new byte[] {2, 8, 1, 3, 10};
            
            }   else if (corredor == 3) {

                    inimigoNome = "Goblin";
                    inimigoStatus = new byte[] {2, 4, 2, 2, 5};
                
                }

        
        System.out.println("Você se depara com um " + inimigoNome + "!");
        do {

            System.out.println("O que gostaria de fazer?");
            System.out.println("1 - Atacar;");
            System.out.println("2 - Defender;");
            System.out.print("3 - Tentar fugir.\n> ");
            gameChoice = scan.nextByte();

            switch (gameChoice) {
                case 1:

                    System.out.println("Você ataca o " + inimigoNome);                        
                    if (rng(1, 21) >= 16) {

                        System.out.println("Você deu um acerto crítico e causou " + (personagemStatus[2] * 2 - inimigoStatus[3]) + " de dano!");
                        //   Hp inimigo  -=   ATQ personagem    * 2 -  DEF inimigo
                        inimigoStatus[1] -= personagemStatus[2] * 2 - inimigoStatus[3];

                    }   else {

                            System.out.println("Você causou " + (personagemStatus[2] - inimigoStatus[3]) + " de dano.");
                            //HP inimigo     -=    ATQ personagem   -  DEF inimigo
                            inimigoStatus[1] -= personagemStatus[2] - inimigoStatus[3];

                        }
                    
                    break;

                case 2:

                    System.out.println("Você decide se preparar para receber o golpe do " + inimigoNome);

                    if (personagemStatus[3] * 2 - inimigoStatus[2] > 1) {

                        personagemStatus[1]--;

                    }   else {

                            personagemStatus[1] -= personagemStatus[3] * 2 - inimigoStatus[2];                        

                        }


                    break;
            
                default:
                    break;
            }
            
        } while (personagemStatus[1] > 0 || inimigoStatus[1] > 0);

    }

    public void trap() throws InterruptedException {

        if (rng(1, 21) >= 16) {

            System.out.println("Você acaba acionando uma armadilha e perde -2 de vida.");
            personagemStatus[1] -= 2;

            System.out.println("Vida atual: " + personagemStatus[1]);
            delay(1000);

        }

    }

    //Da um valor de delay para as "telas" e "limpa" a "tela".
    public static void delay(int n) throws InterruptedException {

        Thread.sleep(n);
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");

    }

    // Random number generator para usos variados
    public static int rng(int lI, int lS) {

        Random random = new Random();
        int rng = random.nextInt(lI, lS);

        return rng;
    }    

}