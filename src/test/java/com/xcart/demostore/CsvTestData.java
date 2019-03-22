package com.xcart.demostore;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;
import java.io.*;
import java.util.*;
@RunWith(value = Parameterized.class)
public class CsvTestData {

    private static WebDriver driver;
    private static StringBuffer verificationErrors = new
            StringBuffer();
    private String height;
    private String weight;
    private String bmi;
    private String bmiCategory;



    @Parameters
    public static Collection testData() throws IOException {
        return getTestData("/Users/olegivanov/work/data.csv");
    }
//    Add the constructor which maps the instance variables with the
//    test data
    public CsvTestData(String height, String weight, String bmi,
                       String bmiCategory) {

        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
        this.bmiCategory = bmiCategory;


    }

    public static Collection<String[]> getTestData(String fileName)
            throws IOException {
        List<String[]> records = new ArrayList<String[]>();
        String record;
        BufferedReader file = new BufferedReader(new
                FileReader(fileName));
        while ((record=file.readLine())!=null) {
            String fields[] = record.split(",");
            records.add(fields);
        }
        file.close();
        return records;
    }

    @Ignore
    @BeforeClass
    public static void setUp() throws Exception {
        // Create a new instance of the Firefox driver
        driver = new ChromeDriver();
        driver.get("http://dl.dropbox.com/u/55228056/bmicalculator.html");
    }
    @Test
    public void testBMICalculator() throws Exception {
        System.out.println("height = "+height);
        System.out.println("weight = "+weight);
        System.out.println("bmi = "+bmi);
        System.out.println("bmiCategory = "+bmiCategory);
        System.out.println("___________");



//        try {
//            WebElement heightField = driver.findElement(By.
//                    name("heightCMS"));
//            heightField.clear();
//            heightField.sendKeys(height);
//
//            WebElement weightField = driver.findElement(By.
//                    name("weightKg"));
//            weightField.clear();
//            weightField.sendKeys(weight);
//            WebElement calculateButton = driver.findElement(By.
//                    id("Calculate"));
//            calculateButton.click();
//
//            WebElement bmiLabel = driver.findElement(By.name("bmi"));
//            assertEquals(bmi, bmiLabel.getAttribute("value"));
//
//            WebElement bmiCategoryLabel = driver.findElement(By.name
//                    ("bmi_category"));
//            assertEquals(bmiCategory,bmiCategoryLabel.
//                    getAttribute("value"));
//
//        } catch (Error e) {
//            //Capture and append Exceptions/Errors
//            verificationErrors.append(e.toString());
//            System.err.println("Assertion Fail " + verificationErrors.
//                    toString());
//        }
    }

    @Ignore
    @AfterClass
    public static void tearDown() throws Exception {
        //Close the browser
        driver.quit();

        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

}
