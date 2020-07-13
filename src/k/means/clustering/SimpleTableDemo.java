package k.means.clustering;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

public class SimpleTableDemo extends JPanel {

    public SimpleTableDemo() {
        super(new GridLayout(4,0));
        //add(new JLabel("Iteration 1"));
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
        
        Boolean flag = false;
        
        while(!flag){
            cluster.calculateMeanDistances();

            JTable table = new JTable();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.addColumn("Points", cluster.pointsStrings());


            int count = 1;
            for (float[] f : cluster.distanceList){
                String s = "Mean distances " + count + " = " + cluster.centers.get(count-1).toString();
                count++;
                String[] arr = new String[f.length];
                for (int i=0;i<f.length;i++)
                    arr[i] = Float.toString(f[i]);
                model.addColumn(s, arr);
            }

            model.addColumn("Clustering", cluster.clustersStrings());
            table.setPreferredScrollableViewportSize(new Dimension(500, 70));
            table.setFillsViewportHeight(true);


            //Create the scroll pane and add the table to it.
            JScrollPane scrollPane = new JScrollPane(table);

            //Add the scroll pane to this panel.
            add(scrollPane);
            
            cluster.updateCenters();
            flag = cluster.getComplete();
        }
        
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("K-means Clustering");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Create and set up the content pane.
        SimpleTableDemo newContentPane = new SimpleTableDemo();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}