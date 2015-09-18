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

package dk.i2m.drupal.services.interceptors;

import retrofit.RequestInterceptor;

/**
 * Session request interceptor.
 */
public class SessionInterceptor implements RequestInterceptor {

    public static final String HEADER_ACCEPT = "Accept";
    public static final String HEADER_COOKIE = "Cookie";
    public static final String HEADER_TOKEN = "X-CSRF-Token";

    private String sessionId;
    private String sessionName;
    private String contentType = "application/json";
    private String csrfToken;

    @Override
    public void intercept(RequestFacade requestFacade) {
        if (sessionId != null && sessionName != null) {
            requestFacade.addHeader(HEADER_COOKIE, String.format("%s=%s", sessionName, sessionId));
        }
        if (csrfToken != null) {
            requestFacade.addHeader(HEADER_TOKEN, csrfToken);
        }
        if (contentType != null) {
            requestFacade.addHeader(HEADER_ACCEPT, contentType);
        }
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getCsrfToken() {
        return csrfToken;
    }

    public void setCsrfToken(String csrfToken) {
        this.csrfToken = csrfToken;
    }
}
