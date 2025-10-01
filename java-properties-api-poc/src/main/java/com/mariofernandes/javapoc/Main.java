package com.mariofernandes.javapoc;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        PropertiesAPIPOC poc = new PropertiesAPIPOC();

        System.out.println("=== Java Properties API POC ===\n");

        // 1. Create and populate properties
        poc.createProperties();

        // 2. Store properties to file
        poc.storeProperties();

        // 3. Read properties from file
        poc.readProperties();

        // 4. Work with System properties
        poc.workWithSystemProperties();
    }
}
