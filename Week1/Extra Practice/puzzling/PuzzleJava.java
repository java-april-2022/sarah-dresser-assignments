import java.util.Random;
// import java.util.Arrays;
import java.util.ArrayList;

public class PuzzleJava {

    // instantiate Random
    Random randMachine = new Random();

    public ArrayList<Integer> getTenRolls(){
        ArrayList<Integer> rolls = new ArrayList<Integer>();
        for(int i=0; i<10; i++){
            rolls.add(randMachine.nextInt(21));
        }
        return rolls;
    }

    public char getRandomLetter(){
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char letter = alphabet[randMachine.nextInt(26)];
        return letter;
    }

    public String generatePassword(){
        // use previous method
        // char[] passwordChars = "abcdefghijklmnopqrstuvwxyz1234567890!@#$%".toCharArray();
        StringBuilder password = new StringBuilder();
        for(int i=0; i<8; i++){
            password.append(getRandomLetter());
        }
        return password.toString();
    }

    public ArrayList<String> getNewPasswordSet(int num){
        ArrayList<String> passwordList = new ArrayList<String>();
        for(int i=0; i<num; i++){
            passwordList.add(generatePassword());
        }
        return passwordList;
    }

    public void shuffleArray(){
        char[] passwordChars = "abcdefghijklmnopqrstuvwxyz1234567890!@#$%".toCharArray();
        for(int i=0; i<passwordChars.length; i++){
            int randInt1 = randMachine.nextInt(passwordChars.length);
            int randInt2 = randMachine.nextInt(passwordChars.length);
            char temp = passwordChars[randInt1];
            passwordChars[randInt1] = passwordChars[randInt2];
            passwordChars[randInt2] = temp;
        }
        System.out.println(passwordChars);
    }
}
