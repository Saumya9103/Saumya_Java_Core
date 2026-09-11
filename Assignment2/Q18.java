package Assignment2;

interface Game {

    int MAX_PLAYERS = 11;

    void displayGame();
}

class Cricket implements Game {

    public void displayGame() {
        System.out.println("Game: Cricket, Max Players: " + MAX_PLAYERS);
    }
}

class Football implements Game {

    public void displayGame() {
        System.out.println("Game: Football, Max Players: " + MAX_PLAYERS);
    }
}

public class Q18 {

    public static void main(String[] args) {

        Cricket cricket = new Cricket();
        Football football = new Football();

        cricket.displayGame();
        football.displayGame();
    }
}