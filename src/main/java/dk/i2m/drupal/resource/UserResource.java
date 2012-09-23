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
package dk.i2m.drupal.resource;

import dk.i2m.drupal.core.AbstractResourceCRUD;
import dk.i2m.drupal.core.DrupalClient;
import dk.i2m.drupal.util.URLBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author Raymond Wanyoike <rwa at i2m.dk>
 */
public class UserResource extends AbstractResourceCRUD {

    private String username;

    private String password;

    public UserResource(DrupalClient dc) {
        super(dc);
    }

    public UserResource(DrupalClient dc, String username, String password) {
        this(dc);
        this.username = username;
        this.password = password;
    }

    public void login() throws HttpResponseException, IOException {
        URLBuilder builder = new URLBuilder(getDc().getHostname());
        builder.add(getDc().getEndpoint());
        builder.add(getAlias());
        builder.add("login");

        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("username", username));
        nvps.add(new BasicNameValuePair("password", password));

        HttpPost method = new HttpPost(builder.toURI());
        method.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));

        ResponseHandler<String> handler = new BasicResponseHandler();
        getDc().getHttpClient().execute(method, handler);
    }

    public void logout() throws HttpResponseException, IOException {
        URLBuilder builder = new URLBuilder(getDc().getHostname());
        builder.add(getDc().getEndpoint());
        builder.add(getAlias());
        builder.add("logout");

        HttpPost method = new HttpPost(builder.toURI());

        ResponseHandler<String> handler = new BasicResponseHandler();
        getDc().getHttpClient().execute(method, handler);
    }

    @Override
    public String getAlias() {
        return "user";
    }
}
