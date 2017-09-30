package arrays;

import java.util.Scanner;
import java.util.StringTokenizer;

public class HorizontalAndVerticalIntersection {

    public static void main(String ...args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of V lines");
        int numV = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter V");
        int i = 0;
        int[][] v = new int[numV][3];
        while (i < numV) {
            String vString = scanner.nextLine();
            vString = vString.replace(" ", " ");
            StringTokenizer tokenizer = new StringTokenizer(vString, " ");
            v[i][0] = Integer.parseInt(tokenizer.nextToken());
            v[i][1] = Integer.parseInt(tokenizer.nextToken());
            v[i][2] = Integer.parseInt(tokenizer.nextToken());
            i++;
        }
        System.out.println("Enter the number of H lines");
        int numH = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter H");
        i = 0;
        int[][] h = new int[numH][3];
        while (i < numH) {
            String hString = scanner.nextLine();
            hString = hString.replace(" ", " ");
            StringTokenizer tokenizer = new StringTokenizer(hString, " ");
            h[i][0] = Integer.parseInt(tokenizer.nextToken());
            h[i][1] = Integer.parseInt(tokenizer.nextToken());
            h[i][2] = Integer.parseInt(tokenizer.nextToken());
            i++;
        }

        int count = 0;

        for(i = 0; i < numV; i++) {
            for (int j = 0; j < numH; j++) {
                if (v[i][0] >= h[j][1] && v[i][0] <= h[j][2]) {
                    if(h[j][0] >= v[i][1] && h[j][0] <= v[i][2]) {
                        count++;
                    }
                }
            }
        }

        System.out.println("Number of Intersections = " + count);
    }
}
