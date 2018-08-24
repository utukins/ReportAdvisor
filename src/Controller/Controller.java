package Controller;

import Model.Isocentre;
import Model.Beam;
import Model.Model;
import View.GUI;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Данный класс должен обрабатывать взаимодействие GUI и модели.
 * Created by чет on 26.07.2017.
 */
public class Controller implements ActionListener, ListSelectionListener {
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
            updateGUI();
        }
        if (e.getActionCommand().equals("deleteIsocentre")) {
            try {
                model.removeIsocentre(gui.getIsoList().getSelectedIndex());
            }
            catch (Exception exceptIso) {
            }
            isoListModel.clear();
            updateGUI();
        }
        //  Создание/Удаление Пучка
        if (e.getActionCommand().equals("createBeam")) {
            model.addBeam(gui.getIsoList().getSelectedIndex(), new Beam("Beam", 10, 10, 222, 432));
            isoListModel.clear();
            updateGUI();
        }
        if (e.getActionCommand().equals("deleteBeam")) {
            try {
                model.removeBeam(gui.getIsoList().getSelectedIndex(), gui.getBeamList().getSelectedIndex());
            }
            catch (Exception exceptBeam) {}
            updateGUI();
        }
        // Создание/Загрузка/Удаление Шаблона
        if (e.getActionCommand().equals("createTemplate")) {
            }
        if (e.getActionCommand().equals("loadTemplate")) {
            }
        if (e.getActionCommand().equals("deleteTemplate")) {
            isoListModel.clear();
            }
        // Кнопка печати
        if (e.getActionCommand().equals("printReport")) {
            gui.clearTextTest();
            gui.setTextTest(model.toString());
        }
        // Кнопка Выход
        if (e.getActionCommand() == "exitButton")
            System.exit(0);
    }

    public void updateGUI (){
        for (Isocentre isocentre: model.getIsocentreList()) {
            if (!isoListModel.contains(isocentre))
                isoListModel.addElement(isocentre);
        }
        try {
            for (Beam beam: model.getIsocentreList().get(gui.getIsoList().getSelectedIndex()).getBeams()) {
                if (beamListModel.contains(beam)==false)
                    beamListModel.addElement(beam);
            }
        }
            catch (Exception e) {
                beamListModel.clear();
            }
         gui.validate();
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        updateGUI();
    }

}
