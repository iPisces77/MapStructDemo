package com.example.mapstructdemo;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.example.mapstructdemo.converter.StudentConverter;
import com.example.mapstructdemo.converter.UserConverter;
import com.example.mapstructdemo.pojo.StudentDto;
import com.example.mapstructdemo.pojo.TypeDto;
import com.example.mapstructdemo.pojo.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MapStructDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testMapStruct() {
        var userDto = new UserDto();
        userDto.setId(2L);
        userDto.setUsername("Root");
        userDto.setPassword("123456");
        var typeDto = new TypeDto();
        typeDto.setId(6L);
        typeDto.setTypeName("Admin");
        var userVo = UserConverter.INSTANCE.convert(userDto, typeDto);
//        assertThat(userVo.getId()).isEqualTo(userDto.getId());
        assertThat(userVo.getUserId()).isEqualTo(userDto.getId());
        assertThat(userVo.getUsername()).isEqualTo(userDto.getUsername());
        assertThat(userVo.getTypeName()).isEqualTo(typeDto.getTypeName());
    }

    @Test
    void customMapStruct() {
        var studentDto = new StudentDto();
        studentDto.setId(10L);
        studentDto.setName("King");
        studentDto.setClassName("三年二班");
        try {
            var studentVo = StudentConverter.INSTANCE.convert(studentDto);
            assertThat(studentVo.getClassName()).isEqualTo(studentDto.getClassName());
            assertThat(studentVo.getId()).isEqualTo(studentDto.getId());
            assertThat(studentVo.getName()).isEqualTo(studentDto.getName());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
