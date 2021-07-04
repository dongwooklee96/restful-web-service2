package com.example.restfulwebservice.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// @JsonIgnoreProperties(value={"password", "ssn"})
// @JsonFilter("UserInfo")
@ApiModel(description = "사용자 상세 정보를 위한 도메인 객체")
public class User {
    private Integer id;

    @ApiModelProperty(notes = "사용자 이름을 입력해주세요.", example = "사용자 이름")
    @Size(min=2, message = "이름은 2글자 이상 입력해주세요.")
    private String name;

    @ApiModelProperty(notes = "사용자 등록일 입력해주세요.")
    @Past
    private Date joinDate;

    // @JsonIgnore
    @ApiModelProperty(notes = "사용자 패스워드를 입력해주세요.")
    private String password;

    // @JsonIgnore
    @ApiModelProperty(notes = "사용자의 주민번호를 입력해주세요.")
    private String ssn;
}
