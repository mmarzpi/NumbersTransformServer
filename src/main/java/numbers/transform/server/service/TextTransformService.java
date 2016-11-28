/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numbers.transform.server.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import numbers.transform.server.service.dto.TextResponseDTO;

/**
 *
 * @author mar
 */
abstract class TextTransformService {
    
    abstract TextResponseDTO transform(String text);
    
    abstract String getLineSeparator();
    
    public List<String> shareLines(String text) {
        if(text == null) {
            return new ArrayList<>();
        }
        String[] lines = text.split(getLineSeparator());
        return Arrays.asList(lines);
    }
    
}
