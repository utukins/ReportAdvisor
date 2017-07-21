import javax.swing.*;
import java.awt.*;

/**
 * Created by чет on 07.07.2017.
 */
public class GUIForm {
    JPanel mainPanel;
    JPanel isocentrePanel;
    JPanel isocentrePropPanel;
    JPanel beamPanel;
    JPanel beamPropPanel;

     JTree isocentreTree;
     JTree beamTree;



    GUIForm () {
        mainPanel = new JPanel();
        isocentrePanel = new JPanel();
        isocentrePropPanel = new JPanel();
        beamPanel = new JPanel();
        beamPropPanel = new JPanel();
        isocentreTree = new JTree();
        beamTree = new JTree();

        GridLayout gridLayout = new GridLayout(2,2);
        mainPanel.setLayout(gridLayout);
        mainPanel.add(isocentrePanel);
        mainPanel.add(isocentrePropPanel);
        mainPanel.add(beamPanel);
        mainPanel.add(beamPropPanel);
        isocentrePanel.add(isocentreTree);
        beamPanel.add(beamTree);

        JFrame frame = new JFrame("Frame");
        frame.setContentPane(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }



}

