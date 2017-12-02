package th.in.pureapp.dictionary.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import th.in.pureapp.dictionary.R;
import th.in.pureapp.dictionary.database.WordData;
import th.in.pureapp.dictionary.model.Word;

public class WordActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);
        ActionBar actionBar = getActionBar();
        Intent intent = getIntent();
        String word = intent.getStringExtra("word");
        actionBar.setTitle(word);
        actionBar.setDisplayHomeAsUpEnabled(true);
        WordData wordData = new WordData(this);
        Word result = wordData.get(word);
        TextView searchTextView = (TextView) findViewById(R.id.search_textview);
        TextView resultTextView = (TextView) findViewById(R.id.result_textview);
        TextView typeTextView = (TextView) findViewById(R.id.type_textview);
        TextView synonymTextView = (TextView) findViewById(R.id.synonym_textview);
        TextView antonymTextView = (TextView) findViewById(R.id.antonym_textview);
        TextView relateTextView = (TextView) findViewById(R.id.relate_textview);
        TextView defineTextView = (TextView) findViewById(R.id.define_textview);
        TextView classifierTextView = (TextView) findViewById(R.id.classifier_textview);
        TextView sampleTextView = (TextView) findViewById(R.id.sample_textview);
        TextView tagTextView = (TextView) findViewById(R.id.tag_textview);
        if(result != null){
            setTextResult(searchTextView,result.getSearch(),getString(R.string.prefix_search));
            setTextResult(resultTextView,result.getResult(),getString(R.string.prefix_result));
            setTextResult(typeTextView,getTypeABBR(result.getType()),getString(R.string.prefix_type));
            setTextResult(synonymTextView,result.getSynonym(),getString(R.string.prefix_synonym));
            setTextResult(antonymTextView,result.getAntonym(),getString(R.string.prefix_antonym));
            setTextResult(relateTextView,result.getRelate(),getString(R.string.prefix_relate));
            setTextResult(defineTextView,result.getDefine(),getString(R.string.prefix_define));
            setTextResult(classifierTextView,result.getClassifier(),getString(R.string.prefix_classifier));
            setTextResult(sampleTextView,result.getSample(),getString(R.string.prefix_sample));
            setTextResult(tagTextView,result.getTag(),getString(R.string.prefix_tag));
        }
    }
    private void setTextResult(TextView textView, String data,String prefix){
        if(data == null){
            textView.setVisibility(View.GONE);
        }else{
            textView.setVisibility(View.VISIBLE);
        }
        textView.setText(prefix+" "+data);
    }
    private String getTypeABBR(String data){
        if(data == null){
            return null;
        }
        if(data.equals("vi,vt")){
            return getString(R.string.type_vivt);
        }
        String out = getStringResourceByName("type_"+data.toLowerCase());
        if(out != null){
            return out;
        }
        return data;
    }
    private String getStringResourceByName(String aString) {
        String packageName = getPackageName();
        int resId = getResources().getIdentifier(aString, "string", packageName);
        if(resId == 0){
            return null;
        }
        return getString(resId);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home ){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
