package br.com.thx.controllers;

import br.com.thx.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class DivController {
    @RequestMapping("/div/{numberOne}/{numberTwo}")
    public Double div(
            @PathVariable String numberOne,
            @PathVariable String numberTwo
    ) throws Exception{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Plese set a numeric value");
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    private boolean isNumeric(String strNumber) {
        if(strNumber == null || strNumber.isEmpty())
          return false;
        String number = strNumber.replace("," , ".");
        return number.matches("[+-]?[0-9]*\\.?[0-9]+");
    }

    private Double convertToDouble(String strNumber){
        if(strNumber == null || strNumber.isEmpty())
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        String number = strNumber.replace("," , ".");
        return Double.parseDouble(number);
    }
}
