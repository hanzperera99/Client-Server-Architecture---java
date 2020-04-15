import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DummyClient
{
    public static void main(String[] args) throws ClassNotFoundException {
        DummyClient dummyClient = new DummyClient() ;
        dummyClient.executeTest() ;

    }

    private void executeTest() throws ClassNotFoundException {
        DummyServer server = new DummyServer() ;
        if(server.isConnected())
        {
            System.out.println("[CLIENT] - The Server is connected, the test can proceed...") ;
            System.out.println("[CLIENT] - The the has finished...");

            TemperatureSample s1 = new TemperatureSample() ;
            s1.value = 10.3 ;
            s1.location = "London" ;
            s1.time = new Date() ;
            System.out.println("[CLIENT] - The Sample is : " + s1);
            try
            {
                server.addSample(s1);
            }
            catch (IOException ex)
            {
                Logger.getLogger(DummyClient.class.getName()).log(Level.SEVERE, null, ex);
            }

            TemperatureSample s2 = new TemperatureSample() ;
            s2.value = 9.1 ;
            s2.location = "London" ;
            s2.time = new Date() ;
            System.out.println("[CLIENT] - The Sample is : " + s2);
            try
            {
                server.addSample(s2);
            }
            catch (IOException ex) {
                Logger.getLogger(DummyClient.class.getName()).log(Level.SEVERE, null, ex);
            }

            TemperatureSample s3 = new TemperatureSample() ;
            s3.value = 10.3 ;
            s3.location = "London" ;
            s3.time = new Date() ;
            System.out.println("[CLIENT] - The Sample is : " + s3);
            try
            {
                server.addSample(s3);
            } catch (IOException ex)
            {
                Logger.getLogger(DummyClient.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        else
        {
            System.out.println("[CLIENT] - The Server is connected, the test has failed...") ;
        }
    }


}
