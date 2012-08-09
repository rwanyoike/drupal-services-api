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
package dk.i2m.services.drupal.core;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;

/**
 * Resources that implement the common CRUD operations on their entities.
 * 
 * @author Raymond Wanyoike <rwa at i2m.dk>
 */
public interface ResourceCRUD {

    /**
     * Creates a resource.
     * 
     * @param <T>
     * @param uefe
     * @return
     * @throws MalformedURLException
     * @throws ClientProtocolException
     * @throws UnsupportedEncodingException
     * @throws IOException 
     */
    public <T> T create(UrlEncodedFormEntity uefe) throws MalformedURLException,
            ClientProtocolException, UnsupportedEncodingException, IOException;

    /**
     * Retrieves a resource.
     * 
     * @throws IOException 
     */
    public void retrieve() throws IOException;

    /**
     * Updates a resource.
     * 
     * @param <T>
     * @param uefe
     * @return
     * @throws MalformedURLException
     * @throws ClientProtocolException
     * @throws UnsupportedEncodingException
     * @throws IOException 
     */
    public <T> T update(UrlEncodedFormEntity uefe) throws MalformedURLException,
            ClientProtocolException, UnsupportedEncodingException, IOException;

    /**
     * Deletes a resource.
     * 
     * @throws IOException 
     */
    public void delete() throws IOException;
}
