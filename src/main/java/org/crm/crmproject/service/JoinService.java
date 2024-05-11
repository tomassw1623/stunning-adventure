package org.crm.crmproject.service;

import org.crm.crmproject.dto.CeoDTO;
import org.crm.crmproject.dto.CustomerDTO;

public interface JoinService {
    static class MidExistException extends Exception {

        public MidExistException() {}
        public MidExistException(String message) {super(message);}
    }

    void cusJoin(CustomerDTO customerDTO) throws MidExistException;

    void ceoJoin(CeoDTO ceoDTO) throws MidExistException;

}
