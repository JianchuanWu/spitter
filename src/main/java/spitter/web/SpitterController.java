package spitter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public List<Spitter> spitters() {
        return spitterRepository.findSpitters(Long.MAX_VALUE, 20);
    }

}
