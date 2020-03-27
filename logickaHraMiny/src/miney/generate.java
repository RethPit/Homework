package miney;

import java.util.Random;

public class generate {

    int width = 8;
    int height = 8;
    int pocetMin = 4;
    int[][] array;

    public generate() {
        array = new int[width][height];

    }

    Random rand = new Random();

    public void generateMiny() {  //generovani min
        int i = 0;

        while (i < pocetMin) {
            int x = rand.nextInt(width);
            int y = rand.nextInt(height);
            if (array[x][y] != 9) {
                array[x][y] = 9;
                i++;
            }
        }
    }

    public void ohodnoceni() { //ohodnoceni podle souradnici 
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (array[x][y] == 9) {
                    if (x - 1 >= 0 && y - 1 >= 0 && array[x - 1][y - 1] != 9) {
                        array[x - 1][y - 1] += 1;
                    }
                    
                    if (y - 1 >= 0 && array[x][y - 1] != 9) {
                        array[x][y - 1] += 1;
                    }
                    
                    if (x + 1 < width && y - 1 >= 0 && array[x + 1][y - 1] != 9) {
                        array[x + 1][y - 1] += 1;
                    }                
                
                    if (x - 1 >= 0 && array[x - 1][y] != 9) {
                        array[x - 1][y] += 1;
                    }
                    
                    if (x + 1 < width && array[x + 1][y] != 9) {
                        array[x + 1][y] += 1;
                    }
                  
                    if (x - 1 >= 0 && y + 1 < height && array[x - 1][y + 1] != 9) {
                        array[x - 1][y + 1] += 1;
                    }
                    
                    if (y + 1 < height && array[x][y + 1] != 9) {
                        array[x][y + 1] += 1;
                    }
                    
                    if (x + 1 < width && y + 1 < height && array[x + 1][y + 1] != 9) {
                        array[x + 1][y + 1] += 1;
                    }
                }
            }
        }
    }

    public void renderPole() { //render pole
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (array[x][y] == 9) {
                    System.out.print(" X ");
                } else {
                    System.out.print(" " + array[x][y] + " ");
                }

            }
            System.out.print("\n");
        }
    }

}
