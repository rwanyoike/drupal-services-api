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

import dk.i2m.services.drupal.DrupalHttpClient;
import java.net.URI;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * Base class for {@link DrupalClient} implementations.
 * 
 * @author Raymond Wanyoike <rwa at i2m.dk>
 */
public abstract class AbstractDrupalClient implements DrupalClient {

    private DefaultHttpClient httpClient;

    private URI hostname;

    private String endpoint;

    /**
     * Creates a new Drupal client.
     * 
     * @param hostname  the druapl server URL
     * @param endPoint  the services endpoint
     */
    public AbstractDrupalClient(URI hostname, String endPoint) {
        this(new DrupalHttpClient(), hostname, endPoint);
    }

    /**
     * Creates a new Drupal client.
     * 
     * @param httpClient    configured {@link HttpClient} 
     * @param hostname      the druapl server URL
     * @param endpoint      the services endpoint
     */
    public AbstractDrupalClient(DefaultHttpClient httpClient, URI hostname,
            String endpoint) {
        // TODO: Check for NULL
        this.httpClient = httpClient;
        this.hostname = hostname;
        this.endpoint = endpoint;
    }

    @Override
    public void setup() {
        // Nothing
    }

    @Override
    public void shutdown() {
        getHttpClient().getConnectionManager().shutdown();
    }

    @Override
    public HttpClient getHttpClient() {
        return httpClient;
    }

    @Override
    public URI getHostname() {
        return hostname;
    }

    @Override
    public String getEndpoint() {
        return endpoint;
    }
}
