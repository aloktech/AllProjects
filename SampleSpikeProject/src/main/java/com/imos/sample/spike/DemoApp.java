/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.sample.spike;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import org.apache.deltaspike.cdise.api.CdiContainer;
import org.apache.deltaspike.cdise.api.CdiContainerLoader;
import org.apache.deltaspike.cdise.api.ContextControl;
import org.apache.deltaspike.core.api.config.ConfigResolver;
import org.apache.deltaspike.core.api.provider.BeanProvider;
import org.apache.deltaspike.core.spi.config.ConfigSource;

/**
 *
 * @author INVCH018
 */
public class DemoApp {

    private static final Logger LOG = Logger.getLogger(DemoApp.class.getName());

    @Inject
    private ApplicationScopedBean applicationScopedBean;

    public static void main(String[] args) {
//        CdiContainer container = CdiContainerLoader.getCdiContainer();
//        container.boot();
//        ContextControl contextControl = container.getContextControl();
//        contextControl.startContexts();
//
//        try {
//            BeanProvider.injectFields(new DemoApp()).runApplicationLogic();
//        } finally {
//            container.shutdown();
//        }
//        ConfigSource re = ConfigSource.DELTASPIKE_ORDINAL;
//        String dbName = ConfigResolver
//                .addConfigSources(configSourcesToAdd)
//                .resolve("db.name")
//                .as(String.class)
//                .getValue();
//        Integer dbPort = ConfigResolver
//                .resolve("db.port")
//                .as(Integer.class)
//                .getValue();

        System.out.println(dbName + " : " + dbPort);
    }

    void runApplicationLogic() {
        LOG.log(Level.INFO, "Info of injected bean: {0}", this.applicationScopedBean.getValue());
    }
}
