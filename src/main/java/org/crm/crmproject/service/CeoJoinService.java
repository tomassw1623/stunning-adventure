package org.crm.crmproject.service;


import org.crm.crmproject.dto.CeoDTO;

public interface CeoJoinService {
    static class MidExistException extends Exception {

        public MidExistException() {}
        public MidExistException(String message) {super(message);}
    }
    //CeojoinService에 customerjoinservce가 있었음
    void ceoJoin(CeoDTO ceoDTO) throws CeoJoinService.MidExistException;


}
