/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Logins;
import java.util.List;

/**
 *
 * @author Armend
 */
public interface LoginsInterface {
    void create(Logins l) throws LoginsException;
    void edit(Logins l) throws LoginsException;
    void delete(Logins l) throws LoginsException;
    List<Logins> findAll() throws LoginsException;
    Logins findById(Integer ID) throws LoginsException;
    List<Logins> findByEmployeeId(Integer ID) throws LoginsException;
    Integer findLogin(int employeeID) throws LoginsException;
    List<Integer> searchEmployeeLoginsHR(String str) throws LoginsException;
    List<Integer> searchEmployeeLoginsCEO(String str) throws LoginsException;
    List<Integer> searchEmployeeLoginsDIR(String str) throws LoginsException;
}
