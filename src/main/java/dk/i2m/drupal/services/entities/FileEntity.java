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
 * Drupal file entity.
 */
public class FileEntity {

    @SerializedName("fid")
    private Long id;

    @SerializedName("uid")
    private Long uid;

    @SerializedName("nid")
    private String fileName;

    @SerializedName("uri")
    private String uri;

    @SerializedName("filemime")
    private String fileMime;

    @SerializedName("filesize")
    private Long fileSize;

    @SerializedName("status")
    private Integer status;

    @SerializedName("timestamp")
    private Long timestamp;

    @SerializedName("origname")
    private Integer origName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getFileMime() {
        return fileMime;
    }

    public void setFileMime(String fileMime) {
        this.fileMime = fileMime;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getOrigName() {
        return origName;
    }

    public void setOrigName(Integer origName) {
        this.origName = origName;
    }
}
