package spitter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import spitter.Spitter;
import spitter.data.SpitterRepository;

import java.util.List;

@Controller
@RequestMapping("/spitters")
public class SpitterController {

    private SpitterRepository spitterRepository;

    @Autowired
    public SpitterController(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Spitter> spitters(
            @RequestParam(value = "max", defaultValue = "0") long max,
            @RequestParam(value = "count", defaultValue = "20") int count
    ) {
        return spitterRepository.findSpitters(max, count);
    }

}
