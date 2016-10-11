/*
 * *****************************************************************************
 * Copyright (c) 2013-2014 CriativaSoft (www.criativasoft.com.br)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *  Ricardo JL Rufino - Initial API and Implementation
 * *****************************************************************************
 */

package br.com.criativasoft.opendevice.core;

/**
 * Provider that is used for local applications <b>without</b> support muti-tenant
 * @author Ricardo JL Rufino
 * @date 29/08/15.
 */
public class LocalTenantProvider extends TenantProvider {

    private static String tenantID;

    @Override
    public void setTenantID(String appID) {
        this.tenantID = appID;
    }

    @Override
    public String getTenantID() {
        return tenantID;
    }
}
