package com.invest.server.api;

import com.invest.server.dto.InvestRequestDto;
import com.invest.server.dto.InvestResponseDto;
import com.invest.server.service.InvestService;
import com.invest.server.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class InvestApiController {

    private final ProductService productService;
    private final InvestService investService;
    private final ModelMapper modelMapper;

    // TODO: 투자하기 API 동시 접근 필요
    // 입력값: 식별값(사용자), 투자금액, 상품 id
    // 총 투자 모집 금액 넘는 경우 -> "sold-out" 상태 응답
    @PostMapping("/invest")
    public InvestResponseDto investProduct(@RequestHeader(value = "X-USER-ID") Long userId, @RequestBody @Valid InvestRequestDto request) {
        // TODO: 현재 상품의 총 투자 금액을 조회한다.
        //Product product = productService.productByProductId(request.getProductId());
        // TODO: 쿼리에서 null 케이스 처리했음으로 값이 존재함

        // TODO: 현재모집금액 + 투자금액 > 총모집금액 = 예외발생(sold-out)

        // TODO: Invest 정보 저장

        // TODO: Product 에 현재모집금액, 투자자수 증가

        investService.investProduct(userId, request);
        return new InvestResponseDto(request.getProductId());
    }
    // TODO: 내가 투자한 투자 목록 API
}
