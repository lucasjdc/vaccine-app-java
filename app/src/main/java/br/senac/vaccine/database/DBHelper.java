package br.senac.vaccine.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "vaccine.db";
    private static final int DATABASE_VERSION = 2;

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
                    reforco TEXT,
                    codigo_usuario TEXT NOT NULL
                )
                """;
        db.execSQL(sql);
        Log.d("DBHelper", "Tabela 'vacinas' criada com sucesso.");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("DBHelper", "Atualizando banco de dados da versão " + oldVersion + " para " + newVersion);

        if (oldVersion < 2) {
            db.execSQL("ALTER TABLE vacinas ADD COLUMN codigo_usuario TEXT");
            Log.d("DBHelper", "Campo 'codigo_usuario' adicionado à tabela 'vacinas'.");
        }
    }
}


