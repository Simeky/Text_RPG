package text_rpg;

import java.util.Random;

public class teste {

    public static int rng() {

        Random random = new Random();
        int rng = random.nextInt(1, 21);

        return rng;
    }

    public static void main(String[] args) {

        Random random = new Random();
        int r;

        

        for (byte i = 0; i < 10; i++) {

            if (rng() == 10) {

            System.out.println("Abacate");

            }

        }
        
    }
    
}
