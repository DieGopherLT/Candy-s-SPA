
package candy.s.spa;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class CANDYSSPA {
    public static void main(String[] args) throws SQLException {
        try {
            new window().setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CANDYSSPA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
