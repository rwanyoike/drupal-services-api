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
package dk.i2m.drupal.field.wrapper;

import dk.i2m.drupal.core.FormAPIField;
import dk.i2m.drupal.field.List;
import java.util.ArrayList;
import java.util.Set;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author Raymond Wanyoike <rwa at i2m.dk>
 */
public class ListWrapper implements FormAPIField<List> {

    private java.util.List<List> lists = new ArrayList<List>();

    private String name;

    public ListWrapper() {
    }

    public ListWrapper(String name) {
        this.name = name;
    }

    public ListWrapper(String name, String value) {
        this(name);
        lists.add(new List(value));
    }

    @Override
    public void add(List field) {
        lists.add(field);
    }

    @Override
    public Set<NameValuePair> setup(String language,
            Set<NameValuePair> nvps) {
        for (int i = 0; i < lists.size(); i++) {
            List list = lists.get(i);

            if (list.getValue() != null) {
                nvps.add(new BasicNameValuePair(name + "[" + language + "][" + i
                        + "]", list.getValue()));
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
