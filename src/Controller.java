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

    Controller(GUI gui) {
        this.gui = gui;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // Здесь нужно добавить обработчики нажатий на кнопки и поля в GUI
        if (e.getActionCommand()=="Добавить Пучок") {
            gui.setLocation(100,100);
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }
}
