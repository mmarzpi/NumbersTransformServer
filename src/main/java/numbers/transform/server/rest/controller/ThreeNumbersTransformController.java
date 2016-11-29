/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numbers.transform.server.rest.controller;

import numbers.transform.server.service.NumbersLineTransformService;
import numbers.transform.server.service.NumbersTextTransformService;
import numbers.transform.server.service.dto.TextResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mar
 */
@RestController
public class ThreeNumbersTransformController {
    
    @Autowired
    NumbersTextTransformService numbersTransformService;
    
    @RequestMapping(value = "/transform/three-numbers", produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.GET)
    public TextResponseDTO transformInput(@RequestBody String text) {
        return numbersTransformService.transform(text);
    }
    
}
