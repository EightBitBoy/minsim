package de.eightbitboy.minsim.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import org.sufficientlysecure.htmltextview.HtmlTextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import butterknife.ButterKnife;
import de.eightbitboy.minsim.R;

public class ChangelogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changelog);

        Toolbar toolbar = (Toolbar) findViewById(R.id.changelog_toolbar);
        setSupportActionBar(toolbar);

        HtmlTextView htmlTextView = (HtmlTextView) findViewById(R.id.changelog_html);
        htmlTextView.setHtml(readFromFile("changelog.html"));
    }

    private String readFromFile(String fileName) {
        try {
            InputStream in = getAssets().open(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String line;
            StringBuilder builder = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }

            reader.close();
            in.close();

            return builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
