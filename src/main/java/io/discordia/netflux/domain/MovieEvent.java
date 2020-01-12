package io.discordia.netflux.domain;


import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovieEvent {

  private String movieId;
  private Date date;

}