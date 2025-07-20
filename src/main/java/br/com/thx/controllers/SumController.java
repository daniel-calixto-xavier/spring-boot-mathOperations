package br.com.thx.controllers;

import br.com.thx.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")//Usado para mapear um de várias categorias
public class SumController {
    @RequestMapping/*Usado para mostrar o caminho get */("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable String numberOne,
            @PathVariable String numberTwo
    ) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))//verificação para ver se é número
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        return convertToDouble(numberOne) + convertToDouble(numberTwo);//deu tudo certo ele faz a soma
    }

    private Double convertToDouble(String strNumber) {
        if (strNumber == null || strNumber.isEmpty())//verificação
            throw new UnsupportedMathOperationException("Please set a numeric value!");//exceção
        String number = strNumber.replace(",", ".");// aqui ele só vai trocar de ,  por .
        return Double.parseDouble(number);//se der tudo certo ele vai
    }

    private boolean isNumeric(String strNumber) {//Ele verifica se é numérico ou não para ser inserido lá encima no isNumeric
        if (strNumber == null || strNumber.isEmpty())//verificação
            return false;
        String number = strNumber.replace(",", ".");
        return number.matches("[+-]?[0-9]*\\.?[0-9]+");//Aqui ele vai mandar as opções de números para serem verificado
    }
}
