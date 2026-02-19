package com.weg.biblioteca.model;

import java.util.Date;

public class Emprestimo {

    private long id;
    private long livro_id;
    private long usuario_id;
    private Date data_emprestimo;
    private Date data_devolucao;

    public Emprestimo() {
    }

    public Emprestimo(long id, long livro_id, long usuario_id, Date data_emprestimo, Date data_devolucao) {
        this.id = id;
        this.livro_id = livro_id;
        this.usuario_id = usuario_id;
        this.data_emprestimo = data_emprestimo;
        this.data_devolucao = data_devolucao;
    }

    public Emprestimo(long livro_id, long usuario_id, Date data_emprestimo, Date data_devolucao) {
        this.livro_id = livro_id;
        this.usuario_id = usuario_id;
        this.data_emprestimo = data_emprestimo;
        this.data_devolucao = data_devolucao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getLivro_id() {
        return livro_id;
    }

    public void setLivro_id(long livro_id) {
        this.livro_id = livro_id;
    }

    public long getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(long usuario_id) {
        this.usuario_id = usuario_id;
    }

    public Date getData_emprestimo() {
        return data_emprestimo;
    }

    public void setData_emprestimo(Date data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }

    public Date getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(Date data_devolucao) {
        this.data_devolucao = data_devolucao;
    }
}
