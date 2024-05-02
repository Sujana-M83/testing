package com.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Moneycontrol {
    @Test
    public void test1() throws InterruptedException
    {
        
        WebDriverManager.chromedriver().setup();
        WebDriver driver  = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.moneycontrol.com/");
       
       driver.findElement(By.xpath("//*[@id='search_str']")).sendKeys("Reliance Industries");
        Thread.sleep(3000);
       
        driver.findElement(By.xpath("//*[@id='autosuggestlist']/ul/li[1]/a")).click();
       
        Actions actions  = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//*[@id='common_header']/div[1]/div[3]/nav/div/ul/li[10]/a/span"));
        actions.moveToElement(element).perform();
        Thread.sleep(3000);
        
        driver.findElement(By.xpath("//*[@id='common_header']/div[1]/div[3]/nav/div/ul/li[10]/div/div/ul/li[2]/ul/li[5]/a")).click();
        
        WebElement element1 = driver.findElement(By.xpath("//*[@id='ff_id']"));
        Select select = new Select(element1);
        select.selectByValue("AA");
       
        WebElement element2 = driver.findElement(By.xpath("//*[@id='im_id']"));
        select = new Select(element2);
        select.selectByValue("MAA586");
        
        driver.findElement(By.xpath("//*[@id='invamt']")).sendKeys("100000");
        
        driver.findElement(By.xpath("//*[@id='stdt']")).sendKeys("2021-08-02");
        driver.findElement(By.xpath("//*[@id='endt']")).sendKeys("2023-08-17");
        driver.findElement(By.xpath("//*[@id='mc_mainWrapper']/div[2]/div/div[3]/div[2]/div[2]/form/div[8]/input")).click();
       
        String invpr = driver.findElement(By.xpath("//*[@id='mc_mainWrapper']/div[2]/div/div[3]/div[2]/div[5]/table/tbody/tr[1]/td[2]")).getText();
        String tai = driver.findElement(By.xpath("//*[@id='mc_mainWrapper']/div[2]/div/div[3]/div[2]/div[5]/table/tbody/tr[3]/td[2]")).getText();
        System.out.println(invpr);
        System.out.println(tai);
        
        
    }
}
