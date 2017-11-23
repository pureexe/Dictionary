package th.in.pureapp.dictionary.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
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
            searchTextView.setText("คำค้นหา: "+result.getSearch());
            resultTextView.setText("คำแปล: "+ result.getResult());
            typeTextView.setText("ประเภทคำ: "+result.getType());
            synonymTextView.setText("คำคล้ายกัน: "+result.getSynonym());
            antonymTextView.setText("คำตรงข้าม: "+result.getAntonym());
            relateTextView.setText("คำที่เกี่ยวข้อง: "+result.getRelate());
            defineTextView.setText("ความหมาย: "+result.getDefine());
            classifierTextView.setText("ลักษณะนาม: "+result.getClassifier());
            sampleTextView.setText("ตัวอย่างประโยค: "+result.getSample());
            tagTextView.setText("แท็ก: "+result.getTag());
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home ){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
