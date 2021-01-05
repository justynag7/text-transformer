package pl.put.poznan.transformer.logic;

import java.util.HashMap;
import java.util.Map;

public class FullFormTransformer extends Decorator{

    public FullFormTransformer(InterfaceTextTransformer transformer){

        super(transformer);
    }

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

    public String transform(String text){

        return toFullForm(text);
    }
}