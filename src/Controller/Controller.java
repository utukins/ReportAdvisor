package Controller;

import Model.Isocentre;
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
    Isocentre isocentre;

    public Controller(GUI gui, Isocentre isocentre) {
        this.gui = gui;
        this.isocentre = isocentre;
        gui.setController(this);
        this.gui.setTextTest("Hello");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // Здесь нужно добавить обработчики нажатий на кнопки и поля в GUI
        if (e.getActionCommand()=="createIsocentre") {
            gui.setTextTest(isocentre.getBeams().toString());
        }
        gui.setTextTest(isocentre.getBeams().toString());
    }


    @Override
    public void stateChanged(ChangeEvent e) {

    }
}
