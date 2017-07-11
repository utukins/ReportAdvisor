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
    private TimeFormat TimeFormat; // Формат единиц времени аппарата
    private double SourceAxisDistance = 100; // РИО аппарата в сантиметрах
    // Конструктор
    RTMachine (String name, double SAD, TimeFormat TimeFormat ) {
        setRTMachineName(name);
        setTimeFormat(TimeFormat);
        setSourceAxisDistance(SAD);
    }
    // Setters
    private void setSourceAxisDistance(double sourceAxisDistance) {
        this.SourceAxisDistance = sourceAxisDistance;
    }
    public void setTimeFormat(TimeFormat timeType) {
        this.TimeFormat = timeType;
    }
    public void setRTMachineName(String RTMachineName) {
        this.RTMachineName = RTMachineName;
    }
    // Getters
    public String getRTMachineName() {
        return RTMachineName;
    }
    public double getSourceAxisDistance() {
        return SourceAxisDistance;
    }
    public String getTimeInFormat(Beam beam) {
        String str = new String();
        if (this.TimeFormat == TimeFormat.SECONDS) {
            str = beam.getBeamTime() + " сек ";
        } else if (this.TimeFormat == TimeFormat.MINUTES) {
            str = beam.getBeamTime()/60 + "min ";
        }
        return str;
    }
}
