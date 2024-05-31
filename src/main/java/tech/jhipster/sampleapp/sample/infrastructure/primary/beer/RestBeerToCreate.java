package tech.jhipster.sampleapp.sample.infrastructure.primary.beer;

import com.fasterxml.jackson.annotation.JsonProperty;
import tech.jhipster.sampleapp.sample.domain.Amount;
import tech.jhipster.sampleapp.sample.domain.beer.BeerName;
import tech.jhipster.sampleapp.sample.domain.beer.BeerToCreate;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

@Schema(name = "beerToCreate", description = "A beer to create")
class RestBeerToCreate {

  private final String name;
  private final BigDecimal unitPrice;

  RestBeerToCreate(@JsonProperty("name") String name, @JsonProperty("unitPrice") BigDecimal unitPrice) {
    this.name = name;
    this.unitPrice = unitPrice;
  }

  public BeerToCreate toDomain() {
    return new BeerToCreate(new BeerName(getName()), new Amount(getUnitPrice()));
  }

  @NotNull
  @Schema(description = "Name of this beer", requiredMode = RequiredMode.REQUIRED)
  public String getName() {
    return name;
  }

  @NotNull
  @Schema(description = "Unit price (in euros) of this beer", requiredMode = RequiredMode.REQUIRED)
  public BigDecimal getUnitPrice() {
    return unitPrice;
  }
}
