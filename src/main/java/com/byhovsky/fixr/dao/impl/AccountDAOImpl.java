package com.byhovsky.fixr.dao.impl;

import com.byhovsky.fixr.dao.DAOInterface;
import com.byhovsky.fixr.model.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class AccountDAOImpl implements DAOInterface<Account> {

    private static final Logger logger = LoggerFactory.getLogger(AccountDAOImpl.class);

    private SessionFactory sessionFactory;

    /**
     * Setter for property 'sessionFactory'.
     *
     * @param sessionFactory Value to set for property 'sessionFactory'.
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(Account account) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(account);
        logger.info("Account added successfully" + account);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(Account account) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(account);
        logger.info("Account updated successfully" + account);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Account account = (Account) session.load(Account.class, new Integer(id));
        if (account != null) {
            session.delete(account);
        }
        logger.info("Account deleted successfully" + account);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Account getById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Account account = (Account) session.load(Account.class, new Integer(id));
        logger.info("Account loaded successfully" + account);
        return account;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Account> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Account> accounts = session.createQuery("from Account").list();
        for (Account account : accounts) {
            logger.info("Account details" + account);
        }
        return accounts;
    }
}
