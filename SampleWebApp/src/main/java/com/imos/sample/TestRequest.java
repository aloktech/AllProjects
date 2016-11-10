/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample;

import com.invicara.xos.core.repository.RepositoryException;
import com.invicara.xos.core.requests.IRequest;
import com.invicara.xos.core.requests.IRequestContext;
import com.invicara.xos.core.requests.RequestEvent;
import com.invicara.xos.core.requests.RequestException;
import com.invicara.xos.logger.XOSLogger;
import org.json.JSONObject;

/**
 *
 * @author alok
 */
//@Permissions({TestPermission.ONE.getDegree()})
public class TestRequest implements IRequest<JSONObject> {

    XOSLogger logger;

    @Override
    public Boolean execute(IRequestContext context) throws RequestException {
        logger = context.getLogger();
        boolean status = false;
        try {
            context.getRepositoryConnection();
            System.out.println("TestRequest");
            logger.event(new TestLog("done"));
        } catch (RepositoryException ex) {
            logger.event(new TestLog());
        }
        return status;
    }

    @Override
    public RequestEvent getBeginEvent(IRequestContext context) {
        return new RequestEvent("", new JSONObject());
    }

    @Override
    public RequestEvent getEndEvent(IRequestContext context) {
        return new RequestEvent("", new JSONObject());
    }

    @Override
    public JSONObject getResults() {
        return new TokenResource().toJSON();
    }

    @Override
    public Boolean isReadOnly() {
        return true;
    }

}
