package dk.i2m.drupal.services.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by raymond on 8/22/15.
 */
public class SessionEntity {

    @SerializedName("sessid")
    private String id;

    @SerializedName("session_name")
    private String name;

    @SerializedName("token")
    private String csrf;

    @SerializedName("user")
    private UserEntity userEntity;

    public String getId() {
        return id;
    }

    public SessionEntity setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public SessionEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getCsrf() {
        return csrf;
    }

    public SessionEntity setCsrf(String csrf) {
        this.csrf = csrf;
        return this;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public SessionEntity setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
        return this;
    }
}
