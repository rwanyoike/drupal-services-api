package dk.i2m.drupal.services.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by raymond on 8/23/15.
 */
public class UserEntity {

    @SerializedName("uid")
    private Integer id;

    @SerializedName("name")
    private String name;

    @SerializedName("pass")
    private String pass;

    @SerializedName("mail")
    private String mail;

    @SerializedName("theme")
    private String theme;

    @SerializedName("signature")
    private String signature;

    @SerializedName("signature_format")
    private String signatureFormat;

    @SerializedName("created")
    private Integer created;

    @SerializedName("access")
    private Integer access;

    @SerializedName("login")
    private Integer login;

    @SerializedName("status")
    private Integer status;

    @SerializedName("timezone")
    private String timezone;

    @SerializedName("language")
    private String language;

    @SerializedName("picture")
    private Integer picture;

    @SerializedName("init")
    private String init;

    // TODO: Cleanup
    // @SerializedName("data")
    // private String data;

    public Integer getId() {
        return id;
    }

    public UserEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getPass() {
        return pass;
    }

    public UserEntity setPass(String pass) {
        this.pass = pass;
        return this;
    }

    public String getMail() {
        return mail;
    }

    public UserEntity setMail(String mail) {
        this.mail = mail;
        return this;
    }

    public String getTheme() {
        return theme;
    }

    public UserEntity setTheme(String theme) {
        this.theme = theme;
        return this;
    }

    public String getSignature() {
        return signature;
    }

    public UserEntity setSignature(String signature) {
        this.signature = signature;
        return this;
    }

    public String getSignatureFormat() {
        return signatureFormat;
    }

    public UserEntity setSignatureFormat(String signatureFormat) {
        this.signatureFormat = signatureFormat;
        return this;
    }

    public Integer getCreated() {
        return created;
    }

    public UserEntity setCreated(Integer created) {
        this.created = created;
        return this;
    }

    public Integer getAccess() {
        return access;
    }

    public UserEntity setAccess(Integer access) {
        this.access = access;
        return this;
    }

    public Integer getLogin() {
        return login;
    }

    public UserEntity setLogin(Integer login) {
        this.login = login;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public UserEntity setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getTimezone() {
        return timezone;
    }

    public UserEntity setTimezone(String timezone) {
        this.timezone = timezone;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public UserEntity setLanguage(String language) {
        this.language = language;
        return this;
    }

    public Integer getPicture() {
        return picture;
    }

    public UserEntity setPicture(Integer picture) {
        this.picture = picture;
        return this;
    }

    public String getInit() {
        return init;
    }

    public UserEntity setInit(String init) {
        this.init = init;
        return this;
    }
}
