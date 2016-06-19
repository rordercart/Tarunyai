package tarunyai;

/**
 *
 * @author Dhairya
 */

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="DBConnection")
public class DBConnection {

	String connectionName;

    public String getConnectionName() {
        return connectionName;
    }
  @XmlElement
    public void setConnectionName(String connectionName) {
        this.connectionName = connectionName;
    }

    
        
}
