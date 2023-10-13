package com.example.nasapicturemicroserviceclient.controller;

import com.example.nasapicturemicroserviceclient.dto.StealPictureRequestDto;
import com.example.nasapicturemicroserviceclient.service.PictureStealService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class NasaPictureController {

  PictureStealService pictureStealService;

  @PostMapping("/pictures/steal")
  @PreAuthorize("hasAuthority('SCOPE_OIDC_USER')")
  public ResponseEntity<String> stealNasaPictures(@RequestBody StealPictureRequestDto request, Authentication principal) {
    String result = pictureStealService.stealPicture(request);
    log.info(result);
    return ResponseEntity.ok().body(result);
  }

  @GetMapping("/")
  @PreAuthorize("principal?.claims['http://localhost:3000/roles']?.contains('OIDC_USER')")
  public ResponseEntity<String> stealNasaPictures(Authentication principal) {
    log.info("result");
    return ResponseEntity.ok().body("result");
  }

}
