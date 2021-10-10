package com.fsot.demoWeb1.DTO;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class UserDTO extends BasicDTO {
    private String fullname;
    private String account;
    private String email;
    private String phone;
    List<RoleDTO> roles = new ArrayList<>();
}
