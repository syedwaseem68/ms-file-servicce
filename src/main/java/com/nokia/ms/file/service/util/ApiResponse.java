package com.nokia.ms.file.service.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

@ApiModel
public class ApiResponse {


    private static final long serialVersionUID = -2479877644814765244L;
    private Integer appStatusCode = 0;
    @ApiModelProperty(
            example = "Json Object"
    )
    private Object payloadJson = null;
    private List<String> messages = new ArrayList();
    @ApiModelProperty(
            example = "url endpoint"
    )
    private String apiCall = "";
    @ApiModelProperty(
            example = "Payload.class"
    )
    private Class<?> payloadClass = Object.class;
    @ApiModelProperty(
            example = "unique request id"
    )
    private String requestId = "";

    public ApiResponse() {
    }

    public ApiResponse(String apiCall) {
        this.apiCall = apiCall;
    }

    public ApiResponse(String apiCall, String requestId) {
        this.apiCall = apiCall;
        this.requestId = requestId;
    }

    public ApiResponse(List<String> messages) {
        this.messages = messages;
    }

    public ApiResponse(int appStatusCode, List<String> messages) {
        this.appStatusCode = appStatusCode;
        this.messages = messages;
    }

    public Integer getAppStatusCode() {
        return this.appStatusCode;
    }

    public Object getPayloadJson() {
        return this.payloadJson;
    }

    public List<String> getMessages() {
        return this.messages;
    }

    public String getApiCall() {
        return this.apiCall;
    }

    public Class<?> getPayloadClass() {
        return this.payloadClass;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setAppStatusCode(final Integer appStatusCode) {
        this.appStatusCode = appStatusCode;
    }

    public void setPayloadJson(final Object payloadJson) {
        this.payloadJson = payloadJson;
    }

    public void setMessages(final List<String> messages) {
        this.messages = messages;
    }


    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ApiResponse)) {
            return false;
        } else {
            ApiResponse other = (ApiResponse)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$appStatusCode = this.getAppStatusCode();
                Object other$appStatusCode = other.getAppStatusCode();
                if (this$appStatusCode == null) {
                    if (other$appStatusCode != null) {
                        return false;
                    }
                } else if (!this$appStatusCode.equals(other$appStatusCode)) {
                    return false;
                }

                Object this$payloadJson = this.getPayloadJson();
                Object other$payloadJson = other.getPayloadJson();
                if (this$payloadJson == null) {
                    if (other$payloadJson != null) {
                        return false;
                    }
                } else if (!this$payloadJson.equals(other$payloadJson)) {
                    return false;
                }

                Object this$messages = this.getMessages();
                Object other$messages = other.getMessages();
                if (this$messages == null) {
                    if (other$messages != null) {
                        return false;
                    }
                } else if (!this$messages.equals(other$messages)) {
                    return false;
                }

                label62: {
                    Object this$apiCall = this.getApiCall();
                    Object other$apiCall = other.getApiCall();
                    if (this$apiCall == null) {
                        if (other$apiCall == null) {
                            break label62;
                        }
                    } else if (this$apiCall.equals(other$apiCall)) {
                        break label62;
                    }

                    return false;
                }

                label55: {
                    Object this$payloadClass = this.getPayloadClass();
                    Object other$payloadClass = other.getPayloadClass();
                    if (this$payloadClass == null) {
                        if (other$payloadClass == null) {
                            break label55;
                        }
                    } else if (this$payloadClass.equals(other$payloadClass)) {
                        break label55;
                    }

                    return false;
                }

                Object this$requestId = this.getRequestId();
                Object other$requestId = other.getRequestId();
                if (this$requestId == null) {
                    if (other$requestId != null) {
                        return false;
                    }
                } else if (!this$requestId.equals(other$requestId)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ApiResponse;
    }


    public String toString() {
        Integer var10000 = this.getAppStatusCode();
        return "ApiResponse(appStatusCode=" + var10000 + ", payloadJson=" + this.getPayloadJson() + ", messages=" + this.getMessages() + ", apiCall=" + this.getApiCall() + ", payloadClass=" + this.getPayloadClass() + ", requestId=" + this.getRequestId() + ")";
    }
}
