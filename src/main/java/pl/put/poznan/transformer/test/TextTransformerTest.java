package pl.put.poznan.transformer.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.exceptions.BadTextTransformationException;
import pl.put.poznan.transformer.logic.TextTransformer;
import org.junit.jupiter.api.*;


public class TextTransformerTest {

    public TextTransformer textTransformer;

    @BeforeEach
    private void setUp() throws BadTextTransformationException {
        String [] empty = {};
        textTransformer = new TextTransformer(empty);
    }

    @Test
    public void lowerCapitalizetest() throws BadTextTransformationException {
        try{
            String[] trans ={"lower","capitalize"};
            textTransformer = new TextTransformer(trans);
            Assertions.assertEquals("Test",textTransformer.transform("TEST"));
        } catch (BadTextTransformationException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void lowerInversetest() throws BadTextTransformationException {
        try{
            String[] trans ={"lower","inverse"};
            textTransformer = new TextTransformer(trans);
            Assertions.assertEquals("tset ",textTransformer.transform("TEST"));
        } catch (BadTextTransformationException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void lowerFullFormtest() throws BadTextTransformationException {
        try{
            String[] trans ={"lower","ToFullForm"};
            textTransformer = new TextTransformer(trans);
            Assertions.assertEquals("profesor",textTransformer.transform("PROF."));
        } catch (BadTextTransformationException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void numbersUppertest() throws BadTextTransformationException {
        try{
            String[] trans ={"NumberToText","upper"};
            textTransformer = new TextTransformer(trans);
            Assertions.assertEquals("DZIESIĘĆ ",textTransformer.transform("10"));
        } catch (BadTextTransformationException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void fullformUppertest() throws BadTextTransformationException {
        try{
            String[] trans ={"ToFullForm","upper"};
            textTransformer = new TextTransformer(trans);
            Assertions.assertEquals("PROFESOR",textTransformer.transform("prof."));
        } catch (BadTextTransformationException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void lowerShortformtest() throws BadTextTransformationException {
        try{
            String[] trans ={"lower","ToShortForm"};
            textTransformer = new TextTransformer(trans);
            Assertions.assertEquals("np.",textTransformer.transform("NA PRZYKŁAD"));
        } catch (BadTextTransformationException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void upperLowerCapitalizetest() throws BadTextTransformationException {
        try{
            String[] trans ={"upper","lower","capitalize"};
            textTransformer = new TextTransformer(trans);
            Assertions.assertEquals("Test",textTransformer.transform("test"));
        } catch (BadTextTransformationException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void upperInversetest() throws BadTextTransformationException {
        try{
            String[] trans ={"upper","inverse"};
            textTransformer = new TextTransformer(trans);
            Assertions.assertEquals("TSET ",textTransformer.transform("test"));
        } catch (BadTextTransformationException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void duplicatesUppertest() throws BadTextTransformationException {
        try{
            String[] trans ={"duplicates","upper"};
            textTransformer = new TextTransformer(trans);
            Assertions.assertEquals("DO ",textTransformer.transform("do do do"));
        } catch (BadTextTransformationException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void duplicatesCapitalizetest() throws BadTextTransformationException {
        try{
            String[] trans ={"duplicates","capitalize"};
            textTransformer = new TextTransformer(trans);
            Assertions.assertEquals("Do ",textTransformer.transform("do do do"));
        } catch (BadTextTransformationException e) {
            e.printStackTrace();
        }

    }




}