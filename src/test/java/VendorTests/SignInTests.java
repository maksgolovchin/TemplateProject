package VendorTests;

import com.template.steps.vendorSteps.LoginSteps;
import com.template.testng.BaseTest;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

import static com.template.props.Properties.props;
import static com.template.utlis.Brands.existingBrand;
import static com.template.utlis.RandomUtils.getRandomGmail;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

@Feature("Login with magick link")
public class SignInTests extends BaseTest {

    @Test(groups = "SmokeTests", testName = "loginWithMagicLinkWithNotRegisteredEmail", description = "User should see success screen after sign in with magic link using not registered email ")
    public void loginWithMagicLinkWithNotRegisteredEmail() {
        String email = getRandomGmail();
        openLoginPage(props.url())
                .requestMagicLink(email)
                .shouldSeeSuccessMagickLinkScreen(email);
    }

    @Test(groups = "SmokeTests", testName = "userCantLoginWithWrongPassword", description = "User should see error when trying to login with wrong password")
    public void userCantLoginWithWrongPassword() {
        LoginSteps loginSteps = openLoginPage(props.url());
        loginSteps.login(existingBrand.getWorkEmail(), randomAlphabetic(7));
        loginSteps.shouldSeeWrongPasswordMessage();

    }

    @Test(priority = 9, groups = "SmokeTests", testName = "forgotPassword", description = "User should see success page when trying to reset password using not registered email")
    public void forgotPassword() {
        String email = getRandomGmail();
        LoginSteps loginSteps = openLoginPage(props.url());
        loginSteps.requestPasswordReset(email);
        loginSteps.shouldSeeSuccessResetPasswordScreen(email);
    }
}
