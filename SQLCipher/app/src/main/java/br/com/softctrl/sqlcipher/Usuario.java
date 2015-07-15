package br.com.softctrl.sqlcipher;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by timoshenko on 7/15/15.
 * E-Mail carlostimoshenkorodrigueslopes@gmail.com
 */
@DatabaseTable(tableName = "user_")
public class Usuario {

    @DatabaseField(generatedId = true)
    private Long id;

    @DatabaseField
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
