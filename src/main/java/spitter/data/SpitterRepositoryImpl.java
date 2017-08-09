package spitter.data;

import org.springframework.stereotype.Controller;
import spitter.Spitter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class SpitterRepositoryImpl implements SpitterRepository {
    @Override
    public List<Spitter> findSpitters(long max, int count) {
        Spitter spitter = new Spitter("这我是一条微博!", new Date(), 20.0, 10.0);
        List<Spitter> spitterList = new ArrayList<>();
        spitterList.add(spitter);
        return spitterList;
    }
}
