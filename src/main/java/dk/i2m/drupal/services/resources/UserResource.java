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

package dk.i2m.drupal.services.resources;

import dk.i2m.drupal.services.entities.SessionEntity;
import dk.i2m.drupal.services.entities.UserEntity;
import retrofit.http.Field;
import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;
import retrofit.http.Path;

import java.util.Map;

/**
 * User resource interface.
 */
public interface UserResource {

    /**
     * Login a user using the specified credentials.
     * <p>
     * Note this will transfer a plaintext password.
     *
     * @param alias  Resource alias
     * @param fields Named key/value pairs for a form-encoded request
     * @return A {@link SessionEntity}
     */
    @FormUrlEncoded
    @POST("/{alias}/login")
    SessionEntity login(
            @Path("alias") String alias,
            @FieldMap Map<String, String> fields);

    /**
     * Logout the current user.
     *
     * @param alias Resource alias
     * @param empty Empty string
     * @return A (anonymous) {@link UserEntity}
     */
    @FormUrlEncoded
    @POST("/{alias}/logout")
    UserEntity logout(
            @Path("alias") String alias,
            // FIXME: https://github.com/square/retrofit/issues/854
            @Field("_") String empty);
}
