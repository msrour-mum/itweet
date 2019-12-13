package mum.itweet.components;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
public interface IStorageService {

    String uploadMultipartFile(MultipartFile multipartFile, String subDirs) throws IOException;
}
