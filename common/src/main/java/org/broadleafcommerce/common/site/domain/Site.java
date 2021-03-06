/*
 * Copyright 2008-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.broadleafcommerce.common.site.domain;

import org.broadleafcommerce.common.sandbox.domain.SandBox;
import org.broadleafcommerce.common.site.service.type.SiteResolutionType;

import java.io.Serializable;
import java.util.List;

/**
 * Created by bpolster.
 */
public interface Site extends Serializable {

    /**
     * Unique/internal id for a site.
     * @return
     */
    public Long getId();

    /**
     * Sets the internal id for a site.
     * @param id
     */
    public void setId(Long id);

    /**
     * The display name for a site.
     * @return
     */
    public String getName();

    /**
     * Sets the displayName for a site.
     * @param name
     */
    public void setName(String name);

    /**
     * @deprecated use {@link #getSiteResolutionType()}
     * Intended to be used along with the #getSiteIdentifierValue()
     * by the SiteResolver to determine if this is the current site.
     *
     * @return
     */
    public String getSiteIdentifierType();

    /**
     * @deprecated Use {@link #setSiteResolutionType(SiteResolutionType)}
     * Sets the site identifier type.
     * @see #getSiteIdentifierType()
     * @param siteIdentifierType
     */
    public void setSiteIdentifierType(String siteIdentifierType);

    /**
     * Used along with {@link #getSiteResolutionType()} to determine the current
     * Site for a given request.
     *
     * @return
     */
    public String getSiteIdentifierValue();

    /**
     *
     * @param siteIdentifierValue
     */
    public void setSiteIdentifierValue(String siteIdentifierValue);

    /**
     * If null, then this is a single-site installation.    Otherwise,
     * each site must define it's production sandbox so that data can
     * be properly segmented.
     *
     * @return
     */
    public SandBox getProductionSandbox();

    /**
     * Sets the production sandbox.   Typically configured via the
     * database.
     *
     * @see #getProductionSandbox();
     * @param sandbox
     */
    public void setProductionSandbox(SandBox sandbox);
    
    /**
     * Intended to be used along with the #getSiteIdentifierValue()
     * by an implementation of SiteResolver to determine 
     * if this is the current site.   
     *
     * @return
     */
    public SiteResolutionType getSiteResolutionType();

    /** 
     * Sets the site resolution type.
     * @see #getSiteResolutionType()
     * @param siteResolutionType
     */
    public void setSiteResolutionType(SiteResolutionType siteResolutionType);

    /**
     * Retrieve a list of product, category and offer groupings that
     * this site has access to
     *
     * @return a list of catalog groupings
     */
    public List<Catalog> getCatalogs();

    /**
     * Set the list of product, category and offer groupings that
     * this site has access to
     *
     * @param catalogs a list of catalog groupings
     */
    public void setCatalogs(List<Catalog> catalogs);

    /**
     * Retrieve an deep copy of this site. Not bound by
     * entity manager scope.
     *
     * @return a deep copy of this site
     */
    public Site clone();

    public boolean isDeactivated();

    public void setDeactivated(boolean deactivated);
}
