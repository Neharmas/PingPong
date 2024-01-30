package src;
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
        if (ball.collision(this)) {
            System.out.println("Test");
        }
    }
    
    @Override
    public boolean collision(Entity entity) {
        return
            0 < entity.position.x + entity.width &&
                0 + width > entity.position.x &&
                0 < entity.position.y + entity.height &&
                0 + height > entity.position.y;
    }
}