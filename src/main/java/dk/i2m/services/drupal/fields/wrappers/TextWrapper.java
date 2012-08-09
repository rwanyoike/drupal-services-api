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
package dk.i2m.services.drupal.fields.wrappers;

import dk.i2m.services.drupal.core.FormAPIField;
import dk.i2m.services.drupal.fields.Text;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author Raymond Wanyoike <rwa at i2m.dk>
 */
public class TextWrapper implements FormAPIField<Text> {

    private List<Text> texts = new ArrayList<Text>();

    private String name;

    public TextWrapper() {
    }

    public TextWrapper(String name) {
        this.name = name;
    }

    public TextWrapper(String name, String value) {
        this(name);
        texts.add(new Text(null, value, null));
    }

    public TextWrapper(String name, String summary, String value, String format) {
        this(name);
        texts.add(new Text(summary, value, format));
    }

    @Override
    public void add(Text field) {
        texts.add(field);
    }

    @Override
    public Set<NameValuePair> setup(String language, Set<NameValuePair> nvps) {
        for (int i = 0; i < texts.size(); i++) {
            Text text = texts.get(i);

            if (text.getSummary() != null) {
                nvps.add(new BasicNameValuePair(name + "[" + language + "][" + i
                        + "][summary]", text.getSummary()));
            }

            if (text.getValue() != null) {
                nvps.add(new BasicNameValuePair(name + "[" + language + "][" + i
                        + "][value]", text.getValue()));
            }

            if (text.getFormat() != null) {
                nvps.add(new BasicNameValuePair(name + "[" + language + "][" + i
                        + "][format]", text.getFormat()));
            }
        }

        return nvps;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
