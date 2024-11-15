package br.senac.vaccine.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "vaccine.db";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = """
                CREATE TABLE vacinas (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    nome TEXT NOT NULL,
                    posto TEXT,
                    data TEXT NOT NULL,
                    reforco TEXT
                )
        """;
        db.execSQL(sql);
        Log.d("DBHelper", "Banco de dados criado!");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Atrualização do banco de dados (se necessário)
        db.execSQL("DROP TABLE IF EXISTS vacinas");
        onCreate(db);

    }
}
