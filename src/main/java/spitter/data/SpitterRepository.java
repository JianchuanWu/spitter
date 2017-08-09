package spitter.data;

import spitter.Spitter;

import java.util.List;

public interface SpitterRepository {
    List<Spitter> findSpitters(long max, int count);
}
