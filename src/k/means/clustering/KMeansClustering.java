package k.means.clustering;

public class KMeansClustering {
    public static float manhattanDistance(Point p1, Point p2){
        float distance = Math.abs(p1.getX()-p2.getX()) + Math.abs(p1.getY()-p2.getY());
        return distance;
    }
    
    public static float EuclideanDistance(Point p1, Point p2){
        float distance = (float)(Math.pow((p1.getX()-p2.getX()),2)) + (float)(Math.pow((p1.getY()-p2.getY()),2));
        return distance;
    }
    
    public static void main(String[] args) {
        Point A1 = new Point(2, 10);
        Point A2 = new Point(2, 9);
        Point A3 = new Point(2, 7);
        Point A4 = new Point(2, 6);
        Point A5 = new Point(3, 7);
        Point A6 = new Point(3, 9);
        Point A7 = new Point(6, 3);
        Point A8 = new Point(6, 4);
        Point A9 = new Point(7, 4);
        Point A10 = new Point(8, 4);
        
        Point C1 = new Point(8, 9);
        Point C2 = new Point(6, 3.5f);
        Point C3 = new Point(7.5f, 4);
        
        Cluster cluster = new Cluster(3);
        
        cluster.addPoint(A1);
        cluster.addPoint(A2);
        cluster.addPoint(A3);
        cluster.addPoint(A4);
        cluster.addPoint(A5);
        cluster.addPoint(A6);
        cluster.addPoint(A7);
        cluster.addPoint(A8);
        cluster.addPoint(A9);
        cluster.addPoint(A10);
        
        cluster.addCenter(C1);
        cluster.addCenter(C2);
        cluster.addCenter(C3);
        
        System.out.println("Points:");
        cluster.printPoints();
        
        System.out.println("Centers:");
        cluster.printCenters();
        
        System.out.println("Mean distances:");
        cluster.calculateMeanDistances();
    }
    
}
