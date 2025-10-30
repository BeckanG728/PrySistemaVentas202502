
package interfaz;

import java.sql.ResultSet;

public interface VentasInferface <T> {
    
    ResultSet search(Object objItem) throws Exception;
    void insert(T objItem) throws Exception;
    void update(T objItem) throws Exception;
    void delete(T objItem) throws Exception;
}
