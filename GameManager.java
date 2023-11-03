public class GameManager
{
    GameBoard gameBoard = new GameBoard(3.5f, 5f, -5f, -3.5f);
    Player player1 = new Player(4, 0);
    Player player2 = new Player(-4, 0);
    Ball ball = new Ball();

    GameManager()
    {
        play();
    }

    public void play()
    {
        while(ball.x > gameBoard.left && ball.x < gameBoard.right)
        {
            ball.x -= 1f;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(ball.x + ball.y);
        }
        System.out.println("Ball out");

    }
}