package com.sanj.amaze.youtube;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.sanj.amaze.R;
import com.squareup.picasso.Picasso;
import java.util.List;

import android.widget.SearchView;

public class SearchActivity extends AppCompatActivity {

    //member variables
    private EditText searchInput;
    private ListView videosFound;
    private Handler handler;
    private List<VideoItem> searchResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchyt);

        searchInput = findViewById(R.id.search_input);
        videosFound = findViewById(R.id.list_view);
        handler = new Handler();

        //listen for user input
        searchInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    searchOnYoutube(textView.getText().toString());
                    return false;
                }
                return true;
            }
        });
        addClickListener();
    }

    //perform search on background thread
    private void searchOnYoutube(final String keywords){
        new Thread(){
            public void run(){
                YoutubeConnector yc = new YoutubeConnector(SearchActivity.this);
                searchResults = yc.search(keywords);
                handler.post(new Runnable(){
                    public void run(){
                        updateVideosFound();
                    }
                });
            }
        }.start();
    }

    private void updateVideosFound(){
        ArrayAdapter<VideoItem> adapter = new ArrayAdapter<VideoItem>(getApplicationContext(), R.layout.video_item, searchResults){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if(convertView == null){
                    convertView = getLayoutInflater().inflate(R.layout.video_item, parent, false);
                }
                ImageView thumbnail = convertView.findViewById(R.id.video_thumbnail);
                TextView title = convertView.findViewById(R.id.video_title);
                TextView description = convertView.findViewById(R.id.video_description);

                VideoItem searchResult = searchResults.get(position); //

                Picasso.with(getApplicationContext()).load(searchResult.getThumbnailURL()).into(thumbnail);
                title.setText(searchResult.getTitle());
                description.setText(searchResult.getDescription());
                return convertView;
            }
        };

        videosFound.setAdapter(adapter);
    }
    private void addClickListener(){
        videosFound.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplication(), PlayerActivity.class);
                intent.putExtra("VIDEO_ID", searchResults.get(position).getId());
                startActivity(intent);
            }
        });
    }

}//class


































