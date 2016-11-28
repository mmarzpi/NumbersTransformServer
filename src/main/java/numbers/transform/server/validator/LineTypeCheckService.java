/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numbers.transform.server.validator;

import numbers.transform.server.enums.LineTypeEnum;
import numbers.transform.server.service.PatternCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author mar
 */
@Service
public class LineTypeCheckService {
    
    @Autowired
    private PatternCheckService patternCheckService;
    
    @Value("${three.numbers.line.pattern}")
    private String threeNumbersLinePattern;
    
    public LineTypeEnum checkLineType(String line) {
        if(line != null && isThreeNumbersLine(line)) {
            return LineTypeEnum.THREE_NUMBERS;
        }
        return null;
    }
    
    private boolean isThreeNumbersLine(String line) {        
        return patternCheckService.isConsistentWithPattern(threeNumbersLinePattern, line);
    }
    

    
}
