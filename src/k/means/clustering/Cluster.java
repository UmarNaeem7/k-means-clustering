package k.means.clustering;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cluster {
    int k;
    private Boolean complete = false;
    List<Point> points = new ArrayList<Point>();
    List<Point> centers = new ArrayList<Point>();
    List<Integer> prevClusters = new ArrayList<Integer>();
    List<Integer> clusterNumbering = new ArrayList<Integer>();
    List<Point> clusters = new ArrayList<Point>();
    
    List<float[]> distanceList = new ArrayList<float[]>();

    public String[] pointsStrings() {
        String[] p = new String[points.size()];
        for (int i=0;i<points.size();i++)
            p[i] = points.get(i).toString();
        return p;
    }
    
    public String[] clustersStrings() {
        String[] p = new String[clusters.size()];
        for (int i=0;i<clusters.size();i++)
            p[i] = clusters.get(i).toString();
        return p;
    }
    
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
        
        
        for (int i=0;i<k;i++){
            float arr[] = new float[points.size()];
            for (int j=0;j<points.size();j++){
                arr[j] = KMeansClustering.EuclideanDistance(points.get(j), centers.get(i));
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
        
        float temp[] = new float[points.size()*k];
        
        int j = 0;
        for (float[] f : distanceList){
            for (int i=0;i<f.length;i++){
                temp[j++] = f[i];
            }
        }
        
        for (int i=0;i<points.size();i++){
            float min = Float.MAX_VALUE;
            int index = 0;
            for (int u=0;u<k;u++){
                if (temp[i+(points.size()*u)]<min){
                    min = temp[i+(points.size()*u)];
                    index = u;
                }
            }
            clusters.add(centers.get(index));
        }
        
        System.out.println("Clustering:");
        for (Point p:clusters){
            p.print();
        }
        
        for (int i=0;i<clusters.size();i++)
            for (int u=0;u<centers.size();u++)
                if (clusters.get(i)==centers.get(u))
                    clusterNumbering.add(u);
        
        System.out.println("Cluster Numbering:");
        for (Integer p:clusterNumbering){
            System.out.println(p);
        }
        
        if (clusterNumbering.equals(prevClusters)){
            System.out.println("Clustering complete!");
            complete = true;
            return;
        }
        else
            if (!prevClusters.isEmpty())
                prevClusters.clear();
        
        for (int i=0;i<clusterNumbering.size();i++)
            prevClusters.add(clusterNumbering.get(i));
        
        
    }
    
    public void updateCenters(){
        //new centers
        System.out.println("New Centers:");
        for (int i=0;i<centers.size();i++){
            float x = 0, y = 0;
            int c = 0;
            for (int u=0;u<clusters.size();u++){
                if (clusters.get(u) == centers.get(i)){
                    x += points.get(u).getX();
                    y += points.get(u).getY();
                    c++;
                }
            }
            centers.get(i).setX(x/c);
            centers.get(i).setY(y/c);
        }
        printCenters();
        clusters.clear();
        clusterNumbering.clear();
        distanceList.clear();
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

    public Boolean getComplete() {
        return complete;
    }
    
}
