package com.bowmeow.gateway.controller;

import com.bowmeow.gateway.dto.SwaggerSampleDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "SwaggerSampleController", description = "Swagger Sample Controller 설명")
@RequestMapping("swagger-sample-controller")
@RestController
public class SwaggerSampleController {

    @Operation(summary = "Swagger sample method - short description"
            , description = "Swagger sample method - long description"
            , responses = {
                @ApiResponse(responseCode = "200"),
                @ApiResponse(responseCode = "404"
                           , description = "404 에러"
                           , content = @Content(schema = @Schema(implementation = Exception.class)) // custom class 를 만들어서 Exception 형태 고정시킬 수 있음
                ),
            }
    )
    @GetMapping("/swagger-sample-method")
    public String swaggerSampleMethod(@ParameterObject @ModelAttribute SwaggerSampleDto swaggerSample) {
        // 인자로 객체를 받는 경우 : 객체 앞에 @ParameterObject 사용 ex) @ParameterObject @ModelAttribute SampleDto sampleDto
        // 단, Multipart/form-data 의 경우 @Operation 내의 requestBody 선언 필요 ex) @Operation(requestBody= 요런식으로 필요 .. )
        // 인자가 객체가 아닌 경우 @Parameter 통해 선언 가능 ex) @Parameter(name="testParameter", ..)
        return "swagger Sample Method";
    }
}
