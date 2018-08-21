package Model;

/**
 * Этот абстрактный класс описывает основноые парпаметры пучка
 * Created by чет on 23.06.2017.
 */
public class Beam {
    public enum Modifiers {
        No,
        Blocks,
        Wedge
    }
    private String BeamName;
    private double BeamSizeX;
    private double BeamSizeY;
    private int BeamTime;
    private int BeamStartAngle;
    private int BeamStopAngle;
    private boolean isStatic;
    private boolean hasModifier;
    private Modifiers Modifier;

    // Конструкторы

    public Beam() {
        setBeamName("Model.Beam");
        setBeamSizeX(10);
        setBeamSizeY(10);
        setBeamTime(0);
        setBeamStartAngle(0);
        setModifier(Modifiers.No);
    }
    public Beam(String BeamName, double BeamSizeX, double BeamSizeY, int BeamStatictAngle ,int BeamTime){
        setBeamName(BeamName);
        setBeamSizeX(BeamSizeX);
        setBeamSizeY(BeamSizeY);
        setBeamStartAngle(BeamStatictAngle);
        setBeamTime(BeamTime);
        setModifier(Modifiers.No);
    }
    public Beam(String BeamName, double BeamSizeX, double BeamSizeY, int BeamStartAngle, int BeamStopAngle ,int BeamTime){
        setBeamName(BeamName);
        setBeamSizeX(BeamSizeX);
        setBeamSizeY(BeamSizeY);
        setBeamStartAngle(BeamStartAngle);
        setBeamStopAngle(BeamStopAngle);
        setBeamTime(BeamTime);
        setModifier(Modifiers.No);
    }

    // Setters

    public void setBeamName(String BeamName) {
        this.BeamName = BeamName;
    }
    public void setBeamSizeX(double BeamSizeX) {
        this.BeamSizeX = BeamSizeX;
    }
    public void setBeamSizeY(double BeamSizeY) {
        this.BeamSizeY = BeamSizeY;
    }
    public void setBeamTime(int BeamTime) {
        this.BeamTime = BeamTime;
    }
    public void setBeamStartAngle(int BeamStartAngle) {
        this.BeamStartAngle = BeamStartAngle;
        if (this.BeamStopAngle == this.BeamStartAngle) {
            isStatic = true;
        } else isStatic = false;
    }
    public void setBeamStopAngle(int BeamStopAngle) {
        this.BeamStopAngle = BeamStopAngle;
        if (this.BeamStopAngle == this.BeamStartAngle) {
            isStatic = true;
        } else isStatic = false;
    }
    public void setBeamStaticAngle (int BeamStaticAngle) {
        this.BeamStartAngle = BeamStaticAngle;
        this.BeamStopAngle = BeamStaticAngle;
        isStatic = true;
    }
    public void setModifier(Modifiers Modifier) {
        this.Modifier = Modifier;
        if (this.Modifier != Modifiers.No) hasModifier = true;
        else hasModifier = false;
    }

    // Getters

    public String getBeamName() {
        return BeamName;
    }
    public double getBeamSizeX() {
        return BeamSizeX;
    }
    public double getBeamSizeY() {
        return BeamSizeY;
    }
    public int getBeamTime() {
        return BeamTime;
    }
    public int getBeamStartAngle() {
        return BeamStartAngle;
    }
    public int getBeamStopAngle() {
        return BeamStopAngle;
    }
    public Modifiers getModifier() {
        return Modifier;
    }
    public boolean isStatic () {
        return isStatic;
    }
    public boolean hasModifier() {
        return hasModifier;
    }

    @Override
    public String toString() {
        return new String(BeamName + " " + BeamSizeX + " x " + BeamSizeY + " agnle " + BeamStartAngle);
    }
}
