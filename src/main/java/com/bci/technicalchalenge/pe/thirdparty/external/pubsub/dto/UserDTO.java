package com.bci.technicalchalenge.pe.thirdparty.external.pubsub.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * |description|.<br/>
 * <b>Class</b>: UserDTO<br/>
 * <b>Copyright</b>: &copy; 2021 Intercorp Retail.<br/>
 * <b>Company</b>: Intercorp Retail.<br/>
 *
 * @author Intercorp Retail <br/>
 * <u>Developed by</u>: <br/>
 * <ul>
 * <li>PM42722316 : Jose Hurtado</li>
 * </ul>
 * <u>Create</u>:<br/>
 * <ul>
 * <li>Jul. 09, 2021 Creaci&oacute;n de Clase.</li>
 * </ul>
 * @version 1.0
 */
@Builder
@Getter
@Setter
public class UserDTO {

  private String name;
  private String email;

}
