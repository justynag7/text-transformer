package pl.put.poznan.transformer.logic;

/**
 * Klasa sluzaca do transformacji tekstu do postaci bez powtorzen wyrazow
 *
 *
 */

public class DuplicatesTransformer extends Decorator{
    
    /**
     * konstruktor tworzacy obiekt dekorujacy podany TextTransformer
     *
     *@param transformer typu TextTransformer
     */

    public DuplicatesTransformer(InterfaceTextTransformer transformer){

        super(transformer);
    }
    
    /**
     * Metoda transformujaca tekst do postaci bez powtorzen wyrazow
     *
     * @param text typu String przechowuje tekst majacy zostac poddany transformacji
     * @return zwracany jest przetransformowany tekst
     *
     */

    private String duplicates(String text){

        String listed[] = text.split(" ");
        StringBuilder result = new StringBuilder();
        result.append(listed[0]);
        result.append(" ");
        for (int i = 1; i < listed.length; i++) {

            if (!(listed[i].equals(listed[i - 1])) ) {
                result.append(listed[i]);
                result.append(" ");
            }

        }
        return result.toString();
    }
    
    /**
     * Metoda przekazujaca aktualna modyfikacje textu do transformera, ktory nastepnie wykona metode duplicates
     *
     * @param text typu String przechowuje tekst majacy zostac poddany transformacji
     * @return zwracane jest wywolanie metody duplicates
     *
     */

    public String transform(String text){
        return duplicates(transformer.transform(text));
    }
}
