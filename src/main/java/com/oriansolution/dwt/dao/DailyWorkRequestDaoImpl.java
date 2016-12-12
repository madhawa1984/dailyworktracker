package com.oriansolution.dwt.dao;

import com.oriansolution.dwt.model.Branch;
import com.oriansolution.dwt.model.WorkRequest;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by madhawa on 11/22/16.
 */
@Repository
public class DailyWorkRequestDaoImpl implements DailyWorkRequestDao {
    @Autowired
    SessionFactory sessionFactoryBean;
    public WorkRequest getRequestById(long requestId) throws Exception {
        Session session = null;
        WorkRequest request = null;
        try {
            session = this.sessionFactoryBean.openSession();
            org.hibernate.query.Query query = session.createQuery("from WorkRequest where ID=:id");
            query.setParameter("id", requestId);
            List<WorkRequest> requestList = query.list();
            if (!requestList.isEmpty()) {
                request = requestList.get(0);
                // initialize the other relationships
                Hibernate.initialize(request.getListOfComments());
                Hibernate.initialize(request.getListOfContacts());
                Hibernate.initialize(request.getBranch());
            }

        }catch(Exception e) {
            e.printStackTrace();
            throw new Exception("DWT Error Occured:",e);
        }
        finally {
            if(session!=null) {
                session.close();
            }

        }

        return request;
    }

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