package com.alura.easycharge.controller;

import com.alura.easycharge.models.Cliente;
import com.alura.easycharge.models.Endereco;
import com.alura.easycharge.models.StatusCliente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Controller
public class ClienteController {

    @GetMapping("/listaCliente")
    public String lista(Model model){
        Cliente cliente = new Cliente();
        cliente.setNome("Olívia");
        cliente.setCpf("03184520145");
        cliente.setEmail("olivia@gmail.com");
        cliente.setProfissao("Desenvolvedor");
        cliente.setRenda(new BigDecimal(1000));
        cliente.setTelefone("998219292");
        cliente.setStatus(StatusCliente.ATIVO);
        cliente.setEndereco(new Endereco("QI 09", "9", "Perto da pracinha","Guara","Brasilia","DF"));

        List<Cliente> clientes = Arrays.asList(cliente);

        model.addAttribute("clientes", clientes);
        return "listaCliente";
    }
}
