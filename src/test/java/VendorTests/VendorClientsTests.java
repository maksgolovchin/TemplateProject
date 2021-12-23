package VendorTests;

import com.template.testng.BaseTest;
import com.template.utlis.softAssertions.MultipleStepSoftAssertion;
import io.qameta.allure.Issue;
import org.testng.annotations.Test;

import static com.template.props.Credentials.creds;
import static com.template.props.Properties.props;
import static com.template.utlis.Brands.enabledBrand;
import static com.template.utlis.Brands.existingBrand;

public class VendorClientsTests extends BaseTest {

    @Test(groups = "SmokeTests", testName = "emptyClientsAccounts", description = "Check empty clients accounts page")
    public void emptyClientsAccounts() {
        openLoginPage(props.url())
                .login(existingBrand.getWorkEmail(), creds.password())
                .openClients()
                .shouldNotSeeClients();
    }

    @Issue("https://gitlab.com/cora2/cora-issues/-/issues/394")
    @Test(groups = "SmokeTests", testName = "clientsSorting", description = "Clients accounts sorting")
    public void clientsSorting() {
        MultipleStepSoftAssertion softAssertionInstance = new MultipleStepSoftAssertion();

        openLoginPage(props.url())
                .login(enabledBrand.getWorkEmail(), creds.password())
                .openClients()
                .shouldSeeClientsSortedByDateSoft(softAssertionInstance, true)
                .selectSorting("Date Added: Old to New")
                .shouldSeeClientsSortedByDateSoft(softAssertionInstance,false)
                .selectSorting("Firm Name: A to Z")
                .shouldSeeClientsSortedByFirmNameSoft(softAssertionInstance,true)
                .selectSorting("Firm Name: Z to A")
                .shouldSeeClientsSortedByFirmNameSoft(softAssertionInstance,false);
    }
}
