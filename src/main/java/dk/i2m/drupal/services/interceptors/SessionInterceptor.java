package dk.i2m.drupal.services.interceptors;

import retrofit.RequestInterceptor;

/**
 * Created by raymond on 8/23/15.
 */
public class SessionInterceptor implements RequestInterceptor {

    public static final String HEADER_COOKIE = "Cookie";
    public static final String HEADER_TOKEN = "X-CSRF-Token";

    private String sessionId;
    private String sessionName;
    private String csrfToken;

    public String getSessionId() {
        return sessionId;
    }

    public SessionInterceptor setSessionId(String sessionId) {
        this.sessionId = sessionId;
        return this;
    }

    public String getSessionName() {
        return sessionName;
    }

    public SessionInterceptor setSessionName(String sessionName) {
        this.sessionName = sessionName;
        return this;
    }

    public String getCsrfToken() {
        return csrfToken;
    }

    public SessionInterceptor setCsrfToken(String csrfToken) {
        this.csrfToken = csrfToken;
        return this;
    }

    @Override
    public void intercept(RequestFacade requestFacade) {
        if (sessionId != null && sessionName != null) {
            requestFacade.addHeader(HEADER_COOKIE, String.format("%s=%s", sessionName, sessionId));
        }
        if (csrfToken != null) {
            requestFacade.addHeader(HEADER_TOKEN, csrfToken);
        }
    }
}
