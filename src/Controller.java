import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Данный класс должен обрабатывать взаимодействие GUI и модели.
 * Created by чет on 26.07.2017.
 */
public class Controller implements ActionListener {
    GUI gui;

    Controller(GUI gui) {
        this.gui = gui;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // Здесь нужно добавить обработчики нажатий на кнопки и поля в GUI
        Object src = e.getSource();
       // if (src == gui.)
    }

}
