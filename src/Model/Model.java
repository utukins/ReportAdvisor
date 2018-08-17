package Model;

import java.util.ArrayList;

public class Model {
    protected  ArrayList<Isocentre> isocentreList = new ArrayList<Isocentre>();

    public ArrayList<Isocentre> getIsocentreList() {
        return isocentreList;
    }
    public void addIsocentre(Isocentre isocentre) {
        isocentreList.add(isocentre);
    }

}