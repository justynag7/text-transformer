package pl.put.poznan.transformer.logic;

public class DuplicatesTransformer extends Decorator{

    public DuplicatesTransformer(InterfaceTextTransformer transformer){

        super(transformer);
    }

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

    public String transform(String text){

        return duplicates(text);
    }
}