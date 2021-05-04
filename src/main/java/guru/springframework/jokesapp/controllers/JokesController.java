package guru.springframework.jokesapp.controllers;

import guru.springframework.jokesapp.services.JokeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by ronnen on 2020-12-09.
 */

@Slf4j
@Controller
@RequestMapping(value = "/")
public class JokesController {

    private String randomJoke;

    private JokeService jokeService;

    @Autowired
    public JokesController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @GetMapping
    public String getChuckJoke(Model model) {

        log.debug(">>>>> New Joke Published");
        randomJoke = jokeService.getJoke();
        model.addAttribute("joke", randomJoke);

        return "chucknorris";
    }
}