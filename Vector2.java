public class Vector2 {
    public float x, y;
    private float magnitude;

    public Vector2()
    {
        this.x = 1;
        this.y = 1;
        this.magnitude = (float) Math.sqrt(this.x*this.x + this.y*this.y);
    }

    public Vector2(float x, float y)
    {
        this.x = x;
        this.y = y;
        this.magnitude = (float) Math.sqrt(x*x + y*y);
    }

    public void normalize()
    {
        this.x /= magnitude;
        this.y /= magnitude;
    }
    public void scale(float scale)
    {
        this.x *= scale;
        this.y *= scale;
        this.magnitude *= scale;
    }
    public Vector2 sum(Vector2 other)
    {
        float x = this.x + other.y;
        float y = other.y + this.y;

        return new Vector2(x,y);
    }

    public float dot(Vector2 other)
    {
        return this.x*other.x + this.y*other.y;
    }
    
    public Vector2 normalized()
    {
        return new Vector2(x/magnitude, y/magnitude);
    }

    public Vector2 opposite()
    {
        return new Vector2(-this.x, -this.y);
    }

    public boolean equals(Vector2 other)
    {
        if(this.magnitude != other.magnitude)
        {
            return false;
        }
        boolean x = this.x == other.x;
        boolean y = this.y == other.y;
        if(!x || !y)
        {
            return false;
        }
        return true;
    }

    public boolean isParallel(Vector2 other)
    {
        Vector2 tempVector = this.normalized();
        Vector2 otherVector = other.normalized();
        if(tempVector.x / otherVector.x == tempVector.y / otherVector.y)
        {
            return true;
        }
        return false;
    }

    public boolean isOpposite(Vector2 other)
    {
        if(this.magnitude != other.magnitude)
        {
            return false;
        }
        boolean x = this.x == -other.x;
        boolean y = this.y == -other.y;

        if(!x || !y)
        {
            return false;
        }
        return true;
    }

    public float magnitude()
    {
        return (float) Math.sqrt(this.x*this.x + this.y*this.y);
    }
}
