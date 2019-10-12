import bagel.Window;
import bagel.util.Point;
import bagel.util.Vector2;

import java.util.ArrayList;

public class Bucket extends Sprite {
    private static final Point defaultPoint = new Point(512, 744);
    private Vector2 velocity = new Vector2(-SPEED, 0).normalised();
    private static final double SPEED = 4;

    public Bucket() {
        super(defaultPoint, "res/bucket.png");
    }


    public int onCollision(int shotsLeft) {
        return shotsLeft + 1;
    }

    @Override
    public void update() {
        super.move(velocity);

        if (super.getRect().left() < 0 || super.getRect().right() > Window.getWidth()) {
            velocity = new Vector2(-velocity.x, velocity.y);
        }

        super.draw();
    }
}