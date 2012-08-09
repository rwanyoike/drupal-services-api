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

import org.apache.http.client.params.AllClientPNames;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.protocol.HTTP;

/**
 * Default implementation of {@link HttpClient} pre-configured for 
 * {@link DrupalClient}.
 * 
 * @author Raymond Wanyoike <rwa at i2m.dk>
 */
public class DrupalHttpClient extends DefaultHttpClient {

    public DrupalHttpClient() {
        BasicHttpParams params = new BasicHttpParams();
        params
                .setParameter(AllClientPNames.CONNECTION_TIMEOUT, 30000)
                .setParameter(AllClientPNames.COOKIE_POLICY,
                CookiePolicy.BEST_MATCH)
                .setParameter(AllClientPNames.HTTP_CONTENT_CHARSET, HTTP.UTF_8)
                .setParameter(AllClientPNames.SO_TIMEOUT, 30000);

        this.setParams(params);
    }

    DrupalHttpClient(int connectionTimeout, int socketTimeout) {
        BasicHttpParams params = new BasicHttpParams();
        params
                .setParameter(AllClientPNames.CONNECTION_TIMEOUT,
                connectionTimeout)
                .setParameter(AllClientPNames.COOKIE_POLICY,
                CookiePolicy.BEST_MATCH)
                .setParameter(AllClientPNames.HTTP_CONTENT_CHARSET, HTTP.UTF_8)
                .setParameter(AllClientPNames.SO_TIMEOUT, socketTimeout);

        this.setParams(params);
    }
}
