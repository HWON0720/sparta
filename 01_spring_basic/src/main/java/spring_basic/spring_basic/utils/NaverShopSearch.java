package spring_basic.spring_basic.utils;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import spring_basic.spring_basic.dto.ItemDto;

import java.util.ArrayList;
import java.util.List;

@Component  // 이제부터, @RequiredArgsConstructor와 함께 사용할 경우 스프링이 자동으로 생성합니다.
public class NaverShopSearch {
    public String search(String query) {
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", "ATH4AqY3Fu4XVlymbytY");
        headers.add("X-Naver-Client-Secret", "1n22kAhr70");
        String body = "";

        HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
        ResponseEntity<String> responseEntity = rest.exchange("https://openapi.naver.com/v1/search/shop.json?query=" + query, HttpMethod.GET, requestEntity, String.class);
        HttpStatus httpStatus = responseEntity.getStatusCode();
        int status = httpStatus.value();
        String response = responseEntity.getBody();
        System.out.println("Response status: " + status);
        System.out.println(response);

        return response;
    }

    // fromJSONtoItems 메소드 만들기
    public List<ItemDto> fromJSONtoItems(String result) {
        JSONObject rjson = new JSONObject(result);
        JSONArray items  = rjson.getJSONArray("items");
        List<ItemDto> ret = new ArrayList<>();
        for (int i=0; i<items.length(); i++) {
            JSONObject itemJson = items.getJSONObject(i);
            System.out.println(itemJson);
            ItemDto itemDto = new ItemDto(itemJson);
            ret.add(itemDto);
        }
        return ret;
    }

//    public static void main(String[] args) {
//        NaverShopSearch naverShopSearch = new NaverShopSearch();
//        naverShopSearch.search("아이맥");
//    }
}
