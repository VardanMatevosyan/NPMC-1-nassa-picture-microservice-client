package com.example.nasapicturemicroserviceclient.service;

import com.example.nasapicturemicroserviceclient.dto.StealPictureRequestDto;

public interface PictureStealService {

  String stealPicture(StealPictureRequestDto request);

}
