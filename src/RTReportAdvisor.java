import Controller.Controller;
import Model.*;
import View.GUI;

import java.util.ArrayList;

/**Главный класс
 * Created by чет on 23.06.2017.
 */
public class RTReportAdvisor {

    public static void main(String[] args) {
        ArrayList<RTMachine> RTMachines = new ArrayList<>();
        RTMachine Theratron = new RTMachine("Theratron", 80 , RTMachine.TimeFormat.MINUTES);
        RTMachine RokusAM = new RTMachine("РОКУС-АМ", 75, RTMachine.TimeFormat.SECONDS);
        RTMachines.add(Theratron);
        RTMachines.add(RokusAM);

        GUI gui = new GUI();
        gui.setSize(900,480);

        Isocentre isocentre = new Isocentre(RTMachines.get(0)); //Здесь нужен список или массив
        isocentre.setRTMachine(RTMachines.get(0));
        isocentre.setPosition (new Position(isocentre.getRtMachine()));
        isocentre.getPosition().setTechnique(Position.Technique.SAD);
        isocentre.getPosition().setAxisSurfaceDistance(10);
        isocentre.getPosition().setLateralOffset(0.5);
        isocentre.getPosition().setLongitudinalOffset(3);
        Beam beam1 = new Beam();
        beam1.setBeamName("Стернальное");
        beam1.setBeamSizeX(12);
        beam1.setBeamSizeY(24);
        beam1.setBeamTime(100);
        beam1.setModifier (Beam.Modifiers.No);

        Beam beam2 = new Beam();
        beam2.setBeamName("Вертебральное");
        beam2.setBeamSizeX(12);
        beam2.setBeamSizeY(24);
        beam2.setBeamTime(222);
        beam2.setModifier (Beam.Modifiers.Blocks);

        Isocentre isocentre2 = new Isocentre(RTMachines.get(0));
        isocentre2.setRTMachine(RTMachines.get(1));
        isocentre2.setPosition (new Position(isocentre2.getRtMachine()));
        isocentre2.getPosition().setTechnique(Position.Technique.SSD);
        isocentre2.getPosition().setAxisSurfaceDistance(10);
        isocentre2.getPosition().setLateralOffset(0.5);
        isocentre2.getPosition().setLongitudinalOffset(3);

        Beam beam3 = new Beam();
        beam3.setBeamName("Пучок с клином");
        beam3.setBeamSizeX(12);
        beam3.setBeamSizeY(24);
        beam3.setBeamTime(555);
        beam3.setModifier (Beam.Modifiers.Wedge);
        Beam beam4 = new Beam("Сектор", 6, 7, 0,180,105);
        Beam beam5 = new Beam("Статика", 6, 7, 0,105);

        isocentre.addBeam(beam1);
        isocentre.addBeam(beam2);
        isocentre2.addBeam(beam3);
        isocentre2.addBeam(beam4);
        isocentre2.addBeam(beam5);

        Model model = new Model();
        model.addIsocentre(isocentre);
        Controller controller = new Controller(gui, model);
        //gui.setController(controller);
    }

    public static String Printreport(Isocentre isocentre)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(isocentre.getRtMachine().getRTMachineName() + '\n');
        sb.append(isocentre.getPosition().toString() + '\n');
        sb.append("Пучки:" + '\n');
        for (Beam beam : isocentre.getBeams()) {
            sb.append(beam.getBeamName() + " " + beam.getBeamSizeX() + 'x' +
            beam.getBeamSizeY() + "cm " +
            beam.getBeamStartAngle() + " - " + beam.getBeamStopAngle()+  "гр " + isocentre.getRtMachine().getTimeInFormat(beam)+
            beam.getModifier() + " " +"\n");
        }
        sb.append('\n');
        return sb.toString();
    }
}
