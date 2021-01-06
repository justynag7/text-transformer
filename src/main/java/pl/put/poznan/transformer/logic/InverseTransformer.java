package pl.put.poznan.transformer.logic;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasa sluzaca do transformacji tekstu do postaci odwroconej kolejnosci liter w slowach z zachowaniem kolejnosci ich wielkosci
 *
 * 
 */

public class InverseTransformer extends Decorator{
    
    /**
     * konstruktor tworzacy obiekt dekorujacy podany TextTransformer
     *
     *@param transformer typu TextTransformer
     */

    public InverseTransformer(InterfaceTextTransformer transformer){
        super(transformer);
    }
    
     /**
     * Metoda transformujaca tekst do postaci odwroconej kolejnosci liter w slowach
     *
     * @param text typu String przechowuje tekst majacy zostac poddany transformacji
     * @return zwracany jest przetransformowany tekst
     *
     */

    private String inverse(String text){

        char[] textToChars = text.toCharArray();
        List<Integer> s = new ArrayList<Integer>();
        for (int i = 0; i < text.length(); i++){
            if (textToChars[i] >= 'A' && textToChars[i] <= 'Z'){
                s.add(i);
            }
        }
        String tmpReverse = "";
        for (int j = text.length()-1; j >= 0; j--){
            tmpReverse += text.charAt(j);
        }
        text = tmpReverse;
        textToChars = text.toCharArray();
        tmpReverse = "";
        int idx = 0;
        for (int i = 0; i < text.length(); i++){
            if (s.get(idx) == i){
                if (textToChars[i] >= 'a' && textToChars[i] <= 'z'){
                    textToChars[i] -= 32;
                }
                if (idx < s.size()-1){
                    idx += 1;
                }
            }
            else{
                if (textToChars[i] >= 'A' && textToChars[i] <= 'Z'){
                    textToChars[i] += 32;
                }
            }
            tmpReverse += textToChars[i];
        }
        text = tmpReverse;
        return text;
    }
    
    /**
     * Metoda przekazujaca aktualna modyfikacje textu do transformera, ktory nastepnie wykona metode inverse
     *
     * @param text typu String przechowuje tekst majacy zostac poddany transformacji
     * @return zwracane jest wywolanie metody inverse
     *
     */

    public String transform(String text){
        return inverse(transformer.transform(text));
    }
}
