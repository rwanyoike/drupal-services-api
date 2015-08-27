package dk.i2m.drupal.services.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by raymond on 8/23/15.
 */
public class NodeEntity {

    @SerializedName("nid")
    private Integer id;

    @SerializedName("vid")
    private Integer vid;

    @SerializedName("type")
    private String type;

    @SerializedName("language")
    private String language;

    @SerializedName("title")
    private String title;

    @SerializedName("uid")
    private Integer uid;

    @SerializedName("status")
    private Integer status;

    @SerializedName("created")
    private Integer created;

    @SerializedName("changed")
    private Integer changed;

    @SerializedName("comment")
    private Integer comment;

    @SerializedName("promote")
    private Integer promote;

    @SerializedName("sticky")
    private Integer sticky;

    @SerializedName("tnid")
    private Integer tnid;

    @SerializedName("translate")
    private Integer translate;

    public Integer getId() {
        return id;
    }

    public NodeEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getVid() {
        return vid;
    }

    public NodeEntity setVid(Integer vid) {
        this.vid = vid;
        return this;
    }

    public String getType() {
        return type;
    }

    public NodeEntity setType(String type) {
        this.type = type;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public NodeEntity setLanguage(String language) {
        this.language = language;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public NodeEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getUid() {
        return uid;
    }

    public NodeEntity setUid(Integer uid) {
        this.uid = uid;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public NodeEntity setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Integer getCreated() {
        return created;
    }

    public NodeEntity setCreated(Integer created) {
        this.created = created;
        return this;
    }

    public Integer getChanged() {
        return changed;
    }

    public NodeEntity setChanged(Integer changed) {
        this.changed = changed;
        return this;
    }

    public Integer getComment() {
        return comment;
    }

    public NodeEntity setComment(Integer comment) {
        this.comment = comment;
        return this;
    }

    public Integer getPromote() {
        return promote;
    }

    public NodeEntity setPromote(Integer promote) {
        this.promote = promote;
        return this;
    }

    public Integer getSticky() {
        return sticky;
    }

    public NodeEntity setSticky(Integer sticky) {
        this.sticky = sticky;
        return this;
    }

    public Integer getTnid() {
        return tnid;
    }

    public NodeEntity setTnid(Integer tnid) {
        this.tnid = tnid;
        return this;
    }

    public Integer getTranslate() {
        return translate;
    }

    public NodeEntity setTranslate(Integer translate) {
        this.translate = translate;
        return this;
    }
}
