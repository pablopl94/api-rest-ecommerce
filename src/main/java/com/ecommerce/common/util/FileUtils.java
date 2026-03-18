package com.ecommerce.common.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Objects;
import java.util.UUID;

@Service
public class FileUtils {

    private final String uploadPath;

    public FileUtils(@Value("${app.uploads.products.image-path}") String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public String handleProductImage(MultipartFile file, String currentFile) {

        if (file == null || file.isEmpty()) {
            return currentFile;
        }

        String uniqueFileName;

        try (InputStream inputStream = file.getInputStream()) {
            String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
            uniqueFileName = UUID.randomUUID() + "-" + fileName;
            Path path = Path.of(uploadPath);
            // createDirectories ya es idempotente, no validar si existe
            Files.createDirectories(path);
            Files.copy(inputStream, path.resolve(uniqueFileName), StandardCopyOption.REPLACE_EXISTING);

        } catch (Exception e) {
            throw new RuntimeException("Error uploading image: " + e.getMessage(), e);
        }
        return uniqueFileName;
    }
}
