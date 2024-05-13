package org.crm.crmproject.service;

import org.crm.crmproject.dto.CeoDTO;
import org.crm.crmproject.dto.CustomerDTO;

public interface UpdateService {
    static class MidExistException extends Exception {

        public MidExistException() {}
        public MidExistException(String message) {super(message);}
    }
    void cusUpdate(CustomerDTO customerDTO) throws MidExistException;

    void ceoUpdate(CeoDTO ceoDTO)throws MidExistException;

    CeoDTO readOne(Long gm);

    CustomerDTO readOne2(Long user);
}