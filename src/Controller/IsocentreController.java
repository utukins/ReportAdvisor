package Controller;
/**
 * Этот класс описсывает котроллер из шаблона MVP
 */

import Model.Isocentre;
import javax.swing.*;

public class IsocentreController {
    private JList IsoList;
    DefaultListModel<Isocentre> IsoListModel;

    public IsocentreController (JList IsoList, DefaultListModel<Isocentre> IsoListModel){
        this.IsoList = IsoList;
        this.IsoListModel = IsoListModel;
    }
    public void update(){

    }
}
