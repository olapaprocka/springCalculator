package springcalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Autowired  //wstrzyknięcie referencji do serwisu
    CalculatorService calculatorService;

    @Autowired
    CalculatorDAO calculatorDAO;

    @RequestMapping("/calculate") //tutaj bedą mapowane request na danego URL
    public String calculate(@RequestParam(required = false) String inputText, Model model){ //Stirng oznacza nazwe templejtu h

        double result = calculatorService.calculate(inputText==null?"":inputText);
        model.addAttribute("resultValue", result);

        if (inputText != null) { //todo fixme -> single responsibility
            calculatorDAO.addToHistory(inputText + "=" + result);
        }
        model.addAttribute("history", calculatorDAO.getHistorySet());


        return "calculatorForm"; //tak się nazywa html na który zostaniemy przeniesieni

    }
}
