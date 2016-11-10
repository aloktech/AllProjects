/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import com.invicara.xos.core.repository.IRepositoryContextDatabase;
import com.invicara.xos.core.repository.IRepositoryContextRedis;
import com.invicara.xos.core.repository.IRepositoryContextSearch;
import com.invicara.xos.core.repository.RepositoryException;
import com.invicara.xos.core.requests.IRequestContext;
import com.invicara.xos.core.security.PrincipalInfo;
import com.invicara.xos.logger.XOSLogger;

/**
 *
 * @author alok
 */
public class AbstractContext implements IRequestContext{

    @Override
    public XOSLogger getLogger() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PrincipalInfo currentUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IRepositoryContextDatabase getRepositoryConnection() throws RepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IRepositoryContextSearch getSearchConnection() throws RepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IRepositoryContextRedis getRedisConnection() throws RepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean isDBConnectionOpen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean isSearchConnectionOpen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean isRedisConnectionOpen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void closeAll() throws RepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
