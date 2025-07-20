package br.com.thx.controllers;

import br.com.thx.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class SubController {

    @RequestMapping("/sub/{numberOne}/{numberTwo}")
    public Double sub(
            @PathVariable String numberOne,
            @PathVariable String numberTwo
    )throws Exception{
        if(!isNumeric (numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");
            return convertToDouble(numberOne) - convertToDouble(numberTwo);

    }

    private Double convertToDouble(String strNumber) {
        if(strNumber == null || strNumber.isEmpty())
            throw new UnsupportedMathOperationException("Please set a numeric value!");
            String number = strNumber.replace("," , ".");
        return Double.parseDouble(number);
    }

    private boolean isNumeric(String strNumber){
        if(strNumber == null || strNumber.isEmpty())
            return false;
        String number = strNumber.replace("," , ".");
        return number.matches("[+-]?[0-9]*\\.?[0-9]+");
    }
}
