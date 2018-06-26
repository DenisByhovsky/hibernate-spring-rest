package com.byhovsky.fixr.service.impl;

import com.byhovsky.fixr.dao.DAOInterface;
import com.byhovsky.fixr.model.Account;
import com.byhovsky.fixr.service.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
public class AccountServiceImpl implements Service<Account> {

    private DAOInterface daoInterface;

    /**
     * Setter for property 'daoInterface'.
     *
     * @param daoInterface Value to set for property 'daoInterface'.
     */
    public void setDaoInterface(DAOInterface daoInterface) {
        this.daoInterface = daoInterface;
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public Account getById(int id) {
        return this.daoInterface.getById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public void add(Account account) {
        this.daoInterface.add(account);
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public void update(Account account) {
        this.daoInterface.update(account);
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public void remove(int id) {
        this.daoInterface.remove(id);
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public List<Account> getAll() {
        return this.daoInterface.getAll();
    }
}
