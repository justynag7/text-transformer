package pl.put.poznan.transformer.logic;

/**
 * Klasa sluzaca do transformacji tekstu na format wspierany przez Latex
 *
 * 
 */

public class LatexFormatTransformer extends Decorator{
    
     /**
     * konstruktor tworzacy obiekt dekorujacy podany TextTransformer
     *
     *@param transformer typu TextTransformer
     */

    public LatexFormatTransformer(InterfaceTextTransformer transformer){

        super(transformer);
    }
    
    /**
     * Metoda transformujaca tekst na format wspierany przez Latex
     *
     * @param text typu String przechowuje tekst majacy zostac poddany transformacji
     * @return zwracany jest przetransformowany tekst
     *
     */

    private String latexFormat(String text){

        return text.replace("$", "\\$").replace("&", "\\&");
    }
    
    /**
     * Metoda przekazujaca aktualna modyfikacje textu do transformera, ktory nastepnie wykona metode latexFormat
     *
     * @param text typu String przechowuje tekst majacy zostac poddany transformacji
     * @return zwracane jest wywolanie metody latexFormat
     *
     */

    public String transform(String text){
        return latexFormat(transformer.transform(text));
    }
}
