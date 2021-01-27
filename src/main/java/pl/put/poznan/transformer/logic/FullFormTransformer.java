package pl.put.poznan.transformer.logic;

import java.util.HashMap;
import java.util.Map;
/**
 * Klasa sluzaca do transformacji tekstu na format z rozwinietymi skrótami
 *
 *
 */
public class FullFormTransformer extends Decorator{
    
    /**
     * konstruktor tworzacy obiekt dekorujacy podany TextTransformer
     *
     *@param transformer typu TextTransformer
     */

    public FullFormTransformer(InterfaceTextTransformer transformer){

        super(transformer);
    }
    
    /**
     * Metoda transformujaca tekst na format z rozwinietymi skrótami
     *
     * @param text typu String przechowuje tekst majacy zostac poddany transformacji
     * @return zwracany jest przetransformowany tekst
     *
     */

    private String toFullForm(String text){

        Map<String, String> map = new HashMap<String, String>();
        map.put("np.", "na przykład");
        map.put("prof.", "profesor");
        map.put("itd.", "i tak dalej");
        map.put("dr", "doktor");
        map.put("m.in.", "między innymi");
        map.put("itp.", "i tym podobne");

        map.put("Np.", "Na przykład");
        map.put("Prof.", "Profesor");
        map.put("Itd.", "I tak dalej");
        map.put("Dr", "Doktor");
        map.put("M.in.", "Między innymi");
        map.put("Itp.", "I tym podobne");
        //map.put("m.in.", "między innymi");
        //map.put("itp.", "i tym podobne");
        //map.put("rigcz", "rozum i godność człowieka");
        //map.put("mgr", "magister");
        //map.put("chleb i bułki", "pieczywo");
        //map.put("jw.", "jak wyżej");
        //map.put("św.", "święty");

        for (Map.Entry<String, String> entry : map.entrySet()){
            int index = text.indexOf(entry.getKey());
            while (index >= 0){
                text = text.replace(entry.getKey(), entry.getValue());
                index = text.indexOf(entry.getKey());
            }
        }
        return text;
    }
    
    /**
     * Metoda przekazujaca aktualna modyfikacje textu do transformera, ktory nastepnie wykona metode toFullForm
     *
     * @param text typu String przechowuje tekst majacy zostac poddany transformacji
     * @return zwracane jest wywolanie metody toFullForm
     *
     */

    public String transform(String text){
        return toFullForm(transformer.transform(text));
    }
}
