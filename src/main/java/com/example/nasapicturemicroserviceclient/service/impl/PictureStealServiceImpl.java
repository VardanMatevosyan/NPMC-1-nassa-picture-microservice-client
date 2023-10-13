package com.example.nasapicturemicroserviceclient.service.impl;

import com.example.nasapicturemicroserviceclient.client.StealPictureClient;
import com.example.nasapicturemicroserviceclient.constant.Message;
import com.example.nasapicturemicroserviceclient.dto.StealPictureRequestDto;
import com.example.nasapicturemicroserviceclient.service.PictureStealService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PictureStealServiceImpl implements PictureStealService {

  StealPictureClient stealPictureClient;

  @Override
  public String stealPicture(StealPictureRequestDto request) {
    ResponseEntity<Void> response = stealPictureClient.stealPictures(request);
    if (HttpStatus.CREATED.equals(response.getStatusCode())) {
      return Message.NASA_PICTURES_STOLEN;
    } else {
      return Message.FAILED_TO_STEAL_NASA_PICTURES;
    }
  }
}
