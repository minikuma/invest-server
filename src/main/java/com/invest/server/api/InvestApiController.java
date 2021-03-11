package com.invest.server.api;

import com.invest.server.dto.InvestRequestDto;
import com.invest.server.repository.invest.query.InvestProductSearchQueryDto;
import com.invest.server.repository.invest.query.InvestProductSearchQueryRepository;
import com.invest.server.service.InvestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class InvestApiController {

    private final InvestService investService;
    private final InvestProductSearchQueryRepository queryRepository;

    @PostMapping("/invest")
    public ResponseEntity<Long> investProduct(@RequestHeader(value = "X-USER-ID")
                                                           Long userId,
                                                           @RequestBody @Valid InvestRequestDto request) {
        Long investId = investService.investProduct(userId, request);
        return ResponseEntity.ok(investId);
    }

    @GetMapping("/invest/{userId}")
    public ResponseEntity<List<InvestProductSearchQueryDto>> investProductSearchByUser(@PathVariable Long userId) {
        List<InvestProductSearchQueryDto> invertProducts = queryRepository.findInvertProducts(userId);
        return ResponseEntity.ok(invertProducts);
    }
}
