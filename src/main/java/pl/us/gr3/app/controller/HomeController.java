package pl.us.gr3.app.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

@RestController
public class HomeController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(){
        return "Hello from Spring";
    }

    @GetMapping("/hello")
    public void helloServlet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        final PrintWriter writer = response.getWriter();
        response.setContentType("text/plain");
        writer.println("Hello " + name);
    }

    @GetMapping(value = "/hej", produces = "text/plain")
    public String helloSpring(@RequestParam String name){
        return "Hello " + name;
    }

    @GetMapping("/age")
    public String age(
            @RequestParam(name = "birth-date", required = false, defaultValue = "2000-01-01") LocalDate birthDate,
            @RequestParam(name = "name", required = false, defaultValue = "noname") String name
            ){
        return "Hello " + name +", your birth date is " + birthDate +", your age is " + (LocalDate.now().getYear() - birthDate.getYear());
    }

    // Dodaj metodę kalkulatora z parametrami:
    // a - liczba
    // b - liczba
    // op - łańcuch z operatorem np. add, mul, sub, div
    // przykład żądania: ?a=4&b=5&op=add
    // odpowiedź: 9
}
