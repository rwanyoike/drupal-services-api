package dk.i2m.drupal.services.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by raymond on 8/23/15.
 */
public class FileEntity {

    @SerializedName("fid")
    private Integer id;

    @SerializedName("uid")
    private Integer uid;

    @SerializedName("nid")
    private String fileName;

    @SerializedName("uri")
    private String uri;

    @SerializedName("filemime")
    private String fileMime;

    @SerializedName("filesize")
    private Integer fileSize;

    @SerializedName("status")
    private Integer status;

    @SerializedName("timestamp")
    private Integer timestamp;

    @SerializedName("origname")
    private Integer origName;

    public Integer getId() {
        return id;
    }

    public FileEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getUid() {
        return uid;
    }

    public FileEntity setUid(Integer uid) {
        this.uid = uid;
        return this;
    }

    public String getFileName() {
        return fileName;
    }

    public FileEntity setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public String getUri() {
        return uri;
    }

    public FileEntity setUri(String uri) {
        this.uri = uri;
        return this;
    }

    public String getFileMime() {
        return fileMime;
    }

    public FileEntity setFileMime(String fileMime) {
        this.fileMime = fileMime;
        return this;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public FileEntity setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public FileEntity setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public FileEntity setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public Integer getOrigName() {
        return origName;
    }

    public FileEntity setOrigName(Integer origName) {
        this.origName = origName;
        return this;
    }
}
