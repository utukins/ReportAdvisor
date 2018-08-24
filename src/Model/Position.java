package Model;

/**
 * Этот класс описывает укладку(смещения)
 * Created by чет on 23.06.2017.
 */
public class Position {
    public enum Technique {
        SSD,
        SAD;
    }
    private Technique Technique;            //ТИП
    private RTMachine rtMachine;
    private double SourceAxisDistance;      //РИО
    private double AxisSurfaceDistance = 0; //РОК
    private double lateralOffset = 0;       // Латеральное смещение
    private double longitudinalOffset = 0;  // Продольное смещение
    private double verticalOffset = 0;      // Вериткальное смещение

    // Конструктор

    public Position(RTMachine RTMachine){
        Technique = Technique.SAD;
        rtMachine = RTMachine;
        SourceAxisDistance = rtMachine.getSourceAxisDistance();
    }

    //  Setters

    public void setTechnique(Technique technique) {
        this.Technique = technique;
    }
    public void setAxisSurfaceDistance(double axisSurfaceDistance) {
        AxisSurfaceDistance = axisSurfaceDistance;
    }
    public void setLateralOffset(double lateralOffset) {
        this.lateralOffset = lateralOffset;
    }
    public void setLongitudinalOffset(double longitudinalOffset) {
        this.longitudinalOffset = longitudinalOffset;
    }
    public void setVerticalOffset(double verticalOffset) {
        this.verticalOffset = verticalOffset;
    }

    //  Getters

    public Technique getTechnique() {
        return Technique;
    }
    public double getSourceSurfaceDistance() {
        return SourceAxisDistance - AxisSurfaceDistance;
    }
    public double getSourceAxisDistance() {
        return SourceAxisDistance;
    }
    public double getAxisSurfaceDistance() {
        return AxisSurfaceDistance;
    }
    public double getLateralOffset() {
        return lateralOffset;
    }
    public double getLongitudinalOffset() {
        return longitudinalOffset;
    }
    public double getVerticalOffset() {
        return verticalOffset;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getTechnique()== Technique.SAD?
                ("РИО-"+getSourceAxisDistance()+";РОК-"+ getAxisSurfaceDistance() + ";РИП-" +
                        getSourceSurfaceDistance() + "\n"):
                ("РИП-" + getSourceAxisDistance())+"\n");
        sb.append("Боковое: " + getLateralOffset()+ "cm\n");
        sb.append("Продольное: " + getLongitudinalOffset()+ "cm\n");
        sb.append("Вертикальное: " + getVerticalOffset()+ "cm\n");
        return sb.toString();
    }
}
