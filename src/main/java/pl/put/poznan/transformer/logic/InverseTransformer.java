package pl.put.poznan.transformer.logic;

import java.util.ArrayList;
import java.util.List;

public class InverseTransformer extends Decorator{

    public InverseTransformer(InterfaceTextTransformer transformer){
        super(transformer);
    }

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

    public String transform(String text){

        return inverse(text);
    }
}