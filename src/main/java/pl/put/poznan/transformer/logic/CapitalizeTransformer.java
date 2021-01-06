package pl.put.poznan.transformer.logic;

/**
 * Klasa sluzaca do transformacji tekstu do postaci dużych, pierwszych liter słów
 *
 * 
 */

public class CapitalizeTransformer extends Decorator{
    
    /**
     * konstruktor tworzacy obiekt dekorujacy podany TextTransformer
     *
     *@param transformer typu TextTransformer
     */

    public CapitalizeTransformer(InterfaceTextTransformer transformer){
        super(transformer);
    }
    
    /**
     * Metoda transformujaca tekst do postaci dużych, pierwszych liter słów
     *
     * @param text typu String przechowuje tekst majacy zostac poddany transformacji
     * @return zwracany jest przetransformowany tekst
     *
     */

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
    
    /**
     * Metoda przekazujaca aktualna modyfikacje textu do transformera, ktory nastepnie wykona metode capitalize
     *
     * @param text typu String przechowuje tekst majacy zostac poddany transformacji
     * @return zwracane jest wywolanie metody capitalize
     *
     */

    public String transform(String text){
        return capitalize(transformer.transform(text));
    }
}
