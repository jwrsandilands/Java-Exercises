package design_patterns.strategy_pattern_exercise;

import java.util.Arrays;

public class CaeserCipher implements CipherStrategy {

    @Override
    public String encode(String input) {
        char[] characters = input.toUpperCase().toCharArray();
        int stepNumber = 5;

        if(stepNumber < 0 || stepNumber > 26){
            System.out.println("number outside of alphabet!");
            return "";
        }
        for(int count = 0; count < characters.length; count++){
            if(characters[count] + stepNumber > 90){
                characters[count] = (char) (characters[count] + stepNumber - 26);
            }
            else{
                characters[count] += (char) stepNumber;
            }
        }

        return Arrays.toString(characters);
    }
}
