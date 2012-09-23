/*
 * Copyright (C) 2012 Interactive Media Management
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package dk.i2m.drupal.message;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/**
 *
 * @author Raymond Wanyoike <rwa at i2m.dk>
 */
public class NodeMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    @SerializedName("nid")
    private Long id;

    @SerializedName("uid")
    private Long uid;

    @SerializedName("created")
    private Long created;

    @SerializedName("changed")
    private Long changed;

    @SerializedName("status")
    private Integer status;

    @SerializedName("comment")
    private Integer comment;

    @SerializedName("promote")
    private Integer promote;

    @SerializedName("sticky")
    private Integer sticky;

    @SerializedName("type")
    private String type;

    @SerializedName("language")
    private String language;

    @SerializedName("title")
    private String title;

    @SerializedName("uri")
    private String uri;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the uid
     */
    public Long getUid() {
        return uid;
    }

    /**
     * @param uid the uid to set
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * @return the created
     */
    public Long getCreated() {
        return created;
    }

    /**
     * @param created the created to set
     */
    public void setCreated(Long created) {
        this.created = created;
    }

    /**
     * @return the changed
     */
    public Long getChanged() {
        return changed;
    }

    /**
     * @param changed the changed to set
     */
    public void setChanged(Long changed) {
        this.changed = changed;
    }

    /**
     * @return the status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return the comment
     */
    public Integer getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(Integer comment) {
        this.comment = comment;
    }

    /**
     * @return the promote
     */
    public Integer getPromote() {
        return promote;
    }

    /**
     * @param promote the promote to set
     */
    public void setPromote(Integer promote) {
        this.promote = promote;
    }

    /**
     * @return the sticky
     */
    public Integer getSticky() {
        return sticky;
    }

    /**
     * @param sticky the sticky to set
     */
    public void setSticky(Integer sticky) {
        this.sticky = sticky;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @param language the language to set
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the uri
     */
    public String getUri() {
        return uri;
    }

    /**
     * @param uri the uri to set
     */
    public void setUri(String uri) {
        this.uri = uri;
    }
}
