package mum.itweet.components.storage;

import com.google.common.io.Files;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Component
public class StorageService implements IStorageService {


    @Override
    public String uploadMultipartFile(MultipartFile multipartFile, String subDirs) throws IOException {
        String extension = multipartFile.getOriginalFilename();
        String fileRelativePath =String.format("/uploads/%s/%s.%s",
                subDirs,
                UUID.randomUUID(),
                Files.getFileExtension(extension));

        File  file = new File(String.format("%s%s", "C:/", fileRelativePath));
        if(!file.exists())
        {
            file.mkdirs();
        }

        multipartFile.transferTo(file);

        return fileRelativePath;
    }
}
