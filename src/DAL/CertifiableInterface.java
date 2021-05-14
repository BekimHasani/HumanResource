/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Certifiable;
import java.util.List;

/**
 *
 * @author Bekim
 */
public interface CertifiableInterface {
    
    void create(Certifiable rs) throws CertifiableException;
    void edit(Certifiable rs) throws CertifiableException;
    void delete(Certifiable rs) throws CertifiableException;
    List<Certifiable> findAll() throws CertifiableException;
    Certifiable findByID(Short ID) throws CertifiableException;
}
