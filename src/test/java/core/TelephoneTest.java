package core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TelephoneTest {

    @Test
    public void correctNumberWithNoExtraSyntax(){
        String expected = "+16085551212";
        String actual = "";
        Telephone telephone = new Telephone(expected);

        actual = telephone.getNumber();

        assertEquals(expected, actual);
    }

    @Test
    public void correctNumberWithExtraSyntax(){
        String testInput = "+1 (608) 555 - 1212";
        String expected = "+16085551212";
        String actual = "";
        Telephone telephone = new Telephone(testInput);

        actual = telephone.getNumber();

        assertEquals(expected, actual);
    }

    @Test
    public void numberTooLong(){
        String testInput = "+1 (608) 555 - 12122";
        String expected = "invalid";
        String actual = "";
        Telephone telephone = new Telephone(testInput);

        actual = telephone.getNumber();

        assertEquals(expected, actual);
    }

    @Test
    public void numberTooShort(){

    }

    @Test
    public void incorrectPlusOneAtStart(){

    }

}