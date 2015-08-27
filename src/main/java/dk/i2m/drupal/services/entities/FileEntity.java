package dk.i2m.drupal.services.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by raymond on 8/23/15.
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

    public FileEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getUid() {
        return uid;
    }

    public FileEntity setUid(Long uid) {
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

    public Long getFileSize() {
        return fileSize;
    }

    public FileEntity setFileSize(Long fileSize) {
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

    public Long getTimestamp() {
        return timestamp;
    }

    public FileEntity setTimestamp(Long timestamp) {
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
