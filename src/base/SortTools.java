package base;

import java.lang.reflect.Array;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SortTools {
    public static Integer[] createSequenceInc(int n) {
        return IntStream.range(1, n + 1).boxed().toArray(Integer[]::new);
    }

    public static Integer[] createSequenceDec(int n) {
        return IntStream.range(0, n).map(i -> n - i + 1 - 1).boxed().toArray(Integer[]::new);
    }

    public static Integer[] createSequenceRand(int n) {
        return new Random().ints(n, 1, n).boxed().toArray(Integer[]::new);
    }

    public static Integer[] createSequenceAlt(int n) {
        return IntStream.range(1, n + 1).map(i -> i % 2 != 0 ? 1 : 2).boxed().toArray(Integer[]::new);
    }

    public static void insertionSort(Integer[] A) {

        for (int i = 1; i < A.length; i++) {

            int var_backup = A[i];
            int j = i - 1;

            while (j >= 0 && A[j] > var_backup) {
                A[j + 1] = A[j];
                j = j - 1;
            }

            A[j + 1] = var_backup;
        }
    }

    public static <T extends Comparable<T>> void insertionSortGen(T[] A) {

        for (int i = 1; i < A.length; i++) {

            T var_backup = A[i];
            int j = i - 1;

            while (j >= 0 && A[j].compareTo(var_backup) > 0) {
                A[j + 1] = A[j];
                j = j - 1;
            }
            A[j + 1] = var_backup;
        }
    }


    @SuppressWarnings("unchecked") // cast Warnung abschalten
    public static <T extends Comparable<T>> void mergeSort(T[] A) {

        // Terminierung
        if (A.length < 2) {
            return;
        }

        // Generische Subarrays erzeugen
        // Was ist denn hier eine alternative Lösung?? 1h google für 2 Zeilen...
        T[] lRay = (T[]) Array.newInstance(A.getClass().getComponentType(), A.length / 2);
        T[] rRay = (T[]) Array.newInstance(A.getClass().getComponentType(), A.length - (A.length / 2));

        // das linke Array auffüllen
        for (int i = 0; i < A.length / 2; i++) {
            lRay[i] = A[i];
        }

        // das rechte Array auffüllen
        for (int i = A.length / 2; i < A.length; i++) {
            rRay[i - A.length / 2] = A[i];
        }

        // rekursiver Aufruf für linkes Array
        mergeSort(lRay);

        // rekursiver Aufruf für rechts Array
        mergeSort(rRay);

        // Reorganisation des Arrays mit startparametern
        merge(A, lRay, rRay, 0, 0, 0);
    }

    private static <T extends Comparable<T>> void merge(T[] A, T[] lRay, T[] rRay, int i, int j, int k) {

        // separates "abarbeiten" der partiellen Arrays
        while (i < lRay.length && j < rRay.length) {

            // wähle kleineres Element aus den beiden Arrays
            if (lRay[i].compareTo(rRay[j]) <= 0) {
                A[k++] = lRay[i++]; // A erhält Wert von lRay an der Stelle i, danach werden i u. k via postfix
                // inkrementiert
            } else {
                A[k++] = rRay[j++];
            }

        }

        while (i < lRay.length) {
            A[k++] = lRay[i++];
        }

        while (j < rRay.length) {
            A[k++] = rRay[j++];
        }
    }


    @SuppressWarnings("unchecked") // cast Warnung abschalten
    public static <T extends Comparable<T>> void mergeSortNew(T[] A) {

        // Terminierung
        if (A.length == 1) {
            return;
        } else if (A.length == 2) {
            mergeSort(A);
        } else {

            T[] lRay, mRay, rRay;

            if (A.length % 3 != 0) {
                lRay = (T[]) Array.newInstance(A.getClass().getComponentType(), A.length / 3);
                mRay = (T[]) Array.newInstance(A.getClass().getComponentType(), A.length / 3);
                rRay = (T[]) Array.newInstance(A.getClass().getComponentType(), A.length - (2 * (A.length / 3)));
            } else {
                // Was ist denn hier eine alternative Lösung?? 1h google für 2 Zeilen...
                lRay = (T[]) Array.newInstance(A.getClass().getComponentType(), A.length / 3);
                mRay = (T[]) Array.newInstance(A.getClass().getComponentType(), A.length / 3);
                rRay = (T[]) Array.newInstance(A.getClass().getComponentType(), A.length / 3);
            }

            // das linke Array auffüllen
            for (int i = 0; i < lRay.length; i++) {
                lRay[i] = A[i];
            }

            // das mittlere Array auffüllen
            for (int i = 0; i < mRay.length; i++) {
                mRay[i] = A[i + lRay.length];
            }

            // das rechte Array auffüllen
            for (int i = 0; i < rRay.length; i++) {
                rRay[i] = A[i + lRay.length + mRay.length];
            }

            // rekursiver Aufruf für linkes Array
            mergeSortNew(lRay);

            // rekursiver Aufruf für mittlere Array
            mergeSortNew(mRay);

            // rekursiver Aufruf für rechts Array
            mergeSortNew(rRay);

            // Reorganisation des Ausgangsarrays
            mergeNew(A, lRay, mRay, rRay);
        }
    }

    private static <T extends Comparable<T>> void mergeNew(T[] A, T[] lRay, T[] mRay, T[] rRay) {

        int h = 0;
        int i = 0;
        int j = 0;
        int k = 0;

        // separates "abarbeiten" der partiellen Arrays
        while (h < lRay.length && i < mRay.length && j < rRay.length) {
            if (lRay[h].compareTo(mRay[i]) <= 0) {
                A[k++] = (lRay[h].compareTo(rRay[j]) <= 0)
                        ? lRay[h++]
                        : rRay[j++];
            } else {
                A[k++] = (mRay[i].compareTo(rRay[j]) <= 0)
                        ? mRay[i++]
                        : rRay[j++];
            }
        }

        T[] a;
        T[] b;

        int count_a;
        int count_b;

        if (h < lRay.length & i < mRay.length) {
            a = lRay;
            b = mRay;

            count_a = h;
            count_b = i;
        } else if (h < lRay.length & j < rRay.length) {
            a = lRay;
            b = rRay;

            count_a = h;
            count_b = j;
        } else {
            a = mRay;
            b = rRay;

            count_a = i;
            count_b = j;
        }

        merge(A, a, b, count_a, count_b, k);
    }

    public static int Trade(Integer[] A, int p, int r) {
        if (p == r ) {
            return 0;
        }
        else {
            int q = (p + r) / 2;
            int t1 = Trade(A,p,q);
            int t2 = Trade(A,q+1, r);
            return maxWin(A,p,r,t1,t2);
        }
    }

    private static int maxWin(Integer[]A, int p, int r, int t1, int t2) {
        int dif = A[r] - A[p];
        return Math.max(dif, Math.max(t1, t2));
    }

}
