package pl.put.poznan.transformer.logic;

import pl.put.poznan.transformer.exceptions.BadTextTransformationException;

public class TextTransformer implements InterfaceTextTransformer{
    private InterfaceTextTransformer transformer;

    public TextTransformer(String[] transforms) throws BadTextTransformationException{
        transformer = new NoTransformer();
        for(String transform : transforms){
            switch(transform){
                case "upper":
                    transformer = new UpperTransformer(transformer);
                case "lower":
                    //to do
                    break;
                case "capitalize":
                    //to do
                    break;
                case "inverse":
                    //to do
                    break;
                case "superinverse":
                    //to do z zachowaniem wielkich i malych liter
                    break;
                case "integers":
                    //zamiana liczb całkowitych do 1000
                    break;
                case "floats":
                    //zamiana liczb zmiennoprzecinkowych do części setnych
                    break;
                case "shortcuts":
                    //na przykład -> np. itp niezależnie od wielkości liter
                    break;
                case "cutshorts":
                    //rozwiniecie skrótu prof -> profesor
                    break;
                case "latexformat":
                    //przeksztalcenie tekstu do formatu wspieranego przez latex
                    break;
                case "duplicates":
                    //zamiana dowolnej liczby powtarzających się wyrazów
                    break;
                default:
                     throw new BadTextTransformationException();
            }
        }
    }

    public String transform(String text)
    {
        return this.transformer.transform(text);
    }
}
