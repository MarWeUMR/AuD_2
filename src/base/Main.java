package base;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        for (int var : new int[]{100, 1000, 10000, 100000, 200000}) { // Schleife über die einzelnen Arrays

            long avg_dec = 0; // counter für mittlere Zeit
            long avg_inc = 0;
            long avg_rand = 0;
            long avg_alt = 0;

            int loops = 10; // anzahl der durchläufe


            for (int f = 0; f < 3; f++) { // Schleife um die verschiedenen Sortieralgorithmen auszuwählen
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

                System.out.printf("Sorting %d Elements\n", var);
                String algo = (f == 0) ? "Insertion Sort" : (f == 1) ? "Merge Sort" : "Merge Sort (New)";

                System.out.printf("Mean execution Time for %s (Decreasing): %d ns (%3.2e s)\n", algo, avg_dec / loops, (double) (avg_dec / loops) / 1000000000);
                System.out.printf("Mean execution Time for %s (Increasing): %d ns (%3.1e s)\n", algo, avg_inc / loops, (double) (avg_inc / loops) / 1000000000);
                System.out.printf("Mean execution Time for %s (Random): %d ns (%3.1e s)\n", algo, avg_rand / loops, (double) (avg_rand / loops) / 1000000000);
                System.out.printf("Mean execution Time for %s (Alternating): %d ns (%3.1e s)\n\n\n", algo, avg_alt / loops, (double) (avg_alt / loops) / 1000000000);



                /*
                Sorting 100 Elements
                Mean execution Time for Insertion Sort (Decreasing): 126910 ns (1,27e-04 s)
                Mean execution Time for Insertion Sort (Increasing): 5870 ns (5,9e-06 s)
                Mean execution Time for Insertion Sort (Random): 59910 ns (6,0e-05 s)
                Mean execution Time for Insertion Sort (Alternating): 32040 ns (3,2e-05 s)


                Sorting 100 Elements
                Mean execution Time for Merge Sort (Decreasing): 185150 ns (1,85e-04 s)
                Mean execution Time for Merge Sort (Increasing): 51180 ns (5,1e-05 s)
                Mean execution Time for Merge Sort (Random): 103250 ns (1,0e-04 s)
                Mean execution Time for Merge Sort (Alternating): 70430 ns (7,0e-05 s)


                Sorting 100 Elements
                Mean execution Time for Merge Sort (New) (Decreasing): 230860 ns (2,31e-04 s)
                Mean execution Time for Merge Sort (New) (Increasing): 86900 ns (8,7e-05 s)
                Mean execution Time for Merge Sort (New) (Random): 154620 ns (1,5e-04 s)
                Mean execution Time for Merge Sort (New) (Alternating): 117760 ns (1,2e-04 s)


                Sorting 1000 Elements
                Mean execution Time for Insertion Sort (Decreasing): 1025680 ns (1,03e-03 s)
                Mean execution Time for Insertion Sort (Increasing): 11480 ns (1,1e-05 s)
                Mean execution Time for Insertion Sort (Random): 508050 ns (5,1e-04 s)
                Mean execution Time for Insertion Sort (Alternating): 251270 ns (2,5e-04 s)


                Sorting 1000 Elements
                Mean execution Time for Merge Sort (Decreasing): 1617060 ns (1,62e-03 s)
                Mean execution Time for Merge Sort (Increasing): 566440 ns (5,7e-04 s)
                Mean execution Time for Merge Sort (Random): 1164750 ns (1,2e-03 s)
                Mean execution Time for Merge Sort (Alternating): 867010 ns (8,7e-04 s)


                Sorting 1000 Elements
                Mean execution Time for Merge Sort (New) (Decreasing): 2007960 ns (2,01e-03 s)
                Mean execution Time for Merge Sort (New) (Increasing): 941790 ns (9,4e-04 s)
                Mean execution Time for Merge Sort (New) (Random): 1576440 ns (1,6e-03 s)
                Mean execution Time for Merge Sort (New) (Alternating): 1265370 ns (1,3e-03 s)


                Sorting 10000 Elements
                Mean execution Time for Insertion Sort (Decreasing): 54608360 ns (5,46e-02 s)
                Mean execution Time for Insertion Sort (Increasing): 57890 ns (5,8e-05 s)
                Mean execution Time for Insertion Sort (Random): 28888260 ns (2,9e-02 s)
                Mean execution Time for Insertion Sort (Alternating): 15565480 ns (1,6e-02 s)


                Sorting 10000 Elements
                Mean execution Time for Merge Sort (Decreasing): 60207540 ns (6,02e-02 s)
                Mean execution Time for Merge Sort (Increasing): 5335280 ns (5,3e-03 s)
                Mean execution Time for Merge Sort (Random): 34981590 ns (3,5e-02 s)
                Mean execution Time for Merge Sort (Alternating): 21287280 ns (2,1e-02 s)


                Sorting 10000 Elements
                Mean execution Time for Merge Sort (New) (Decreasing): 61910250 ns (6,19e-02 s)
                Mean execution Time for Merge Sort (New) (Increasing): 7005050 ns (7,0e-03 s)
                Mean execution Time for Merge Sort (New) (Random): 38066760 ns (3,8e-02 s)
                Mean execution Time for Merge Sort (New) (Alternating): 23505830 ns (2,4e-02 s)


                Sorting 100000 Elements
                Mean execution Time for Insertion Sort (Decreasing): 6095520130 ns (6,10e+00 s)
                Mean execution Time for Insertion Sort (Increasing): 597160 ns (6,0e-04 s)
                Mean execution Time for Insertion Sort (Random): 4663074620 ns (4,7e+00 s)
                Mean execution Time for Insertion Sort (Alternating): 1519490630 ns (1,5e+00 s)


                Sorting 100000 Elements
                Mean execution Time for Merge Sort (Decreasing): 6104771980 ns (6,10e+00 s)
                Mean execution Time for Merge Sort (Increasing): 9928060 ns (9,9e-03 s)
                Mean execution Time for Merge Sort (Random): 4680176660 ns (4,7e+00 s)
                Mean execution Time for Merge Sort (Alternating): 1529204050 ns (1,5e+00 s)


                Sorting 100000 Elements
                Mean execution Time for Merge Sort (New) (Decreasing): 6111558120 ns (6,11e+00 s)
                Mean execution Time for Merge Sort (New) (Increasing): 17114600 ns (1,7e-02 s)
                Mean execution Time for Merge Sort (New) (Random): 4694345440 ns (4,7e+00 s)
                Mean execution Time for Merge Sort (New) (Alternating): 1536887960 ns (1,5e+00 s)


                Sorting 200000 Elements
                Mean execution Time for Insertion Sort (Decreasing): 24176817130 ns (2,42e+01 s)
                Mean execution Time for Insertion Sort (Increasing): 704870 ns (7,0e-04 s)
                Mean execution Time for Insertion Sort (Random): 19108264180 ns (1,9e+01 s)
                Mean execution Time for Insertion Sort (Alternating): 6012884600 ns (6,0e+00 s)


                Sorting 200000 Elements
                Mean execution Time for Merge Sort (Decreasing): 24196382130 ns (2,42e+01 s)
                Mean execution Time for Merge Sort (Increasing): 18779080 ns (1,9e-02 s)
                Mean execution Time for Merge Sort (Random): 19142222140 ns (1,9e+01 s)
                Mean execution Time for Merge Sort (Alternating): 6031625230 ns (6,0e+00 s)


                Sorting 200000 Elements
                Mean execution Time for Merge Sort (New) (Decreasing): 24210280960 ns (2,42e+01 s)
                Mean execution Time for Merge Sort (New) (Increasing): 33301740 ns (3,3e-02 s)
                Mean execution Time for Merge Sort (New) (Random): 19171934120 ns (1,9e+01 s)
                Mean execution Time for Merge Sort (New) (Alternating): 6047403030 ns (6,0e+00 s)
                * */
            }
        }
    }
}
