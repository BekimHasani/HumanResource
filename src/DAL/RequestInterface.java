/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Request;
import java.util.List;

/**
 *
 * @author Armend
 */
public interface RequestInterface {
    void create(Request r) throws RequestException; 
    void edit(Request r) throws RequestException;
    void delete(Request r) throws RequestException;
    List<Request> findAll() throws RequestException;
    Request findById(Integer ID) throws RequestException;
    List<Request> getPendingHr() throws RequestException;
    List<Request> getPendingDirector() throws RequestException;
    List<Integer> findEmployeeRequests(int employeeId,String str) throws RequestException;
}
