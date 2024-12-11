package text_rpg;

import java.util.Random;
import java.util.Scanner;

public class Game {
 
    static byte menuChoice, gameChoice, corredor = 0;
    static String personagemNome, inimigoNome;
    static int personagemStatus[], vidaMax, inimigoStatus[];
    static boolean escape;
    static Scanner scan = new Scanner(System.in);

    /*
    Autores:
        Guilherme Carsten Rayser
        Vinicius Henrique Grossert
     */
    public static void main(String[] args) throws InterruptedException{
        
        do {
            
            System.out.println("Min 1 caractéres\tMax 7 caractéres");
            System.out.print("Digite o nome de seu personagem:\n> ");
            personagemNome = scan.nextLine();
            delay(1000);
            
        } while (personagemNome.length() > 7 || personagemNome.length() < 1);

        
        menu();        
        
        scan.close();
                
    }
        
    public static void menu() throws InterruptedException {

        
        do {

            //                           | Lv | HP | ATQ | DEF | XP |
            personagemStatus = new int[] { 1,   10,  10,   10,    0  };
            vidaMax = 10;


            System.out.println( "Bem vindo ao RPG de texto " + personagemNome + "!");
            System.out.println( "O jogo só termina quando seu personagem morrer ou quando o chefe for derrotado.");
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
        personagemStatus = new int[] { 1,   10,   10,    10,    0  };
        vidaMax = 10;

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
        
        delay(2000);
        
        bossRoom();

        if (personagemStatus[1] < 1) {
            
            System.out.println("Você morreu...");
            personagemStatus[1] = 0;
            status();

        }   else {

                System.out.println("Parabéns! Você ganhou o jogo!");
                status();

            }

    }

    public static void bossRoom() throws InterruptedException {

        do {

            if (personagemStatus[1] < 1) {

                break;
                
            }

            if (corredor == 1) {
                
                System.out.println("Você se encontra em um espaço aberto como se estivesse dentro de um vulcão...");
                System.out.println("O chão começa a tremer e uma criatura emerge de dentro dos poços de lava...");

            }   else if (corredor == 2) {

                    System.out.println("Você se encontra em uma sala aberta com uma cratera no chão, é como se tivesse caido um meteoro...");
                    System.out.println("Dentro da cratera há um monte de escombros...");
                    System.out.println("Conforme você se aproxima os escombros começam a se mexer e o chão a tremer...");

                }   else if (corredor == 3) {

                        System.out.println("Você se encontra em uma vila e se sente observado por todos os lados...");
                        System.out.println("Você avista um ser sentado em um trono...");
                        System.out.println("Ele se levanta e anda em sua direção...");
                    
                    }

            delay(5000);

            battle(true);

        } while(inimigoStatus[1] > 0);

    }
    
    //Avançando no caminho;
    public static void continuar() throws InterruptedException {        

        do {

            if (personagemStatus[1] < 1) {

                break;

            }
                
            System.out.println("Conforme você avança pelo caminho, você sente que está sendo observado...");
            System.out.println("O que gostaria de fazer?");
            System.out.print("1 - Seguir o caminho;\n> ");
            gameChoice = scan.nextByte();

            switch (gameChoice) {
                case 1:

                    delay(1500);
                    battle(false);    
                    
                    break;                        
                
                default:
                    System.out.println("Mesmo não sendo uma opção você decide não fazer nada...");
                    delay(1700);
                    break;

            }                

        } while (gameChoice != 1 );

    }    

    //Batalha contra inimigos normais
    public static void battle(boolean boss) throws InterruptedException {

        if (boss == false) {

            if (corredor == 1) {
            
                inimigoNome = "Lobo cinzento";
                inimigoStatus = new int[] {2 , 10, 9, 1, 8};
                
            }   else if (corredor == 2) {
    
                    inimigoNome = "Golem de pedra";
                    inimigoStatus = new int[] {2, 15, 5, 5, 10};
                
                }   else if (corredor == 3) {
    
                        inimigoNome = "Goblin";
                        inimigoStatus = new int[] {2, 10, 7, 3, 5};
                    
                    }  
                    
            for (byte i = 0; i < inimigoStatus.length; i++) {

                inimigoStatus[i] *= personagemStatus[0];
                
            }
            
        }   else {

                if (corredor == 1) {

                    inimigoNome = "\033[31mAsher, o Lobo Infernal\033[0m";
                    inimigoStatus = new int[] {10, 100, 40, 10 , 1};

                }   else if(corredor == 2) {

                        inimigoNome = "\033[38;5;214mAstregor, o Guardião caído\033[0m";
                        inimigoStatus = new int[] {20, 200, 80, 60 , 2};

                    }   else if(corredor == 3) {

                            inimigoNome = "\033[32mZarklim, o Rei Goblin\033[0m";
                            inimigoStatus = new int[] {8, 60, 30, 15 , 3};

                        }

        }

        System.out.println("Você se depara com um " + inimigoNome + "!");
        delay(2000);
        do {

            if (personagemStatus[1] < 1) {

                break;

            }

            System.out.println("\033[38;5;196mVida:\033[0m " + personagemStatus[1] + "/" + vidaMax);
            System.out.println("O que gostaria de fazer?");
            System.out.println("1 - Atacar;");
            System.out.println("2 - Defender;");
            System.out.print("3 - Tentar fugir.\n> ");
            gameChoice = scan.nextByte();
            
            delay(1500);

            switch (gameChoice) {

                case 1:

                    System.out.println("Você ataca o " + inimigoNome + "...");

                    if (boss == true && inimigoNome == "\033[38;5;214mAstregor, o Guardião caído\033[0m" && rng(1, 21) >= 15) {

                        System.out.println(inimigoNome + " armou suas defesas e ignorou todo o dano recebido...");
                        delay(2000);
                        break;
                        
                    }

                    if (rng(1, 21) >= 16) {               
                        
                        if ((personagemStatus[2] * 2) - inimigoStatus[3] < 1) {

                            System.out.println("Você deu um acerto crítico e causou\033[33m 1\033[0m de dano!");
                            inimigoStatus[1]--;
    
                        }   else {

                                System.out.println("Você deu um acerto crítico e causou \033[33m" + ((personagemStatus[2] * 2) - inimigoStatus[3]) + "\033[0m de dano!");
                                inimigoStatus[1] -= (personagemStatus[2] * 2) - inimigoStatus[3];                        
    
                            }

                    }   else { 

                            if ((personagemStatus[2] - inimigoStatus[3]) < 1) {

                                System.out.println("Você causou\033[31m 1\033[0m de dano.");
                                inimigoStatus[1]--;
        
                            }   else {

                                    System.out.println("Você causou \033[31m" + (personagemStatus[2] - inimigoStatus[3]) + "\033[0m de dano!");
                                    inimigoStatus[1] -= (personagemStatus[2] - inimigoStatus[3]);                        
        
                                }

                        }    
                        
                    delay(2000);
                        
                    if (inimigoStatus[1] <= 0) {

                        break;
                        
                    }
    
                    if (boss == true) {
                        
                        inimigoAtaque(true);

                    }   else {

                            inimigoAtaque(false);

                    }  

                    delay(1500);
                    
                    break;

                case 2: 

                    System.out.println("Você decide se preparar para receber o golpe do " + inimigoNome + "...");

                    personagemStatus[3] *= 2;

                    if (boss == true) {
                        
                        inimigoAtaque(true);

                    }   else {

                            inimigoAtaque(false);

                    }  

                    personagemStatus[3] /= 2;

                    delay(1800);

                    break;
            
                default:

                    if (rng(1 , 21) > 17 && boss == false) {

                        System.out.println("Você tenta escapar e consegue fugir do " + inimigoNome + "!");
                        escape = true;
                        delay(1700);
                        break;

                    }   else if (rng(1, 21) > 10) {

                            System.out.println("Você tenta escapar mas o " + inimigoNome + " bloqueia sua passagem.");
                            escape = false;
                            delay(1700);

                    }   else {

                            System.out.println("Você tenta escapar, você tropeça, cai, e perde\033[31m 2\033[0m de vida" );
                            personagemStatus[1] -= 2;
                            System.out.println("Vida atual: " + personagemStatus[1]);
                            escape = false;
                            delay(1700);

            	    }

                    if (boss == true) {
                        
                        inimigoAtaque(true);

                    }   else if (boss == false && escape == false) {

                            inimigoAtaque(false);

                    }  

                    break;

            }

            if (inimigoStatus[1] < 1) {

                System.out.println("Você derrotou " + inimigoNome + " e ganhou \033[31m" + inimigoStatus[4] + "\033[0m de EXP.");
                levelUp();            
                
            }
            
        } while (personagemStatus[1] > 0 && inimigoStatus[1] > 0 && escape == false);

    }

    public static void inimigoAtaque(boolean boss) {

        if (boss ==  true && rng(1, 21) >= 18 && inimigoNome == "\033[31mAsher, o Lobo Infernal\033[0m") {

            System.out.println(inimigoNome + " imbuiu suas garras e presas em magma ardente e ignorou suas defesas...");
            System.out.println("Causando \033[31m" + inimigoStatus[2] +  "\033[0m de dano!!!");
            personagemStatus[1] -= inimigoStatus[2];
            
        }   else if (boss == true && rng(1, 21) >= 15 && inimigoNome == "\033[38;5;214mAstregor, o Guardião caído\033[0m") {

                System.out.println(inimigoNome + " concentra a energia de seu núcleo perdendo -10 de vida e ganhando +2 de defesa...");
                inimigoStatus[1] -= 10;
                inimigoStatus[3] += 2;

                if (inimigoStatus[1] > 0) {

                    System.out.println("Causando \033[31m" + (inimigoStatus[2] * 0.5 + inimigoStatus[3] - personagemStatus[3]) + "\033[0m de dano!!!" ); 
                    personagemStatus[1] -= inimigoStatus[2] * 0.5 + inimigoStatus[3] - personagemStatus[3];            
                    
                }   else {

                        System.out.println(inimigoNome + " se explodiu...");

                    }
            
            }   else if (boss == true && rng(1, 21) >= 15 && inimigoNome == "\033[32mZarklim, o Rei Goblin\033[0m") {

                    System.out.println(inimigoNome + " chama dois de seus suditos para atacarem junto com ele...");
                    System.out.println("Causando \033[31m" + (inimigoStatus[2] + 2 * 8 - personagemStatus[3]) + "\033[0m de dano!!!");
                
                } else {

                    if ((inimigoStatus[2] - personagemStatus[3]) < 1) {
                                
                        System.out.println(inimigoNome + " lhe causou\033[31m 1 \033[0mde dano.");
                        personagemStatus[1]--;
            
                    }   else {
            
                            System.out.println(inimigoNome + " lhe causou \033[31m" + (inimigoStatus[2] - personagemStatus[3]) + "\033[0m de dano.");
                            //HP personagem     -=    ATQ inimigo   -  DEF personagem
                            personagemStatus[1] -= (inimigoStatus[2] - personagemStatus[3]);                           
            
                        }

                }      

    }

    public static void levelUp() throws InterruptedException {

        personagemStatus[4] += inimigoStatus[4];

        while (personagemStatus[4] >= 10) {
            
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

    public static void status() throws InterruptedException {

        System.out.println("_________________________");
        System.out.println(  "|\tNome:\t"   + personagemNome      +   "\t|"); 
        System.out.println(  "|\tNível:\t"  + personagemStatus[0] +   "\t|"); 
        System.out.println(  "|\tVida:\t"   + personagemStatus[1] + "/" + vidaMax +  "\t|");
        System.out.println(  "|\tAtaque:\t" + personagemStatus[2] +   "\t|");   
        System.out.println(  "|\tDefesa:\t" + personagemStatus[3] +   "\t|");
        System.out.println(  "|\tExp:\t"    + personagemStatus[4] +   "\t|");
        System.out.println("|_______________________|");
        delay(4000);

    }

    public static void trap() throws InterruptedException {

        if (rng(1, 21) >= 16) {

            System.out.println("Você acaba acionando uma armadilha e perde\033[31m -2\033[0m de vida.");
            personagemStatus[1] -= 2;

            System.out.println("Vida atual: " + personagemStatus[1]);
            delay(2000);

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