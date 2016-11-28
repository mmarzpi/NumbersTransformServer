/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numbers.analizer.server.service.validator;

import numbers.transform.server.Main;
import numbers.transform.server.enums.LineTypeEnum;
import numbers.transform.server.validator.LineTypeCheckService;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author mar
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {Main.class})
@ActiveProfiles("test")
public class LineTypeCheckServiceTest {

    @Autowired
    private LineTypeCheckService lineTypeCheckService;

    @Test
    public void testCheckLineTypeXConstraints() {
        assertEquals(lineTypeCheckService.checkLineType("1 20 40"), LineTypeEnum.THREE_NUMBERS);
        assertEquals(lineTypeCheckService.checkLineType("20 20 40"), LineTypeEnum.THREE_NUMBERS);
        assertEquals(lineTypeCheckService.checkLineType("0 20 40"), null);
        assertEquals(lineTypeCheckService.checkLineType("21 20 40"), null);
    }

    @Test
    public void testCheckLineTypeYConstraints() {
        assertEquals(lineTypeCheckService.checkLineType("1 1 40"), LineTypeEnum.THREE_NUMBERS);
        assertEquals(lineTypeCheckService.checkLineType("20 20 40"), LineTypeEnum.THREE_NUMBERS);
        assertEquals(lineTypeCheckService.checkLineType("1 0 40"), null);
        assertEquals(lineTypeCheckService.checkLineType("20 21 40"), null);
    }

    @Test
    public void testCheckLineTypeNConstraints() {
        assertEquals(lineTypeCheckService.checkLineType("1 20 10"), LineTypeEnum.THREE_NUMBERS);
        assertEquals(lineTypeCheckService.checkLineType("20 20 100"), LineTypeEnum.THREE_NUMBERS);
        assertEquals(lineTypeCheckService.checkLineType("1 20 9"), null);
        assertEquals(lineTypeCheckService.checkLineType("20 20 101"), null);
    }
    
    @Test
    public void testNullValue() {
        assertEquals(lineTypeCheckService.checkLineType(null), null);
    }

}
