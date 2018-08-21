package Controller;

import Model.Isocentre;
import Model.Beam;
import Model.Model;
import View.GUI;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Данный класс должен обрабатывать взаимодействие GUI и модели.
 * Created by чет on 26.07.2017.
 */
public class Controller implements ActionListener, ChangeListener, ListSelectionListener {
    private GUI gui;
    private Model model;
    private DefaultListModel<Isocentre> isoListModel = new DefaultListModel<Isocentre>();
    private DefaultListModel<Beam> beamListModel = new DefaultListModel<Beam>();

    public Controller(GUI gui, Model model) {
        this.gui = gui;
        this.model = model;
        gui.setController(this);
        gui.getIsoList().setModel(isoListModel);
        gui.getBeamList().setModel(beamListModel);
        gui.getIsoList().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        updateGUI();
        gui.getIsoList().setSelectedIndex(0);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Здесь нужно добавить обработчики нажатий на кнопки и поля в GUI
        // Создание/Удаление Изоцентра
        if (e.getActionCommand().equals("createIsocentre")) {
            model.addIsocentre(new Isocentre());
            gui.setTextTest("Isocentre created");
            updateGUI();
        }
        if (e.getActionCommand().equals("deleteIsocentre")) {
            gui.clearTextTest();
            gui.setTextTest("deleteIsocentre");
        }
        //  Создание/Удаление Пучка
        if (e.getActionCommand().equals("createBeam")) {
            gui.clearTextTest();
            model.getIsocentreList().get(gui.getIsoList().getSelectedIndex()).addBeam(new Beam("Beam1", 10, 10, 222, 432));
            gui.setTextTest("Beam created");
            updateGUI();
        }
        if (e.getActionCommand().equals("deleteBeam")) {

            gui.setTextTest("deleteBeam");
        }
        // Создание/Загрузка/Удаление Шаблона
        if (e.getActionCommand().equals("createTemplate")) {

            gui.setTextTest("createTemplate");
        }
        if (e.getActionCommand().equals("loadTemplate")) {

            gui.setTextTest("loadTemplate");
        }
        if (e.getActionCommand().equals("deleteTemplate")) {

            gui.setTextTest("deleteTemplate");
        }
        // Кнопка печати
        if (e.getActionCommand().equals("printReport")) {
            gui.getIsoList().setSelectedIndex(0);
            gui.setTextTest("printReport: изоцентров - " + model.getIsocentreList().toArray().length);
        }
        // Кнопка Выход
        if (e.getActionCommand() == "exitButton")
            System.exit(0);
    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }
    public void updateGUI (){
        for (Isocentre isocentre: model.getIsocentreList()) {
            if (!isoListModel.contains(isocentre))
                isoListModel.addElement(isocentre);
        }
        beamListModel.clear();
        try {
            for (Beam beam: model.getIsocentreList().get(gui.getIsoList().getSelectedIndex()).getBeams()) {
                if (beamListModel.contains(beam)==false)
                    beamListModel.addElement(beam);
            }
        }
            catch (Exception e) {}
         gui.validate();
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        updateGUI();
    }
}
