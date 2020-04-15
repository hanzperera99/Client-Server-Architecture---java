import java.io.*;
import java.nio.file.FileSystemNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DummyServer
{

    ArrayList<TemperatureSample> samples = new ArrayList<TemperatureSample>() ;
    String fileName = "Sample.ser" ;
    public DummyServer()
    {
        try {
            loadFromFile();
        }catch (IOException ex)
        {
            Logger.getLogger(DummyServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(DummyServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean isConnected()
    {
        System.out.println("[SERVER] - Testing if server is connected");
        return true ;
    }

    public void addSample(TemperatureSample s) throws IOException, ClassNotFoundException {
        System.out.println("[SERVER ] - Adding " + s + " to " + samples ) ;
        samples.add(s) ;
        System.out.println("[SERVER] - Samples are " + samples) ;
        saveToFile();
    }

    private void saveToFile() throws FileSystemNotFoundException, IOException, ClassNotFoundException {
        System.out.println("[SERVER] - Saving " + samples + " to file " + fileName);
        FileOutputStream file = new FileOutputStream(fileName ) ;
        ObjectOutputStream out = new ObjectOutputStream(file) ;

        out.writeObject(samples);
        out.close();
        file.close();

        System.out.println("[SERVER] - Object has been serialized") ;
     }

    private void loadFromFile() throws FileSystemNotFoundException, IOException, ClassNotFoundException {
        System.out.println("[SERVER] - Loading sample from file " + fileName);

        FileInputStream file = new FileInputStream(fileName) ;
        ObjectInputStream in = new ObjectInputStream(file) ;

        samples = (ArrayList<TemperatureSample>)in.readObject() ;
        in.close();
        file.close();

    }

    private void getColdestTemperatureIn(String city)
    {
        double coldest_temperature = samples.get(0).value ;
        for (int i = 0 ; i < samples.size() ; i ++)
        {

        }
    }

}
