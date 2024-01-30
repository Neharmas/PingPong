package src;

import Util.Vector2;

public class Ball implements Entity{
    public Vector2 position = new Vector2();
    public Vector2 velocity = new Vector2(1, 0);
    float width = 1.0f;
    float height = 1.0f;
    float speed = 2.0f;
    public Ball() { }
    
    public void move(Vector2 direction, float deltaTime)
    {
        velocity = direction.normalized().scale(speed * deltaTime);
        this.position.add(velocity);
    }
    
    @Override
    public void start() {
    
    }
    
    @Override
    public void update(float deltaTime){
        move(velocity, deltaTime);
        
        if(width + position.x > 5){
            //System.out.println("Player 1 wins");
        }
        else if(position.x - width < -5)
        {
            //System.out.println("Player 2 wins");
        }
    }
    
    @Override
    public boolean collision(Entity entity)
    {
      return
          position.x < entity.position.x + entity.width &&
          position.x + width > entity.position.x &&
          position.y < entity.position.y + entity.height &&
          position.y + height > entity.position.y;
    }
}
