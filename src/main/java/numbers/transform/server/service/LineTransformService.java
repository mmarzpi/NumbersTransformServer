/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numbers.transform.server.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author mar
 */
abstract class LineTransformService {
    
    abstract String transform(String line);
    
    abstract String getTokenSeparator();
    
    public List<String> tokenize(String line) {
        String[] array = line.split(getTokenSeparator());
        return Arrays.asList(array);
    }
    
}
