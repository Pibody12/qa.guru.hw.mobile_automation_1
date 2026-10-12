package helpers;

import static io.restassured.RestAssured.given;

public class BrowserStack {

    public static String videoUrl(String sessionId) {
        String url = String.format("https://api-cloud.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic("drobotenkotimofe_aFRH7J", "XQqGSSo1oR5sYnBJJGnf")
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
