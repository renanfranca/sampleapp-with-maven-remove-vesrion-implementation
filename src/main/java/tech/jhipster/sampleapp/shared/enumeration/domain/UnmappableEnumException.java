package tech.jhipster.sampleapp.shared.enumeration.domain;

class UnmappableEnumException extends RuntimeException {

  public <T extends Enum<T>, U extends Enum<U>> UnmappableEnumException(Class<T> from, Class<U> to) {
    super("Can't map " + from + " to " + to);
  }
}
