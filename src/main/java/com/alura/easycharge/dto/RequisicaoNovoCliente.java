package com.alura.easycharge.dto;

import com.alura.easycharge.models.Cliente;
import com.alura.easycharge.models.Endereco;
import com.alura.easycharge.models.StatusCliente;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

public class RequisicaoNovoCliente {

    @NotBlank
    private String nomeCliente;

    @NotBlank
    private String cpfCliente;

    @NotBlank
    private String telefoneCliente;

    @NotBlank
    private String emailCliente;

    @NotBlank
    private String profissaoCliente;

    @NotBlank
    private BigDecimal rendaCliente;

    @NotBlank
    private StatusCliente statusCliente;

    @NotBlank
    private String ruaEnderecoCliente;

    @NotBlank
    private String numeroEnderecoCliente;

    private String complementoEnderecoCliente;

    @NotBlank
    private String bairroEnderecoCliente;

    @NotBlank
    private String cidadeEnderecoCliente;

    @NotBlank
    private String estadoEnderecoCliente;

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getProfissaoCliente() {
        return profissaoCliente;
    }

    public void setProfissaoCliente(String profissaoCliente) {
        this.profissaoCliente = profissaoCliente;
    }

    public BigDecimal getRendaCliente() {
        return rendaCliente;
    }

    public void setRendaCliente(BigDecimal rendaCliente) {
        this.rendaCliente = rendaCliente;
    }

    public StatusCliente getStatusCliente() {
        return statusCliente;
    }

    public void setStatusCliente(StatusCliente statusCliente) {
        this.statusCliente = statusCliente;
    }

    public String getRuaEnderecoCliente() {
        return ruaEnderecoCliente;
    }

    public void setRuaEnderecoCliente(String ruaEnderecoCliente) {
        this.ruaEnderecoCliente = ruaEnderecoCliente;
    }

    public String getNumeroEnderecoCliente() {
        return numeroEnderecoCliente;
    }

    public void setNumeroEnderecoCliente(String numeroEnderecoCliente) {
        this.numeroEnderecoCliente = numeroEnderecoCliente;
    }

    public String getComplementoEnderecoCliente() {
        return complementoEnderecoCliente;
    }

    public void setComplementoEnderecoCliente(String complementoEnderecoCliente) {
        this.complementoEnderecoCliente = complementoEnderecoCliente;
    }

    public String getBairroEnderecoCliente() {
        return bairroEnderecoCliente;
    }

    public void setBairroEnderecoCliente(String bairroEnderecoCliente) {
        this.bairroEnderecoCliente = bairroEnderecoCliente;
    }

    public String getCidadeEnderecoCliente() {
        return cidadeEnderecoCliente;
    }

    public void setCidadeEnderecoCliente(String cidadeEnderecoCliente) {
        this.cidadeEnderecoCliente = cidadeEnderecoCliente;
    }

    public String getEstadoEnderecoCliente() {
        return estadoEnderecoCliente;
    }

    public void setEstadoEnderecoCliente(String estadoEnderecoCliente) {
        this.estadoEnderecoCliente = estadoEnderecoCliente;
    }

    public Cliente toCliente() {
        Cliente cliente = new Cliente();
        cliente.setNome(nomeCliente);
        cliente.setCpf(cpfCliente);
        cliente.setEmail(emailCliente);
        cliente.setTelefone(telefoneCliente);
        cliente.setRenda(rendaCliente);
        cliente.setStatus(statusCliente);
        cliente.setProfissao(profissaoCliente);
        cliente.setEndereco(new Endereco(ruaEnderecoCliente,numeroEnderecoCliente,complementoEnderecoCliente,bairroEnderecoCliente,cidadeEnderecoCliente,estadoEnderecoCliente));

        return null;
    }
}
