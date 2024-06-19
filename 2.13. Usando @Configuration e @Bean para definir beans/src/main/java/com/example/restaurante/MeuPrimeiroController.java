package com.example.restaurante;

import com.example.restaurante.domain.modelo.Cliente;
import com.example.restaurante.domain.service.AtivacaoClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MeuPrimeiroController {

    private AtivacaoClienteService ativacaoClienteService;

    public MeuPrimeiroController(AtivacaoClienteService ativacaoClienteService) {
        this.ativacaoClienteService = ativacaoClienteService;

        System.out.println("MeuPrimeiroController: " + ativacaoClienteService);
    }

    @GetMapping("/hello")
    @ResponseBody // informa que a retorno seja devolvida como resposta
    public String helloWorld(){
        return "hello";
    }

    // @PutMapping("/ativar")
    // @ResponseBody
    // public Cliente ativaCliente(Cliente cliente){
    //     ativacaoClienteService.ativar(cliente);
    //     return cliente;
    // }
}
