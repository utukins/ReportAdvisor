import java.util.ArrayList;

/**
 * Этот класс описывает Изоцентр, который может содержать в себе много пучков, одну укладку, один Аппарат
 * Created by чет on 23.06.2017.
 */
public class Isocentre {
    private ArrayList<Beam> beams = new ArrayList<>(); // Список/Массив пучков
    private RTMachine rtMachine; // Аппарат
    Position position; // Полодение изоцентра (смещения)
    // Конструктор
    Isocentre(RTMachine RT_Machine) {
        setRtMachine(RT_Machine);
        setPosition(new Position(RT_Machine));
    }
    Isocentre(RTMachine RT_Machine, Position position) {
        setRtMachine(RT_Machine);
        setPosition(position);
    }

    // Setters

    public void setRtMachine(RTMachine rtMachine) {
        this.rtMachine = rtMachine;
    }
    public void setPosition(Position position) {
        this.position = position;
    }
    public void setBeams(ArrayList<Beam> beams) {
        this.beams = beams;
    }

    // Getters

    public RTMachine getRtMachine() {
        return rtMachine;
    }
    public ArrayList<Beam> getBeams() {
        return (ArrayList<Beam>) beams.clone();
    }
    public Position getPosition() {
        return position;
    }
    public int getNumberOfBeams() {
        return beams.size();
    }

    // Добавление/Удаление пучка из списка

    public void addBeam(Beam beam) {
        beams.add(beam);
    }
    public void swapBeams (int intdexOfBeam1,
                          int IndexOfBeam2) {
        if (((intdexOfBeam1 >= 0)&&(intdexOfBeam1 < beams.size()))&&((IndexOfBeam2 >= 0)&&(IndexOfBeam2 < beams.size()))) {
            Beam beamTMP = beams.get(intdexOfBeam1);
            beams.set(intdexOfBeam1, beams.get(IndexOfBeam2));
            beams.set(IndexOfBeam2, beamTMP);
        }
   }
    public void removeBeam(Beam beam){
        beams.remove(beam);
    }
    public void removeBeam(int IndexOfBeam){
        beams.remove(IndexOfBeam);
    }
}
