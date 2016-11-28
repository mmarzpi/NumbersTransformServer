/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numbers.transform.server.service;

import numbers.transform.server.validator.LineTypeCheckService;
import java.util.HashMap;
import javax.annotation.PostConstruct;
import numbers.transform.server.enums.LineTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mar
 */
@Service
public class NumbersLineTransformService {
    
    @Autowired
    private ThreeNumbersLineTransformService threeNumbersLineTransformService;
    
    private HashMap<LineTypeEnum, LineTransformService> lineTransformServiceMap;
    
    @PostConstruct
    public void init() {
        lineTransformServiceMap = new HashMap<>();
        lineTransformServiceMap.put(LineTypeEnum.THREE_NUMBERS, threeNumbersLineTransformService);
    }
    
    public String transform(LineTypeEnum lineType, String line) {        
        return lineTransformServiceMap.get(lineType).transform(line);
    }
    
}
