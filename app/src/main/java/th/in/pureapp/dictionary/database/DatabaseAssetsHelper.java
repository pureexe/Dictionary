package th.in.pureapp.dictionary.database;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by pakkapon on 23/11/2560.
 */

public class DatabaseAssetsHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "dictionary.db";
    private static final int DATABASE_VERSION = 1;
    public DatabaseAssetsHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
