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

package dk.i2m.drupal.services.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Drupal session response.
 */
public class SessionEntity {

    @SerializedName("sessid")
    private String id;

    @SerializedName("session_name")
    private String name;

    @SerializedName("token")
    private String csrf;

    @SerializedName("user")
    private UserEntity user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCsrf() {
        return csrf;
    }

    public void setCsrf(String csrf) {
        this.csrf = csrf;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
