
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Pintu
 */
public class RESTClientTest {

    private WebTarget target;
    private static Client client;

    @BeforeClass
    public static void setUp() {
        client = ClientBuilder.newClient();
    }

    @Test
    public void testLocal() {
        target = client.target("http://10.0.0.4:8080/SampleWebApp").path("resources").path("basic").path("name");
        String data = target.request().get().readEntity(String.class);
        System.out.println(data);
    }

    @Test
    @Ignore
    public void testDocker() {
        target = client.target("http://192.168.1.34:8088/SampleRESTService").path("basic").path("name");
        String data = target.request().get().readEntity(String.class);
        System.out.println(data);
    }
}
