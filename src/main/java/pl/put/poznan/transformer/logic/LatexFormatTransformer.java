package pl.put.poznan.transformer.logic;

public class LatexFormatTransformer extends Decorator{

    public LatexFormatTransformer(InterfaceTextTransformer transformer){

        super(transformer);
    }

    private String latexFormat(String text){

        return text.replace("$", "\\$").replace("&", "\\&");
    }

    public String transform(String text){
        return latexFormat(transformer.transform(text));
    }
}