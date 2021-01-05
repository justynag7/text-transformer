package pl.put.poznan.transformer.logic;

public class CapitalizeTransformer extends Decorator{

    public CapitalizeTransformer(InterfaceTextTransformer transformer){
        super(transformer);
    }

    private String capitalize(String text){

        char[] textToChars = text.toCharArray();
        for (int i = 0; i < text.length(); i++){
            if (i == 0 && textToChars[i] != ' ' ||
                    textToChars[i] != ' ' && textToChars[i - 1] == ' ') {
                if (textToChars[i] >= 'a' && textToChars[i] <= 'z') {
                    textToChars[i] = (char)(textToChars[i] - 'a' + 'A');
                }
            }
        }
        text = String.valueOf(textToChars);
        return text;
    }

    public String transform(String text){

        return capitalize(text);
    }
}
