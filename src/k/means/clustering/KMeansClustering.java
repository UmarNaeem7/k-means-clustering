package k.means.clustering;

public class KMeansClustering {
    public static float manhattanDistance(Point p1, Point p2){
        float distance = Math.abs(p1.getX()-p2.getX()) + Math.abs(p1.getY()-p2.getY());
        return distance;
    }
    
    public static float EuclideanDistance(Point p1, Point p2){
        float distance = (float)Math.sqrt((Math.pow((p1.getX()-p2.getX()),2)) + (float)(Math.pow((p1.getY()-p2.getY()),2)));
        return distance;
    }
    
   
}
