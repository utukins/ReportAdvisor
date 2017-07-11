/**
 * Этот класс описывает укладку
 * Created by чет on 23.06.2017.
 */
public class Position {
    enum Technique {
        SSD,
        SAD;
    }
    private Technique Technique; //ТИП
    private double SourceAxisDistance = 100; //РИО
    private double AxisSurfaceDistance = 0; //РОК
    private double lateralOffset = 0;
    private double longitudinalOffset = 0;
    private double verticalOffset = 0;

    // Конструктор

    Position (RTMachine RTMachine){
        Technique = Technique.SAD;
        this.setSourceAxisDistance(RTMachine.getSourceAxisDistance());
    }

    //  Setters

    public void setTechnique(Technique technique) {
        this.Technique = technique;
    }
    public void setSourceAxisDistance(double sourceAxisDistance) {
        SourceAxisDistance = sourceAxisDistance;
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
