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
package dk.i2m.services.drupal;

import dk.i2m.services.drupal.core.AbstractDrupalClient;
import java.net.URI;

/**
 * Default implementation of {@link DrupalClient} pre-configured for most 
 * common use scenarios.
 * 
 * @author Raymond Wanyoike <rwa at i2m.dk>
 */
public class DefaultDrupalClient extends AbstractDrupalClient {

    /**
     * Creates a new Drupal client from a hostname and endpoint.
     * 
     * @param hostname  the druapl server URL
     * @param endPoint  the services endpoint
     */
    public DefaultDrupalClient(URI hostname, String endPoint) {
        super(hostname, endPoint);
    }

    public DefaultDrupalClient(URI hostname, String endpoint,
            int connectionTimeout, int socketTimeout) {
        super(new DrupalHttpClient(connectionTimeout, socketTimeout), hostname,
                endpoint);
    }
}
