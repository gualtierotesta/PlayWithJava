package it.gualtierotesta.playwithjava.streams;

import java.time.LocalDate;

public class MyBean {

    private final String nome;
    private final LocalDate dataDiNascita;

    public MyBean(final String nome, final LocalDate dataDiNascita) {
        this.nome = nome;
        this.dataDiNascita = dataDiNascita;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("MyBean{");
        sb.append("nome='").append(nome).append('\'');
        sb.append(", dataDiNascita=").append(dataDiNascita);
        sb.append('}');
        return sb.toString();
    }
}
