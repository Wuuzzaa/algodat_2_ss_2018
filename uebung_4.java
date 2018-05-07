import java.util.Arrays;

public class uebung_4 {

    public static int[] insertionSort(int[] sortieren) {
        int temp;
        for (int i = sortieren.length -2; i >=0 ; i--) {
            //for (int i = 1; i < sortieren.length; i++) {
            temp = sortieren[i];
            int j = i;

            while (j < sortieren.length-1 && sortieren[j + 1] > temp) {
                //while (j > 0 && sortieren[j - 1] > temp) {
                sortieren[j] = sortieren[j + 1];
                j++;
            }
            sortieren[j] = temp;
            System.out.println(Arrays.toString(sortieren));
        }
            return sortieren;
    }


    public static int[] shakersort(int[] sortieren) {
        int temp;
        boolean swapped = false;

        do{
            swapped = false;

            for(int i=0; i < sortieren.length-2; i++){
                // Aufsteigend sortieren
                if(sortieren[i] > sortieren[i+1]){
                    temp = sortieren[i+1];
                    sortieren[i+1] = sortieren[i];
                    sortieren[i] = temp;

                    swapped = true;
                }

                // Absteigend sortieren
                if(!swapped){
                    for( int j = sortieren.length-2; j >= 0; j--){
                        if(sortieren[j] >sortieren[j+1]){
                            temp = sortieren[j+1];
                            sortieren[j+1] = sortieren[j];
                            sortieren[j] = temp;

                            swapped = true;
                        }
                    }
                }
            }
        } while(swapped);

        System.out.println(Arrays.toString(sortieren));
        return sortieren;

    }

    public static void main (String[] args){
        int[] unsortiert = { 4, 1, 8, -3, 5, 7 };

        System.out.println(Arrays.toString(unsortiert));
        System.out.println();
        //int[] sortiert = insertionSort(unsortiert);
        int[] sortiert = shakersort(unsortiert);

    }
}
