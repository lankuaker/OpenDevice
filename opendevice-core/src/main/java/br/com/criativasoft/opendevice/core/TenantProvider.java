/*
 *
 *  * ******************************************************************************
 *  *  Copyright (c) 2013-2014 CriativaSoft (www.criativasoft.com.br)
 *  *  All rights reserved. This program and the accompanying materials
 *  *  are made available under the terms of the Eclipse Public License v1.0
 *  *  which accompanies this distribution, and is available at
 *  *  http://www.eclipse.org/legal/epl-v10.html
 *  *
 *  *  Contributors:
 *  *  Ricardo JL Rufino - Initial API and Implementation
 *  * *****************************************************************************
 *
 */

package br.com.criativasoft.opendevice.core;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * TenantProvider
 *
 * @author Ricardo JL Rufino on 05/10/14.
 */
public abstract class TenantProvider {

    private static TenantProvider provider = new LocalTenantProvider();

    public static final String HTTP_HEADER_KEY = "AuthToken";

    // ============================
    // Private
    // ============================

    protected Map<String, TenantContext> tenants = new ConcurrentHashMap<String, TenantContext>();


    // ============================
    // Abstract
    // ============================


    /**
     * Create a new {@link TenantContext} with provied ID
     */
    protected abstract TenantContext createContext(String id);

    public abstract void  setTenantID(String appID);

    public abstract String getTenantID();


    // ============================
    // Public
    // ============================

    public boolean exist(String tenantID) {
        return tenants.containsKey(tenantID);
    }

    /**
     * Create a new {@link TenantContext} with provied ID
     * @throws IllegalArgumentException if ID already exists
     */
    public TenantContext addNewContext(String id){
        if(!exist(id)){
            TenantContext context = createContext(id);
            tenants.put(id,context);
            return context;
        }else{
            throw new IllegalArgumentException("Context with ID already exists");
        }
    }

    public TenantContext getTenantContext() {
        synchronized (tenants) {
            return tenants.get(getTenantID());
        }
    }

    public TenantContext getTenantContext(String ID) {
        synchronized (tenants) {
            return tenants.get(ID);
        }
    }

    public void cleanUp() {
        // Nothing in default implementtion
    }

    public static TenantProvider getTenantProvider() {
        return provider;
    }

    // ============================
    // Static
    // ============================

    public static void setProvider(TenantProvider provider) {
        TenantProvider.provider = provider;
    }

    public static synchronized void setCurrentID(String appID){
        provider.setTenantID(appID);
    }

    public static String getCurrentID(){
        return provider.getTenantID();
    }

    /** Get current tenant context */
    public static TenantContext getCurrentContext(){ return provider.getTenantContext(); };

}
