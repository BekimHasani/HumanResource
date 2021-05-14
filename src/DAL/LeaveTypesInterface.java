/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.LeaveTypes;
import java.util.List;

/**
 *
 * @author Bekim
 */
public interface LeaveTypesInterface {
    void create(LeaveTypes lt) throws LeaveTypesException;
    void edit(LeaveTypes lt) throws LeaveTypesException;
    void delete(LeaveTypes lt) throws LeaveTypesException;
    List<LeaveTypes> findAll() throws LeaveTypesException;
    LeaveTypes findById(Integer ID) throws LeaveTypesException;
}
