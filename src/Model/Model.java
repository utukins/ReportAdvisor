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
    public void addBeam(int IsocentreNumber, Beam beam){
        isocentreList.get(IsocentreNumber).addBeam(beam);
    }
    public void removeIsocentre (int NumberOfIsocentre) {
        isocentreList.remove(NumberOfIsocentre);
    }
}