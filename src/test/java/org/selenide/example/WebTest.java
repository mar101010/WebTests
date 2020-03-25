package org.selenide.example;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class WebTest {
    @Test
    public void userCanLoginByUsername() {
        open("/login");
        $(By.name("user.name")).setValue("johny");
        $("#submit").click();
        $(".loading_progress").should(disappear); // Waits until element disappears
        $("#username").shouldHave(text("Hello, Johny!")); // Waits until element gets text
    }

    @Test
    public void userCanSearchKeywordWithGoogle() {
        // Initialize browser
        //System.setProperty("webdriver.chrome.driver", "C:/Users/MarinaPv/Downloads/chromedriver_win32/chromedriver.exe");
        //WebDriver driver=new ChromeDriver();
        //driver.get("http://www.google.com");
        System.setProperty("webdriver.chrome.driver", "C:/Users/MarinaPv/Downloads/chromedriver_win32/chromedriver.exe");
        System.setProperty("selenide.browser", "Chrome");
        open("http://google.com");
        $(By.name("q")).setValue("Selenide").pressEnter();
        $$("#res div.rc").shouldHaveSize(7);
        $("#res div.rc",0).shouldHave(text("selenide"));
    }


    @Test
    public void userCanOpenGoogleSearchResult() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/MarinaPv/Downloads/chromedriver_win32/chromedriver.exe");
        System.setProperty("selenide.browser", "Chrome");
        open("http://google.com");
        $(By.name("q")).setValue("Wild cats").pressEnter();
        $(".rc h3", 5).click();
        $(".infobox.biota.biota-infobox tr", 5).$("a").shouldHave(text("Conservation status"));
        System.out.println();
    }


    @Test
    public void userCanLogin() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/MarinaPv/Downloads/chromedriver_win32/chromedriver.exe");
        System.setProperty("selenide.browser", "Chrome");
        open("https://www.myfitness.ee/");
        $(".link-login").click();
        $("#login-field-username").setValue("Viktoria");
        $("#login-field-password").setValue("12345");
        $(".btn.form-group.login-form").click();//complete
        //$(".item p",2).$("a").click();;
        // $(".rc h3", 5).click();
        //$(".infobox.biota.biota-infobox tr", 5).$("a").shouldHave(text("Conservation status"));
        System.out.println();
    }

}
