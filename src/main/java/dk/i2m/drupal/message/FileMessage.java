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
public class FileMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    @SerializedName("fid")
    private Long id;

    @SerializedName("uid")
    private Long uid;

    @SerializedName("timestamp")
    private Long timestamp;

    @SerializedName("status")
    private Integer status;

    @SerializedName("filename")
    private String fileName;

    @SerializedName("filemime")
    private String fileMime;

    @SerializedName("filesize")
    private String fileSize;

    @SerializedName("origname")
    private String origName;

    @SerializedName("uri")
    private String uri;

    @SerializedName("uri_full")
    private String uriFull;

    @SerializedName("target_uri")
    private String targetUri;

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
     * @return the timestamp
     */
    public Long getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
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
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @return the fileMime
     */
    public String getFileMime() {
        return fileMime;
    }

    /**
     * @param fileMime the fileMime to set
     */
    public void setFileMime(String fileMime) {
        this.fileMime = fileMime;
    }

    /**
     * @return the fileSize
     */
    public String getFileSize() {
        return fileSize;
    }

    /**
     * @param fileSize the fileSize to set
     */
    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * @return the origName
     */
    public String getOrigName() {
        return origName;
    }

    /**
     * @param origName the origName to set
     */
    public void setOrigName(String origName) {
        this.origName = origName;
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

    /**
     * @return the uriFull
     */
    public String getUriFull() {
        return uriFull;
    }

    /**
     * @param uriFull the uriFull to set
     */
    public void setUriFull(String uriFull) {
        this.uriFull = uriFull;
    }

    /**
     * @return the targetUri
     */
    public String getTargetUri() {
        return targetUri;
    }

    /**
     * @param targetUri the targetUri to set
     */
    public void setTargetUri(String targetUri) {
        this.targetUri = targetUri;
    }
}
