package web.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.Service.CarService;

@Controller
@AllArgsConstructor
public class CarsController {

    private final CarService carService;


    @GetMapping(value = "/cars")
    public String printCar(@RequestParam(value = "count", defaultValue = "5") Integer count, Model model) {
        model.addAttribute("cars", carService.getCarsList(count));

        return "cars";
    }

}
