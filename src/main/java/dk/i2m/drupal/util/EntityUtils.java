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
package dk.i2m.drupal.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import org.apache.http.Consts;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.tika.config.TikaConfig;
import org.apache.tika.io.IOUtils;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.apache.tika.mime.MimeType;
import org.apache.tika.mime.MimeTypeException;
import org.apache.tika.mime.MimeTypes;

/**
 *
 * @author Raymond Wanyoike <rwa at i2m.dk>
 */
public class EntityUtils {

    public static MultipartEntity getMultipartEntity(Map<File, String> files)
            throws MimeTypeException, IOException {
        MimeTypes mimeTypes = TikaConfig.getDefaultConfig().getMimeRepository();
        MultipartEntity multipartEntity = new MultipartEntity();

        int x = 0;
        
        for (Map.Entry<File, String> entry : files.entrySet()) {
            String name = entry.getValue();
            File file = entry.getKey();

            byte[] buf = IOUtils.toByteArray(new FileInputStream(file));
            MediaType mediaType = mimeTypes.
                    detect(new ByteArrayInputStream(buf), new Metadata());
            MimeType mimeType = mimeTypes.forName(mediaType.toString());
            FileBody fb = new FileBody(file, name + mimeType.getExtension(),
                    mimeType.getName(), Consts.UTF_8.name());

            multipartEntity.addPart("files[" + x + "]", fb);
            x++;
        }

        return multipartEntity;
    }
}
