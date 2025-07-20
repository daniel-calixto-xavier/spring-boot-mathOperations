package br.com.thx.controllers;

import br.com.thx.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MeanController {
    @RequestMapping("/mean/{numberOne}/{numberTwo}")
    public Double mean(
            @PathVariable String numberOne,
            @PathVariable String numberTwo
    ) throws Exception{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");
            Double num1 = Double.parseDouble(numberOne);
            Double num2 = Double.parseDouble(numberTwo);
            return (num1 + num2) / 2;
    }

        private boolean isNumeric(String strNumber){
            if (strNumber == null || strNumber.isEmpty())
                return false;
            String number = strNumber.replace("," , ".");
            return number.matches("[+-]?[0-9]*\\.?[0-9]+");
        }
}
