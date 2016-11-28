/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numbers.transform.server.validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import numbers.transform.server.enums.LineTypeEnum;
import numbers.transform.server.validator.dto.ValidationErrorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author mar
 */
@Service
public class NumbersLineValidatorService {

    @Autowired
    private LineTypeCheckService lineTypeCheckService;
    
    @Value("${line.type.not.found.error.message}")
    private String lineTypeNotFoundErrorMessage;

    public List<ValidationErrorDTO> validate(String line) {
        List<ValidationErrorDTO> validationErrorList = new ArrayList<>();
        LineTypeEnum lineType = lineTypeCheckService.checkLineType(line);
        if(lineType == null) {
            ValidationErrorDTO validationErrorDTO = new ValidationErrorDTO();
            validationErrorDTO.setLineText(line);
            validationErrorDTO.setErrorDescription(lineTypeNotFoundErrorMessage);
            validationErrorList.add(validationErrorDTO);
        }
        return validationErrorList;
    }

}
