/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numbers.transform.server.validator;

import java.util.ArrayList;
import java.util.List;
import numbers.transform.server.service.NumbersTextTransformService;
import numbers.transform.server.validator.dto.ValidationErrorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mar
 */
@Service
public class NumbersTextValidatorService implements ITextValidatorService{
    
    @Autowired
    private NumbersTextTransformService numbersTextTransformService;
    
    @Autowired
    private NumbersLineValidatorService numbersLineValidatorService;

    @Override
    public List<ValidationErrorDTO> validate(String text) {
        List<ValidationErrorDTO> validationErrorList = new ArrayList<>();
        List<String> lineList = numbersTextTransformService.shareLines(text);
        lineList.forEach(line -> {
            validationErrorList.addAll(numbersLineValidatorService.validate(line));
        });
        
        return validationErrorList;              
    }
      
}
