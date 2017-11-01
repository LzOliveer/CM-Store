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
public class Empresa {
    private int COD;
    private String CNPJ;
    private String IE;
    private String FONE;
    private String RAZAO;
    private String NOME;
    private String END;
    private String SITE;

    /**
     * @return the COD
     */
    public int getCOD() {
        return COD;
    }

    /**
     * @param COD the COD to set
     */
    public void setCOD(int COD) {
        this.COD = COD;
    }

    /**
     * @return the CNPJ
     */
    public String getCNPJ() {
        return CNPJ;
    }

    /**
     * @param CNPJ the CNPJ to set
     */
    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    /**
     * @return the IE
     */
    public String getIE() {
        return IE;
    }

    /**
     * @param IE the IE to set
     */
    public void setIE(String IE) {
        this.IE = IE;
    }

    /**
     * @return the FONE
     */
    public String getFONE() {
        return FONE;
    }

    /**
     * @param FONE the FONE to set
     */
    public void setFONE(String FONE) {
        this.FONE = FONE;
    }

    /**
     * @return the RAZAO
     */
    public String getRAZAO() {
        return RAZAO;
    }

    /**
     * @param RAZAO the RAZAO to set
     */
    public void setRAZAO(String RAZAO) {
        this.RAZAO = RAZAO;
    }

    /**
     * @return the NOME
     */
    public String getNOME() {
        return NOME;
    }

    /**
     * @param NOME the NOME to set
     */
    public void setNOME(String NOME) {
        this.NOME = NOME;
    }

    /**
     * @return the END
     */
    public String getEND() {
        return END;
    }

    /**
     * @param END the END to set
     */
    public void setEND(String END) {
        this.END = END;
    }

    /**
     * @return the SITE
     */
    public String getSITE() {
        return SITE;
    }

    /**
     * @param SITE the SITE to set
     */
    public void setSITE(String SITE) {
        this.SITE = SITE;
    }
    
}
