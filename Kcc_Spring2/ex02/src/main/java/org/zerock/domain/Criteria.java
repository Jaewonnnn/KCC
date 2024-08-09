package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString
@Setter
@Getter
public class Criteria {

  private int pageNum; //페이징 처리 했을때 여기로 받음
  private int amount; //글 몇개?
  
  private String type;
  private String keyword;

  public Criteria() {
    this(1, 10);
  }

  public Criteria(int pageNum, int amount) {
    this.pageNum = pageNum;
    this.amount = amount;
  }
  
  public String[] getTypeArr() {
    
    return type == null? new String[] {}: type.split("");
  }
}
