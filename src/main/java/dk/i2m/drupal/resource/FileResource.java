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
package dk.i2m.drupal.resource;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dk.i2m.drupal.core.AbstractResourceCRUD;
import dk.i2m.drupal.core.DrupalClient;
import dk.i2m.drupal.message.FileMessage;
import dk.i2m.drupal.util.URLBuilder;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;
import org.apache.http.Consts;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.tika.config.TikaConfig;
import org.apache.tika.io.IOUtils;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.apache.tika.mime.MimeType;
import org.apache.tika.mime.MimeTypeException;
import org.apache.tika.mime.MimeTypes;

/**
 * @author Raymond Wanyoike <rwa at i2m.dk>
 */
public class FileResource extends AbstractResourceCRUD {

    public FileResource(DrupalClient dc) {
        super(dc);
    }

    public FileMessage createRaw(File file, String fileName) throws
            HttpResponseException, MimeTypeException, IOException {
        URLBuilder builder = new URLBuilder(getDc().getHostname());
        builder.add(getDc().getEndpoint());
        builder.add(getAlias());
        builder.add("create_raw");

        HttpPost method = new HttpPost(builder.toURI());
        method.setEntity(getMultipartEntity(file, fileName));

        ResponseHandler<String> handler = new BasicResponseHandler();
        String response = getDc().getHttpClient().execute(method, handler);

        Type typeOfT = new TypeToken<List<FileMessage>>() {
        }.getType();
        List<FileMessage> fromJson = new Gson().fromJson(response, typeOfT);

        return fromJson.get(0);
    }

    public FileMessage retrieve(Long id) throws HttpResponseException,
            IOException {
        URLBuilder builder = new URLBuilder(getDc().getHostname());
        builder.add(getDc().getEndpoint());
        builder.add(getAlias());
        builder.add(id);
        // Do not return the file contents (saves bandwidth)
        builder.addQuery("file_contents", 0);

        HttpGet method = new HttpGet(builder.toURI());

        ResponseHandler<String> handler = new BasicResponseHandler();
        String response = getDc().getHttpClient().execute(method, handler);

        return new Gson().fromJson(response, FileMessage.class);
    }

    public boolean delete(Long id) throws HttpResponseException, IOException {
        URLBuilder builder = new URLBuilder(getDc().getHostname());
        builder.add(getDc().getEndpoint());
        builder.add(getAlias());
        builder.add(id);

        HttpDelete method = new HttpDelete(builder.toURI());

        ResponseHandler<String> handler = new BasicResponseHandler();
        String response = getDc().getHttpClient().execute(method, handler);

        return Boolean.valueOf(response);
    }

    private MultipartEntity getMultipartEntity(File file, String fileName)
            throws MimeTypeException, IOException {
        TikaConfig tikaConfig = TikaConfig.getDefaultConfig();
        MimeTypes mimeTypes = tikaConfig.getMimeRepository();
        byte[] buf = IOUtils.toByteArray(new FileInputStream(file));
        InputStream in = new ByteArrayInputStream(buf);
        MediaType mediaType = mimeTypes.detect(in, new Metadata());
        MimeType mimeType = mimeTypes.forName(mediaType.toString());
        MultipartEntity multipartEntity = new MultipartEntity();

        int x = 0;

        FileBody fb = new FileBody(file, fileName + mimeType.getExtension(),
                mimeType.getName(), Consts.UTF_8.name());
        multipartEntity.addPart("files[" + x + "]", fb);

        return multipartEntity;
    }

    @Override
    public String getAlias() {
        return "file";
    }
}
