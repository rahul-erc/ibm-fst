import org.testng.annotations.DataProvider;

public class TestNG_Dataprovider {
    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {
        return new Object[][] {
                { "Rahul", "chowdary","rahul@gmail.com","9900389665" },
                { "pooja", "Gowda","pooja@gmail.com","9876567123" },
                {"Shivu","The god","Shivu@gmail.com","9010203040"}
        };
    }
}
