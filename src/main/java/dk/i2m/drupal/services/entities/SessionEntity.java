package dk.i2m.drupal.services.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by raymond on 8/22/15.
 */
public class SessionEntity {

    @SerializedName("sessid")
    private String sessionId;

    @SerializedName("session_name")
    private String sessionName;

    @SerializedName("token")
    private String csrfToken;

    @SerializedName("user")
    private UserEntity userEntity;

    public String getSessionId() {
        return sessionId;
    }

    public SessionEntity setSessionId(String sessionId) {
        this.sessionId = sessionId;
        return this;
    }

    public String getSessionName() {
        return sessionName;
    }

    public SessionEntity setSessionName(String sessionName) {
        this.sessionName = sessionName;
        return this;
    }

    public String getCsrfToken() {
        return csrfToken;
    }

    public SessionEntity setCsrfToken(String csrfToken) {
        this.csrfToken = csrfToken;
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
