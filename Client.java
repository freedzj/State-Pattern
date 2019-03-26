public class Client {

    public static void main(String[] args) {

        Hangman game = new Hangman();
        game.initialize();
        game.loadContent();
        do {
            game.userAction();
            game.draw();
        }
        while(game.evaluateState());
        game.report();
    }

}
