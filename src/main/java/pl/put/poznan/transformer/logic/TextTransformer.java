package pl.put.poznan.transformer.logic;

public class TextTransformer {

    private final String[] transforms;

    public TextTransformer(String[] transforms){
        this.transforms = transforms;
    }

    public String transform(String text){

        return text.toUpperCase();
    }
    public String getTransform(int id)
    {
        return transforms[id];
    }

    //functions
}
