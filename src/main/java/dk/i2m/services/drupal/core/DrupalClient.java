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

import java.net.URI;
import org.apache.http.client.HttpClient;

/**
 * Provides a generic but powerful API for web services.
 * 
 * @author Raymond Wanyoike <rwa at i2m.dk>
 */
public interface DrupalClient {

    /**
     * Called when setting up the client.
     */
    public void setup();

    /**
     * Called when shutting down the client.
     */
    public void shutdown();

    /**
     * Return the {@link HttpClient}.
     * 
     * @return  the HTTP client
     */
    public HttpClient getHttpClient();

    /**
     * Return the Drupal server URL.
     * 
     * @return  the hostname
     */
    public URI getHostname();

    /**
     * Return the services endpoint.
     * 
     * @return  the endpoint
     */
    public String getEndpoint();
}
