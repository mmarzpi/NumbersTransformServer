/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numbers.transform.server.rest.controller;

import java.util.List;
import numbers.transform.server.validator.NumbersLineValidatorService;
import numbers.transform.server.validator.NumbersTextValidatorService;
import numbers.transform.server.validator.dto.ValidationErrorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mar
 */
@RestController
public class ThreeNumbersValidatorController {
    
    @Autowired
    private NumbersTextValidatorService numbersTextValidatorService;
    
    @RequestMapping(value = "/validate/three-numbers", produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.GET)
    public @ResponseBody List<ValidationErrorDTO> validate(@RequestBody String text) {
        return numbersTextValidatorService.validate(text);
    }
    
}
