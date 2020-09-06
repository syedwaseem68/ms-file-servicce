package com.nokia.ms.file.service.contoller.Base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.nokia.ms.file.service.exceptions.InputPayloadException;
import com.nokia.ms.file.service.util.ApiResponse;
import com.nokia.ms.file.service.util.SystemHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Slf4j
public class BaseController {

    @JsonIgnore
    @Autowired SystemHelper helper;
    @Autowired protected ObjectMapper objectMapper;


    protected JsonObject getJsonObject(String payload, String key) {
        Gson gson = new Gson();
        JsonObject data = gson.fromJson(payload, JsonObject.class);
        return key.isEmpty() ? data : data.getAsJsonObject(key);
    }

    protected JsonObject getDataObject(String data) {
        log.debug("Json Payload -->{}", data);
        return getJsonObject(data, "data");
    }

    public ResponseEntity<ApiResponse> ping() {
        ApiResponse apiResponse = this.initializeResponse(".../ping");

        try {
            JsonObject data = new JsonObject();
            data.addProperty("time", this.helper.getCurrentTimeString());
            this.setJsonPayload(apiResponse, data);
        } catch (Exception var3) {
            this.handleAppExceptions(var3, apiResponse);
        }
        return this.getResponseEntity(apiResponse);
    }

    protected ResponseEntity<ApiResponse> getResponseEntity(ApiResponse response) {
        return this.getResponseEntity(response, response.getMessages(), HttpStatus.OK, (HttpHeaders)null);
    }

    protected ResponseEntity<ApiResponse> getResponseEntity(ApiResponse response, List<String> messages, HttpStatus status, HttpHeaders headers) {
        response.setMessages(messages);
        return new ResponseEntity(response, headers, status);
    }

    protected void setJsonPayload(ApiResponse response, JsonElement data) throws JsonProcessingException {
        JsonObject resData = data.getAsJsonObject();
        if (resData.has("status") && !resData.get("status").getAsString().equalsIgnoreCase("success")) {
            response.setAppStatusCode(6);
        }

        response.setPayloadJson(this.objectMapper.readValue(this.helper.toJSON(data), Object.class));
    }

    protected ApiResponse initializeResponse(String message) {

        log.debug("API End point {}", message);
        return new ApiResponse(message, helper.getRandomUUID());
    }

    protected void handleAppExceptions(Exception e, ApiResponse apiResponse) {
        StringBuilder message = new StringBuilder(apiResponse.getApiCall() + "\n\n Header Info :\n");
        if (e instanceof InputPayloadException) {
            InputPayloadException i = (InputPayloadException)e;
            apiResponse.setMessages(i.getErrorMessages());
            apiResponse.setAppStatusCode(4);
            message.append("InputPayloadException : ");
        }
    }
}
