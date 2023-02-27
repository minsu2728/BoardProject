package com.project.board.entity;

import javax.persistence.*;

/*
>>> @Entity <<<
- JPA가 관리하는 클래스로, 해당 클래스를 엔티티라고 부른다.
- 엔티티는 자바에서 객체지향적인 코드를 작성할 때 DB의 테이블과 매핑되는 클래스의 이름이다.
- JPA를 사용하여 테이블과 매핑해야할 클래스는 반드시 @Entity를 선언해야한다.
- 일반적으로 클래스명과 동일한 이름을 사용하기 때문에 엔티티 이름을 변경하지 않는다.
  만약 엔티티 이름을 변경하고 싶을 때는 @Entity(name="myMember") 와 같은 형식의 어노테이션을 붙이면 된다.
- 속성
  name : JPA에서 사용할 엔티티 이름을 지정. 일반적으로 기본값인 클래스 이름을 사용하며 생략 가능.

- 주의사항
    ㆍ기본 생성자는 필수 (JPA가 엔티티 객체 생성 시 기본 생성자를 사용하기 때문이다)
    ㆍfinal 클래스, enum, interface, inner class 에는 사용할 수 없음.
    ㆍ저장할 필드에 final 사용 불가함.
*/

@Entity
@Table(name="tbl_board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long subno;

    private long fk_mnum;
    private String subject;
    private String contnent;
    private String registerdate;


    // 기본생성자 필수
    public Board() { }

    public Board(String subject, String contnent, String registerdate){
        this.subject = subject;
        this.contnent = contnent;
        this.registerdate = registerdate;
    }


    public long getSubno() {
        return subno;
    }

    public void setSubno(long subno) {
        this.subno = subno;
    }

    public long getFk_mnum() {
        return fk_mnum;
    }

    public void setFk_mnum(long fk_mnum) {
        this.fk_mnum = fk_mnum;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContnent() {
        return contnent;
    }

    public void setContnent(String contnent) {
        this.contnent = contnent;
    }

    public String getRegisterdate() {
        return registerdate;
    }

    public void setRegisterdate(String registerdate) {
        this.registerdate = registerdate;
    }
}
