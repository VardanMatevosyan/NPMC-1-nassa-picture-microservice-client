package com.example.nasapicturemicroserviceclient.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Message {
  public static final String NASA_PICTURES_STOLEN = "Nasa pictures successfully stolen";
  public static final String FAILED_TO_STEAL_NASA_PICTURES = "Can't steal nasa pictures";
}
