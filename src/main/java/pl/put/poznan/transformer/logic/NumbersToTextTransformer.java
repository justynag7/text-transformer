package pl.put.poznan.transformer.logic;

public class NumbersToTextTransformer extends Decorator{

    public NumbersToTextTransformer(InterfaceTextTransformer transformer){
        super(transformer);
    }

    private boolean isNumber(String word){

        for (int i = 0; i < word.length(); i++){
            char tmpChar = word.charAt(i);
            if ((tmpChar < '0' || tmpChar > '9') && (tmpChar != '.' && tmpChar != ',')){
                return false;
            }
        }
        return true;
    }
    private boolean isFloat(String word){

        for (int i = 0; i < word.length(); i++){
            char tmpChar = word.charAt(i);
            if (tmpChar == '.' || tmpChar == ','){
                return true;
            }
        }
        return false;
    }

    private String convertIntPart(String numberToConvert){

        String[] setki = {"", "sto", "dwieście", "trzysta", "czterysta", "pięćset", "sześćset", "siedemset", "osiemset", "dziewięćset"};
        String[] nascie = {"dziesięć", "jedenaście", "dwanaście", "trzynaście", "czternaście", "piętnaście", "szesnaście", "siedemnaście", "osiemnaście", "dziewiętnaście"};
        String[] dziesiatki = {"", "dziesięć", "dwadzieścia", "trzydzieści", "czterdzieści", "pięćdziesiąt", "sześćdziesiąt", "siedemdziesiąt", "osiemdziesiąt", "dziewięćdziesiąt"};
        String[] jednosci = {"", "jeden", "dwa", "trzy", "cztery", "pięć", "sześć", "siedem", "osiem", "dziewięć"};

        StringBuilder result = new StringBuilder();
        StringBuilder newStr = new StringBuilder();

        boolean intiger = true;
        for(int i = 0; i < numberToConvert.length(); i++) {
            char tmpChar = numberToConvert.charAt(i);
            if(tmpChar == '.' || tmpChar == ','){
                intiger = false;
            }
            if(intiger){
                newStr.append(tmpChar);
            }
        }
        for(int i = newStr.length() - 1; i >= 0; i--){
            int idx = newStr.charAt(i) - '0';

            if(newStr.length() - 1 - i == 0) {
                result.insert(0, jednosci[idx]);
            }
            else if(newStr.length() - 1 - i == 1) {
                if(idx == 1){
                    int b = newStr.charAt(i+1) - '0';
                    result.setLength(0);
                    result.insert(0, nascie[b]);
                }
                else {
                    if(newStr.charAt(i) != '0' && newStr.charAt(i + 1) != '0') result.insert(0, ' ');
                    result.insert(0, dziesiatki[idx]);
                }
            }
            else if(newStr.length() - 1 - i == 2) {
                if(newStr.charAt(1) != '0' || newStr.charAt(2) != '0') result.insert(0, ' ');
                result.insert(0, setki[idx]);
            }
        }

        return result.toString();

    }

    private String convertFloatPart(String numberToConvert){

        String[] dziesiatki = {"", "dziesięć", "dwadzieścia", "trzydzieści", "czterdzieści", "pięćdziesiąt", "sześćdziesiąt", "siedemdziesiąt", "osiemdziesiąt", "dziewięćdziesiąt"};
        String[] nascie = {"dziesięć", "jedenaście", "dwanaście", "trzynaście", "czternaście", "piętnaście", "szesnaście", "siedemnaście", "osiemnaście", "dziewiętnaście"};
        String[] czesci_ulamkowe = {"", "jedna", "dwie", "trzy", "cztery", "pięć", "sześć", "siedem", "osiem", "dziewięć"};
        String[] jednosci = {"", "jeden", "dwie", "trzy", "cztery", "pięć", "sześć", "siedem", "osiem", "dziewięć"};

        StringBuilder newStr = new StringBuilder();
        StringBuilder result = new StringBuilder();

        boolean floating = false;
        for(int i = 0; i < numberToConvert.length(); i++) {
            char tmpChar = numberToConvert.charAt(i);
            if(floating){
                newStr.append(tmpChar);
            }
            if(tmpChar == '.' || tmpChar == ','){
                floating = true;
            }
        }
        if(newStr.charAt(0) == '1' && newStr.length() == 2){
            int idx = newStr.charAt(1) - '0';
            result.append(nascie[idx]);
            result.append(" ");
            result.append("setnych");
        }
        else if(newStr.length() == 2){
            int idx = newStr.charAt(0) - '0';
            int idx2 = newStr.charAt(1) - '0';
            result.append(dziesiatki[idx]);
            if(idx != 0) result.append(" ");
            if(idx == 0 && idx2 == 1) result.append("jedna");
            else result.append(jednosci[idx2]);
            if(idx2 != 0) result.append(" ");
            if(idx2 == 2 || idx2 == 3 || idx2 == 4) result.append("setne");
            else if(idx == 0 && idx2 == 1) result.append("setna");
            else if(idx != 0 || idx2 != 0) result.append("setnych");
        }
        else{
            int idx = newStr.charAt(0) - '0';
            result.append(czesci_ulamkowe[idx]);
            if(idx != 0) result.append(" ");
            if(idx == 1) result.append("dziesiąta");
            else if(idx == 2 || idx == 3 || idx == 4) result.append("dziesiąte");
            else if(idx != 0) result.append("dziesiątych");
        }

        return result.toString();
    }


    private String numbersToText(String text){

        String[] words = text.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words){
            if (isNumber(word)){
                String intPart = convertIntPart(word);
                result.append(intPart);
                if (isFloat(word)){
                    String floatPart = convertFloatPart(word);
                    if(intPart.length() > 0 && floatPart.length() > 0){
                        result.append(" i ");
                    }
                    if(!floatPart.equals(" ")){
                        result.append(floatPart);
                    }
                }
                if(word.equals("0") || word.equals("0.0") || word.equals("0,0")){
                    result.append("zero");
                }
                result.append(" ");
            }
            else{
                result.append(word);
                result.append(" ");
            }
        }
        text = result.toString();
        return text;
    }

    public String transform(String text){
        return numbersToText(transformer.transform(text));
    }
}