package com.oriansolution.dwt.dao;

import com.oriansolution.dwt.model.Branch;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by madhawa on 12/7/16.
 */
@Repository
public class BranchDaoImpl implements BranchDao {
    @Autowired
    SessionFactory sessionFactoryBean;

    public List<Branch> getBranchList() {
        Session session = null;
        Branch branch = null;
        List<Branch> branchList = new ArrayList<Branch>();

        try {
            session = sessionFactoryBean.openSession();
            // session = sessionFactoryBean.getCurrentSession();
            Query query = session.createQuery("from Branch");
            branchList = query.list();

        }catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            if(session!=null) {
                session.close();
            }
            return branchList;
        }

    }
    @Override
    public Branch getBranchByUpfId(String upfServiceBranchId) {
        Session session = null;
        Branch branch = null;
        try {
            session = sessionFactoryBean.openSession();
            // session = sessionFactoryBean.getCurrentSession();
            Query query = session.createQuery("from Branch where upfServiceBranchId=:id");
            query.setParameter("id", upfServiceBranchId);
            List<Branch> branchList = query.list();
            if (!branchList.isEmpty()) {
                branch = branchList.get(0);
            }

        }catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            if(session!=null) {
                session.close();
            }
            return branch;
        }

    }
}
