package base;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

  /*      Integer[] A = SortTools.createSequenceRand(8);
        Arrays.stream(A).forEach(System.out::print);
        System.out.println();
        System.out.println(SortTools.Trade(A,0,A.length- 1));*/





        for (int var : new int[]{100, 1000, 10000, 100000, 200000}) { // Schleife über die einzelnen Arrays

            long avg_dec = 0; // counter für mittlere Zeit
            long avg_inc = 0;
            long avg_rand = 0;
            long avg_alt = 0;

            int loops = 10; // anzahl der durchläufe


            for (int f = 0; f < 3; f++) {
                for (int i = 0; i < loops; i++) { // n-fache sortierung des arrays

                    var dec = SortTools.createSequenceDec(var); // Array erzeugen
                    var inc = SortTools.createSequenceInc(var);
                    var rand = SortTools.createSequenceRand(var);
                    var alt = SortTools.createSequenceAlt(var);

                    long t_start_dec = System.nanoTime();
                    if (f == 0) SortTools.insertionSort(dec);
                    else if (f == 1) SortTools.mergeSort(dec);
                    else SortTools.mergeSortNew(dec);
                    long t_stop_dec = System.nanoTime();

                    long t_start_inc = System.nanoTime();
                    if (f == 0) SortTools.insertionSort(inc);
                    else if (f == 1) SortTools.mergeSort(inc);
                    else SortTools.mergeSortNew(inc);
                    long t_stop_inc = System.nanoTime();

                    long t_start_rand = System.nanoTime();
                    if (f == 0) SortTools.insertionSort(rand);
                    else if (f == 1) SortTools.mergeSort(rand);
                    else SortTools.mergeSortNew(rand);
                    long t_stop_rand = System.nanoTime();

                    long t_start_alt = System.nanoTime();
                    if (f == 0) SortTools.insertionSort(alt);
                    else if (f == 1) SortTools.mergeSort(alt);
                    else SortTools.mergeSortNew(alt);
                    long t_stop_alt = System.nanoTime();

                    avg_dec += t_stop_dec - t_start_dec;
                    avg_inc += t_stop_inc - t_start_inc;
                    avg_rand += t_stop_rand - t_start_rand;
                    avg_alt += t_stop_alt - t_start_alt;
                }

                String algo = (f == 0) ? "Insertion Sort" : (f == 1) ? "Merge Sort" : "Merge Sort (New)";

                System.out.printf("Mean execution Time for %s (Decreasing): %d ns (%3.2e s)\n", algo, avg_dec / loops, (double) (avg_dec / loops) / 1000000000);
                System.out.printf("Mean execution Time for %s (Increasing): %d ns (%3.1e s)\n", algo, avg_inc / loops, (double) (avg_inc / loops) / 1000000000);
                System.out.printf("Mean execution Time for %s (Random): %d ns (%3.1e s)\n", algo, avg_rand / loops, (double) (avg_rand / loops) / 1000000000);
                System.out.printf("Mean execution Time for %s (Alternating): %d ns (%3.1e s)\n\n\n", algo, avg_alt / loops, (double) (avg_alt / loops) / 1000000000);

                /*
                 * Execution Time (Decreasing): 1392 ns; 61818 ns; 228182 ns; 16146550 ns;
                 * 70437808 ns Execution Time (Increasing): 9940 ns; 18820 ns; 35580 ns; 181610
                 * ns; 330860 ns; Execution Time (Random): 21250 ns; 254740 ns; 2194500 ns;
                 * 112249550 ns; 460927470 ns; Execution Time (Alternating): 14420 ns; 143170
                 * ns; 1066100 ns; 60333850 ns; 231798940 ns;
                 */
            }
        }


    }
}
