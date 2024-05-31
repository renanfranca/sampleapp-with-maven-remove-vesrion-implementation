package tech.jhipster.sampleapp.sample.domain.beer;

import tech.jhipster.sampleapp.sample.domain.BeerId;
import java.util.Optional;

public interface BeersRepository {
  void save(Beer beer);

  Beers catalog();

  Optional<Beer> get(BeerId beer);
}
