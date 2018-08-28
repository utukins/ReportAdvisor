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
            int selectedIndex = gui.getIsoList().getSelectedIndex();
            String beamName = new String();
            double beamX;
            double beamY;
            int startAngle;
            int stopAngle;
            int time;

            beamName = gui.getBeamName();
            beamX = gui.getBeamSizeX();
            beamY = gui.getBeamSizeY();
            startAngle = gui.getBeamStartAngle();
            stopAngle = gui.getBeamStopAngle();
        //    time = Integer.parseInt(gui.getBeamTime());
            time = 555;
            model.addBeam(selectedIndex, new Beam(beamName, beamX, beamY, startAngle,stopAngle, time));
            isoListModel.clear();
            updateGUI();
            gui.getIsoList().setSelectedIndex(selectedIndex);
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
        //Обновляем отображение изоцентров в соответствии с моделью
        for (Isocentre isocentre: model.getIsocentreList()) {
            if (!isoListModel.contains(isocentre))
                isoListModel.addElement(isocentre);
        }
        for (int i = 0; i < isoListModel.size();i++) {
            if(!model.contains(isoListModel.get(i))) {
                isoListModel.remove(i);
            }
        }
        //Обновляем отображение пучков в соответствии с моделью
        try {
            for (Beam beam: model.getIsocentreList().get(gui.getIsoList().getSelectedIndex()).getBeams()) {
                if (beamListModel.contains(beam)==false)
                    beamListModel.addElement(beam);
            }
            for (int i = 0; i < beamListModel.size();i++) {
                if(!model.getIsocentreList().get(gui.getIsoList().getSelectedIndex()).getBeams().contains(beamListModel.get(i))) {
                    beamListModel.remove(i);
                }
            }
        }
        catch (Exception e) {
            beamListModel.clear();
        }
        //Обновляем отображающуюся информацию в соответствии с выделенным изоцентром

        //Обновляем отображающуюся информацию в соответствии с выделенным пучком
        try {
            gui.setBeamName(model.getIsocentreList().get(gui.getIsoList().getSelectedIndex())
                    .getBeams().get(gui.getBeamList().getSelectedIndex()).getBeamName());
            gui.setBeamSizeX(model.getIsocentreList().get(gui.getIsoList().getSelectedIndex())
                    .getBeams().get(gui.getBeamList().getSelectedIndex()).getBeamSizeX());
            gui.setBeamSizeY(model.getIsocentreList().get(gui.getIsoList().getSelectedIndex())
                    .getBeams().get(gui.getBeamList().getSelectedIndex()).getBeamSizeY());
            gui.setBeamStartAngle(model.getIsocentreList().get(gui.getIsoList().getSelectedIndex())
                    .getBeams().get(gui.getBeamList().getSelectedIndex()).getBeamStartAngle());
            gui.setBeamStopAngle(model.getIsocentreList().get(gui.getIsoList().getSelectedIndex())
                    .getBeams().get(gui.getBeamList().getSelectedIndex()).getBeamStopAngle());
            gui.setBeamTime(model.getIsocentreList().get(gui.getIsoList().getSelectedIndex())
                    .getBeams().get(gui.getBeamList().getSelectedIndex()).getBeamTime());
        } catch (Exception e) {
            //e.printStackTrace();
            gui.setBeamName("Не выбран Пучок");
            gui.setBeamSizeX(0);
            gui.setBeamSizeY(0);
            gui.setBeamStartAngle(0);
            gui.setBeamStopAngle(0);
            gui.setBeamTime(0);
        }
        //
        gui.validate();
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        updateGUI();
    }
}
