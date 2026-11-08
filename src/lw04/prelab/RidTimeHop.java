package lw04.prelab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RidTimeHop {

    public static void main(String[] args) throws FileNotFoundException {

        // Read input file
        Scanner input = new Scanner(
            new File("src/lw04/prelab/branches.txt")
        );

        // Read number of branches
        int n = input.nextInt();

        int[] branches = new int[n];

        // Read branch stability values
        for (int i = 0; i < n; i++) {
            branches[i] = input.nextInt();
        }

        // Read number of targets
        int m = input.nextInt();

        int[] targets = new int[m];

        // Read target values
        for (int i = 0; i < m; i++) {
            targets[i] = input.nextInt();
        }

        input.close();

        // Insertion Sort - exactly 3 passes
        for (int i = 1; i <= 3 && i < n; i++) {

            int key = branches[i];
            int j = i - 1;

            while (j >= 0 && branches[j] < key) {
                branches[j + 1] = branches[j];
                j--;
            }

            branches[j + 1] = key;
        }

        // Display sorted array
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(branches[i]);
        }

        System.out.println();

        // Linear Search for each target
        for (int i = 0; i < m; i++) {

            int foundIndex = -1;

            for (int j = 0; j < n; j++) {
                if (branches[j] == targets[i]) {
                    foundIndex = j;
                    break;
                }
            }

            if (foundIndex != -1) {
                System.out.println(
                    targets[i] + ": FOUND at index " + foundIndex
                );
            } else {
                System.out.println(
                    targets[i] + ": NOT FOUND"
                );
            }
        }
    }
}
