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
package dk.i2m.drupal.resources;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dk.i2m.drupal.core.AbstractResourceCRUD;
import dk.i2m.drupal.core.DrupalClient;
import dk.i2m.drupal.response.FileResponce;
import dk.i2m.drupal.util.URLBuilder;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.Consts;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.tika.config.TikaConfig;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.apache.tika.mime.MimeType;
import org.apache.tika.mime.MimeTypeException;
import org.apache.tika.mime.MimeTypes;

/**
 * TODO: ...
 * 
 * @author Raymond Wanyoike <rwa at i2m.dk>
 */
public class FileResource extends AbstractResourceCRUD {

    private static final Logger LOG = Logger.getLogger(FileResource.class.
            getName());

    private DrupalClient drupalClient;

    public FileResource(DrupalClient drupalClient) {
        super(drupalClient);
        this.drupalClient = drupalClient;
    }

    /**
     * Adds a new file and returns the file response.
     * 
     * @param file
     * @param fileName
     * @return
     * @throws MimeTypeException
     * @throws MalformedURLException
     * @throws ClientProtocolException
     * @throws UnsupportedEncodingException
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public FileResponce createRaw(File file, String fileName) throws MimeTypeException,
            MalformedURLException, ClientProtocolException,
            UnsupportedEncodingException, FileNotFoundException, IOException {
        URLBuilder builder = new URLBuilder(drupalClient.getHostname());
        builder
                .add(drupalClient.getEndpoint())
                .add(getAlias())
                .add("create_raw");

        TikaConfig tikaConfig = TikaConfig.getDefaultConfig();
        MimeTypes mimeTypes = tikaConfig.getMimeRepository();
        InputStream in = new ByteArrayInputStream(get(file));
        MediaType mediaType = mimeTypes.detect(in, new Metadata());
        MimeType mimeType = mimeTypes.forName(mediaType.toString());
        MultipartEntity multipartEntity = new MultipartEntity();

        FileBody fb = new FileBody(file, fileName + mimeType.getExtension(),
                mimeType.getName(), Consts.UTF_8.name());
        multipartEntity.addPart("files[0]", fb);

        HttpPost post = new HttpPost(builder.toURI());
        post.setEntity(multipartEntity);

        LOG.log(Level.INFO,
                "> Uploading file... [name = ''{0}''], [mime = ''{1}''], [size = {2}]",
                new Object[]{fileName, mimeType, file.length()});

        ResponseHandler<String> handler = new BasicResponseHandler();
        String response = drupalClient.getHttpClient().execute(post, handler);

        Gson gson = new Gson();
        Type typeOfT = new TypeToken<List<FileResponce>>(){}.getType();
        List<FileResponce> fromJson = gson.fromJson(response, typeOfT);
        
        return fromJson.get(0);
    }

    /**
     * Returns the contents of a file as an array of bytes.
     * 
     * @param file
     * @return 
     */
    private byte[] get(File file) {
        byte[] fileData = new byte[(int) file.length()];
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(file);
            fis.read(fileData);
        } catch (IOException ex) {
            fileData = null;
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ex) {
                    // ignore
                }
            }
        }

        return fileData;
    }

    @Override
    public String getAlias() {
        return "file";
    }
}
