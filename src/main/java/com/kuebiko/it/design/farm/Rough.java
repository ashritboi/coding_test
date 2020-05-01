package com.kuebiko.it.design.farm;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @Created_On- 30/April/2020
 * @Project- coding_test
 * @Author- Ashrit Koirala
 **/
public class Rough {
    public static void main(String[] args) throws InterruptedException {
        List<LocalDateTime> loc = new ArrayList<LocalDateTime>();
        for(int i =0; i<10; i++) {
            loc.add(LocalDateTime.now());
            Thread.sleep(1000);
        }
        loc.forEach(System.out::println);
    }
}
