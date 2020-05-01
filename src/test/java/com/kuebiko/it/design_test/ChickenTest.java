package com.kuebiko.it.design_test;

import com.kuebiko.it.design.farm.Chicken;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Created_On- 29/April/2020
 * @Project- coding_test
 * @Author- Ashrit Koirala
 **/
public class ChickenTest {

    Chicken chicken = new Chicken ("chicken");

    @Test
    public void incubation_periodTest() {
        int chicken_incub= (int)Chicken.initialize();
        Assert.assertEquals(21, chicken_incub);
    }

    @Test
    public void isHatchedTest() throws Exception {
        Boolean b = chicken.lay().isAlreadyHatched();
        Assert.assertTrue(b);
    }

}
