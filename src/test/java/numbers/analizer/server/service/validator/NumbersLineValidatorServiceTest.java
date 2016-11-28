/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numbers.analizer.server.service.validator;

import numbers.transform.server.Main;
import numbers.transform.server.validator.NumbersLineValidatorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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
public class NumbersLineValidatorServiceTest {

    @Autowired
    private NumbersLineValidatorService numbersLineValidatorService;

    @Test
    public void testValidateNullValue() {
        assertTrue(numbersLineValidatorService.validate(null) != null);
    }

    @Test
    public void testValidateWrongValue() {
        assertTrue(!numbersLineValidatorService.validate("aaaa").isEmpty());
    }

    @Test
    public void testValidateValidValue() {
        assertTrue(numbersLineValidatorService.validate("12 12 12").isEmpty());
    }

}
