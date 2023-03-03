package com.project.board.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;


import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Data
@AllArgsConstructor // 이필드 모두를 매개변수로 사용할 수 있는 생성자를 만들어줌
@NoArgsConstructor
@Table(name="tbl_comlist")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comno;

    @Column
    private Long fk_subno;

    @Column
    private Long fk_mnum;

    @Column
    private String comtitle;

    @Generated(GenerationTime.INSERT)
    private LocalDateTime comdate;


}
