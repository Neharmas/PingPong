package src.Game;

import Util.Vector2;
import src.BaseEntity;
import src.Components.Collision;
import src.Components.Physics;
import src.Components.Transform;

public class Ball extends BaseEntity {
    public boolean hasCollided = false;
    public Transform transform;
    public Physics physics;
    public Collision collision;
    public Vector2 direction;
    public float speed = 2.0f;
    
    @Override
    public void start() {
        collision = (Collision) components.addComponent(new Collision());
        transform = (Transform) components.addComponent(new Transform());
        physics = (Physics) components.addComponent(new Physics());
        direction = new Vector2(1, 0);
        collision.setHeight(1);
        collision.setWidth(1);
        transform.position = new Vector2();
    }
    
    @Override
    public void update(float deltaTime){
        if (collision.getCollisionEntity() != null && !hasCollided) {
            if (collision.getCollisionEntity().getClass() == Player.class) {
                Transform colTrans = (Transform) collision.getCollisionEntity().components.getComponent(Transform.class);
                Vector2 colPos = colTrans.position;
                // IF BALL IS HIGHER THAN PADDLE
                if (transform.position.y >= colPos.y)
                {
                    // CHECK FOR LEFT PADDLE
                    if(transform.position.x >= colPos.x)
                        direction = new Vector2(0.7f, 0.71f);
                    
                    // CHECK FOR RIGHT PADDLE
                    else
                        direction = new Vector2(-0.7f, 0.71f);
                }
                // IF BALL IS LOWER THAN PADDLE
                else
                {
                    // CHECK FOR LEFT PADDLE
                    if(transform.position.x <= colPos.x)
                        direction = new Vector2(0.7f, -0.71f);
                    // CHECK FOR RIGHT PADDLE
                    else
                        direction = new Vector2(-0.7f, -0.71f);
                }
            }
          direction = direction.opposite();
          hasCollided = true;
        } else {
            // Reset the flag when there's no longer a collision
            hasCollided = false;
        }
        move(deltaTime);
        System.out.println(transform.position);
    }
    
    public void move(float deltaTime)
    {
        physics.velocity = direction.normalized().scale(speed * deltaTime);
        this.transform.position.add(physics.velocity);
    }
}
