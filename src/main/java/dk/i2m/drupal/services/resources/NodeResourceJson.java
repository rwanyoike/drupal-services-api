package dk.i2m.drupal.services.resources;

import dk.i2m.drupal.services.entities.FileEntity;
import dk.i2m.drupal.services.entities.NodeEntity;
import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.DELETE;
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
public interface NodeResourceJson {

    @GET("/{alias}/{nid}")
    NodeEntity retrieve(
            @Path("alias") String alias,
            @Path("nid") Integer nid);

    @POST("/{alias}")
    NodeEntity create(
            @Path("alias") String alias,
            @Body NodeEntity nodeEntity);

    @PUT("/{alias}/{nid}")
    NodeEntity update(
            @Path("alias") String alias,
            @Path("nid") Integer nid,
            @Body NodeEntity nodeEntity);

    @DELETE("/{alias}/{nid}")
    Response delete(
            @Path("alias") String alias,
            @Path("nid") Integer nid);

    @GET("/{alias}")
    List<NodeEntity> index(
            @Path("alias") String alias,
            @QueryMap Map<String, String> options);

    @GET("/{alias}/{nid}/files")
    List<FileEntity> files(
            @Path("alias") String alias,
            @Path("nid") Integer nid);

    // TODO: Json equivalent
    @Multipart
    @POST("/{alias}/{nid}/attach_file")
    List<FileEntity> attachFile(
            @Path("alias") String alias,
            @Path("nid") Integer nid,
            @Part("field_name") String fieldName,
            @Part("attach") Integer attach,
            @PartMap Map<String, Object> params);
}
