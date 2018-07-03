
import com.practice.soap.person.bean.xsd.Person;
import javax.xml.ws.BindingProvider;
import webservice.person.soap.practice.com.PersonServiceImpl;
import webservice.person.soap.practice.com.PersonServiceImplPortType;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author baluj
 */
public class PersonClientTest {
 
    public static void main(String arg[]) {
        PersonServiceImpl service = new PersonServiceImpl();
        
        PersonServiceImplPortType port = service.getPersonServiceImplHttpport();
        
        BindingProvider bp = (BindingProvider) port;
        
        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:8080/axis2_6/services/PersonServiceImpl?wsdl");
        
        port.addPerson(1, "Prem", "Anand");
        port.addPerson(2, "Dinesh", "Ram");
        
        for(int i=0;i<3;i++) {
        Person person = port.getPerson(i);
        
        System.out.println("Person id:"+person.getId()+ " Firstname:"+person.getFirstname().getValue()+ " Lastname:"+person.getLastname().getValue());
        }
        
    }
}
