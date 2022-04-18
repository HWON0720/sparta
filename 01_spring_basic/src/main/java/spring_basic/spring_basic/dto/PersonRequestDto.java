package spring_basic.spring_basic.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class PersonRequestDto {
    private String name;
    private int age;
    private String address;

    public PersonRequestDto(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
}
