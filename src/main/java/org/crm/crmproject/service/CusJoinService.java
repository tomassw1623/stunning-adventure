package org.crm.crmproject.service;

import org.crm.crmproject.dto.CustomerDTO;

public interface CusJoinService {
    static class MidExistException extends Exception {

        public MidExistException() {}
        public MidExistException(String message) {super(message);}
    }

    void cusJoin(CustomerDTO customerDTO) throws MidExistException;


}
