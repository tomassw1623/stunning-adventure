package org.crm.crmproject.service;


import org.crm.crmproject.dto.CeoDTO;

public interface CeoJoinService {
    static class MidExistException extends Exception {

        public MidExistException() {}
        public MidExistException(String message) {super(message);}
    }
    void ceoJoin(CeoDTO ceoDTO) throws CusJoinService.MidExistException;

}
