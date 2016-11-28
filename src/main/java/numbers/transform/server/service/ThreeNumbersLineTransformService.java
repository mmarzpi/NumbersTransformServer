/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numbers.transform.server.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author mar
 */
@Service
public class ThreeNumbersLineTransformService extends LineTransformService{
    
    @Value("${three.numbers.line.separator}")
    private String threeNumbersLineSeparator;
    
    private static final String FIRST_DIVIDER_CONVERSION = "F";
    
    private static final String SECOND_DIVIDER_CONVERSION = "B";
    
    private static final String BOTH_DIVIDERS_CONVERSION = "FB";

    @Override
    public String transform(String line) {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> lineTokens = tokenize(line);
        int xDelimeter = Integer.parseInt(lineTokens.get(0));
        int yDelimeter = Integer.parseInt(lineTokens.get(1));
        int count = Integer.parseInt(lineTokens.get(2));
        for(int a=1; a<=count; a++) {
            if(((a % xDelimeter) == 0) && ((a % yDelimeter) == 0)) {
                stringBuilder.append(BOTH_DIVIDERS_CONVERSION);
            } else if((a % xDelimeter) == 0) {
                stringBuilder.append(FIRST_DIVIDER_CONVERSION);
            } else if((a % yDelimeter) == 0) {
                stringBuilder.append(SECOND_DIVIDER_CONVERSION);
            } else {
                stringBuilder.append(a);
            }
            stringBuilder.append(getTokenSeparator());
        }
        return stringBuilder.toString();
    }

    @Override
    public String getTokenSeparator() {
        return threeNumbersLineSeparator;
    }
    
}
