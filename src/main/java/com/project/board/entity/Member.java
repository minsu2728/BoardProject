package com.project.board.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Data
@AllArgsConstructor // 이필드 모두를 매개변수로 사용할 수 있는 생성자를 만들어줌
@NoArgsConstructor
@Table(name="tbl_member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment지정
    private Long mnum;

    @Column(unique = true)
    private String id;

    @Column
    private String pwd;

    @Column
    private String name;

    @Column
    private String mobile;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate  regdate;
/*

    public Member(){};

    public Member(String id, String pwd, String name, String mobile){
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.mobile = mobile;
        this.regdate = LocalDate.now();
    }
*/

}

