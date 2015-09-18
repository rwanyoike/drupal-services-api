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

package dk.i2m.drupal.services.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Drupal node entity.
 */
public class NodeEntity {

    @SerializedName("nid")
    private Long id;

    @SerializedName("vid")
    private Long vid;

    @SerializedName("type")
    private String type;

    @SerializedName("language")
    private String language;

    @SerializedName("title")
    private String title;

    @SerializedName("uid")
    private Long uid;

    @SerializedName("status")
    private Integer status;

    @SerializedName("created")
    private Long created;

    @SerializedName("changed")
    private Long changed;

    @SerializedName("comment")
    private Integer comment;

    @SerializedName("promote")
    private Integer promote;

    @SerializedName("sticky")
    private Integer sticky;

    @SerializedName("tnid")
    private Long tnid;

    @SerializedName("translate")
    private Integer translate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVid() {
        return vid;
    }

    public void setVid(Long vid) {
        this.vid = vid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Long getChanged() {
        return changed;
    }

    public void setChanged(Long changed) {
        this.changed = changed;
    }

    public Integer getComment() {
        return comment;
    }

    public void setComment(Integer comment) {
        this.comment = comment;
    }

    public Integer getPromote() {
        return promote;
    }

    public void setPromote(Integer promote) {
        this.promote = promote;
    }

    public Integer getSticky() {
        return sticky;
    }

    public void setSticky(Integer sticky) {
        this.sticky = sticky;
    }

    public Long getTnid() {
        return tnid;
    }

    public void setTnid(Long tnid) {
        this.tnid = tnid;
    }

    public Integer getTranslate() {
        return translate;
    }

    public void setTranslate(Integer translate) {
        this.translate = translate;
    }
}
