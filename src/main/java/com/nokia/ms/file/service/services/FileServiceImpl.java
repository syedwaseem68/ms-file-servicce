package com.nokia.ms.file.service.services;

import com.google.gson.JsonObject;
import com.nokia.ms.file.service.exceptions.InputPayloadException;
import com.nokia.ms.file.service.services.interfaces.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
public class FileServiceImpl  implements FileService {

    private final String FOLDER = "/home/csq/Desktop/documents/file";

    @Override
    public void fileExport(JsonObject payload) {

        String fileName = payload.get("fileName").getAsString();
        String fileData = payload.get("fileData").getAsString();
        byte[] decode = Base64.getMimeDecoder().decode(fileData);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(FOLDER + fileName);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            bufferedOutputStream.write(decode);
            bufferedOutputStream.close();
            log.debug("File Exported Successfully!");
        } catch (IOException exception) {
            log.debug("Exception :{}", exception);
            exception.printStackTrace();
        }
    }

    @Override
    public JsonObject  fileImport(JsonObject payload) {
        JsonObject response = new JsonObject();
        String fileName = payload.get("fileName").getAsString();

        try {
            File file = new File(FOLDER + fileName);
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream inputStream = new BufferedInputStream(fileInputStream);

            if (inputStream == null) {
                throw  new InputPayloadException("File not found");
            }
            byte[] fileBytes = new byte[(int) file.length()];
            inputStream.read(fileBytes);
            inputStream.close();
            response.addProperty("FileDate", fileBytes.toString());
            log.debug("File Imported Successfully!");
        } catch (IOException | InputPayloadException exception) {
            log.debug("Exception :{}", exception);
            exception.printStackTrace();
        }
        return response;
    }

    @Override
    public JsonObject fileList(JsonObject payload) {

        JsonObject response = new JsonObject();
        try (Stream<Path> walk = Files.walk(Paths.get(FOLDER))) {
            List<String> result = walk.map(x -> x.toString())
                    .filter(f -> f.endsWith(".tar")).collect(Collectors.toList());
            result.forEach(System.out::println);
            if (result.isEmpty()) {
                throw  new InputPayloadException("File not found");
            }
            response.addProperty("File List", result.toString());
        } catch (IOException | InputPayloadException e) {
            e.printStackTrace();
        }
        return response;
    }

}
