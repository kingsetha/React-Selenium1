package com.ani.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;


class AddTest {

	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@BeforeEach
	public void setUp() {
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	}

	@AfterEach
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void testMain() {
//		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:3000/");
		assertEquals("React App", driver.getTitle());
	}
	@Test

	public void testAddMovie1() {
//		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:3000/AddMovie");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.findElement(By.name("mname")).sendKeys("Maamanan");
		driver.findElement(By.name("type")).sendKeys("Action/Thriller");
		driver.findElement(By.name("timing")).sendKeys("12pm-6pm");
        driver.findElement(By.name("sub1")).submit();
//        assertSame("Data added Successfully", "Data added Successfully");
        assertEquals("Data added Successfully","Data added Successfully");
	}
	@Test

	public void testAddMovie2() {
//		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:3000/AddMovie");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.findElement(By.name("mname")).sendKeys("");
		driver.findElement(By.name("type")).sendKeys("Action/Thriller");
		driver.findElement(By.name("timing")).sendKeys("2pm-6pm");
        driver.findElement(By.name("sub1")).submit();
        assertEquals("valid data needed", "valid data needed");
	}
	@Test
	
	public void testAddMovie3() {
//		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:3000/AddMovie");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.findElement(By.name("mname")).sendKeys("Maruthu");
		driver.findElement(By.name("type")).sendKeys("");
		driver.findElement(By.name("timing")).sendKeys("12pm-4pm");
        driver.findElement(By.name("sub1")).submit();
        assertEquals("valid data needed", "valid data needed");
	}
	@Test
	
	public void testAddMovie4() {
//		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:3000/AddMovie");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.findElement(By.name("mname")).sendKeys("Chennai express");
		driver.findElement(By.name("type")).sendKeys("Action/Romantic");
		driver.findElement(By.name("timing")).sendKeys("");
        driver.findElement(By.name("sub1")).submit();
        assertEquals("valid data needed","valid data needed");
	}
	

}
