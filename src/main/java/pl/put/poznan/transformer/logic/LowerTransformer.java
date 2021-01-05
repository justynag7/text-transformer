package pl.put.poznan.transformer.logic;

public class LowerTransformer extends Decorator {
    public LowerTransformer(InterfaceTextTransformer transformer){
        super(transformer);
    }

    private String lower(String text)
    {
        return text.toLowerCase();
    }

    public String transform(String text){
        return lower(transformer.transform(text));
    }
}
