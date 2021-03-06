package View;

import Controller.Controller;
import Model.Beam;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import java.awt.event.ActionListener;import java.awt.event.KeyAdapter;import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Этот класс описывает вид из шаблона MVP
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
    private JScrollPane printScrollPane;
    private JScrollPane beamScrollPane;
    private JScrollPane TemplatesScrollPane;
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
        beamNameValue.setActionCommand("beamNameValue");

        setTextTest("Start");

        //Формат вещественных чисел

        NumberFormat number = new DecimalFormat("#0.#");
        beamTimeValue.setFormatterFactory(new DefaultFormatterFactory());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    beamNameValue.addKeyListener(new KeyAdapter() { } );}

    public void setController (Controller controller){
        createIsocentre.addActionListener(controller);
        deleteIsocentre.addActionListener(controller);
        createBeam.addActionListener(controller);
        deleteBeam.addActionListener(controller);
        createTemplate.addActionListener(controller);
        loadTemplate.addActionListener(controller);
        deleteTemplate.addActionListener(controller);
        printReport.addActionListener(controller);
        exitButton.addActionListener(controller);
        isoList.addListSelectionListener(controller);
        beamList.addListSelectionListener(controller);
        beamNameValue.addActionListener(controller);
    }
    //Getters
    public String getBeamName (){
        return beamNameValue.getText();
    }
    public double getBeamSizeX() {
        return Double.parseDouble(beamSizeX.getValue().toString());
    }
    public double getBeamSizeY() {
        return Double.parseDouble(beamSizeY.getValue().toString());
    }

    public int getBeamStartAngle() {
        return (int)beamStartAngle.getValue();
    }
    public int getBeamStopAngle() {
        return (int)beamStopAngle.getValue();
    }
    public String getBeamTime () {
        return beamTimeValue.getText();
    }

    //Setters
    public void setBeamName(String beamName) {
        this.beamNameValue.setText(beamName);
    }
    public void setBeamSizeX(double beamSizeX) {
        this.beamSizeX.setValue(beamSizeX);
    }
    public void setBeamSizeY(double beamSizeY) {
        this.beamSizeY.setValue(beamSizeY);
    }
    public void setBeamStartAngle (int StartAngle) {
        this.beamStartAngle.setValue(StartAngle);
    }
    public void setBeamStopAngle (int StopAngle) {
        this.beamStopAngle.setValue(StopAngle);
    }
    public void setBeamTime (int time) {
        this.beamTimeValue.setValue("Time");
    }
    ////////
    public void setTextTest (String textTest) {
        printPreviewEditor.setText(printPreviewEditor.getText() + "\n" + textTest);
    }
    public void clearTextTest () {
        printPreviewEditor.setText("Report:");
    }

    public JList getIsoList() {
        return isoList;
    }

    public JList getBeamList() {
        return beamList;
    }

    public JList getTemplatesList() {
        return TemplatesList;
    }
}
