/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numbers.transform.server.service;

import numbers.transform.server.Main;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
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
public class ThreeNumbersLineTransformServiceTest {
    
    @Autowired
    private ThreeNumbersLineTransformService threeNumbersLineTransformService;
    
    @Test
    public void testTransformValidValue() {
        assertEquals(threeNumbersLineTransformService.transform("3 5 10"), "1 2 F 4 B F 7 8 F B ");
    }
    
}
