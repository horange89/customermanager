package org.sample.customermanager.domain;

/**
 * 특정고객관리 Branch 예외처리
 * @author 이승호
 * @version 1.0
 */
public class BranchException extends Exception {

    public BranchException(String msg) {
        super(msg);
    }

}
