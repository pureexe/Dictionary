package th.in.pureapp.dictionary.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import th.in.pureapp.dictionary.model.Word;

/**
 * Created by pakkapon on 23/11/2560.
 */

public class WordData {
    private SQLiteDatabase database;
    Context context;
    DatabaseAssetsHelper databaseHelper;

    public WordData(Context context){
        this.context = context;
        databaseHelper = new DatabaseAssetsHelper(context);
        database = databaseHelper.getReadableDatabase();
    }
    public List<String> getIndexString(String text){
        List<String> output = new ArrayList<>();
        Cursor cursor;
        char c = 'A';
        try {
            c = text.charAt(1);
        }catch(Exception e){

        }
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            cursor = database.query("english_thai", new String[]{ "search"}, "search LIKE ?",new String[]{text}, "search", "", "search ASC","1000");
            while(cursor.moveToNext()){
                output.add(cursor.getString(cursor.getColumnIndex("search")));
            }
        }else {
            cursor = database.query("thai_english", new String[]{"search"}, "search LIKE ?", new String[]{text}, "search", "", "search ASC", "1000");
            while (cursor.moveToNext()) {
                output.add(cursor.getString(cursor.getColumnIndex("search")));
            }
        }
        return output;
    }
    public Word get(String text){
        Word word = null;
        String tableName = "thai_english";
        char c = 'A';
        try {
            c = text.charAt(0);
        }catch(Exception e){

        }

        Cursor cursor;
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            tableName = "english_thai";
        }
        cursor = database.query(tableName, new String[]{"id","search","result","type","synonym","antonym","relate","define","classifier","sample","tag"}, "search = ?", new String[]{text}, "search", "", "", "1");
        while (cursor.moveToNext()) {
            word = new Word(
                    cursor.getInt(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex("search")),
                    cursor.getString(cursor.getColumnIndex("result")),
                    cursor.getString(cursor.getColumnIndex("type")),
                    cursor.getString(cursor.getColumnIndex("synonym")),
                    cursor.getString(cursor.getColumnIndex("antonym")),
                    cursor.getString(cursor.getColumnIndex("relate")),
                    cursor.getString(cursor.getColumnIndex("define")),
                    cursor.getString(cursor.getColumnIndex("classifier")),
                    cursor.getString(cursor.getColumnIndex("sample")),
                    cursor.getString(cursor.getColumnIndex("tag")),
                    tableName.equals("english_thai")?"english":"ไทย"
            );
        }
        return word;
    }
}
