package spring_basic.spring_basic.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring_basic.spring_basic.dto.ItemDto;
import spring_basic.spring_basic.dto.Product;
import spring_basic.spring_basic.dto.ProductMypriceRequestDto;
import spring_basic.spring_basic.repository.ProductRepository;

@RequiredArgsConstructor    // final로 선언된 멤버 변수를 자동으로 생성합니다.
@Service    // 서비스임을 선언합니다.
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional  // 메소드 동작이 SQL 쿼리문임을 선언합니다.
    public Long update(Long id, ProductMypriceRequestDto requestDto) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );
        product.update(requestDto);
        return id;
    }

    @Transactional  // 메소드 동작이 SQL 쿼리문임을 선언합니다.
    public Long updateBySearch(Long id, ItemDto itemDto) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );
        product.updateByItemDto(itemDto);
        return id;
    }
}
