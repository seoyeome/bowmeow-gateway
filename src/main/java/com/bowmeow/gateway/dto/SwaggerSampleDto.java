package com.bowmeow.gateway.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Swagger Sample Dto")
@Data
public class SwaggerSampleDto {

    @Schema(description = "Sample Field description"
          , allowableValues = "sample1, sample2, sample3" // 이 3가지의 데이터만 가능하다라는 의미
          , requiredMode = Schema.RequiredMode.REQUIRED // 필수여부
          , example = "sample1") // 데이터 example
    private String sampleField;
}