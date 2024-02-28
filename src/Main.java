import design_patterns.builder_example.*;
import design_patterns.factory_example.*;
import design_patterns.singleton_exercise.GuessTheNumber;
import design_patterns.strategy_pattern_exercise.CaeserCipher;
import design_patterns.strategy_pattern_exercise.CipherStrategy;
import design_patterns.strategy_pattern_exercise.Encoder;


public class Main {
    public static void main(String[] args) {
        CaeserCipher newcipher = new CaeserCipher();
        Encoder.encodeMessage(newcipher,"AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz");
    }
}