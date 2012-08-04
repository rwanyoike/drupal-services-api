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
package dk.i2m.drupal.core;

import dk.i2m.drupal.core.DrupalClient;
import dk.i2m.drupal.core.ResourceCRUD;
import dk.i2m.drupal.util.URLBuilder;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.logging.Logger;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;

/**
 * Base class for {@link ResourceCRUD} implementations.
 * 
 * @author Raymond Wanyoike <rwa at i2m.dk>
 */
public abstract class AbstractResourceCRUD implements ResourceCRUD {

    private DrupalClient drupalClient;

    public AbstractResourceCRUD(DrupalClient drupalClient) {
        this.drupalClient = drupalClient;
    }

    @Override
    public <T> T create(UrlEncodedFormEntity uefe) throws MalformedURLException,
            ClientProtocolException, UnsupportedEncodingException, IOException {
        URLBuilder builder = new URLBuilder(drupalClient.getHostname());
        builder
                .add(drupalClient.getEndpoint())
                .add(getAlias());

        HttpPost post = new HttpPost(builder.toURI());
        post.setEntity(uefe);

        ResponseHandler<String> handler = new BasicResponseHandler();
        String response = drupalClient.getHttpClient().execute(post, handler);

        return (T) response;
    }

    @Override
    public void retrieve() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <T> T update(UrlEncodedFormEntity uefe) throws MalformedURLException,
            ClientProtocolException, UnsupportedEncodingException, IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public abstract String getAlias();
}
