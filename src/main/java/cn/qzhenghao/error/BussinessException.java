package cn.qzhenghao.error;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * @author suiyue
 * @ClassName BussinessException
 * @Description TODO
 * @date 2019/1/8 16:14
 */
public class BussinessException extends RuntimeException {


    public BussinessException() {

    }

    public BussinessException(String message) {
        super(message);
    }
}
