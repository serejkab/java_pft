package ru.stqa.pft.rest;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.testng.SkipException;

import java.io.IOException;

/**
 * Created by SerejKa on 07.06.2017.
 */
public class TestBase {

    public void skipIfNotFixed(int issueId) throws IOException {
        if (isIssueOpen(issueId)) {
            throw new SkipException("Ignored because of issue " + issueId);
        }
    }

    private boolean isIssueOpen(int issueId) throws IOException {
        String json = getExecutor().execute(Request.Get(String.format(("http://demo.bugify.com/api/issues/%s.json"), issueId)))
                .returnContent().asString();
        JsonElement parsed = new JsonParser().parse(json);
        JsonElement issues = parsed.getAsJsonObject().get("issues").getAsJsonArray().get(0);
        JsonElement state = issues.getAsJsonObject().get("state");

        if (state.getAsInt() == 2 || state.getAsInt() == 3){
            return false;
        } else {
            return true;
        }

    }



    private Executor getExecutor() {
        return Executor.newInstance().auth("LSGjeU4yP1X493ud1hNniA==", "");
    }
}
