import org.w3c.dom.ls.LSOutput;

import java.util.HashMap;
import java.util.regex.Pattern;

public class StringToHashMap {
    public static void main(String[] args){

        String str = "This is<script> just a stupid <script></script> test <script>";
        System.out.println("String ohne Filter: " + str);
        //neue Hashmap erstellen
        HashMap<Integer,String> hashMap = new HashMap<>();
        //String Array erstellen, hier wird einfach nach jedem Leerzeichen ein neues Wort angefangen
        String[] words = str.split(" ");
        int index = 0;


        //String Array in eine Hashmap packen
        for(String word :words){
            hashMap.put(index, word);
            index++;
        }

        System.out.println(hashMap);
        //für jedes Element in der Hashmap die searchforXSS funktion aufrufen
        int size = hashMap.size();
        for(int i =0; i< size; i++){

            String clean = new searchforXSS().search(hashMap.get(i));
            //wenn die Funktion ein Element erwischt, dass gefiltert werden soll, wir dieses Element gelöscht
            if(clean == null){
                System.out.println("error");
                return;
            }
            //die Funktion löscht dann einfach das ganze Element und gibt einen leeren String zurück
            if(clean.equals("") || clean.equals("\0")){
                hashMap.remove(i);
            }
        }
        //nun muss die Hashmap noch irgendwie aufgelöst werden
        String convert = convertHashMapToString(hashMap);
        System.out.println("String mit Filter:  " + convert);
        //String convert2 = new searchforXSS().searchAgain(convert);
        //System.out.println("String mit Filter2: " + convert2);
        String check = new checkPassword().checkmyPassword("1hello1*");
        System.out.println(check);

    }

    //dafür holen wir uns Element für Element aus der Hashmap und fügen es in einen String ein
    public static String convertHashMapToString(HashMap<Integer, ?> hashMap) {
        StringBuilder mapAsString = new StringBuilder("");
        for (Integer key : hashMap.keySet()) {
            mapAsString.append(hashMap.get(key) + " ");
        }
        mapAsString.delete(mapAsString.length()-1, mapAsString.length()).append(" ");
        return mapAsString.toString();
    }



}
