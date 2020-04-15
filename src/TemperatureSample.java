import java.io.Serializable;
import java.util.Date;

public class TemperatureSample implements Serializable
{
    public double value ;
    public String location ;
    public Date time ;

    @Override
    public String toString() {
        return "TemperatureSample{" +
                "value=" + value +
                ", location='" + location + '\'' +
                ", time=" + time +
                '}';
    }
}
