package th.in.pureapp.dictionary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import th.in.pureapp.dictionary.R;
import th.in.pureapp.dictionary.model.Word;

/**
 * Created by pakkapon on 23/11/2560.
 */

public class IndexAdapter extends ArrayAdapter {
    private final Context context;
    private final int resource;
    private List<Word> words;
    public IndexAdapter(Context context, int resource,List wordList) {
        super(context, resource, wordList);
        words = wordList;
        this.context = context;
        this.resource = resource;
    }
    @Override
    public View getView(int position,View convertView,  ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        LayoutInflater layout = LayoutInflater.from(context);
        View view = layout.inflate(this.resource,null);
        Word word = (Word) this.words.get(position);
        TextView nameView = (TextView) view.findViewById(android.R.id.text1);
        nameView.setText(word.getSearch());
        return view;
    }
}
