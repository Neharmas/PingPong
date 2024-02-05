package src.Game;

import Util.Vector2;
import src.BaseEntity;
import src.Components.Collision;
import src.Components.Physics;
import src.Components.Render;
import src.Components.Transform;

import static src.Game.Game.entityManager;

public class Ball extends BaseEntity {
    public Transform transform;
    public Physics physics;
    public Collision collision;
    public Vector2 direction;
    public float speed = 2.0f;
    
    @Override
    public void start() {
        collision = components.addComponent(new Collision(1, 1));
        transform = components.addComponent(new Transform());
        physics = components.addComponent(new Physics());
        components.addComponent(new Render(1,1));

        direction = new Vector2(1, 0);
    }
    
    @Override
    public void update(float deltaTime){
        if (collision.getCollisionID() != null) {
            BaseEntity collisionEntity = entityManager.getEntity(collision.getCollisionID());
            Vector2 colliderPos = collisionEntity.components.getComponent(Transform.class).position;
            if (collisionEntity.getClass() == Player.class) {
                // IF BALL IS HIGHER THAN PADDLE
                if (transform.position.y >= colliderPos.y)
                {
                    // CHECK FOR LEFT PADDLE
                    if(transform.position.x >= colliderPos.x)
                        direction = new Vector2(0.7f, 0.71f);
                    
                    // CHECK FOR RIGHT PADDLE
                    else
                        direction = new Vector2(-0.7f, 0.71f);
                }
                // IF BALL IS LOWER THAN PADDLE
                else
                {
                    // CHECK FOR LEFT PADDLE
                    if(transform.position.x <= colliderPos.x)
                        direction = new Vector2(0.7f, -0.71f);
                    // CHECK FOR RIGHT PADDLE
                    else
                        direction = new Vector2(-0.7f, -0.71f);
                }
            }
            else{
                Vector2 collisionVector = new Vector2(transform.position.x - colliderPos.x, transform.position.y - colliderPos.y);
                collisionVector.normalize();

                // Calculate the reflection angle
                double reflectionAngle = Math.atan2(collisionVector.y, collisionVector.x);
                direction = new Vector2((float)Math.cos(reflectionAngle), (float)Math.sin(reflectionAngle));
            }
        }
        move(deltaTime);
        System.out.println(transform.position);
    }
    
    public void move(float deltaTime)
    {
        physics.velocity = direction.normalized().scale(speed * deltaTime);
        transform.position.add(physics.velocity);
    }
}
