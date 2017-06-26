package com.falcon.controller.dataController;


import com.falcon.entities.Dummy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by bagasas on 26/6/2017.
 */
@Repository
@Transactional
public interface EntityDao extends CrudRepository<Dummy, Long>{
}
