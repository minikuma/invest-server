package com.invest.server.api;

import com.invest.server.dto.InvestRequestDto;
import com.invest.server.dto.InvestResponseDto;
import com.invest.server.exception.NotEnoughProductException;
import com.invest.server.service.InvestService;
import com.invest.server.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class InvestApiController {

    private final ProductService productService;
    private final InvestService investService;
    private final ModelMapper modelMapper;

    @PostMapping("/invest")
    public InvestResponseDto investProduct(@RequestHeader(value = "X-USER-ID")
                                                       Long userId,
                                           @RequestBody @Valid InvestRequestDto request) {
        investService.investProduct(userId, request);
        return new InvestResponseDto(request.getProductId());
    }
}
