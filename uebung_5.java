public class uebung_5 {
    public static void print_wechselgeld(int[] muenzen, int wechselgeld){
        /*
        Vorraussetzungen:
        - muenzenwerte sind aufsteigend sortiert
        - 1 ist in muenzwerten enthalten damit jedes Wechselgeld zurückgegeben werden kann
        - 7 Münzen, sonst muss das ausgabe_array angepasst werden -> nicht flexibel...
         */
        int rest = wechselgeld;
        int[] ausgabe_array = {0,0,0,0,0,0,0};

        // O(k²) ?
        /*
        while(rest > 0){
            for(int i=muenzen.length -1; i >= 0; i--){
                if(rest - muenzen[i] >= 0) {
                    rest -= muenzen[i];
                    //System.out.println(muenzen[i] + " ausgegeben. Restgeld: " + rest);  //DEBUG
                    ausgabe_array[i] += 1;
                    break;
                }
            }
        }

        */
        // O(k)
        for(int i=muenzen.length -1; i >= 0; i--){
            ausgabe_array[i] = rest / muenzen[i];
            rest -= ausgabe_array[i] * muenzen[i];
        }

        // Ausgabe auf Konsole
        for(int i=0; i< muenzen.length; i++){
            System.out.println(muenzen[i] + " werden " + ausgabe_array[i] + " mal zurückgegeben");
        }
    }


    public static void main (String[] args){
        int[] muenzen = { 1,2,5,10,20,50,100};
        int wechselgeld = 42;

        print_wechselgeld(muenzen, wechselgeld);
    }
}
