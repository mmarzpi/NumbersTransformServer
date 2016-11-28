/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numbers.transform.server.service;

import java.util.List;
import numbers.transform.server.enums.LineTypeEnum;
import numbers.transform.server.service.dto.TextResponseDTO;
import numbers.transform.server.validator.LineTypeCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author mar
 */
@Service
public class NumbersTextTransformService extends TextTransformService {

    @Autowired
    private NumbersLineTransformService numbersLineTransformService;

    @Autowired
    private LineTypeCheckService lineTypeCheckService;

    @Override
    public TextResponseDTO transform(String text) {
        TextResponseDTO textResponseDTO = new TextResponseDTO();
        if (text != null) {
            StringBuilder stringBuilder = new StringBuilder();
            List<String> lineList = shareLines(text);
            lineList.forEach(line -> {
                LineTypeEnum lineType = lineTypeCheckService.checkLineType(line);
                if (lineType != null) {
                    stringBuilder.append(numbersLineTransformService.transform(lineType, line));
                }
                stringBuilder.append(getLineSeparator());
            });
            textResponseDTO.setValue(stringBuilder.toString());
        }

        return textResponseDTO;
    }

    @Override
    public String getLineSeparator() {
        return System.getProperty("line.separator");
    }

}
