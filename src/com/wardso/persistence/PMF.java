package com.wardso.persistence;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

/**
 * Created by IntelliJ IDEA.
 * User: wardso
 * Date: 7/20/11
 * Time: 9:40 PM
 * To change this template use File | Settings | File Templates.
 */
public final class PMF {
    private static final PersistenceManagerFactory pmfInstance =
        JDOHelper.getPersistenceManagerFactory("transactions-optional");

    public static <T> PersistenceManager<T> get(Class<T> classType){
        return new PersistenceManager<T>(pmfInstance.getPersistenceManager(), classType);
    }
}
