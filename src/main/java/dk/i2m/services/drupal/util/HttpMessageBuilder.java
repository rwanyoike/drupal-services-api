/*
 * Copyright (C) 2012 Interactive Media Management
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package dk.i2m.services.drupal.util;

import dk.i2m.services.drupal.core.FormAPIField;
import java.util.HashSet;
import java.util.Set;
import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;

/**
 * Assemble valid HTTP form parameters from component parts, encoding as 
 * necessary.
 * 
 * @author Raymond Wanyoike <rwa at i2m.dk>
 */
public class HttpMessageBuilder {

    private Set<NameValuePair> nvps;

    private String language = "und";

    /**
     * Create an empty HTTP message builder, no language,.
     */
    public HttpMessageBuilder() {
        init();
    }

    /**
     * Create a new HTTP message builder using an existing language.
     * 
     * @param language  an existing language
     */
    public HttpMessageBuilder(String language) {
        this();
        this.language = language;
    }

    private void init() {
        clearNvps();
        clearLang();
    }

    private Set<NameValuePair> prep() {
        checkLang();

        Set<NameValuePair> set = new HashSet<NameValuePair>();
        set.add(new BasicNameValuePair("language", language));

        for (NameValuePair nvp : nvps) {
            if ("language".equals(nvp.getName())) {
                continue; // Ignore
            }

            set.add(nvp);
        }

        return set;
    }

    private void checkLang() {
        if (language == null) {
            throw new IllegalArgumentException("language cannot be null");
        }
    }

    /**
     * Clear all name value pair components.
     */
    public void clearNvps() {
        this.nvps = new HashSet<NameValuePair>();
    }

    /**
     * Clear the language.
     */
    public void clearLang() {
        // this.setLanguage(null);
    }

    /**
     * Append a parameter component to the HTTP message.
     * 
     * @param fapif a {@link FormAPIField}
     * @return      self
     */
    public HttpMessageBuilder add(FormAPIField fapif) {
        checkLang();

        nvps = fapif.setup(language, nvps);
        return this;
    }

    /**
     * Turn this HttpMessageBuilder object into a {@link UrlEncodedFormEntity}.
     * 
     * @return  a new UrlEncodedFormEntity object
     */
    public UrlEncodedFormEntity toUrlEncodedFormEntity() {
        return new UrlEncodedFormEntity(prep(), Consts.UTF_8);
    }

    @Override
    public String toString() {
        return prep().toString();
    }
}
