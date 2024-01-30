package Util;

public class Vector2 {
    public float x, y;

    public Vector2() {
        this(0, 0);
    }

    public Vector2(float x, float y) {
        if (Float.isNaN(x) || Float.isNaN(y) || Float.isInfinite(x) || Float.isInfinite(y)) {
            throw new IllegalArgumentException("Invalid input for Vector2");
        }
        this.x = x;
        this.y = y;
    }

    public void normalize() {
        float magnitude = getMagnitude();
        if (magnitude != 0) {
            this.x /= magnitude;
            this.y /= magnitude;
        }
    }

    public Vector2 scale(float scale) {
        this.x *= scale;
        this.y *= scale;
        return this;
    }
    public Vector2 add(Vector2 other) {
        this.x += other.x;
        this.y += other.y;
        return this;
    }
    public Vector2 sum(Vector2 other) {
        float newX = this.x + other.x;
        float newY = this.y + other.y;
        return new Vector2(newX, newY);
    }

    public float dot(Vector2 other) {
        return this.x * other.x + this.y * other.y;
    }

    public Vector2 normalized() {
        return new Vector2(x / getMagnitude(), y / getMagnitude());
    }

    public Vector2 opposite() {
        return new Vector2(-this.x, -this.y);
    }

    public boolean equals(Vector2 other) {
        return Float.compare(this.getMagnitude(), other.getMagnitude()) == 0 &&
               Float.compare(this.x, other.x) == 0 &&
               Float.compare(this.y, other.y) == 0;
    }

    public boolean isParallel(Vector2 other) {
        Vector2 tempVector = this.normalized();
        Vector2 otherVector = other.normalized();
        if (otherVector.x != 0 && otherVector.y != 0) {
            return Float.compare(tempVector.x / otherVector.x, tempVector.y / otherVector.y) == 0;
        }
        return false;
    }

    public boolean isOpposite(Vector2 other) {
        return Float.compare(this.getMagnitude(), other.getMagnitude()) == 0 &&
               Float.compare(this.x, -other.x) == 0 &&
               Float.compare(this.y, -other.y) == 0;
    }

    public float getMagnitude() {
        return (float) Math.sqrt(this.x * this.x + this.y * this.y);
    }
    
    public String toString()
    {
        return "X Position: " + String.format("%.2f", this.x) + ", Y Position: " + String.format("%.2f", this.y) ;
    }
}

