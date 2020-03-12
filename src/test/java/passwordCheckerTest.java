import org.junit.Assert;
import org.junit.Test;



public class passwordCheckerTest {

    @Test
    public void passwordIsValid() throws passwordException {
        Assert.assertTrue(passwordChecker.passwordIsValid("passsssssA\"3"));
    }

    @Test
    public void passwordIsOk() {
        Assert.assertTrue(passwordChecker.passwordIsOk());
    }
}