
package com.imos.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author alok
 */
public class QueryManagement {

    private final Session session;

    public QueryManagement(Session session) {
        this.session = session;
    }

    <T> List<T> executeForList(String query, Map<String, Object> parameters) {
        try {
            Query q = session.createQuery(query);
            q.setProperties(parameters);

            return (List<T>) q.list();
        } catch (Exception e) {
        }
        return new ArrayList<>();
    }
    
    int executeForSingleResult(String query, Map<String, Object> parameters) {
        try {
            Query q = session.createQuery(query);
            q.setProperties(parameters);

            return q.getFirstResult();
        } catch (Exception e) {
        }
        return 0;
    }
}
