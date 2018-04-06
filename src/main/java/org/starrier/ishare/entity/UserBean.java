package org.starrier.ishare.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * @Author Starri @Time 2018/3/23.
 */
@Data
@Log4j
@NoArgsConstructor
@AllArgsConstructor
public class UserBean {

    private String account;

    private String password;

}
