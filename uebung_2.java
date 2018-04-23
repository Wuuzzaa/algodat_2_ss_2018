import java.util.ArrayList;
import java.util.Arrays;

public class uebung_2 {
    public static void geheim1 (int[] A, int n){
        //Aufgabe 3.1 (a+b)Array wird aufsteigend sortiert (Bubblesort)
        for(int i=0; i < n; i++){
            for(int j= n-1; j >= i+1; j--){
                if(A[j] < A[j-1]){
                    int temp = A[j];
                    A[j] = A[j-1];
                    A[j-1] = temp;
                }
            }
            System.out.println(Arrays.toString(A));
        }
        System.out.println(Arrays.toString(A));
    }

    public static void geheim2(int a, int n){
        // Aufgabe 3.2 Algo. gibt a^n aus.
        int x = 1;
        int p = a;

        while(n>0){
            if(n%2 == 1){
                x *= p;
            }

            n /= 2;
            p *= p;
        }

        System.out.println("x: " + x);
    }

    // Aufgabe 3.3 Funktionen gemäß Zuwachsraten sortieren
    // REIHENFOLGE NICHT GERRüFT
    // 4n log2 n +2n        4
    // 2^10                 0
    // 2^logn               7
    // 3n + 100 log2n       2
    // 4n                   1
    // 2^n                  8
    // n^2 +10n             5
    // n^3                  6
    // n log2n              3

    public static void zuwachstest(){
        int [] A = {1,5,10,20,50,100,1000,10000};

        for(int i = 0; i < A.length; i++){
            System.out.print((int) (4*A[i] * Math.log(A[i])/Math.log(2) + 2*A[i]) + ",");
            System.out.println();
            System.out.print((int) (Math.pow(2,10)));
            // und so weiter keine lust zu tippen
        }
    }


    // Aufgabe 3.4 Rekursionsaufrufe (von oben nach unten)
    // Power(2, 9)
    // Power(2, 4)
    // Power(2, 2)
    // Power(2, 1)
    // Power(2, 0)

    // Aufgabe 3.5
    // Berechnet den ganzzahligen Teil des Logarithmus zur Basis 2
    public static void log(int x){
        int log = 0;
        int X = x;

        while(x > 1){
            x /= 2;
            log +=1;
        }

        System.out.println(X + " log 2 = " + log);
    }

    // Aufgabe 3.6
    // Gegeben sei ein Array A mit n verschiedenen Integerzahlen, die in aufsteigender
    // Reihenfolge sortiert sind. Beschreiben Sie einen rekursiven Algorithmus in Pseudocode,
    // um für eine gegebene Integerzahl k zwei Zahlen in A zu finden, deren Summe
    // gleich k ist.
    public static void check_summe(ArrayList<Integer> A, int k){
        int n = A.size();

        // Abbruchbedingung
        if(n == 1){
            System.out.println("Summe von " + k + " ist nicht erzeugbar");
            return;
        }

        int summe = A.get(0) + A.get(n-1);

        // Treffer
        if(summe == k){
            System.out.println(k + " = " + A.get(0) + " + " + A.get(n-1));
            return;
        }

        // Summe zu groß => größtes Element aus Array löschen
        else if(summe > k) {
            A.remove(n-1);
            check_summe(A, k);
            return;
        }
        // Summe zu niedrig => niedrigstes Element aus Array löschen
        else if(summe < k) {
            A.remove(0);
            check_summe(A, k);
            return;
        }
    }


    public static void main (String[] args){
        //int [] A = {6,5,4,3,2,1};

        //geheim1(A,6);
        //geheim2(2,6);
        //log(7789);
        //zuwachstest();

        ArrayList<Integer> A = new ArrayList<Integer>();
        for(int i = 1; i <=1000; i++){
            A.add(i);
        }

        check_summe(A, 1467);


    }
}
