package com.aang23.rsinfinitewireless.utils;

import net.minecraft.util.IStringSerializable;

import java.util.Arrays;
import java.util.Comparator;

public enum TransmitterState implements IStringSerializable {
  CONNECTED(0, "connected", true),
  DISCONNECTED(1, "disconnected", false);

  private static final TransmitterState[] VALUES = Arrays.stream(values()).sorted(Comparator.comparingInt(TransmitterState::getId)).toArray((index) -> {
    return new TransmitterState[index];
  });
  private final int id;
  private final String translationKey;
  private final boolean value;

  TransmitterState(int idIn, String translationKeyIn, boolean valueIn) {
    this.id = idIn;
    this.translationKey = translationKeyIn;
    this.value = valueIn;
  }

  public int getId() {
    return this.id;
  }

  public String getTranslationKey() {
    return this.translationKey;
  }
  public boolean getValue() { return this.value; }

  public static TransmitterState byId(int stateId) {
    if (stateId < 0 || stateId >= VALUES.length) {
      stateId = 1;
    }

    return VALUES[stateId];
  }

  public static TransmitterState byTranslationKey(String translationKeyIn, TransmitterState fallback) {
    for (TransmitterState transmitterState : values()) {
      if (transmitterState.translationKey.equals(translationKeyIn)) {
        return transmitterState;
      }
    }

    return fallback;
  }

  public String toString() {
    return this.translationKey;
  }

  public String getString() {
    return this.translationKey;
  }
}
