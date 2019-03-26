import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
public class Hangman extends Game
{
    public final int numberOfGuesses = 7;
    private int guessesUsed;
    private char[] guessed;
    private String[]  words =   {"geography", "cat", "today", "java", "truck", "opportunity",
        "fish", "token", "transportation", "bottom", "apple", "cake",
        "remote", "pocket", "terminology", "arm", "cranberry", "implement",
        "caterpillar", "fork", "watermelon", "laptop", "toe", "toad",
        "fundamental", "capitol", "garbage", "anticipate", "apple"};
    private char[] output;
    private char guess;
    private char[] currentWord;
    private String word;
    private Random randGen;
    private Scanner kb;
    protected void initialize()
    {   
        guessesUsed = 0;
       
        guessed = new char[8];
        randGen = new Random();
        guessesUsed = 0;
        word = "";
        guess = ' ';
        kb = new Scanner(System.in);
    }

    protected void loadContent()
    {
        int num = randGen.nextInt(words.length - 1);
        word = words[num];
        currentWord = new char[word.length()];
        output = new char[word.length()];
        for(int i = 0; i < word.length(); i++)
        {
            currentWord[i] = word.charAt(i);
        }
        for(int i = 0; i < word.length(); i++)
        {
            output[i] = '*';
        }
    } 

    protected void userAction()
    {
        System.out.println("Guess a letter");
        guess = kb.next().charAt(0);
        guessed[guessesUsed] = guess;
        boolean yn = false;
        for(int i = 0; i < word.length(); i++)
        {
            
            
            if(guess == currentWord[i])
            {
                yn = true;
                output[i] = guess;
            }
        }
        if(yn == false)
        {
            guessesUsed++;
        }
    
    
    
    }
    protected void draw()
    {
        System.out.print("Word being guessed: ");
        for(int i = 0; i<word.length(); i++)
        {
            System.out.print(output[i]);
        }
        System.out.print(" Guesses remaining: " 
        + (numberOfGuesses - guessesUsed) + "\n");
        
        
    }
    protected boolean evaluateState()
    {
        boolean ans = true;
        
        if(guessesUsed == numberOfGuesses)
        {
            ans = false;
        }
        if(Arrays.equals(currentWord, output) == true)
        {
            ans = false;
        }
        
        return ans;
    }
    protected void report()
    {
        if(guessesUsed <= numberOfGuesses && Arrays.equals(currentWord, output))
        {
            System.out.println("Congradulations, you won!");
        }
        else
        {
            System.out.println("Im sorry but, you lost");
        }
    }
}
    






