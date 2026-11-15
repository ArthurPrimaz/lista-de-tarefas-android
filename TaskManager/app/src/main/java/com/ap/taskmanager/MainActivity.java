package com.ap.taskmanager;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etTitle, etDescription;
    Button btnAdd;
    ListView listView;

    DatabaseHelper db;
    ArrayList<String> lista;
    ArrayAdapter<String> adapter;

    String idSelecionado = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitle = findViewById(R.id.etTitle);
        etDescription = findViewById(R.id.etDescription);
        btnAdd = findViewById(R.id.btnAdd);
        listView = findViewById(R.id.listView);

        db = new DatabaseHelper(this);
        lista = new ArrayList<>();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista);
        listView.setAdapter(adapter);

        carregarDados();

        btnAdd.setOnClickListener(v -> {
            String titulo = etTitle.getText().toString();
            String descricao = etDescription.getText().toString();

            if (idSelecionado == null) {
                boolean inserido = db.insertData(titulo, descricao);
                if (inserido) Toast.makeText(this, "Inserido", Toast.LENGTH_SHORT).show();
            } else {
                db.updateData(idSelecionado, titulo, descricao);
                idSelecionado = null;
                btnAdd.setText("Adicionar");
            }

            limparCampos();
            carregarDados();
        });

        listView.setOnItemClickListener((parent, view, position, id) -> {

            String item = lista.get(position);
            String[] partes = item.split(" \\| ");

            String idItem = partes[0];
            String titulo = partes[1];
            String descricao = partes[2];

            String[] opcoes = {"Editar", "Excluir"};

            new AlertDialog.Builder(this)
                    .setTitle("Escolha uma opção")
                    .setItems(opcoes, (dialog, which) -> {

                        if (which == 0) {
                            etTitle.setText(titulo);
                            etDescription.setText(descricao);
                            idSelecionado = idItem;
                            btnAdd.setText("Salvar");
                        }

                        if (which == 1) {
                            db.deleteData(idItem);
                            carregarDados();
                            Toast.makeText(this, "Excluído", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .show();
        });
    }

    private void carregarDados() {
        lista.clear();
        Cursor cursor = db.getAllData();

        if (cursor.moveToFirst()) {
            do {
                String id = cursor.getString(0);
                String titulo = cursor.getString(1);
                String descricao = cursor.getString(2);

                lista.add(id + " | " + titulo + " | " + descricao);

            } while (cursor.moveToNext());
        }

        adapter.notifyDataSetChanged();
    }

    private void limparCampos() {
        etTitle.setText("");
        etDescription.setText("");
    }
}