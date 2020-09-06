package com.nokia.ms.file.service.services.interfaces;

import com.google.gson.JsonObject;

public interface FileService {

    void fileExport(JsonObject payload);
    JsonObject fileImport(JsonObject payload);
    JsonObject fileList(JsonObject payload);
}
