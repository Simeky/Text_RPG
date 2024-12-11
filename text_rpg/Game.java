package text_rpg;

import java.util.Random;
import java.util.Scanner;

public class Game {

    //                                                                  | Lv | HP | ATQ | DEF | XP | 
    static byte menuChoice, gameChoice, personagemStatus[] = new byte[] { 1,   10,  10,   10,    0  }, inimigoStatus[], corredor = 0, vidaMax = 10, dano;
    static String personagemNome, inimigoNome;
    static boolean escape;

    static Scanner scan = new Scanner(System.in);

    /*
    Autores:
        Guilherme Carsten Rayser
        Vinicius Henrique Grossert
     */
    public static void main(String[] args) throws InterruptedException{ 

        System.out.print("Digite o nome de seu personagem:\n> ");
        personagemNome = scan.nextLine();
        delay(2000);

        menu();        
        
                scan.close();
                
            }
        
            public static void menu() throws InterruptedException {

        do {

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

                    game();
                                        
                    break;
                
                case 2:

                    status();
                    
                    break;

                case 3:
                    System.out.println("Finalizando o jogo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    delay(2000);
                    break;
            }
            
        } while (menuChoice != 3);


    }

    public static void game() throws InterruptedException {

        //                            | Lv | HP | ATQ | DEF | EXP |  
        personagemStatus = new byte[] { 1,   10,   4,    3,    0  };

        System.out.println("Você se encontra em um lugar desconhecido feito de tijolos de pedra.\nHá um caminho a sua frente.");

        do {
                
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

        trap();

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
        
        for (byte i = 0; i < 4; i++) {

            if (personagemStatus[1] < 1) {

                break;

            }

            trap();
            continuar();

        }             

    }    
    
    //Avançando no caminho;
    public static void continuar() throws InterruptedException {        

        do {

            if (personagemStatus[1] < 1) {

                gameOver();
                break;

            }
                
            System.out.println("Conforme você avança pelo caminho, você sente que está sendo observado...");
            System.out.println("O que gostaria de fazer?");
            System.out.print("1 - Seguir o caminho;\n> ");
            gameChoice = scan.nextByte();

            switch (gameChoice) {
                case 1:

                    delay(1500);
                    battle();    
                    
                    break;                        
                
                default:
                    System.out.println("Mesmo não sendo uma opção você decide não fazer nada...");
                    delay(1700);
                    break;

            }                

        } while (gameChoice != 1 );

    }    

    //Batalha contra inimigos normais
    public static void battle() throws InterruptedException {

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
        delay(1000);
        do {

            if (personagemStatus[1] < 1) {

                break;

            }

            System.out.println("O que gostaria de fazer?");
            System.out.println("1 - Atacar;");
            System.out.println("2 - Defender;");
            System.out.print("3 - Tentar fugir.\n> ");
            gameChoice = scan.nextByte();
            
            delay(1500);

            switch (gameChoice) {

                case 1:

                    System.out.println("Você ataca o " + inimigoNome);

                    if (rng(1, 21) >= 16) {               
                        
                        dano = (byte) ((personagemStatus[2] * 2) - inimigoStatus[3]);
                        
                        if (dano < 1) {

                            System.out.println("Você deu um acerto crítico e causou 1 de dano!");
                            inimigoStatus[1]--;
    
                        }   else {

                                System.out.println("Você deu um acerto crítico e causou " + dano + " de dano!");
                                inimigoStatus[1] -= dano;                        
    
                            }

                    }   else {       
                        
                            dano = (byte) (personagemStatus[2] - inimigoStatus[3]);

                            if (dano < 1) {

                                System.out.println("Você causou 1 de dano.");
                                inimigoStatus[1]--;
        
                            }   else {

                                    System.out.println("Você causou " + dano + " de dano!");
                                    inimigoStatus[1] -= dano;                        
        
                                }

                        }                                              
    
                    inimigoAtaque();

                    delay(1500);
                    
                    break;

                case 2:

                    System.out.println("Você decide se preparar para receber o golpe do " + inimigoNome);

                    dano = (byte) (inimigoStatus[2] - (personagemStatus[3] * 2));
                    if (dano < 1) {

                        System.out.println(inimigoNome + " lhe causou 1 de dano.");
                        personagemStatus[1]--;

                    }   else {

                            System.out.println(inimigoNome + " lhe causou " + dano + " de dano!");
                            personagemStatus[1] -= dano;                 

                        }

                    break;
            
                default:

                    if (rng(1 , 21) > 17) {

                        System.out.println("Você tenta escapar e se depara com o corredor seguro e consegue escapar!");
                        escape = true;
                        delay(1700);
                        break;

                    }   else if (rng(1, 21) > 10) {

                            System.out.println("Você tenta escapar e se depara com o corredor desmoronado!");
                            escape = false;
                            delay(1700);

                    }   else {

                            System.out.println("Você tenta escapar, você tropeça, cai e perde 2 de vida" );
                            personagemStatus[1] -= 2;
                            System.out.println("Vida atual: " + personagemStatus[1]);
                            escape = false;
                            delay(1700);

            	    }
                        
                    inimigoAtaque();

                    break;
            }

            if (inimigoStatus[1] < 1) {

                levelUp();
                break;
                
            }
            
        } while (personagemStatus[1] > 0 || inimigoStatus[1] > 0 || escape == false);

    }

    public static void inimigoAtaque() {

        dano = (byte) (inimigoStatus[2] - personagemStatus[3]);

        if (dano < 1) {
                                
            System.out.println(inimigoNome + " lhe causou 1 de dano.");
            personagemStatus[1]--;

        }   else {

                System.out.println(inimigoNome + " lhe causou " + dano + " de dano.");
                //HP personagem     -=    ATQ inimigo   -  DEF personagem
                personagemStatus[1] -= dano;                           

        }

    }

    public static void levelUp() throws InterruptedException {

        personagemStatus[4] += inimigoStatus[4];

        if (personagemStatus[4] >= 10) {
            
            personagemStatus[4] -= 10;
            personagemStatus[0]++;

            System.out.println("Parabéns! Você agora está no nível " + personagemStatus[0] + ".");
            
            vidaMax += 10;
            personagemStatus[1] = vidaMax;

            if (rng(1, 21) <= 10) {

                personagemStatus[2] += 5;
                personagemStatus[3] += 3;
                status();

            }   else {

                    personagemStatus[2] += 3;
                    personagemStatus[3] += 5;
                    status();

                }

        }

    }

    public static void gameOver() throws InterruptedException {

        System.out.println("Você morreu...");
        personagemStatus[1] = 0;
        status();

    }

    public static void status() throws InterruptedException {

        System.out.println("_________________________");
        System.out.println(  "|\tNome:\t"   + personagemNome      +   "\t|"); 
        System.out.println(  "|\tNível:\t"  + personagemStatus[0] +   "\t|"); 
        System.out.println(  "|\tVida:\t"   + personagemStatus[1] +   "\t|");
        System.out.println(  "|\tAtaque:\t" + personagemStatus[2] +   "\t|");   
        System.out.println(  "|\tDefesa:\t" + personagemStatus[3] +   "\t|");
        System.out.println(  "|\tExp:\t"    + personagemStatus[4] +   "\t|");
        System.out.println("|_______________________|");
        delay(4000);

    }

    public static void trap() throws InterruptedException {

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