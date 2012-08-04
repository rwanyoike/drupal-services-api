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
package dk.i2m.drupal.resources;

import dk.i2m.drupal.core.AbstractResourceCRUD;
import dk.i2m.drupal.core.DrupalClient;
import dk.i2m.drupal.util.URLBuilder;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.message.BasicNameValuePair;

/**
 * Enables the user registration and login system.
 * 
 * @author Raymond Wanyoike <rwa at i2m.dk>
 */
public class UserResource extends AbstractResourceCRUD {

    private static final Logger LOG = Logger.getLogger(UserResource.class.
            getName());

    private DrupalClient drupalClient;

    private String username;

    private String password;

    public UserResource(DrupalClient drupalClient) {
        super(drupalClient);
        this.drupalClient = drupalClient;
    }

    public UserResource(DrupalClient drupalClient, String username,
            String password) {
        this(drupalClient);
        this.username = username;
        this.password = password;
    }

    /**
     * Login a user for a new session.
     * 
     * @throws MalformedURLException
     * @throws ClientProtocolException
     * @throws UnsupportedEncodingException
     * @throws IOException 
     */
    public void login() throws MalformedURLException, ClientProtocolException,
            UnsupportedEncodingException, IOException {
        URLBuilder builder = new URLBuilder(drupalClient.getHostname());
        builder
                .add(drupalClient.getEndpoint())
                .add(getAlias())
                .add("login");

        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("username", username));
        nvps.add(new BasicNameValuePair("password", password));

        HttpPost post = new HttpPost(builder.toURI());
        post.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));

        LOG.log(Level.INFO, "Trying to login... [user = ''{0}'']", username);

        ResponseHandler<String> handler = new BasicResponseHandler();
        drupalClient.getHttpClient().execute(post, handler);
    }

    /**
     * Logout a user session.
     * 
     * @throws MalformedURLException
     * @throws ClientProtocolException
     * @throws UnsupportedEncodingException
     * @throws IOException 
     */
    public void logout() throws MalformedURLException, ClientProtocolException,
            UnsupportedEncodingException, IOException {
        URLBuilder builder = new URLBuilder(drupalClient.getHostname());
        builder
                .add(drupalClient.getEndpoint())
                .add(getAlias())
                .add("logout");

        HttpPost post = new HttpPost(builder.toURI());

        LOG.log(Level.INFO, "Trying to logout... [user = ''{0}'']", username);

        ResponseHandler<String> handler = new BasicResponseHandler();
        drupalClient.getHttpClient().execute(post, handler);
    }

    @Override
    public String getAlias() {
        return "user";
    }
}
