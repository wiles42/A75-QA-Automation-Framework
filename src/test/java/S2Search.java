import org.testng.Assert;
import org.testng.annotations.Test;
import pom.LoginPage;

/**
 * @author wiles42
 */
public class S2Search extends BaseTest {
    @Test(priority = 1)
    public void epicSong() {
        LoginPage loginPage = new LoginPage(driver);
        pom.S2Search s2Search = new pom.S2Search(driver);

        loginPage.login();
        s2Search.inputSong();
        Assert.assertTrue(s2Search.verifyEpic());
        Assert.assertTrue(s2Search.nullAlbum());
        Assert.assertTrue(s2Search.nullAlbum());
    }


    @Test(priority = 2)
    public void pinkFloyd() {
        LoginPage loginPage = new LoginPage(driver);
        pom.S2Search s2Search = new pom.S2Search(driver);

        loginPage.login();
        s2Search.inputPink();
        Assert.assertTrue(s2Search.nullSong());
        Assert.assertTrue(s2Search.nullArtist());
        Assert.assertTrue(s2Search.nullAlbum());
    }
    @Test(priority = 3)
    public void spaceSong(){
        LoginPage loginPage = new LoginPage(driver);
        pom.S2Search s2Search = new pom.S2Search(driver);

        loginPage.login();
        s2Search.inputSpaceSong();
        Assert.assertTrue(s2Search.verifyEpic());
        Assert.assertTrue(s2Search.nullArtist());
        Assert.assertTrue(s2Search.nullAlbum());
    }
    @Test (priority = 4)
    public void deleteSong(){
        LoginPage loginPage = new LoginPage(driver);
        pom.S2Search s2Search = new pom.S2Search(driver);

        loginPage.login();
        s2Search.inputSpaceSong();
        Assert.assertTrue(s2Search.clearSearch());

    }
}