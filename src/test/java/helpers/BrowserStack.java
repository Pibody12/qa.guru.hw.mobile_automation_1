package helpers;

import static io.restassured.RestAssured.given;

public class BrowserStack {

    // curl -u "bsuser_wRTViP:zHJ52YppsoNf9U4pYaTz" -X GET "https://api-cloud.browserstack.com/app-automate/sessions/c5d7b61827647e396447c63a755614eb0e4d3f18.json"
    // automation_session.video_url

    public static String videoUrl(String sessionId) {
        String url = String.format("https://api-cloud.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic("bsuser_wRTViP", "zHJ52YppsoNf9U4pYaTz")
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
