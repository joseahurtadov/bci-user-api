package com.bci.technicalchalenge.pe.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Users extends UUIDEntity {

  private UUID id;
  private String name;
  private String email;
  private String password;
  private Date dateCreated;
  private Date dateModified;
  private Date dateLastLogin;
  private String token;
  private boolean isActive;

}
