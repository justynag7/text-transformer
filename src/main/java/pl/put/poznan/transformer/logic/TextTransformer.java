package pl.put.poznan.transformer.logic;

import pl.put.poznan.transformer.exceptions.BadTextTransformationException;

public class TextTransformer {

    private final String[] transforms;

    public TextTransformer(String[] transforms){
        this.transforms = transforms;
    }

    public String transform(String text) throws BadTextTransformationException{
        for(String i : transforms)
        {
                switch (i) {
                    case "upper":
                        text = upper(text);
                    case "lower":
                        text = lower(text);
                    default:
                        throw new BadTextTransformationException();
                }
        }
        return text;
    }
    public String getTransform(int id)
    {
        return transforms[id];
    }

    //functions
    public String upper(String text)
    {
        return text.toUpperCase();
    }

    public String lower(String text)
    {
        return text.toLowerCase();
    }

    public String capitalize(String text)
    {
        return text;
    }


}
