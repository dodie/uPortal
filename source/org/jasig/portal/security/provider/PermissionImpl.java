package org.jasig.portal.security.provider;

/**
 * Copyright (c) 2001 The JA-SIG Collaborative.  All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. Redistributions of any form whatsoever must retain the following
 *    acknowledgment:
 *    "This product includes software developed by the JA-SIG Collaborative
 *    (http://www.jasig.org/)."
 *
 * THIS SOFTWARE IS PROVIDED BY THE JA-SIG COLLABORATIVE "AS IS" AND ANY
 * EXPRESSED OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE JA-SIG COLLABORATIVE OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */

import  org.jasig.portal.security.*;
import  java.util.Date;
import  org.jasig.portal.groups.EntityTypes;


/**
 * @author Bernie Durfee (bdurfee@interactivebusiness.com)
 * @author Dan Ellentuck
 * @version $Revision$ 
 */
public class PermissionImpl implements IPermission{
  private String m_owner = null;	
  private String m_principalKey = null;
  private int m_principalType = 0;
  private String m_activity = null;
  private String m_target = null;
  private String m_type = null;
  private Date m_effective = null;
  private Date m_expires = null;

  /**
   * This constructor ensures that all Permission objects are created with an owner specified.
   * @param owner
   */
  public PermissionImpl (String owner) {
    // Make sure to call the constructor that stores the owner
    super();
    m_owner = owner;
  }
  /**
   * Returns the token that represents the activity that this Permission is associated with.
   * @return 
   */
  public String getActivity () {
    return  (m_activity);
  }
  /**
   * Returns the effective date that was set for this Permission.
   * @return 
   */
  public Date getEffective () {
    return  (m_effective);
  }
  /**
   * Returns the expires date that was set for this Permission.
   * @return 
   */
  public Date getExpires () {
    return  (m_expires);
  }
  /**
   * Returns the owner of this Permission
   * @return 
   */
  public String getOwner () {
    return  (m_owner);
  }
  /**
   * Returns the token that represents the key of the principal that this Permission is associated with.
   * @return 
   */
  public String getPrincipalKey () {
    return  (m_principalKey);
  }
  /**
   * @return String
   */
  private String getPrincipalString () 
  {
    Integer typeID = new Integer(getPrincipalType());
    Class type = EntityTypes.getEntityType(typeID);
	return type.getName() + " : " + getPrincipalKey();
  }
  /**
   * Returns the entity type of the principal that this Permission is associated with.
   * @return 
   */
  public int getPrincipalType () {
    return  (m_principalType);
  }
  /**
   * Returns the token that represents the target that this Permission is associated with.
   */
  public String getTarget () {
    return  (m_target);
  }
  /**
   * Returns the type of permission that this is, generally GRANT or DENY
   * @return 
   */
  public String getType () {
    return  (m_type);
  }
  /**
   * Specifies the token that represents the activity that this Permission is associated with.
   * @param activity
   */
  public void setActivity (String activity) {
    m_activity = activity;
  }
  /**
   * Specifies the date that this Permission will become effective.
   * @param effective
   */
  public void setEffective (Date effective) {
    m_effective = effective;
  }
  /**
   * Specifies the date that this Permission will expire.
   * @param expires
   */
  public void setExpires (Date expires) {
    m_expires = expires;
  }
  /**
   * Specifies the token that represents the key of principal that this Permission is associated with.
   * @param principal
   */
  public void setPrincipalKey (String newPrincipalKey) {
    m_principalKey = newPrincipalKey;
  }
  /**
   * Specifies the entity type of the principal that this Permission is associated with.
   * @param principal
   */
  public void setPrincipalType (int newPrincipalType) {
    m_principalType = newPrincipalType;
  }
  /**
   * Specifies the token that represents the target that this Permission is associated with.
   * @param target
   */
  public void setTarget (String target) {
    m_target = target;
  }
  /**
   * Sets the permission type
   * @param type
   */
  public void setType (String type) {
    m_type = type;
  }
/**
 * @return java.lang.String
 */
public String toString() {
    StringBuffer buff = new StringBuffer("Permission on ");
    buff.append(getOwner());
    buff.append(" for ");
    buff.append(getPrincipalString());
    buff.append(" (");
    buff.append(getActivity());
    buff.append(")");
    return buff.toString();
}
}
