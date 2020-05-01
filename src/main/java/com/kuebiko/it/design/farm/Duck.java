package com.kuebiko.it.design.farm;

import com.opencsv.CSVWriter;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @Created_On- 29/April/2020
 * @Project- coding_test
 * @Author- Ashrit Koirala
 **/
public class Duck implements Bird{
    private final String name;

    private static final long HATCHING_PERIOD_MINS = initialize();

    private static final String propurl = "C:\\Users\\Ashrit\\Documents\\coding_test\\src\\main\\resources\\farm\\bird.properties";
    private final String CSVpath = "C:\\Users\\Ashrit\\Documents\\coding_test\\src\\main\\resources\\farm\\egg.csv";
    private List<Egg> eggs = new ArrayList<>(100);
    private LocalDateTime l, l1;

    public Duck(String name) {
        this.name = name;
    }

    static long initialize()  {
        InputStream input = null;
        try {
            input = new FileInputStream(propurl);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties prop = new Properties();
        try {
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String inc=prop.getProperty("incubation.period.minutes.duck");
        int incubation_duck = Integer.parseInt(inc);
        return incubation_duck;
        //throw new NotYetImplementedException("get from src/main/resources/farm/bird.properties");
    }

    @Override
    public Egg lay() throws Exception {

        do {
            l = LocalDateTime.now();
            System.out.println(String.format("Duck (%s) laid an egg at %s", name, l));

            Egg egg = new Egg(this::hatch_period);
            System.out.println(String.format("Duck Egg laid at %s Hatched an egg at %s", l, l1));

            this.eggs.add(egg);
            writeInCsv(this.name, l, l1);
            return egg;
        }while (eggs.size()<100);

    }


    public Duck hatch_period() throws InterruptedException {
        int incubation_period= (int)HATCHING_PERIOD_MINS *1000; //
        Thread.sleep(incubation_period);
        this.l1 = LocalDateTime.now();
        return this;
    }

    private void writeInCsv(String s, LocalDateTime l, LocalDateTime l1){
        File file = new File(CSVpath);
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file,true);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);

            // add data to csv
            String[] data1 = { s +" Laid at"+" "+ l +" "+ "&" + " Hatch at "+l1 };
            writer.writeNext(data1);

            // closing writer connection
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
