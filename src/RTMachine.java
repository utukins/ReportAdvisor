/**
 * Этот класс описывает аппарат: РИО, мониторные единицы, название.
 * Created by чет on 23.06.2017.
 */
public class RTMachine {
    enum TimeFormat {
        SECONDS,
        MINUTES,
        MINUTES_SECONDS
    }
    private String RTMachineName; // Название аппарата
    private TimeFormat timeFormat; // Формат единиц времени аппарата
    private double SourceAxisDistance = 100; // РИО аппарата в сантиметрах
    // Конструктор
    RTMachine (String name, double SAD, TimeFormat TimeFormat ) {
        RTMachineName = name;
        timeFormat = TimeFormat;
        SourceAxisDistance = SAD;
    }
    // Setters
  /*  private void setSourceAxisDistance(double sourceAxisDistance) {
        this.SourceAxisDistance = sourceAxisDistance;
    }
    public void setTimeFormat(timeFormat timeType) {
        this.timeFormat = timeType;
    }
    public void setRTMachineName(String RTMachineName) {
        this.RTMachineName = RTMachineName;
    }
    */
    // Getters
    public String getRTMachineName() {
        return RTMachineName;
    }
    public double getSourceAxisDistance() {
        return SourceAxisDistance;
    }
    public String getTimeInFormat(Beam beam) {
        String str = new String();
        if (this.timeFormat == TimeFormat.SECONDS) {
            str = beam.getBeamTime() + " сек ";
        } else if (this.timeFormat == TimeFormat.MINUTES) {
            str = roundResult(((double)beam.getBeamTime())/60.0, 2) + " min ";
        } else if (this.timeFormat == TimeFormat.MINUTES_SECONDS) {
            str = ((int)beam.getBeamTime()/60) + " мин " + (beam.getBeamTime() - 60*((int)beam.getBeamTime()/60)) + " сек ";
        } else str = "NOT";
        return str;
    }
    private double roundResult (double d, int precise) {
        precise = (int) Math.pow(10,precise);
        d = d * precise;
        int i = (int) Math.round(d);
        return (double) i/precise;
    }

}
