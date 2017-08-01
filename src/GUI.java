import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.*;
import java.text.NumberFormat;

/**
 * Created by чет on 21.07.2017.
 */
public class GUI extends JFrame {
    private JPanel mainPanel;
    private JPanel isoPropPanel;
    private JPanel beamPanel;
    private JPanel beamPropPanel;
    private JPanel isoPanel;
    private JButton createIsocentre;
    private JButton deleteIsocentre;
    private JPanel beamButtons;
    private JButton createBeam;
    private JButton deleteBeam;
    private JList beamList;
    private JList isoList;
    private JPanel isoButtons;
    private JLabel beamName;
    private JLabel beamSize;
    private JSpinner beamSizeX;
    private JSpinner beamSizeY;
    private JLabel beamAngle;
    private JSpinner beamStartAngle;
    private JSpinner beamStopAngle;
    private JTextField beamNameValue;
    private JLabel beamCollimator;
    private JSpinner beamCollimatorValue;
    private JLabel beamModifier;
    private JComboBox beamModifierValue;
    private JTextField beamModifierComment;
    private JLabel beamTime;
    private JFormattedTextField beamTimeValue;
    private JPanel isoRTMachine;
    private JPanel isoTechnique;
    private JPanel isoOffsets;
    private JLabel isoRTMachineLabel;
    private JComboBox isoRTMachines;
    private JLabel isoTechniqueLabel;
    private JLabel isoOffsetLabel;
    private JRadioButton radioSSD;
    private JRadioButton radioSAD;
    private JSpinner isoASDvalue;
    private JLabel isoASDLabel;
    private JRadioButton radioLeft;
    private JRadioButton radioRight;
    private JLabel isoOffsetLateral;
    private JLabel isoOffsetLong;
    private JRadioButton radioUp;
    private JRadioButton radioDown;
    private JLabel isoOffsetComment;
    private JTextField isoOffsetCommentValue;
    private JPanel TeamplatesPanel;
    private JPanel TemplatesButtons;
    private JButton createTemplate;
    private JButton deleteTemplate;
    private JList TemplatesList;
    private JButton loadTemplate;
    private JPanel PrintPreviewPanel;
    private JLabel PrintPreviewLabel;
    private JLabel templatesLabel;
    private JLabel isoLabel;
    private JLabel beamLabel;
    private JPanel printButtons;
    private JButton printReport;
    private JButton exitButton;
    private JTextArea templatesDescription;
    private JLabel templatesDescriptionLabel;
    private JPanel descriptionPanel;
    private JEditorPane printPreviewEditor;
    private JEditorPane editoPane;


    public GUI() {
        setContentPane(mainPanel);
        setVisible(true);
        // Задаем каждому компоненту ActionCommand для идентификации в контроллере
        createIsocentre.setActionCommand("createIsocentre");
        deleteIsocentre.setActionCommand("deleteIsocentre");
        createBeam.setActionCommand("createBeam");
        deleteBeam.setActionCommand("deleteBeam");
        loadTemplate.setActionCommand("loadTemplate");
        createTemplate.setActionCommand("createTemplate");
        deleteTemplate.setActionCommand("deleteTemplate");
        printReport.setActionCommand("printReport");
        exitButton.setActionCommand("exitButton");
        radioSSD.setActionCommand("radioSSD");
        radioSSD.setActionCommand("radioSSD");
        radioDown.setActionCommand("radioDown");
        radioUp.setActionCommand("radioUp");
        radioLeft.setActionCommand("radioLeft");
        radioRight.setActionCommand("radioRight");


        Controller controller = new Controller(this);
        //Формат вещественных чисел
        NumberFormat number = new DecimalFormat("#0.#");
        beamTimeValue.setFormatterFactory(new DefaultFormatterFactory());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        createBeam.addActionListener(controller);

    }

}
