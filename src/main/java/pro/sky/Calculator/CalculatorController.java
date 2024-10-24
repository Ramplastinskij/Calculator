package pro.sky.Calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequestMapping("/calculator")
    public class CalculatorController {

        @Autowired
        private CalculatorService calculatorService;

        @GetMapping
        public String welcome() {
            return "Добро пожаловать в калькулятор";
        }
        @GetMapping("/plus")
        public String add(@RequestParam int num1, @RequestParam int num2) {
            int result = calculatorService.add(num1, num2);
            return String.format("%d + %d = %d", num1, num2, result);
        }
        @GetMapping("/minus")
        public String subtract(@RequestParam int num1, @RequestParam int num2) {
            int result = calculatorService.subtract(num1, num2);
            return String.format("%d - %d = %d", num1, num2, result);
        }
        @GetMapping("/multiply")
        public String multiply(@RequestParam int num1, @RequestParam int num2) {
            int result = calculatorService.multiply(num1, num2);
            return String.format("%d * %d = %d", num1, num2, result);
        }
        @GetMapping("/divide")
        public String divide(@RequestParam int num1, @RequestParam int num2) {
            if (num2 == 0) {
                return "Ошибка: Деление на 0 невозможно.";
            }
            int result = calculatorService.divide(num1, num2);
            return String.format("%d / %d = %d", num1, num2, result);
        }
    }
