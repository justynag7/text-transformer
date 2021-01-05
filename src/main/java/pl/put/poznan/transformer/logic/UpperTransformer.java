package pl.put.poznan.transformer.logic;

public class UpperTransformer extends Decorator {

    public UpperTransformer(InterfaceTextTransformer transformer){
        super(transformer);
    }

    private String upper(String text)
    {
        return text.toUpperCase();
    }

    public String transform(String text){
        return upper(text);
    }
}
