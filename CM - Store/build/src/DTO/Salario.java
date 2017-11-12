/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author luizo
 */
public class Salario {
    private int cod;
    private int cod_fun;
    private String dt_inicial;
    private String dt_final;
    private String vlr;
    private String nome;

    /**
     * @return the cod
     */
    public int getCod() {
        return cod;
    }

    /**
     * @param cod the cod to set
     */
    public void setCod(int cod) {
        this.cod = cod;
    }

    /**
     * @return the cod_fun
     */
    public int getCod_fun() {
        return cod_fun;
    }

    /**
     * @param cod_fun the cod_fun to set
     */
    public void setCod_fun(int cod_fun) {
        this.cod_fun = cod_fun;
    }

    /**
     * @return the dt_inicial
     */
    public String getDt_inicial() {
        return dt_inicial;
    }

    /**
     * @param dt_inicial the dt_inicial to set
     */
    public void setDt_inicial(String dt_inicial) {
        this.dt_inicial = dt_inicial;
    }

    /**
     * @return the dt_final
     */
    public String getDt_final() {
        return dt_final;
    }

    /**
     * @param dt_final the dt_final to set
     */
    public void setDt_final(String dt_final) {
        this.dt_final = dt_final;
    }

    /**
     * @return the vlr
     */
    public String getVlr() {
        return vlr;
    }

    /**
     * @param vlr the vlr to set
     */
    public void setVlr(String vlr) {
        this.vlr = vlr;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
}
