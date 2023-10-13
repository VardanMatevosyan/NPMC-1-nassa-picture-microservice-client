package com.example.nasapicturemicroserviceclient.client;

import com.example.nasapicturemicroserviceclient.dto.StealPictureRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("nasa-picture-stealer")
public interface StealPictureClient {

  @PostMapping("/pictures/steal")
  ResponseEntity<Void> stealPictures(@RequestBody StealPictureRequestDto request);

}
