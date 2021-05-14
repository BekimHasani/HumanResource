/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.HumanResourceLogin;
import java.util.List;

/**
 *
 * @author Armend
 */
public interface HumanResourceLoginInterface {
    void create(HumanResourceLogin hrl) throws HumanResourceLoginException; 
    void edit(HumanResourceLogin hrl) throws HumanResourceLoginException;
    void delete(HumanResourceLogin hrl) throws HumanResourceLoginException;
    List<HumanResourceLogin> findAll() throws HumanResourceLoginException;
    HumanResourceLogin findById(Integer ID) throws HumanResourceLoginException;
    HumanResourceLogin loginByUsernameAndPassword(String u, String p) throws HumanResourceLoginException;
}
