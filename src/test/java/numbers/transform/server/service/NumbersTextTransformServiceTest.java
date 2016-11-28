/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numbers.transform.server.service;

import numbers.transform.server.Main;
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
public class NumbersTextTransformServiceTest {
    
    @Autowired
    private NumbersTextTransformService numbersTextTransformService;
    
    @Test
    public void testTransformValidValue() {
        assertTrue(numbersTextTransformService.transform("3 5 10").getValue()!=null);
    }
    
}
