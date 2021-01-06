package pl.put.poznan.transformer.logic;

/**
 * Klasa sluzaca do transformacji tekstu do postaci duzych liter
 *
 * 
 */

public class UpperTransformer extends Decorator{
    
    /**
     * konstruktor tworzacy obiekt dekorujacy podany TextTransformer
     *
     *@param transformer typu TextTransformer
     */

    public UpperTransformer(InterfaceTextTransformer transformer){
        super(transformer);
    }
    
    /**
     * Metoda transformujaca tekst do postaci duzych liter
     *
     * @param text typu String przechowuje tekst majacy zostac poddany transformacji
     * @return zwracany jest przetransformowany tekst
     *
     */

    private String upper(String text){
        return text.toUpperCase();
    }
    
    /**
     * Metoda przekazujaca aktualna modyfikacje textu do transformera, ktory nastepnie wykona metode upper
     *
     * @param text typu String przechowuje tekst majacy zostac poddany transformacji
     * @return zwracane jest wywolanie metody upper
     *
     */

    public String transform(String text){
        return upper(transformer.transform(text));
    }
}
