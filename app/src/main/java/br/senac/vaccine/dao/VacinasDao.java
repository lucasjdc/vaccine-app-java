package br.senac.vaccine.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import br.senac.vaccine.database.DBHelper;
import br.senac.vaccine.model.Vacina;

public class VacinasDao {

    private final DBHelper dbHelper;

    public VacinasDao(DBHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    public List<Vacina> buscaTodos() {
        List<Vacina> vacinas = new ArrayList<>();
        SQLiteDatabase db = null;
        Cursor cursor = null;
        try {
            db = dbHelper.getReadableDatabase();
            String query = "SELECT * FROM vacinas";
            cursor = db.rawQuery(query, null);

            if (cursor.moveToFirst()) {
                do {
                    Vacina vacina = new Vacina(
                            cursor.getInt(cursor.getColumnIndexOrThrow("id")),
                            cursor.getString(cursor.getColumnIndexOrThrow("nome")),
                            cursor.getString(cursor.getColumnIndexOrThrow("posto")),
                            cursor.getString(cursor.getColumnIndexOrThrow("data")),
                            cursor.getString(cursor.getColumnIndexOrThrow("reforco"))
                    );
                    vacinas.add(vacina);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) cursor.close();
            if (db != null) db.close();
        }
        return vacinas;
    }

    public long adiciona(Vacina vacina) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("nome", vacina.getNomeVacina());
        values.put("posto", vacina.getPosto());
        values.put("data", vacina.getData());
        values.put("reforco", vacina.getReforco());

        long id = db.insert("vacinas", null, values);
        db.close();
        return id;
    }

    public void limparVacinas() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete("vacinas", null, null);
        db.close();
    }

}
