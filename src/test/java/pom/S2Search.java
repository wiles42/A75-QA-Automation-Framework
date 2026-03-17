package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

/**
 * @author wiles42
 */
public class S2Search extends BasePage {
    public S2Search(WebDriver givenDriver) {
        super(givenDriver);
    }

    By searchBar = By.xpath("//input[@type='search']");
    By epicSong = By.xpath("//span[contains(@class,'details') and contains(normalize-space(.), 'Epic Song')]");
    By artistNull = By.xpath("//section[@class='artists']//p[contains(text(),'None found')]");
    By albumsNull = By.xpath("//section[@class='albums']//p[contains(text(),'None found')]");
    By songNull = By.xpath("//section[@class='songs']//p[contains(text(), 'None found')]");


    public void inputSong() {
        presenceOfElement(searchBar);
        findElement(searchBar).sendKeys("Song");
    }

    public void inputPink() {
        presenceOfElement(searchBar);
        findElement(searchBar).sendKeys("Pink Flyod");
    }

    public void inputSpaceSong() {
        presenceOfElement(searchBar);
        findElement(searchBar).sendKeys(Keys.SPACE, "Song");

    }

    public boolean verifyEpic() {
        return findElement(epicSong).isDisplayed();

    }

    public boolean nullArtist() {
        return findElement(artistNull).isDisplayed();

    }

    public boolean nullAlbum() {
        return findElement(albumsNull).isDisplayed();

    }

    public boolean nullSong() {
        return findElement(songNull).isDisplayed();

    }

    public boolean clearSearch() {
        WebElement search = findElement(searchBar);
        search.sendKeys("Song");
        search.sendKeys(Keys.chord(Keys.COMMAND,"a"));
        search.sendKeys(Keys.DELETE);
        return wait.until(driver -> Objects.requireNonNull(search.getAttribute("value")).isEmpty());

    }


}
