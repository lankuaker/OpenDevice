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

package br.com.criativasoft.opendevice.middleware.model.rules;

import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.Entity;

/**
 *
 * @author Ricardo JL Rufino
 * @date 31/10/16
 */
@Entity
@JsonTypeName(value = "state")
public class StateRuleSpec extends RuleSpec {

    private long value;

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "StateRule[Device:"+getResourceID()+", Value:"+value+"]";
    }
}
