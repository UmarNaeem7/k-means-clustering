package k.means.clustering;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Cluster {
    int k;
    List<Point> points = new ArrayList<Point>();
    List<Point> centers = new ArrayList<Point>();

    public Cluster(int k) {
        this.k = k;
    }
    
    public void addPoint(Point p){
        points.add(p);
    }
    
    public void addCenter(Point p){
        centers.add(p);
    }
    
    public void calculateMeanDistances(){
        List<float[]> distanceList = new ArrayList<float[]>();
        
        for (int i=0;i<k;i++){
            float arr[] = new float[points.size()];
            for (int j=0;j<points.size();j++){
                arr[j] = KMeansClustering.manhattanDistance(points.get(j), centers.get(i));
            }
            distanceList.add(arr);
        }
        
        int count = 1;
        for (float[] f : distanceList){
            System.out.println("Mean distances " + count++);
            for (int i=0;i<f.length;i++){
                System.out.println(f[i]);
            }
        }
    }
    
    public void printPoints(){
        for (Point p : points){
            p.print();
        }
    }
    
    public void printCenters(){
        for (Point c : centers){
            c.print();
        }
    }
    
}
