package k.means.clustering;

public class Point {
    private float x;
    private float y;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ')';
    } 
    
    public void print(){
        System.out.println("(x,y) = " + x + "," + y);
    }
}
