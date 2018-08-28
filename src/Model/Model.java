package Model;

import java.util.ArrayList;

/**
 * Этот класс описывает Модель из шаблона MVP
 */
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
    public void removeBeam (int IndexOfIsocentre, int IndexOfBeam) {
        isocentreList.get(IndexOfIsocentre).removeBeam(IndexOfBeam);
    }

    public boolean contains(Isocentre isocentre){
        return isocentreList.contains(isocentre);
    }
    @Override
    public String toString() {
        String result = new String();
        int counter = 1;
        StringBuilder sb = new StringBuilder();
        for (Isocentre isocentre : isocentreList) {
            sb = sb.append(counter).append(") ").
                    append(isocentre.toString()).
                    append("\n");
            int beamCount = 1;
            for(Beam beam : isocentre.getBeams()) {
                sb.append("    ").
                   append(beamCount).
                   append(".").
                   append(beam.toString()).
                   append("\n");
                beamCount++;
            }
            counter++;
        }
        result = sb.toString();
        return result ;
    }
}