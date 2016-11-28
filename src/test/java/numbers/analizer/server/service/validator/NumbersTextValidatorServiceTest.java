/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numbers.analizer.server.service.validator;

import numbers.transform.server.Main;
import numbers.transform.server.validator.NumbersTextValidatorService;
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
public class NumbersTextValidatorServiceTest {

    @Autowired
    private NumbersTextValidatorService numbersTextValidatorService;

    @Test
    public void testValidateNullValue() {
        assertTrue(numbersTextValidatorService.validate(null) != null);
        assertTrue(numbersTextValidatorService.validate(null).isEmpty());
    }

    @Test
    public void testValidateNotValidValue() {
        assertTrue(!numbersTextValidatorService.validate("1 1 1"
                + "1 1 1").isEmpty());
    }

    @Test
    public void testValidateValidValue() {
        assertTrue(!numbersTextValidatorService.validate("12 12 12"
                + "12 12 12").isEmpty());
    }

}
