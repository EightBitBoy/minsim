package de.eightbitboy.minsim.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import org.sufficientlysecure.htmltextview.HtmlTextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import de.eightbitboy.minsim.R;

public class HtmlActivity extends AppCompatActivity {

	private static final String EXTRA_HTML_FILE_NAME = "EXTRA_HTML_FILE_NAME";

	public static Intent getStartIntent(Context context, String htmlFileName){
		Intent intent = new Intent(context, HtmlActivity.class);
		intent.putExtra(EXTRA_HTML_FILE_NAME, htmlFileName);
		return intent;
	}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html);

        Toolbar toolbar = (Toolbar) findViewById(R.id.changelog_toolbar);
        setSupportActionBar(toolbar);

        HtmlTextView htmlTextView = (HtmlTextView) findViewById(R.id.changelog_html);
        htmlTextView.setHtml(readFromFile(getIntent().getStringExtra(EXTRA_HTML_FILE_NAME)));
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
