package com.project.board.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@AllArgsConstructor // 이필드 모두를 매개변수로 사용할 수 있는 생성자를 만들어줌
@Table(name="tbl_member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment지정
    private Long mnum;

    @Column
    private String id;

    @Column
    private String pwd;

    @Column
    private String name;

    @Column
    private String mobile;

    @Column
    private String regdate;


}

