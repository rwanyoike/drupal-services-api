package dk.i2m.drupal.services.resources;

import dk.i2m.drupal.services.entities.SessionEntity;
import dk.i2m.drupal.services.entities.UserEntity;
import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

import java.util.Map;

/**
 * Created by raymond on 8/22/15.
 */
public interface UserResourceForm {

    @GET("/{alias}/{uid}")
    UserEntity retrieve(
            @Path("alias") String alias,
            @Path("uid") Integer uid);

    @FormUrlEncoded
    @POST("/{alias}/login")
    SessionEntity login(
            @Path("alias") String alias,
            @FieldMap Map<String, String> fields);

    @FormUrlEncoded
    @POST("/{alias}/logout")
    UserEntity logout(
            @Path("alias") String alias);
}
