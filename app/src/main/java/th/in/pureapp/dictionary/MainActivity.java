package th.in.pureapp.dictionary;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.List;

import th.in.pureapp.dictionary.activity.WordActivity;
import th.in.pureapp.dictionary.adapter.IndexAdapter;
import th.in.pureapp.dictionary.database.WordData;

public class MainActivity extends Activity {
    private WordData wordData;
    private List<String> indexData;
    private ArrayAdapter indexAdapter;
    private ListView listView;
    private RelativeLayout infoView;
    private boolean isShowInfo = true;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.index_listview);
        wordData = new WordData(this);
        indexAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1);
        infoView = (RelativeLayout) findViewById(R.id.info_relative_view);
        listView.setAdapter(indexAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String word = (String) indexAdapter.getItem(i);
                Intent intent = new Intent(getApplicationContext(), WordActivity.class);
                intent.putExtra("word",word);
                startActivity(intent);
            }
        });
        ImageView imageView = (ImageView) findViewById(R.id.search_magnify_icon);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchView.setIconified(false);
                searchView.requestFocusFromTouch();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        MenuItem searchItem = menu.findItem(R.id.app_bar_search);
        searchView = (SearchView) searchItem.getActionView();
        searchView.setMaxWidth( Integer.MAX_VALUE );
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                String query = "%";
                if(!s.equals("")){

                    query = "%"+s+"%";
                    indexAdapter.clear();
                    indexAdapter.addAll(wordData.getIndexString(query));
                    indexAdapter.notifyDataSetChanged();
                    if(isShowInfo == true){
                        infoView.setVisibility(View.GONE);
                        listView.setVisibility(View.VISIBLE);
                        isShowInfo = false;
                    }
                }else{
                    if(isShowInfo == false){
                        infoView.setVisibility(View.VISIBLE);
                        listView.setVisibility(View.GONE);
                        isShowInfo = true;
                    }
                }
                return false;
            }
        });

        return true;
    }
}
