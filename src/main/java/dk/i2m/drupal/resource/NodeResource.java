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

import com.google.gson.Gson;
import dk.i2m.drupal.core.AbstractResourceCRUD;
import dk.i2m.drupal.core.DrupalClient;
import dk.i2m.drupal.response.NodeResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;

/**
 * The core that allows content to be submitted to the site using the usual 
 * form API pattern.
 * 
 * @author Raymond Wanyoike <rwa at i2m.dk>
 */
public class NodeResource extends AbstractResourceCRUD {

    public NodeResource(DrupalClient drupalClient) {
        super(drupalClient);
    }

    @Override
    public <T> T create(UrlEncodedFormEntity uefe) throws MalformedURLException,
            ClientProtocolException, UnsupportedEncodingException, IOException {
        String response = super.create(uefe);
        Gson gson = new Gson();
        NodeResponse fromJson = gson.fromJson(response, NodeResponse.class);

        return (T) fromJson;
    }

    @Override
    public String getAlias() {
        return "node";
    }
}
