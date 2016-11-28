/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numbers.transform.server.validator;

import java.util.List;
import numbers.transform.server.validator.dto.ValidationErrorDTO;

/**
 *
 * @author mar
 */
interface ITextValidatorService {
    
    List<ValidationErrorDTO> validate(String text);
    
}
