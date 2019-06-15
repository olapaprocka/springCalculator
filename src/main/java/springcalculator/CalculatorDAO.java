package springcalculator;

import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
@Getter
public class CalculatorDAO {

    private  Set<String> historySet = new LinkedHashSet();
    public void addToHistory(String result){
        historySet.add(result);
    }

}
