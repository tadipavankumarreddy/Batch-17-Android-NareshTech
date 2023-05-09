package in.nareshtech.jokes_asynctask;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class FetchJoke extends AsyncTask<String,Void,String> {

    private ProgressBar mProgressBar;
    private TextView mTextView;

    public FetchJoke(ProgressBar mProgressBar, TextView mTextView) {
        this.mProgressBar = mProgressBar;
        this.mTextView = mTextView;
    }

    // This method runs on WorkerThread - You should not access UI
    @Override
    protected String doInBackground(String... strings) {
        String link = strings[0];
        try {
            URL url = new URL(link);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            InputStream is = connection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = "";
            StringBuilder sb = new StringBuilder();
            while((line=br.readLine())!=null){
                sb.append(line);
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // This method is called after doinbackground(..) and runs on Main thread
    // so you can access the UI
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        mProgressBar.setVisibility(View.INVISIBLE);
        try {
            JSONObject obj = new JSONObject(s);
            String joke = obj.getString("value");
            mTextView.setText(joke);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}



/**
 * AsyncTask<String, Void, String>
 *     First "String" is the input type of doInBackground(...)
 *     Secondly "Void" is for the return type of publishProgress(...) method
 *     Third one "String" is the input type of onPostExecute(...) method*/