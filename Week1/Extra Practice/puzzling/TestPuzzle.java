public class TestPuzzle {
    
    public static void main(String[] args){
        // create instance of PuzzleJava class
        PuzzleJava puzzleTest = new PuzzleJava();

        System.out.println("\n----getTenRolls Test----");
        System.out.println(puzzleTest.getTenRolls());

        System.out.println("\n----getRandomLetter test----");
        System.out.println(puzzleTest.getRandomLetter());

        System.out.println("\n----generatePassword test----");
        System.out.println(puzzleTest.generatePassword());

        System.out.println("\n----getNewPasswordSet test----");
        System.out.println(puzzleTest.getNewPasswordSet(3));

        System.out.println("\n----shuffleArray test----");
        puzzleTest.shuffleArray();
    }
}
