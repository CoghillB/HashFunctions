import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Hashing {

    // with ~341,000 words, a table size of 1mil keeps the load factor low
    static final int tableSize = 1_000_000;

    public static void main(String[] args) throws IOException {
        // TODO: You will be hashing strings using polynomial in k, for all values
        // k=1 to 100. Once you have this one case (of k=31) working, you will
        // probably want to wrap your code in a for loop for k=1 to 100
        ArrayList<Integer> collisionResults = new ArrayList<>();
        ArrayList<Integer> bucketResults = new ArrayList<>();
        int i;
        for (i = 1; i <= 100; i++) {

            // Leave these two lines alone for opening the input file
            FileReader f = new FileReader("src/englishWords.txt");
            Scanner sc = new Scanner(f);

            // This creates your hashtable or simulated hashtable of size tableSize
            int[] counts = new int[tableSize];
            int collisions = 0;
            // This loop runs through the words in the file

            while (sc.hasNext()) {
                String s = sc.nextLine();

                // DONE: Find hashValue of s using hash(s,k). Update your simulated hashtable
                // note: if your hash(s,k) function is correct, hash(s,31) should
                //			correspond exactly to s.hashCode();
                int index = hash(s, i);

                index = (index & Integer.MAX_VALUE) % tableSize;

                // DONE: Don't forget to count collisions
                if (counts[index] > 0) {
                    collisions++;
                }
                counts[index]++;
            }
            // DONE: Find the maximum bucket size
            int maxBucketSize = 0;
            for (int count : counts) {
                if (count > maxBucketSize) {
                    maxBucketSize = count;
                }
            }
            collisionResults.add(collisions);
            bucketResults.add(maxBucketSize);

            // grabbing top three k values with the least buckets and collisions

            // DONE: Report the total number of collisions found at this k value
//            System.out.println("k = " + i);
//            System.out.println("Total number of collisions: " + collisions);
//
//            // DONE: Report the maximum bucket size found at this k value
//            System.out.println("Maximum bucket size: " + maxBucketSize + "\n");
//            // Leave this line alone to close the input file
            f.close();
            sc.close();
        }
        // sort the ArrayLists
        Collections.sort(collisionResults);
        Collections.sort(bucketResults);

        //TODO: fix
        if (collisionResults.size() > 2 && bucketResults.size() > 2) {
            System.out.println("Three smallest collision counts:");
            for (int j = 0; j < 3; j++) {
                System.out.println("k = " + (i));
                System.out.println("Total number of collisions: " + collisionResults.get(j));
                System.out.println("Maximum bucket size: " + bucketResults.get(j) + "\n");
            }

        }

    }
        public static int hash (String s,int k){
            int value = 0;
            // DONE: Compute the hash function in O(n) time, where n = s.length()
            // You can do this using Horner's method to compute the polynomial
            // s[0]*k^(n-1) + s[1]*k^(n-2) + ... + s[n-1]
            for (int i = 0; i < s.length(); i++) {
                value = value * k + s.charAt(i);
            }
            return value;
        }
    }

/***********************************************************
 * Report your best k values here in this comment block
 * (if you want, you can output all k values and then visually
 * inspect your output for your 3 best k values). Give your 3
 * best k-values for (i) the smallest total number of collisions,
 * and also give another set of (ii) your 3 best k-values according
 * to the smallest value for the max-bucket-size.
 *
 *
 */