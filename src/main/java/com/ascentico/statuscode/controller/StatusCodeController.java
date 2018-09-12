package com.ascentico.statuscode.controller;

import com.ascentico.statuscode.model.StatusCode;
import com.ascentico.statuscode.model.StatusCodeOnlyListWrapper;
import com.ascentico.statuscode.model.StatusCodeValidationWrapper;
import com.ascentico.statuscode.service.StatusCodeService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:4201")
@RequestMapping("/api/v1/")
public class StatusCodeController {

    private static final Logger logger =
            LoggerFactory.getLogger(StatusCodeController.class);

    StatusCodeService statusCodeService;

    @Autowired
    public void setStatusCodeService(StatusCodeService statusCodeService) {
        this.statusCodeService = statusCodeService;
    }

    @ApiOperation(value = "Read a single HTTP status code", notes = "Will return details of a single HTTP status code if the status code exists")
    @RequestMapping(value = "/status/{requestedStatusCode}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    ResponseEntity<StatusCode> getStatusCode(@PathVariable int requestedStatusCode) {

        StatusCode statusCode = statusCodeService.findDistinctByStatusCodeEquals(requestedStatusCode);
        ResponseEntity response;

        if (statusCode != null) {
            logger.debug("StatusCode found, returning OK");
            response = new ResponseEntity<>(statusCode, HttpStatus.OK);
        } else {
            logger.debug("StatusCode not found, returning NOT_FOUND");
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return response;
    }

    @ApiOperation(value = "Read a list of all HTTP status codes", notes = "Will returns a list of all HTTP Status Codes")
    @RequestMapping(value = "/status", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    ResponseEntity<StatusCode> getAllStatusCodes() {

        ResponseEntity response;

        List<StatusCode> statusCodeList = statusCodeService.findAllStatusCodes();

        if (statusCodeList != null) {
            logger.debug("Status Codes found, returning OK");
            response = new ResponseEntity<>(statusCodeList, HttpStatus.OK);
        } else {
            logger.debug("Status Codes not found, returning NOT_FOUND");
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return response;

    }

    @ApiOperation(value = "Bulk read a list of HTTP status codes", notes = "Will returns a list of all HTTP Status Codes")
    @RequestMapping(value = "/status", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    public @ResponseBody
    ResponseEntity<StatusCode> getBulkStatusCodes(@RequestBody StatusCodeOnlyListWrapper requestedStatusCodeList) {

        List<StatusCode> statusCodeList = new ArrayList<>();

        for (Integer requestedStatusCode: requestedStatusCodeList) {
            StatusCode statusCode;

            statusCode = statusCodeService.findDistinctByStatusCodeEquals(requestedStatusCode);

            if (statusCode != null) {
                statusCodeList.add(statusCode);
            }
        }

        ResponseEntity response = new ResponseEntity<>(statusCodeList, HttpStatus.OK);

        return response;

    }

    @ApiOperation(value = "Read a random HTTP status code", notes = "Will returns a valid random HTTP Status Code")
    @RequestMapping(value = "/random/status", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    ResponseEntity<StatusCode> getRandomStatusCode() {

        StatusCode statusCode = statusCodeService.findRandomStatusCode();
        ResponseEntity response;

        if (statusCode != null) {
            logger.debug("StatusCode found, returning OK");
            response = new ResponseEntity<>(statusCode, HttpStatus.OK);
        } else {
            logger.debug("StatusCode not found, returning NOT_FOUND");
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return response;

    }

    @ApiOperation(value = "Validate a single HTTP status code", notes = "Will return a boolean if the HTTP status code is valid")
    @RequestMapping(value = "/status/{statusCodeToValidate}/validate", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    ResponseEntity<StatusCodeValidationWrapper> validateStatusCode(@PathVariable int statusCodeToValidate) {

        StatusCodeValidationWrapper statusCodeValidationWrapper = new StatusCodeValidationWrapper();
        statusCodeValidationWrapper.setStatusCode(statusCodeToValidate);
        statusCodeValidationWrapper.setValid(statusCodeService.ifExists(statusCodeToValidate));

        ResponseEntity response = new ResponseEntity<>(statusCodeValidationWrapper, HttpStatus.OK);

        return response;
    }

    @ApiOperation(value = "Read a category of HTTP status codes", notes = "Will return details of all HTTP status codes in the category if the status category exists, pass in a member of a category or the category as 2xx or 200")
    @RequestMapping(value = "/category/{requestedCategory}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    ResponseEntity<StatusCode> getCategory(@PathVariable String requestedCategory) {

        logger.debug("Entering getCategory");

        ResponseEntity response;

        List<StatusCode> statusCodeList = statusCodeService.findAllByCategoryMember(requestedCategory);

        if (statusCodeList != null) {
            logger.debug("Category found, returning OK");
            response = new ResponseEntity<>(statusCodeList, HttpStatus.OK);
        } else {
            logger.debug("Category not found, returning NOT_FOUND");
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        logger.debug("Leaving getCategory");

        return response;
    }

}