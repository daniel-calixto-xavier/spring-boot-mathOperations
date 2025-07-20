package br.com.thx.controllers;

import br.com.thx.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class SquareRootController {
    @RequestMapping("/squareRoot/{number}")
    public Double sqr(
            @PathVariable String number
    ) throws Exception{
        if(!isNumeric(number))
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        return Math.sqrt(Double.parseDouble(number));
    }
        private boolean isNumeric(String strNumber){
        if(strNumber == null || strNumber.isEmpty())
            return false;
            String number = strNumber.replace("," , ".");
            return number.matches("[+-]?[0-9]*\\.?[0-9]+");
        }

}
