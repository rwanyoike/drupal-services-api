package dk.i2m.drupal.services.interceptors;

import dk.i2m.drupal.services.entities.SessionEntity;
import retrofit.RequestInterceptor;

/**
 * Created by raymond on 8/23/15.
 */
public class SessionInterceptor implements RequestInterceptor {

    public static final String COOKIE_HEADER = "Cookie";
    public static final String TOKEN_HEADER = "X-CSRF-Token";

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

    public void setSession(SessionEntity session) {
        setSessionId(session.getSessionId());
        setSessionName(session.getSessionName());
        setCsrfToken(session.getCsrfToken());
    }

    public void clearSession() {
        setSessionId(null);
        setSessionName(null);
        setCsrfToken(null);
    }

    @Override
    public void intercept(RequestFacade requestFacade) {
        if (sessionId != null && sessionName != null) {
            requestFacade.addHeader(COOKIE_HEADER, String.format("%s=%s", sessionName, sessionId));
        }
        if (csrfToken != null) {
            requestFacade.addHeader(TOKEN_HEADER, csrfToken);
        }
    }
}
