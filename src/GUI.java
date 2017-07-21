import javax.swing.*;

/**
 * Created by чет on 21.07.2017.
 */
public class GUI extends JFrame {
    private JPanel mainPanel;
    private JPanel isoPropPanel;
    private JPanel beamPanel;
    private JPanel beamPropPanel;
    private JPanel isoPanel;
    private JButton CreateIsocentre;
    private JButton DeleteIsocentre;
    private JPanel beamButtons;
    private JButton createBeam;
    private JButton deleteBeam;
    private JList beamList;
    private JList isocentreList;
    private JPanel isoButtons;
    private JLabel beamNameLabel;
    private JLabel beamSize;
    private JSpinner beamSizeX;
    private JSpinner beamSizeY;
    private JLabel beamAngle;
    private JSpinner beamStartAngle;
    private JSpinner beamStopAngle;
    private JTextField textField1;
    private JEditorPane editoPane;

    public GUI(){
        setContentPane(mainPanel);
        setVisible(true);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
