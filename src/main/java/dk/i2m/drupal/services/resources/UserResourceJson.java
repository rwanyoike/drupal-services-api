package dk.i2m.drupal.services.resources;

import dk.i2m.drupal.services.entities.SessionEntity;
import dk.i2m.drupal.services.entities.UserEntity;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by raymond on 8/22/15.
 */
public interface UserResourceJson {

    @GET("/{alias}/{uid}")
    UserEntity retrieve(
            @Path("alias") String alias,
            @Path("uid") Long uid);

    @POST("/{alias}/login")
    SessionEntity login(
            @Path("alias") String alias,
            @Body UserEntity userEntity);

    @POST("/{alias}/logout")
    UserEntity logout(
            @Path("alias") String alias);
}
