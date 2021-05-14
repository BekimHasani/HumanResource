/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.TrainingTypes;
import java.util.List;

/**
 *
 * @author BesaC
 */
public interface TrainingTypesInterface {

    void create(TrainingTypes eps) throws TrainingTypesException;

    void edit(TrainingTypes eps) throws TrainingTypesException;

    void remove(TrainingTypes eps) throws TrainingTypesException;

    List<TrainingTypes> findAll() throws TrainingTypesException;

    TrainingTypes findById(Integer ID) throws TrainingTypesException;
}
