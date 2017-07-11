import javax.print.attribute.standard.MediaSize;
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

        Isocentre isocentre = new Isocentre(RTMachines.get(0)); //Здесь нужен список или массив
        isocentre.setRtMachine(RTMachines.get(0));
        isocentre.position = new Position(isocentre.getRtMachine());
        isocentre.position.setTechnique(Position.Technique.SAD);
        isocentre.position.setAxisSurfaceDistance(10);
        isocentre.position.setLateralOffset(0.5);
        isocentre.position.setLongitudinalOffset(3);
        Beam beam1 = new Beam();
        beam1.setBeamName("Стернальное");
        beam1.setBeamSizeX(12);
        beam1.setBeamSizeY(24);
        beam1.setBeamTime(222);
        beam1.Modifier = Beam.Modifiers.No;

        Beam beam2 = new Beam();
        beam2.setBeamName("Вертебральное");
        beam2.setBeamSizeX(12);
        beam2.setBeamSizeY(24);
        beam2.setBeamTime(222);
        beam2.Modifier = Beam.Modifiers.Blocks;

        Isocentre isocentre2 = new Isocentre(RTMachines.get(0));
        isocentre2.setRtMachine(RTMachines.get(1));
        isocentre2.position = new Position(isocentre2.getRtMachine());
        isocentre2.position.setTechnique(Position.Technique.SSD);
        isocentre2.position.setAxisSurfaceDistance(10);
        isocentre2.position.setLateralOffset(0.5);
        isocentre2.position.setLongitudinalOffset(3);

        Beam beam3 = new Beam();
        beam3.setBeamName("Пучок с клином");
        beam3.setBeamSizeX(12);
        beam3.setBeamSizeY(24);
        beam3.setBeamTime(555);
        beam3.Modifier = Beam.Modifiers.Wedge;
        Beam beam4 = new Beam("Сектор", 6, 7, 0,180,105);
        Beam beam5 = new Beam("Статика", 6, 7, 0,105);

        isocentre.addBeam(beam1);
        isocentre.addBeam(beam2);
        isocentre2.addBeam(beam3);
        isocentre2.addBeam(beam4);
        isocentre2.addBeam(beam5);
        Printreport(isocentre);
        Printreport(isocentre2);
    }

    public static void Printreport(Isocentre isocentre)
    {
        System.out.println(isocentre.getRtMachine().getRTMachineName());
        System.out.println(isocentre.position.toString());
        System.out.println("Пучки:");
        for (Beam beam : isocentre.getBeams()) {
            System.out.print(beam.getBeamName() + " " + beam.getBeamSizeX() + 'x' +
            beam.getBeamSizeY() + "cm " +
            beam.getBeamStartAngle() + " - " + beam.getBeamStopAngle()+  "гр " + isocentre.getRtMachine().getTimeInFormat(beam)+
            beam.getModifier() + "\n");
        }
        System.out.println();
    }
}
