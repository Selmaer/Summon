package summon;

import java.util.Random;
import java.util.Scanner;

public class Summon {
    
    public static final double twoStar = 0;
    public static final double threeStar = 77.84;
    public static final double fourStar = 19;
    public static final double fiveStar = 3.16;
    
    public static int totalScrolls = 0;
    public static int totalFiveStars = 0;
    
    private static Random rand = new Random();

    public static int prob() {
        
        double chance = rand.nextDouble() * 100;
        if (chance <= twoStar)
            return 2;
        else if (chance > twoStar && chance <= twoStar + threeStar)
            return 3;
        else if (chance > twoStar + threeStar && chance <= twoStar + threeStar + fourStar)
            return 4;
        else if (chance > twoStar + threeStar + fourStar && chance <= twoStar + 
                threeStar + fourStar + fiveStar)
            return 5;
        else return 1;
    } 
    
    public static String summon(int times) {
        int oneS = 0;
        int twoS = 0;
        int threeS = 0;
        int fourS = 0;
        int fiveS = 0;
        
        for (int i = 0; i < times; i++) {
            int stars = prob();
        
            switch (stars) {
                default : oneS++; break;
                case 2 : twoS++; break;
                case 3 : threeS++; break;
                case 4 : fourS++; break;
                case 5 : fiveS++; 
            }
        }
        totalScrolls += times;
        totalFiveStars += fiveS;
        
        return ("\t\t\t While summoning your heroes you wasted " + times + " magic scrolls \n"
               + "\t\t\t\t\t and enwoked such heroes: \n\n"
                + "\t\t\t\t\t\t     *     : " + oneS +"\n"
                + "\t\t\t\t\t\t    * *    : " + twoS + "\n"
                + "\t\t\t\t\t\t   * * *   : " + threeS + "\n"
                + "\t\t\t\t\t\t  * * * *  : " + fourS + "\n"
                + "\t\t\t\t\t\t # # # # # : " + fiveS + "\n\n"
                + "\t\t Totally you used " + totalScrolls + " and got " +
                    totalFiveStars + " 5-star heroes. \n"
                + "\t\t Enter the amount of scrolls you want to use next time or any char to exit");
    }
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\t\t\t\t Enter the amount of scrolls you want to use:");
        while(sc.hasNextInt())
        System.out.println(summon(sc.nextInt()));
    }

}
