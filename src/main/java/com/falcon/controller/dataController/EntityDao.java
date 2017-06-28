package com.falcon.controller.dataController;


import com.falcon.entities.OutputMessage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by io-sar on 26/6/2017.
 */
@Repository
@Transactional
public interface EntityDao extends CrudRepository<OutputMessage, Long>{
}
