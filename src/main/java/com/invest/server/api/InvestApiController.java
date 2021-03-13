package com.invest.server.api;

import com.invest.server.dto.InvestRequestDto;
import com.invest.server.dto.InvestResponseDto;
import com.invest.server.repository.invest.query.InvestProductSearchQueryDto;
import com.invest.server.repository.invest.query.InvestProductSearchQueryRepository;
import com.invest.server.service.InvestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 투자 API 컨트롤러
 * @version 1.0
 * @author Jeon Jihoon
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class InvestApiController {

    private final InvestService investService;
    private final InvestProductSearchQueryRepository queryRepository;

    /**
     *
     * @param userId (사용자)
     * @param request (입력값: 투자금액, 상품아이디)
     * @return 등록된 투자 아이디
     */

    @PostMapping("/invest")
    public ResponseEntity<InvestResponseDto> investProduct(@RequestHeader(value = "X-USER-ID")
                                                           Long userId,
                                                           @RequestBody @Valid InvestRequestDto request) {
        InvestResponseDto findInvest = investService.investProduct(userId, request);
        return ResponseEntity.ok(findInvest);
    }

    /**
     *
     * @param userId (사용자)
     * @return 사용자 기준 투자 상품 목록 리스트
     */

    @GetMapping("/invest/{userId}")
    public ResponseEntity<List<InvestProductSearchQueryDto>> investProductSearchByUser(@PathVariable Long userId) {
        List<InvestProductSearchQueryDto> invertProducts = queryRepository.findInvertProducts(userId);
        return ResponseEntity.ok(invertProducts);
    }
}
