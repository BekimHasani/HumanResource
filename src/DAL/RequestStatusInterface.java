/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.RequestStatus;
import java.util.List;

/**
 *
 * @author USER
 */
public interface RequestStatusInterface {
    void create(RequestStatus rs) throws RequestStatusException;
    void edit(RequestStatus rs) throws RequestStatusException;
    void delete(RequestStatus rs) throws RequestStatusException;
    List<RequestStatus> findAll() throws RequestStatusException;
    RequestStatus findByID(Integer ID) throws RequestStatusException;
    RequestStatus getPending() throws RequestStatusException;
    RequestStatus getPendingHR() throws RequestStatusException;
}
