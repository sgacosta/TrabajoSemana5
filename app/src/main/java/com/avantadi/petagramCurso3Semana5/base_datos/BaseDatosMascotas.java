package com.avantadi.petagramCurso3Semana5.base_datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.avantadi.petagramCurso3Semana5.R;
import com.avantadi.petagramCurso3Semana5.pojo.Mascota;

import java.util.ArrayList;

public class BaseDatosMascotas extends SQLiteOpenHelper {
    private Context context;

    public BaseDatosMascotas(@Nullable Context context) {
        super(context, BaseDatosMascotasConstantes.DATABASE_NAME, null, BaseDatosMascotasConstantes.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascotas =
                "CREATE TABLE " + BaseDatosMascotasConstantes.TABLE_PETS + " (" +
                        BaseDatosMascotasConstantes.TABLE_PETS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        BaseDatosMascotasConstantes.TABLE_PETS_NOMBRE + " TEXT," +
                        BaseDatosMascotasConstantes.TABLE_PETS_FOTO + " INTEGER," +
                        BaseDatosMascotasConstantes.TABLE_PETS_RATING + " INTEGER" +
                        ")";
        db.execSQL(queryCrearTablaMascotas);
        //se insertan mascotas de ejemplo ....
        insertarMascotasDeEjemplo(db);

    }

    private void insertarMascotasDeEjemplo(SQLiteDatabase db){

        ContentValues contentValues = new ContentValues();

        contentValues.put(BaseDatosMascotasConstantes.TABLE_PETS_NOMBRE,"Minino");
        contentValues.put(BaseDatosMascotasConstantes.TABLE_PETS_RATING,3);
        contentValues.put(BaseDatosMascotasConstantes.TABLE_PETS_FOTO,R.drawable.icons8_cat_100);
        insertarMascota(db,contentValues);

        contentValues.put(BaseDatosMascotasConstantes.TABLE_PETS_NOMBRE,"Gorky");
        contentValues.put(BaseDatosMascotasConstantes.TABLE_PETS_RATING,4);
        contentValues.put(BaseDatosMascotasConstantes.TABLE_PETS_FOTO,R.drawable.icons8_dog_100);
        insertarMascota(db,contentValues);

        contentValues.put(BaseDatosMascotasConstantes.TABLE_PETS_NOMBRE,"Nemo");
        contentValues.put(BaseDatosMascotasConstantes.TABLE_PETS_RATING,1);
        contentValues.put(BaseDatosMascotasConstantes.TABLE_PETS_FOTO,R.drawable.icons8_clown_fish_100);
        insertarMascota(db,contentValues);

        contentValues.put(BaseDatosMascotasConstantes.TABLE_PETS_NOMBRE,"Fritz");
        contentValues.put(BaseDatosMascotasConstantes.TABLE_PETS_RATING,7);
        contentValues.put(BaseDatosMascotasConstantes.TABLE_PETS_FOTO,R.drawable.icons8_german_shepherd_100);
        insertarMascota(db,contentValues);

        contentValues.put(BaseDatosMascotasConstantes.TABLE_PETS_NOMBRE,"Adelantado");
        contentValues.put(BaseDatosMascotasConstantes.TABLE_PETS_RATING,5);
        contentValues.put(BaseDatosMascotasConstantes.TABLE_PETS_FOTO,R.drawable.icons8_horse_100);
        insertarMascota(db,contentValues);

        contentValues.put(BaseDatosMascotasConstantes.TABLE_PETS_NOMBRE,"Rabitt");
        contentValues.put(BaseDatosMascotasConstantes.TABLE_PETS_RATING,3);
        contentValues.put(BaseDatosMascotasConstantes.TABLE_PETS_FOTO,R.drawable.icons8_rabbit_100);
        insertarMascota(db,contentValues);

        contentValues.put(BaseDatosMascotasConstantes.TABLE_PETS_NOMBRE,"Mara");
        contentValues.put(BaseDatosMascotasConstantes.TABLE_PETS_RATING,9);
        contentValues.put(BaseDatosMascotasConstantes.TABLE_PETS_FOTO,R.drawable.icons8_dog_100);
        insertarMascota(db,contentValues);

        contentValues.put(BaseDatosMascotasConstantes.TABLE_PETS_NOMBRE,"Lua");
        contentValues.put(BaseDatosMascotasConstantes.TABLE_PETS_RATING,2);
        contentValues.put(BaseDatosMascotasConstantes.TABLE_PETS_FOTO,R.drawable.icons8_german_shepherd_100);
        insertarMascota(db,contentValues);

        contentValues.put(BaseDatosMascotasConstantes.TABLE_PETS_NOMBRE,"Ron");
        contentValues.put(BaseDatosMascotasConstantes.TABLE_PETS_RATING,6);
        contentValues.put(BaseDatosMascotasConstantes.TABLE_PETS_FOTO,R.drawable.icons8_dog_100);
        insertarMascota(db,contentValues);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + BaseDatosMascotasConstantes.TABLE_PETS);
        onCreate(db);
    }

    public void insertarMascota(SQLiteDatabase db,ContentValues contentValues) {
        db.insert(BaseDatosMascotasConstantes.TABLE_PETS, null, contentValues);
    }

