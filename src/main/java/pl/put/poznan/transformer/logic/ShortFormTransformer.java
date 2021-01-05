package pl.put.poznan.transformer.logic;

import java.util.HashMap;
import java.util.Map;

public class ShortFormTransformer extends Decorator{

    public ShortFormTransformer(InterfaceTextTransformer transformer){

        super(transformer);
    }

    private String toShortForm(String text){

        Map<String, String> map = new HashMap<String, String>();
        map.put("na przykład", "np.");
        map.put("profesor", "prof.");
        map.put("i tak dalej", "itd.");
        map.put("doktor", "dr");
        map.put("między innymi", "m.in.");
        map.put("i tym podobne", "itp.");

        //map.put("Na przykład", "Np.");
        //map.put("Profesor", "Prof.");
        //map.put("I tak dalej", "Itd.");
        //map.put("Doktor", "Dr");
        //map.put("Między innymi", "M.in.");
        //map.put("I tym podobne", "Itp.");

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

    public String transform(String text){

        return toShortForm(text);
    }
}