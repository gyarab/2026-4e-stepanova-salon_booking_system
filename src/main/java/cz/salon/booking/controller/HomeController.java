
package cz.salon.booking.controller;

import cz.salon.booking.model.Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {

        ArrayList<Service> services = new ArrayList<>();

        services.add(new Service("Soft waves", 800, 45));
        services.add(new Service("Volume blowout", 900, 60));
        services.add(new Service("Sleek hair", 850, 50));
        services.add(new Service("Defined curls", 1000, 75));

        model.addAttribute("services", services);

        return "index";
    }

    @GetMapping("/calculate")
    public String calculate(
            @RequestParam String service,
            @RequestParam String length,
            @RequestParam String density,
            Model model) {

        int price = 0;
        int duration = 0;


        if (service.equals("Soft waves")) {
            price = 800;
            duration = 45;
        } else if (service.equals("Volume blowout")) {
            price = 900;
            duration = 60;
        } else if (service.equals("Sleek hair")) {
            price = 850;
            duration = 50;
        } else if (service.equals("Defined curls")) {
            price = 1000;
            duration = 75;
        }


        if (length.equals("medium")) {
            price += 150;
            duration += 10;
        } else if (length.equals("long")) {
            price += 300;
            duration += 20;
        }


        if (density.equals("thick")) {
            price += 150;
            duration += 10;
        }

        model.addAttribute("price", price);
        model.addAttribute("service", service);
        model.addAttribute("duration", duration);

        return "result";
    }
}
