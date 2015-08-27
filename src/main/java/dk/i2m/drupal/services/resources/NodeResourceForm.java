package dk.i2m.drupal.services.resources;

import dk.i2m.drupal.services.entities.FileEntity;
import dk.i2m.drupal.services.entities.NodeEntity;
import retrofit.client.Response;
import retrofit.http.DELETE;
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
 * Created by raymond on 8/23/15.
 */
public interface NodeResourceForm {

    @GET("/{alias}/{nid}")
    NodeEntity retrieve(
            @Path("alias") String alias,
            @Path("nid") Long nid);

    @FormUrlEncoded
    @POST("/{alias}")
    NodeEntity create(
            @Path("alias") String alias,
            @FieldMap Map<String, String> fields);

    @FormUrlEncoded
    @PUT("/{alias}/{nid}")
    NodeEntity update(
            @Path("alias") String alias,
            @Path("nid") Long nid,
            @FieldMap Map<String, String> fields);

    @DELETE("/{alias}/{nid}")
    Response delete(
            @Path("alias") String alias,
            @Path("nid") Long nid);

    @GET("/{alias}")
    List<NodeEntity> index(
            @Path("alias") String alias,
            @QueryMap Map<String, String> options);

    @GET("/{alias}/{nid}/files")
    List<FileEntity> files(
            @Path("alias") String alias,
            @Path("nid") Long nid);

    @Multipart
    @POST("/{alias}/{nid}/attach_file")
    List<FileEntity> attachFile(
            @Path("alias") String alias,
            @Path("nid") Long nid,
            @Part("field_name") String fieldName,
            @Part("attach") Integer attach,
            @PartMap Map<String, Object> params);
}
