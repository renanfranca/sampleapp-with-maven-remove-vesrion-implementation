package tech.jhipster.sampleapp.sample.domain.beer;

import tech.jhipster.sampleapp.sample.domain.BeerId;
import tech.jhipster.sampleapp.shared.error.domain.Assert;

public class BeersRemover {

  private final BeersRepository beers;

  public BeersRemover(BeersRepository beers) {
    Assert.notNull("beers", beers);

    this.beers = beers;
  }

  public void remove(BeerId id) {
    Assert.notNull("id", id);

    Beer beer = beers.get(id).orElseThrow(() -> new UnknownBeerException(id));

    beer.removeFromSell();
    beers.save(beer);
  }
}
