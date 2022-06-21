package com.example.moizaspringserver.domain.feed.presenstation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ImageUrlListResponse {

    private final List<ImageUrlResponse> imageLists;

    @Getter
    @AllArgsConstructor
    public static class ImageUrlResponse {
        private final String imageUrl;
    }
}

