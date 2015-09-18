/*
 * Copyright (C) 2015 Raymond Wanyoike
 *
 * This file is part of Converge.
 *
 * Converge is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Converge is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Converge. If not, see <http://www.gnu.org/licenses/>.
 */

package dk.i2m.drupal.services.wrappers;

import java.util.HashMap;
import java.util.Map;

/**
 * Drupal simple field wrapper.
 */
public class BasicWrapper implements Wrapper {

    private String language = LANGUAGE_NONE;

    @Override
    public Map<String, String> wrap(String field, Object[] values) {
        Map<String, String> params = new HashMap<String, String>();
        int index = 0;

        for (Object value : values) {
            String f = format(field, index);
            String v = String.valueOf(value);
            params.put(f, v);
            index++;
        }

        return params;
    }

    @Override
    public Map<String, String> wrap(String field, Object value) {
        Object[] values = {value};
        return wrap(field, values);
    }

    @Override
    public String format(String field, int index) {
        return String.format("%s[%s]", field, index);
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