    //agrega un like y retorna el objeto mascoca modificado
    public Mascota agregarLikeAMascota(Mascota mascota) {
        Mascota mascotaResultado = new Mascota();
        SQLiteDatabase db = this.getWritableDatabase();

        //consulta para incfrementar en 1 el rating
        String query = "UPDATE " + BaseDatosMascotasConstantes.TABLE_PETS + " SET " +
                BaseDatosMascotasConstantes.TABLE_PETS_RATING + " = " + BaseDatosMascotasConstantes.TABLE_PETS_RATING + " + 1 " +
                "WHERE " + BaseDatosMascotasConstantes.TABLE_PETS_ID + " = " + String.valueOf(mascota.getId());
        db.execSQL(query);

        //consulta para obtener el rating
        query = "SELECT * " +
                "FROM " + BaseDatosMascotasConstantes.TABLE_PETS + " " +
                "WHERE " + BaseDatosMascotasConstantes.TABLE_PETS_ID + " = " + String.valueOf(mascota.getId());
        Cursor registros = db.rawQuery(query, null);
        while (registros.moveToNext()) {
            //he creado un constructor de Mascota sin parámetros
            Mascota mascotaEsteRegistro = new Mascota();

            //se estbalce el contenido
            mascotaEsteRegistro.setId(registros.getInt(registros.getColumnIndex(BaseDatosMascotasConstantes.TABLE_PETS_ID)));
            mascotaEsteRegistro.setNombre(registros.getString(registros.getColumnIndex(BaseDatosMascotasConstantes.TABLE_PETS_NOMBRE)));
            mascotaEsteRegistro.setRating(registros.getInt(registros.getColumnIndex(BaseDatosMascotasConstantes.TABLE_PETS_RATING)));
            mascotaEsteRegistro.setFoto(registros.getInt(registros.getColumnIndex(BaseDatosMascotasConstantes.TABLE_PETS_FOTO)));

            mascotaResultado = mascotaEsteRegistro;
        }

        db.close();
        return mascotaResultado;
    }

    //obtener las 5 mascotas con el rating más alto
    public ArrayList<Mascota> obtenerLas5MascotasConMasRating() {
        ArrayList<Mascota> mascotas5MasRating = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        //las 5 mascotas má votadas: se ordenan por rating y luego se seleccionan sólo las 5 primeras
        String query = "SELECT * FROM " + BaseDatosMascotasConstantes.TABLE_PETS + " ORDER BY " + BaseDatosMascotasConstantes.TABLE_PETS_RATING + " DESC LIMIT 5";

        Cursor registros = db.rawQuery(query, null);
        while (registros.moveToNext()) {
            //he creado un constructor de Mascota sin parámetros
            Mascota mascotaEsteRegistro = new Mascota();

            //se estbalce el contenido
            mascotaEsteRegistro.setId(registros.getInt(registros.getColumnIndex(BaseDatosMascotasConstantes.TABLE_PETS_ID)));
            mascotaEsteRegistro.setNombre(registros.getString(registros.getColumnIndex(BaseDatosMascotasConstantes.TABLE_PETS_NOMBRE)));
            mascotaEsteRegistro.setRating(registros.getInt(registros.getColumnIndex(BaseDatosMascotasConstantes.TABLE_PETS_RATING)));
            mascotaEsteRegistro.setFoto(registros.getInt(registros.getColumnIndex(BaseDatosMascotasConstantes.TABLE_PETS_FOTO)));

            //se agrega al ArrayList
            mascotas5MasRating.add(mascotaEsteRegistro);
        }

        db.close();

        return mascotas5MasRating;
    }

    //obtener todas las mascotas
    public ArrayList<Mascota> obtenerTodasLasMascotas() {
        ArrayList<Mascota> mascotas = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        //las 10 primeras: se seleccionan sólo las 10 primeras
        String query = "SELECT * FROM " + BaseDatosMascotasConstantes.TABLE_PETS;

        Cursor registros = db.rawQuery(query, null);
        while (registros.moveToNext()) {
            //he creado un constructor de Mascota sin parámetros
            Mascota mascotaEsteRegistro = new Mascota();

            //se estbalce el contenido
            mascotaEsteRegistro.setId(registros.getInt(registros.getColumnIndex(BaseDatosMascotasConstantes.TABLE_PETS_ID)));
            mascotaEsteRegistro.setNombre(registros.getString(registros.getColumnIndex(BaseDatosMascotasConstantes.TABLE_PETS_NOMBRE)));
            mascotaEsteRegistro.setRating(registros.getInt(registros.getColumnIndex(BaseDatosMascotasConstantes.TABLE_PETS_RATING)));
            mascotaEsteRegistro.setFoto(registros.getInt(registros.getColumnIndex(BaseDatosMascotasConstantes.TABLE_PETS_FOTO)));

            //se agrega al ArrayList
            mascotas.add(mascotaEsteRegistro);
        }

        db.close();

        return mascotas;
    }

    //especial: obtiene 5 mascotas pero retorna todas con la misma imagen ... para el perfil
    public ArrayList<Mascota> obtenerTodasLasMascotasParaPerfil(int fotoDrawableId) {
        //para simplificar, aquí se retornan la 10 primeras mascotas y se establece en todas la misma foto y sin nombre ...
        ArrayList<Mascota> mascotas = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        //las 10 primeras: se seleccionan sólo las 10 primeras
        String query = "SELECT * FROM " + BaseDatosMascotasConstantes.TABLE_PETS + " LIMIT 5";

        Cursor registros = db.rawQuery(query, null);
        while (registros.moveToNext()) {
            //he creado un constructor de Mascota sin parámetros
            Mascota mascotaEsteRegistro = new Mascota();

            //se estbalce el contenido
            mascotaEsteRegistro.setId(registros.getInt(registros.getColumnIndex(BaseDatosMascotasConstantes.TABLE_PETS_ID)));
            mascotaEsteRegistro.setNombre("");
            mascotaEsteRegistro.setRating(registros.getInt(registros.getColumnIndex(BaseDatosMascotasConstantes.TABLE_PETS_RATING)));
            //...para el perfil ....
            mascotaEsteRegistro.setFoto(fotoDrawableId);

            //se agrega al ArrayList
            mascotas.add(mascotaEsteRegistro);
        }

        db.close();

        return mascotas;
    }
}
