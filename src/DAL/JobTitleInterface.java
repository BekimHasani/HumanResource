/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.JobTitle;
import java.util.List;

/**
 *
 * @author Armend
 */
public interface JobTitleInterface {
    void create(JobTitle jt) throws JobTitleException;
    void edit(JobTitle jt) throws JobTitleException;
    void delete(JobTitle jt) throws JobTitleException;
    List<JobTitle> findAll() throws JobTitleException;
    JobTitle findByID(Integer ID);
}
