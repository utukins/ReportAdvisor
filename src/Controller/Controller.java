package Controller;

import Model.Isocentre;
import Model.Model;
import View.GUI;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Данный класс должен обрабатывать взаимодействие GUI и модели.
 * Created by чет on 26.07.2017.
 */
public class Controller implements ActionListener, ChangeListener {
    GUI gui;
    Model model;

    public Controller(GUI gui, Model model) {
        this.gui = gui;
        this.model = model;
        gui.setController(this);
        gui.setTextTest("Hello");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // Здесь нужно добавить обработчики нажатий на кнопки и поля в GUI
        // Создание/Удаление Изоцентра
        if (e.getActionCommand().equals("createIsocentre")) {
            model.addIsocentre(new Isocentre());
            gui.setTextTest("Isocentre created");
        }
        if (e.getActionCommand().equals("deleteIsocentre")) {

            gui.setTextTest("deleteIsocentre");
        }
        //  Создание/Удаление Пучка
        if (e.getActionCommand().equals("createBeam")) {

            gui.setTextTest("Beam created");
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

            gui.setTextTest("printReport: изоцентров - " + model.getIsocentreList().toArray().length);
        }
        // Кнопка Выход
        if(e.getActionCommand()== "exitButton")
        System.exit(0);
    }


    @Override
    public void stateChanged(ChangeEvent e) {

    }
    public void updateGUI (){
       // gui.getIsoList().add("Isocontre", );
    }
}
