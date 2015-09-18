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

import dk.i2m.drupal.services.entities.FileEntity;
import dk.i2m.drupal.services.entities.NodeEntity;
import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Part;
import retrofit.http.PartMap;
import retrofit.http.Path;
import retrofit.http.QueryMap;

import java.util.List;
import java.util.Map;

/**
 * Node resource interface.
 */
public interface NodeResource {

    /**
     * Creates a new node based on submitted values.
     * <p/>
     * Note that this function uses drupal_form_submit() to create new nodes,
     * which may require very specific formatting. The full implications of
     * this are beyond the scope of this comment block.
     *
     * @param alias  Resource alias
     * @param fields Named key/value pairs for a form-encoded request
     * @return A {@link NodeEntity}
     */
    @FormUrlEncoded
    @POST("/{alias}")
    NodeEntity create(
            @Path("alias") String alias,
            @FieldMap Map<String, String> fields);

    /**
     * Updates a new node based on submitted values.
     * <p/>
     * Note that this function uses drupal_form_submit() to create new nodes,
     * which may require very specific formatting. The full implications of
     * this are beyond the scope of this comment block.
     *
     * @param alias  Resource alias
     * @param id     Node ID of the node we're editing
     * @param fields Named key/value pairs for a form-encoded request
     * @return A {@link NodeEntity}
     */
    @FormUrlEncoded
    @PUT("/{alias}/{id}")
    NodeEntity update(
            @Path("alias") String alias,
            @Path("id") Long id,
            @FieldMap Map<String, String> fields);

    /**
     * Return an array of optionally paged nids baed on a set of criteria.
     *
     * @param alias   Resource alias
     * @param options Query parameter keys and values appended to the URL
     * @return A list of {@link NodeEntity}
     */
    @GET("/{alias}")
    List<NodeEntity> index(
            @Path("alias") String alias,
            @QueryMap Map<String, String> options);

    /**
     * Attaches or overwrites file(s) to an existing node
     *
     * @param alias     Resource alias
     * @param id        Node ID of the node the file(s) is being attached to
     * @param fieldName Machine name of the field that is attached to the node
     * @param attach    1 = attach files, 0 = remove and attach files
     * @param params    Denotes name and value parts of a multi-part request
     * @return A list of {@link FileEntity}
     */
    @Multipart
    @POST("/{alias}/{id}/attach_file")
    List<FileEntity> attachFile(
            @Path("alias") String alias,
            @Path("id") Long id,
            @Part("field_name") String fieldName,
            @Part("attach") Integer attach,
            @PartMap Map<String, Object> params);
}
