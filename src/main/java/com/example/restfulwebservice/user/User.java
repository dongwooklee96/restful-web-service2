package com.example.restfulwebservice.user;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import net.minidev.json.annotate.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// @JsonIgnoreProperties(value={"password", "ssn"})
// @JsonFilter("UserInfo")
@ApiModel(description = "사용자 상세 정보를 위한 도메인 객체")
@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    public User(Integer id, String name, Date joinDate, String password, String ssn) {
        this.id = id;
        this.name = name;
        this.joinDate = joinDate;
        this.password = password;
        this.ssn = ssn;
    }

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

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Post> posts;
}
