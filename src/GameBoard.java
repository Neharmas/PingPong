package src;

import Util.Vector2;
import src.Game.Ball;
import src.Game.Player;

public class GameBoard implements Entity
{
    Player player1;
    Player player2;
    Ball ball;
    public float width, height;
    public GameBoard(float width, float height)
    {
        this.width = width;
        this.height = height;
    }
    @Override
    public void start() {
    
    }
    
    @Override
    public void update(float deltaTime) {
    
    }
}