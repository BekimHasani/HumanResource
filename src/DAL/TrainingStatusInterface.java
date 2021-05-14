/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.TrainingStatus;
import java.util.List;

/**
 *
 * @author BesaC
 */
public interface TrainingStatusInterface {
    
    void create(TrainingStatus ts) throws TrainingStatusException;
    void edit (TrainingStatus ts) throws TrainingStatusException;
    void remove(TrainingStatus ts) throws TrainingStatusException;
    List<TrainingStatus> findAll() throws TrainingStatusException;
    TrainingStatus findById(Short id) throws TrainingStatusException;
}
