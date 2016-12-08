package com.oriansolution.dwt.dao;

import com.oriansolution.dwt.model.WorkRequest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by madhawa on 11/22/16.
 */
@Repository
public class DailyWorkRequestDaoImpl implements DailyWorkRequestDao {
    @Autowired
    SessionFactory sessionFactoryBean;

    public WorkRequest createRequest(WorkRequest request) {
        Session session = null;
        try {
            session = this.sessionFactoryBean.openSession();
            //session = this.sessionFactoryBean.getCurrentSession();
            //Transaction tx = session.beginTransaction();
            // session.saveOrUpdate(request);
            session.save(request);
            //tx.commit();
            session.close();
        }catch(Exception e) {
            e.printStackTrace();
            request = null; // if exception caught
        }
        finally {
            if(session!=null) {
                session.close();
            }
             return request;
        }

    }
}