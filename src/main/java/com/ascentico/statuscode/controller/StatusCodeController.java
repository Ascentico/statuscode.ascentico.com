package com.ascentico.statuscode.controller;

import com.ascentico.statuscode.model.*;
import com.ascentico.statuscode.service.SoftwareService;
import com.ascentico.statuscode.service.StatusCodeService;
import com.ascentico.statuscode.service.StatusCodeTypeService;
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
// TODO: Fix mapping via properties file
//@RequestMapping("${controller.statuscode.request-mapping-base}")
@RequestMapping("api/v1/")
public class StatusCodeController {

    private static final Logger logger =
            LoggerFactory.getLogger(StatusCodeController.class);

    StatusCodeService statusCodeService;
    SoftwareService softwareService;
    StatusCodeTypeService statusCodeTypeService;

    @Autowired
    public void setStatusCodeService(StatusCodeService statusCodeService) {
        this.statusCodeService = statusCodeService;
    }

    @Autowired
    public void setSoftwareService(SoftwareService softwareService) {
        this.softwareService = softwareService;
    }

    @Autowired
    public void setStatusCodeTypeService(StatusCodeTypeService statusCodeTypeService) {
        this.statusCodeTypeService = statusCodeTypeService;
    }

    @ApiOperation(value = "Read a single HTTP status code", notes = "Will return details of a single HTTP status code if the status code exists")
    @RequestMapping(value = "/status/{requestedStatusCode}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    ResponseEntity<StatusCode> getStatusCode(@PathVariable int requestedStatusCode) {

        List<StatusCode> statusCodeList = statusCodeService.findByStatusCodeEquals(requestedStatusCode);

        ResponseEntity response;

        if (statusCodeList != null) {
            logger.debug("StatusCode found, returning OK");
            response = new ResponseEntity<>(statusCodeList, HttpStatus.OK);
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
            List<StatusCode> temporyStatusCodeList;

            temporyStatusCodeList = statusCodeService.findByStatusCodeEquals(requestedStatusCode);

            if (temporyStatusCodeList != null) {
                statusCodeList.addAll(temporyStatusCodeList);
            }
        }

        ResponseEntity response = new ResponseEntity<>(statusCodeList, HttpStatus.OK);

        return response;

    }

    @ApiOperation(value = "Read a random HTTP status code", notes = "Will returns a valid random HTTP Status Code")
    @RequestMapping(value = "/status/random", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
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

        StatusCodeValidationWrapper statusCodeValidationWrapper =
                new StatusCodeValidationWrapper(statusCodeService.findByStatusCodeEquals(statusCodeToValidate));

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

    @ApiOperation(value = "Read a list of software that uses unofficial HTTP status codes", notes = "Will return details of software that uses unofficial HTTP status codes")
    @RequestMapping(value = "/software/", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    ResponseEntity<Software> getSoftware() {

        ResponseEntity response;

        List<Software> softwareList = softwareService.findAllSoftware();

        if (softwareList != null) {
            logger.debug("Sofware found, returning OK");
            response = new ResponseEntity<>(softwareList, HttpStatus.OK);
        } else {
            logger.debug("Category not found, returning NOT_FOUND");
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        logger.debug("Leaving getCategory");

        return response;
    }

    @ApiOperation(value = "Read a list of only the unofficial status codes used by software", notes = "Will return details of software that uses unofficial HTTP status codes")
    @RequestMapping(value = "/software/{shortDescription}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    ResponseEntity<StatusCode> getStatusCodeForSoftware(@PathVariable String shortDescription) {

        ResponseEntity response;

        List<StatusCode> statusCodeList = statusCodeService.findAllBySoftwareShortDescription(shortDescription);

        if (statusCodeList != null) {
            logger.debug("Status Codes found, returning OK");
            response = new ResponseEntity<>(statusCodeList, HttpStatus.OK);
        } else {
            logger.debug("Status Codes not found, returning NOT_FOUND");
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        logger.debug("Leaving getStatusCodeForSoftware");

        return response;
    }

}