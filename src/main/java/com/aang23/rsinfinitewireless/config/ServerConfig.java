package com.aang23.rsinfinitewireless.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.Builder;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;

public class ServerConfig {
  private final Builder builder = new Builder();
  private final ForgeConfigSpec spec;
  private final ServerConfig.InfiniteWirelessTransmitter infiniteWirelessTransmitter = new ServerConfig.InfiniteWirelessTransmitter();
  public ServerConfig() {
    this.spec = this.builder.build();
  }
  public ServerConfig.InfiniteWirelessTransmitter getInfiniteWirelessTransmitter() { return this.infiniteWirelessTransmitter; }

  public ForgeConfigSpec getSpec() {
    return spec;
  }

  public class InfiniteWirelessTransmitter {
    private final IntValue usage;
    private final IntValue range;

    public InfiniteWirelessTransmitter()
    {
      ServerConfig.this.builder.push("infiniteWirelessTransmitter");
      this.usage = ServerConfig.this.builder.comment("The energy used by the Infinite Wireless Transmitter").defineInRange("usage",1000, 0, Integer.MAX_VALUE);
      this.range = ServerConfig.this.builder.comment("The range of the Infinite Wireless Transmitter").defineInRange("range", Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
      ServerConfig.this.builder.pop();
    }

    public int getUsage() {
      return this.usage.get();
    }
    public int getRange() {
      return this.range.get();
    }
  }
}
