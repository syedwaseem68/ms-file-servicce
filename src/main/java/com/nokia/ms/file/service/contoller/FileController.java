package com.nokia.ms.file.service.contoller;

import com.google.gson.JsonObject;
import com.nokia.ms.file.service.contoller.Base.BaseController;
import com.nokia.ms.file.service.services.interfaces.FileService;
import com.nokia.ms.file.service.util.ApiResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/nokia/file")
public class FileController extends BaseController {

    public static final String APPLICATION_JSON_CHARSET_UTF_8 = "application/json; charset=utf-8";

    @Autowired private FileService fileService;

    @ApiOperation(value = "File Export API", notes = "")
    @ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200, message = "Successful \n\n   <table style=\"width: 30%; border-collapse: unset !important; text-align: center; border-style: solid\"> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\"><b>App status <b></td> <td style=\"border-style: solid\"><b>Value <b></td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">0</td> <td style=\"border-style: solid\">success</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">1</td> <td style=\"border-style: solid\">missing fields</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">2</td> <td style=\"border-style: solid\">duplicate record</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">3</td> <td style=\"border-style: solid\">invalid data format</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">4</td> <td style=\"border-style: solid\">data input error</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">5</td> <td style=\"border-style: solid\">record not found</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">6</td> <td style=\"border-style: solid\">login failed</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">7</td> <td style=\"border-style: solid\">inactive</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">8</td> <td style=\"border-style: solid\">pending</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">9</td> <td style=\"border-style: solid\">locked</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">10</td> <td style=\"border-style: solid\">logout</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">11</td> <td style=\"border-style: solid\">invalid request</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">12</td> <td style=\"border-style: solid\">request already process</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">13</td> <td style=\"border-style: solid\">communication error</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">14</td> <td style=\"border-style: solid\">data calculation error</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">15</td> <td style=\"border-style: solid\">unauthorized error</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">16</td> <td style=\"border-style: solid\">authentication error</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">100</td> <td style=\"border-style: solid\">application error</td> </tr> </table>", response = ApiResponse.class)})
    @PostMapping(value = "/export", consumes = APPLICATION_JSON_CHARSET_UTF_8, produces = APPLICATION_JSON_CHARSET_UTF_8)
    public ResponseEntity<ApiResponse> fileExport(@RequestBody  String payload) {
        ApiResponse apiResponse = this.initializeResponse("/nokia/file/export");
        try {
            JsonObject data = this.getDataObject(payload);
            fileService.fileExport(data);
        } catch (Exception e) {
                this.handleAppExceptions(e, apiResponse);
            }
        return  this.getResponseEntity(apiResponse);
    }

    @ApiOperation(value = "File Import API", notes = "{ \"data\": { \"fileName\": \"demo.tar\"} }")
    @ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200, message = "Successful \n\n   <table style=\"width: 30%; border-collapse: unset !important; text-align: center; border-style: solid\"> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\"><b>App status <b></td> <td style=\"border-style: solid\"><b>Value <b></td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">0</td> <td style=\"border-style: solid\">success</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">1</td> <td style=\"border-style: solid\">missing fields</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">2</td> <td style=\"border-style: solid\">duplicate record</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">3</td> <td style=\"border-style: solid\">invalid data format</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">4</td> <td style=\"border-style: solid\">data input error</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">5</td> <td style=\"border-style: solid\">record not found</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">6</td> <td style=\"border-style: solid\">login failed</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">7</td> <td style=\"border-style: solid\">inactive</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">8</td> <td style=\"border-style: solid\">pending</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">9</td> <td style=\"border-style: solid\">locked</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">10</td> <td style=\"border-style: solid\">logout</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">11</td> <td style=\"border-style: solid\">invalid request</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">12</td> <td style=\"border-style: solid\">request already process</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">13</td> <td style=\"border-style: solid\">communication error</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">14</td> <td style=\"border-style: solid\">data calculation error</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">15</td> <td style=\"border-style: solid\">unauthorized error</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">16</td> <td style=\"border-style: solid\">authentication error</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">100</td> <td style=\"border-style: solid\">application error</td> </tr> </table>", response = ApiResponse.class)})
    @PostMapping(value = "/import", consumes = APPLICATION_JSON_CHARSET_UTF_8, produces = APPLICATION_JSON_CHARSET_UTF_8)
    public ResponseEntity<ApiResponse> fileImport(@RequestBody  String payload) {
        ApiResponse apiResponse = this.initializeResponse("/nokia/file/import");
        try {
            JsonObject data = this.getDataObject(payload);
            fileService.fileImport(data);
        } catch (Exception e) {
            this.handleAppExceptions(e, apiResponse);
        }
        return  this.getResponseEntity(apiResponse);
    }

    @ApiOperation(value = "File List API", notes = "{ \"data\": { \"fileName\": \"demo.tar\" } }")
    @ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200, message = "Successful \n\n   <table style=\"width: 30%; border-collapse: unset !important; text-align: center; border-style: solid\"> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\"><b>App status <b></td> <td style=\"border-style: solid\"><b>Value <b></td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">0</td> <td style=\"border-style: solid\">success</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">1</td> <td style=\"border-style: solid\">missing fields</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">2</td> <td style=\"border-style: solid\">duplicate record</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">3</td> <td style=\"border-style: solid\">invalid data format</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">4</td> <td style=\"border-style: solid\">data input error</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">5</td> <td style=\"border-style: solid\">record not found</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">6</td> <td style=\"border-style: solid\">login failed</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">7</td> <td style=\"border-style: solid\">inactive</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">8</td> <td style=\"border-style: solid\">pending</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">9</td> <td style=\"border-style: solid\">locked</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">10</td> <td style=\"border-style: solid\">logout</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">11</td> <td style=\"border-style: solid\">invalid request</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">12</td> <td style=\"border-style: solid\">request already process</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">13</td> <td style=\"border-style: solid\">communication error</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">14</td> <td style=\"border-style: solid\">data calculation error</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">15</td> <td style=\"border-style: solid\">unauthorized error</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">16</td> <td style=\"border-style: solid\">authentication error</td> </tr> <tr style=\"border-style: solid\"> <td style=\"border-style: solid\">100</td> <td style=\"border-style: solid\">application error</td> </tr> </table>", response = ApiResponse.class)})
    @PostMapping(value = "/file-list", consumes = APPLICATION_JSON_CHARSET_UTF_8, produces = APPLICATION_JSON_CHARSET_UTF_8)
    public ResponseEntity<ApiResponse> fileList(@RequestBody  String payload) {
        ApiResponse apiResponse = this.initializeResponse("/nokia/file/file-list");
        try {
            JsonObject data = this.getDataObject(payload);
            fileService.fileList(data);
        } catch (Exception e) {
            this.handleAppExceptions(e, apiResponse);
        }
        return  this.getResponseEntity(apiResponse);
    }


}
