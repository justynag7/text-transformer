package pl.put.poznan.transformer.logic;

public class NoTransformer  implements InterfaceTextTransformer{

    @Override
    public String transform(String text) {
        return text;
    }
}
